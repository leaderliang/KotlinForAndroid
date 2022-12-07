package com.kotlin.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val mTextView by lazy {
        findViewById<TextView>(R.id.text_view)
        findViewById<TextView>(R.id.text_view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mTextView.text = "hello"


    }


}

var a = fun() = false
var b = fun(): Boolean { return false }
fun isEmptyc() = false
fun isEmptycc() {
    false
}

fun main() {
    println(a)

}
