package com.kotlin.practice.expressions.eg

/**
 * String 实现 四则运算
 *
 * 运算符重载 operator
 * 拓展方法的定义 String.minus
 *
 */

operator fun String.minus(right: Any?)
        = this.replaceFirst(right.toString(), "")

operator fun String.times(right: Int): String {
    return (1..right).joinToString(""){ this }
}

operator fun String.div(right: Any?): Int {
    val right = right.toString()
    return this.windowed(right.length, 1, transform = {
        it == right
    }) // [false, false, false, false ... false, true, ..., true]
        .count { it }
}

fun main() {
    val value = "HelloWorld World"

    println(value - "World")
    println(value * 2)

    val star = "*"
    println("*" * 20)

    println(value / 3)
    println(value / "l")
    println(value / "ld")
}
