package com.kotlin.practice.advancedtypes.constructors

/**
 * 构造同名的工厂函数
 */
fun main() {
    val str = String()
    val str1 = String(charArrayOf('1', '2'))
    println(str1)

}

fun string(ints: IntArray): String {

    return ints.contentToString()
}