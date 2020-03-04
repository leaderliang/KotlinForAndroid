package com.kotlin.practice.builtin_types

import kotlin.reflect.KProperty

/**
 * TODO
 * 数组相关
 *
 * val
 * var
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/11/07 11:42
 */
var age: Int = 18


class A {
    // 这块不能叫常量，应该叫  只读变量；
    // 每次取值不一定相同。
    val bb: Int
        get() {
            return (Math.random() * 100).toInt()
        }
}

fun main() {


    // val b = 3 和在 java 中声明 final int b = 3 ；如果都是声明在函数里作为局部变量存在的话，是等价的。可以叫常量
    val b = 3
    // 但在 kotlin 中，用 val 定义的都叫 只读变量；主要是因为作为属性，或者顶级属性，


//    println(doSomething(2))

    // 打印范围，通过使用 字符串模板 ${} 代替 java 中的 +
    println("Range of Int:[${Int.MIN_VALUE}, ${Int.MAX_VALUE}]")
    println("Range of Int:[${Int.SIZE_BITS}, ${Int.SIZE_BYTES}]")

    val k = "today is a sunny day"
    val l = String("today is a sunny day".toCharArray())
    // compare value 比较内容
    println(k == l)
    // compare reference 比较引用
    println(k === l)

    // 5 相当于数组大小
    // it 当前元素对应的 index 的值
    // it 相当于数组下标，it + 1 则表示值为 下标 + 1;
    var c = IntArray(5) { (it + 1) * 3 }
    // it 为 [0, 1, 2, 3, 4, 5]
    // it + 1 为 [1, 2, 3, 4, 5]
    // it + 2 为 [2, 3, 4, 5, 6]
    // (it + 1)*3 为 [3, 6, 9, 12, 15]
//    println(c.toString())
    println(c.contentToString())

    // 数组的长度
    var c1 = IntArray(5)
    println(c1.size)

    // 数组的读写
    var d = arrayOf("hello", "java")
    var d1 = arrayOf(1)
    d[1] = "kotlin"
    println("${d[0]} , ${d[1]}")

    // 数组的遍历
    val e = arrayOf(1f, 2f, 3f, 4f, 5f)
    // in 表示迭代
    for (element in e) {
        println(element)
    }

    println()

    // forEach 高阶函数； it 是默认值
    /*e.forEach {it->
        println(it)
    }*/
    e.forEach {
        println(it)
    }

    // in 数组的包含关系，这个 in 表示 包含与被包含
    if (1f in e) {
        println("1f in e -> true")
    }

    if (1.2f !in e) {
        println("1f in e -> false")
    }


}


fun doSomething(i: Int): Int {
    return i + 1 + age
}


fun aboutArray() {
    // 整型 ---> java int[]
    val intArray = IntArray(5) {
        it + 1
    }

    val charArray = CharArray(5) {
        3.toChar()
    }

    // 整型装箱 ---> java Char[]
    val mIntArray = Array<Int>(5) { 2 }

    // 数组的创建
//    it 当前元素对应的 index 的值
    val c = intArrayOf(1, 2, 3, 4, 5)
    val c1 = IntArray(5) { it + 1 }


}


