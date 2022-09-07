package com.example.myapplication.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.webkit.WebSettings
import android.webkit.WebSettings.LOAD_NO_CACHE
import android.webkit.WebStorage
import android.webkit.WebView
import com.example.myapplication.R

public class MainActivity : Activity() {

    val handler = object:Handler(){
        override fun handleMessage(msg: Message) {
            Log.v("zwp","内存泄露");
            super.handleMessage(msg)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        findViewById<View>(R.id.btn).setOnClickListener {
//            val intent = Intent(this@MainActivity, SecondActivity::class.java);
//            startActivity(intent);
////            finish()
//        }


//        http://192.168.92.127:8080/vue/bankuai/module/72

        val webView = findViewById<WebView>(R.id.webView)

        webView.settings.allowFileAccess = true
        //如果访问的页面中有Javascript，则webview必须设置支持Javascript
        webView.settings.javaScriptEnabled = true
        webView.settings.setAppCacheEnabled(true)
        webView.settings.domStorageEnabled = true
        webView.settings.databaseEnabled = true
        webView.clearCache(true);
        WebStorage.getInstance().deleteAllData();
        webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webView.loadUrl("http://192.168.92.127:8080/vue/bankuai/module/72")

        Log.v("zwp", "1 onCreate")

        handler.sendMessageDelayed(Message.obtain(),10000);
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