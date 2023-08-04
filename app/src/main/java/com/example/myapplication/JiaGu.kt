package com.example.myapplication

import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset

class JiaGu {

    var path = this.javaClass.getResource("/").path
    val runtime = Runtime.getRuntime()

    init {
        path = "C:\\Users\\YFW\\Desktop\\360jiagubao_windows_64\\jiagu"
    }

    fun execLogin() {
        println("登录中")
        val process = runtime.exec("$path\\java\\bin\\java -jar $path\\jiagu.jar -login 15172382015 qwer789.")
        val result = streamToString(process.inputStream, "GB2312")
        println(result)
    }

    fun execJiaGu() {
        println("开始加固")
        val process = runtime.exec("$path\\java\\bin\\java -jar $path\\jiagu.jar -jiagu $path\\output\\15172382015\\yfw_release_v7.0.1000-2304251514_701000_jiagu.apk $path\\output\\15172382015")
        val result = streamToString(process.errorStream, "GB2312")
        println(result)
    }

    fun streamToString(`in`: InputStream, encoding: String?): String? {
        return try {
            val sb = StringBuffer()
            val b = ByteArray(1024)
            var n: Int
            while (`in`.read(b).also { n = it } != -1) {
                sb.append(String(b, 0, n, Charset.forName(encoding)))
            }
            sb.toString()
        } catch (e: IOException) {
            e.printStackTrace()
            throw RuntimeException("提取 requestBody 异常", e)
        }
    }
}

fun main() {
    JiaGu().apply {
        execLogin()
        execJiaGu()
    }
}

