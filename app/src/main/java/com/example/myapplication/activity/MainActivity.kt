package com.example.myapplication.activity

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Rect
import android.hardware.Camera
import android.os.Bundle
import android.util.Log
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.myapplication.R
import net.sourceforge.zbar.*


class MainActivity : AppCompatActivity() {
    private var cameraPreview: SurfaceView? = null
    private var resultTextView: TextView? = null
    private lateinit var camera: Camera
    private var scanner: ImageScanner? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cameraPreview = findViewById<SurfaceView>(R.id.cameraPreview)
        resultTextView = findViewById<TextView>(R.id.resultTextView)

        // 初始化 ZBar 的扫描器
        scanner = ImageScanner()
        scanner!!.setConfig(Symbol.NONE, Config.ENABLE, 1)

        // 检查相机权限
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA),
                REQUEST_CAMERA_PERMISSION
            )
        } else {
            setupCamera()
        }
    }

    private fun setupCamera() {
        val holder = cameraPreview!!.holder
        holder.addCallback(object : SurfaceHolder.Callback {
            override fun surfaceCreated(surfaceHolder: SurfaceHolder) {
                try {
                    camera = Camera.open()
                    val params = camera.parameters
                    params.setPreviewSize(1280,720)
                    params.setPictureSize(1280,720)
                    val x = 300
                    val y = 800
                    if (params.getMaxNumFocusAreas() > 0) {
                        // 定义对焦区域
                        val focusArea = Camera.Area(Rect(x - 100, y - 100, x + 100, y + 100), 1000)
                        val focusAreas: ArrayList<Camera.Area> = ArrayList()
                        focusAreas.add(focusArea)
                        params.setFocusAreas(focusAreas)
                    }
                    camera.parameters = params
                    camera.setPreviewDisplay(holder)
                    camera.setDisplayOrientation(90)
                    camera.setPreviewCallback { data, camera ->
                        val parameters: Camera.Parameters = camera.getParameters()
                        val size: Camera.Size = parameters.getPreviewSize()

                        // 创建 ZBar Image
                        val barcode =
                            Image(size.width, size.height, "Y800")
                        barcode.setData(data)

                        // 扫描二维码
                        if (scanner!!.scanImage(barcode) != 0) {
                            val symbols = scanner!!.results
                            for (symbol in symbols) {
                                val result = symbol.data
                                if (result != null) {
                                    resultTextView!!.text = result
                                    camera.setPreviewCallback(null) // 停止扫描
                                    camera.stopPreview()
                                    break
                                }
                            }
                        }
                    }
                    camera.startPreview()
                } catch (e: Exception) {
                    Log.e("ZBar", "Error setting up camera: " + e.message)
                }
            }

            override fun surfaceChanged(surfaceHolder: SurfaceHolder, i: Int, i1: Int, i2: Int) {
                if (camera != null) {
                    camera.startPreview()
                }
            }

            override fun surfaceDestroyed(surfaceHolder: SurfaceHolder) {
                if (camera != null) {
                    camera.stopPreview()
                    camera.release()
                }
            }
        })
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CAMERA_PERMISSION) {
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                setupCamera()
            } else {
                resultTextView!!.text = "相机权限被拒绝"
            }
        }
    }

    companion object {
        private const val REQUEST_CAMERA_PERMISSION = 100
    }
}
