package com.android.kotlin

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/11/07 11:42
 */
var age: Int = 18

fun main() {
    println(doSomething(2))
}

fun doSomething(i: Int): Int {
    return i + 1 + age
}