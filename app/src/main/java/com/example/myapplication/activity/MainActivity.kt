package com.example.myapplication.activity

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import com.example.myapplication.R
import com.tencent.smtt.export.external.interfaces.PermissionRequest
import com.tencent.smtt.sdk.ValueCallback
import com.tencent.smtt.sdk.WebChromeClient
import com.tencent.smtt.sdk.WebView
import com.tencent.smtt.sdk.WebViewClient

public class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val webView = findViewById<WebView>(R.id.webView)
        webView.settings.allowFileAccess = true
        //如果访问的页面中有Javascript，则webview必须设置支持Javascript
        webView.settings.javaScriptEnabled = true

        webView.settings.setAppCacheEnabled(true)

        webView.settings.domStorageEnabled = true
        webView.settings.databaseEnabled = true

        webView.settings.builtInZoomControls = true
        webView.settings.displayZoomControls = false

        webView.settings.useWideViewPort = true


        webView.settings.loadWithOverviewMode = true

        webView.settings.allowContentAccess = true // 是否可访问Content Provider的资源，默认值 true
        webView.settings.allowFileAccess = true // 是否可访问本地文件，默认值 true
        webView.settings.javaScriptEnabled = true
        webView.settings.setSupportZoom(true)

        webView.loadUrl("http://patient-test.kuaihuw.com/chat_room?client=phone&system=android&clientVersion=7.5.1903&caseId=46962&doctorId=4159&caseParams=JTdCJTIyY3VzdENlcnRObyUyMiUzQSUyMktZMDYwMzIzJTIyJTJDJTIyaWQlMjIlM0ElMjIzYThhZjI3MTJlZjU0ZDNiYjk3ZDA3Mzg5ZjdlMDVlMiUyMiU3RA==")

        webView.webViewClient = object: WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url!!)
                return true
            }
        }

        webView.webChromeClient = object : WebChromeClient() {
            override fun onPermissionRequest(request: PermissionRequest) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    request.grant(request.resources)
                }
            }
            //h5调用本地相机相册For Android 4.1  - 5.0
            override fun openFileChooser(
                uploadMsg: ValueCallback<Uri?>,
                acceptType: String?,
                capture: String?
            ) {

            }

            //h5调用本地相机相册For 5.0+
            override fun onShowFileChooser(
                webView: WebView,
                filePathCallback: ValueCallback<Array<Uri>>,
                fileChooserParams: FileChooserParams
            ): Boolean {
                val i = Intent(Intent.ACTION_GET_CONTENT)
                i.addCategory(Intent.CATEGORY_OPENABLE)
                i.type = "image/*"

                return true
            }
        }
    }

    override fun onRestart() {
        Log.v("zwp", "1 onRestart")
        super.onRestart()
    }

    override fun onResume() {
        Log.v("zwp", "1 onResume")
        super.onResume()
    }

    override fun onStart() {
        Log.v("zwp", "1 onStart")
        super.onStart()
    }

    override fun onPause() {
        Log.v("zwp", "1 onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.v("zwp", "1 onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.v("zwp", "1 onDestroy")
        super.onDestroy()
    }

    override fun onNewIntent(intent: Intent?) {
        Log.v("zwp", "1 onNewIntent")
        super.onNewIntent(intent)
    }
}