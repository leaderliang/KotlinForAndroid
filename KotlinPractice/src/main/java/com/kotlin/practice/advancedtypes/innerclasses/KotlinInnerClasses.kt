package com.kotlin.practice.advancedtypes.innerclasses


class Test {

}

fun main() {
    fun localFunc() {
        println("Hello")
    }

    class LocalClass : Cloneable, Runnable {
        override fun run() {}
    }


    // Cloneable & Runnable  交叉类型 （Cloneable + Runnable）
    // Cloneable | Runnable
    val runnableCloneable = object : Cloneable, Runnable {
        override fun run() {

        }
    }

}

// TypeScript 语言里支持的；联合类型
/*
fun String(array: ByteArray | CharArray){
    when (array) {
        is ByteArray -> {

        }
        is CharArray -> {

        }
    }
}*/
