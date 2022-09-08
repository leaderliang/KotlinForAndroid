package com.android.kotlin.test


/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0.0
 * @since 2022/06/27 18:00
 */

val d = arrayOf(1, 2, 3, 4, 5, 6)

class Foo {
    fun bar(p0: String, p1: Long): Any {
        TODO()
    }
}

fun foo() {}
fun foo(p0: Int): String {
    TODO()
}

fun main() {
    //    区间
    val intRange = 1..100
    val longRange = 1L..100L
    val charRange = "a".."z"
    val floatRange = 1f..100F
    println(intRange.toString())
    println(intRange.joinToString())

    println(charRange.toString())
    println(longRange.joinToString())
    println(floatRange.toString())

    // 无符号类型
    val uCharRange = "a".."z"
    println(uCharRange.toString())


    //  数组遍历： java 中的 fori 在 kotlin 中可以按照下面方式写
    val array = intArrayOf(1, 3, 5, 7)
    for (i in 0 until array.size) {
        println(array[i])
    }
    // 官方提供如下方法代替
    for (i in array.indices) {
        println(i)
    }

//    val foo = Foo()
//    val m:(String, Long) -> Any = Foo::bar

    // 函数的类型和引用
    val x: Foo.(String, Long) -> Any = Foo::bar
    val x0: (Foo, String, Long) -> Any = Foo::bar
    val x1: Function3<Foo, String, Long, Any> = Foo::bar
    //这三个是等价的  Foo.(String, Long)->Any  =  (Foo, String, Long)->Any  =  Function3<Foo, String, Long, Any>

//    也可以赋值给 y
    val y: (Foo, String, Long) -> Any = x0
    val y0: (Foo, String, Long) -> Any = x
    val y1: Function3<Foo, String, Long, Any> = x

//    方法传参，方法里传递函数
    doSomething(x)

}


fun doSomething(param:(Foo, String, Long)->Any){
    // invoke 和 () 调用是一样的
    param.invoke(Foo(), "", 3L)
    param(Foo(), "", 3L)
}





