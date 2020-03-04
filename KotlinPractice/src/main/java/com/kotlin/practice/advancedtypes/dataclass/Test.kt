package com.kotlin.practice.advancedtypes.dataclass

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2020/02/28 21:17
 */
open class Test {
    /**
     * 声明 伴生对象
     */
    companion object {
        //编译期常量
        const val a = 3

        @JvmField
        val b = 4

        @JvmStatic
        fun doPlus (a: Int): Int{
            return a + 3
        }
    }
}


fun main() {
    val pair = "123" to "345"
    val (hello, world) = pair

    val book = Book(234, "", Person(1, "dev", 40))
    val (id, haha, lalal) = book



    // 多返回值的使用
    // conflicting declaration
    // val(a,b,c) 解构表达式，a b c 可以用来使用，相当于定义了常量名
    val (a, b, c) = multiReturnValues()
    val r = a + c



    // 调用伴生对象声明的变量和函数
    val test = Test.doPlus(1)

}

/**
 * 多返回值之三个参数写法
 * Triple<Int,String,Long> 三个类型对应返回值的三个类型
 */
fun multiReturnValues(): Triple<Int, String, Long> {
    return Triple(1, "三个返回值第二个参数", 3L)
}