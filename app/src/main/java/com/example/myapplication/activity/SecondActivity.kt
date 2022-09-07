package com.example.myapplication.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.myapplication.R

public class SecondActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.v("zwp", "2 onCreate")
    }

    override fun onRestart() {
        Log.v("zwp", "2 onRestart")
        super.onRestart()
    }

    override fun onResume() {
        Log.v("zwp", "2 onResume")
        super.onResume()
    }

    override fun onStart() {
        Log.v("zwp", "2 onStart")
        super.onStart()
    }

    override fun onPause() {
        Log.v("zwp", "2 onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.v("zwp", "2 onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.v("zwp", "2 onDestroy")
        super.onDestroy()
    }

    override fun onNewIntent(intent: Intent?) {
        Log.v("zwp", "2 onNewIntent")
        super.onNewIntent(intent)
    }
}