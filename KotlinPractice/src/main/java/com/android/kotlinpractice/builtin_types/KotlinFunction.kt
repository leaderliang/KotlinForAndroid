package com.android.kotlinpractice.builtin_types


/**
 * TODO
 * 函数
 *
 * kotlin 的方法和函数区别
 * 方法可以认为是函数的一种特殊类型
 * 从形式上，有 receiver 的函数即为方法；
 *
 * 方法就是外边套的有类。
 * 没有类的方法就是函数；
 *
 * 解构表达式 val(1,2,3)
 *
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2020/01/25 18:14
 */


/**
 * vararg 多参数（变长参数）
 */
fun main(args: Array<String>): Unit {


    // 定义变量去接收上面的引用
    val f: () -> Unit = ::food
    val f1: (Int) -> String = ::food // 可以简写为 val f1 = ::food
//    val f1 = ::food

    // 这个有 三 种写法
    val f2: (Food, String, Long) -> Any = Food::banana
    // receiver 的一种写法；Food 是 receiver
    val f3: Food.(String, Long) -> Any = Food::banana
    val f4: Function3<Food, String, Long, Any> = Food::banana
    // (Food, String, Long) -> Any = Food.(String, Long) -> Any = Function3<Food, String, Long, Any>


    // Food 对象
    val mFood = Food()
    val m: (String, Long) -> Any = mFood::banana


    // 涉及到类型的话，是都可以推断出来了，所以可以省略不写
    // 可以简写为
    // val f = ::food
    // val f1 = ::food
    // val f2 = Food::banana

    // 传递类型
    testFun(f2)

    multiParameters(1, 2, 3, 4)

    // listOf() 里面也使用了 vararg 变长参数
    val sss = listOf(1, 2, 3, 4, "lalala")
    println(sss.joinToString())


    // 多返回值的使用
    // conflicting declaration
    // val(a,b,c) 解构表达式； val(a,b,c) 解构表达式； val(a,b,c) 解构表达式；
    val (a, b, c) = multiReturnValues()
    val r = a + c


    // 默认参数
//    defaultParameter(2,"我是第二个参数")
    defaultParameter(y = "lalalala") // 指定具名参数

}


// 函数的类型
// 返回值类型 () -> Unit
fun food() {
}

// 返回值类型 (Int)-> String
fun food(nameId: Int): String {
    return ""
}

// Food 是 banner 的 receiver
class Food {
    // 返回值类型   Food.(String,Long) -> Any   ==》  (Food,String,Long) -> Any
    fun banana(weight: String, length: Long): Any {
        return ""
    }

}

// 函数的引用：
// 类似 C 语言中的函数指针，可用于函数传递
// 上面三个的函数 引用 分别是
// ::food
// ::food
// Food::banana





fun testFun(f: (Food, String, Long) -> Any) {
    // 两种调用方式
    f(Food(), "", 3L)
//    f.invoke(Food(), "", 3L)
}


/**
 * vararg 变长参数
 */
fun multiParameters(vararg ints: Int) {
    println(ints.contentToString())
}

/**
 * 多返回值之三个参数写法
 * Triple<Int,String,Long> 三个类型对应返回值的三个类型
 */
fun multiReturnValues(): Triple<Int, String, Long> {
    return Triple(1, "三个返回值第二个参数", 3L)
}

/**
 * 多返回值之二个参数写法
 */
fun multiReturnValues2(): Pair<Int, String> {
    return Pair(1, "两个返回值的第二个参数")
}

/**
 * 默认参数
 *
 * 当方法为 fun defaultParameter(x: Int, y: String, z: Long = 3)
 * 这个方法的默认值如果是字后一个参数的话，传参可以直接这样写 defaultParameter(1, "lala")
 *
 * 当方法为 fun defaultParameter(x: Int = 0, y: String, z: Long = 3)时
 * 调用方法时如果 defaultParameter("lala") 这样调用是会报错的，因为 IDE 以为你传递的是第一个参数，总之就是识别不了
 *
 * kotlin 针对这个问题给了另一种实现方案，就是使用 "具名参数"
 * 具名参数，也就是使用形参的名字 就可以指定具体传的是哪个参数了；
 * 如 defaultParameter(x = 1, "lala")
 *
 */
fun defaultParameter(x: Int = 0, y: String, z: Long = 3) {
    println("[$x,$y,$z]")
}


