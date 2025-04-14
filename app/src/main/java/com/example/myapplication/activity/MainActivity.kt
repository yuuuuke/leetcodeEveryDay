package com.example.myapplication.activity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.hardware.Camera
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.example.myapplication.R


class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v("zwp", "1 onCreate")
        setContentView(R.layout.activity_main)
        val view = findViewById<View>(R.id.main_tv)
        view.setOnClickListener {
            val intent = Intent(this@MainActivity,SecondActivity::class.java);
            startActivity(intent)
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
