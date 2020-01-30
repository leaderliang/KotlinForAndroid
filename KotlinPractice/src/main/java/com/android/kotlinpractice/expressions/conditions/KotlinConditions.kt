package com.android.kotlinpractice.expressions.conditions

import java.lang.Exception

fun main() {
    var a = 2
    var c: Int

    if (a == 3) {
        c = 4
    } else {
        c = 5
    }

    // 分支表达式
    // if...else 表达式
    c = if (a == 3) 4 else 5

    when (a) {
        0 -> c = 5
        1 -> c = 100
        else -> c =  20
    }

    c = when (a) {
        0 -> 5
        1 -> 100
        else -> 20
    }




    var x: Any = Any()
    when{
        x is String -> c = x.length
        x == 1 -> c =  100
        else -> c = 20
    }

    c = when {
        x is String -> x.length
        x == 1 -> 100
        else -> 20
    }

    c = when (val input = readLine()) { //  when (val input = readLine()) at kotlin since 1.3
        null -> 0
        else -> input.length
    }


    // try ... catch 像 if ... else
    val b = 0

    try {
        c = a / b
    } catch (e: Exception) {
        e.printStackTrace()
        c = 0
    }

    c = try {
        a / b
    } catch (e: ArithmeticException) {
        2
    } catch (e: Exception) {
        e.printStackTrace()
        0
    }

    c = try {
        a / b
    } catch (e: ArithmeticException) {
        2
    } catch (e: Exception) {
        e.printStackTrace()
        0
    }


}