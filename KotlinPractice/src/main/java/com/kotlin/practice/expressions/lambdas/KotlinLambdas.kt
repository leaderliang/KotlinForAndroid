package com.kotlin.practice.expressions.lambdas

import kotlin.Function1


/**
 * lambda 表达式 （匿名函数）
 *
 * kotlin 中
 * 没有函数名的函数是匿名函数
 * 函数可以赋值给变量，可以传递
 *
 *
 */
fun main() {

    // 这是个匿名函数
    // func 是变量名
    // 调用时候这样，func()  或者 func.invoke()；用变量调用函数；
    // 匿名函数的类型 这个 函数的类型是  () -> Unit
    val func: () -> Unit = fun() {
        println("Hello")
    }

    // lambda 表达式
    // lambda 表达式 是 匿名函数更具有表现力的写法，本质也是 匿名函数
    val lambda: () -> Unit = {
        println("Hello")// println 的返回值也是 Unit，所以上面的返回值就是 Unit
    }


    //region 下面的 lambda 表达式，表示接收一个 Int 类型参数，返回一个 String 类型的表达式
    val f1 = { p: Int ->
        println(p) // 方法体
        "Hello" // 返回值
    }

    // 上面的可以写成 Function1 这种形式，前面记录过
    val f2: Function1<Int, String> = { p: Int ->
        println(p) // 方法体
        "Hello" // 返回值
    }
    //  下面是类型 推导
    val f3: Function1<Int, String> = { p ->
        println(p) // 方法体
        "Hello" // 返回值
    }
    val f4: (Int) -> String = { p: Int ->
        println(p) // 方法体
        "Hello" // 返回值
    }
    val f5 = { p: Int ->
        println(p) // 方法体
        "Hello" // 返回值
    }
    // endregion


    // lambda 表达式如果只有一个参数的话，可以省略，用 it 来代替
    val f6: Function1<Int, Unit> = {
        println(it) // 方法体
    }





    println(f1(1))


    IntArray(5) { it + 1 }
}