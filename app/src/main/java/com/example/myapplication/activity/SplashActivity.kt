package com.example.myapplication.activity

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.myapplication.R

@SuppressLint("CustomSplashScreen")
public class SplashActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Log.v("zwp","0 onCreate")

        findViewById<View>(R.id.btn).setOnClickListener{
            val intent = Intent(this@SplashActivity,MainActivity::class.java);
            startActivity(intent);
            finish()
        }
    }

    override fun onRestart() {
        Log.v("zwp","0 onRestart")
        super.onRestart()
    }

    override fun onResume() {
        Log.v("zwp","0 onResume")
        super.onResume()
    }

    override fun onStart() {
        Log.v("zwp","0 onStart")
        super.onStart()
    }

    override fun onPause() {
        Log.v("zwp","0 onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.v("zwp","0 onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.v("zwp","0 onDestroy")
        super.onDestroy()
    }

    override fun onNewIntent(intent: Intent?) {
        Log.v("zwp", "0 onNewIntent")
        super.onNewIntent(intent)
    }
}