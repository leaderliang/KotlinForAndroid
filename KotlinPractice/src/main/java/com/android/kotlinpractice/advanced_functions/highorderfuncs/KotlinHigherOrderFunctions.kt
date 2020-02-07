package com.android.kotlinpractice.advanced_functions.highorderfuncs

/**
 * 高阶函数使用
 * 接收函数类型的参数 或者 返回函数
 *
 * 常见高阶函数：forEach、map、window、joinToString等
 *
 */

fun main() {

    // 接收函数类型
    cost {
        val fibonacciNext = fibonacci()
        for (i in 0..10) {
            println(fibonacciNext())
        }
    }



    // region +折叠
    val intArray = IntArray(5) { it + 1 }
    intArray.forEach {
        println(it)
    }

    intArray.forEach(::println)

    intArray.forEach {
        println("Hello $it")
    }
    //endregion



    // region + 隐藏
    val ccc = testFun(3)
    println("---> ${ccc(2)}")
    // endregion


    val pair = testPair(5)
    println("---> ${pair(Pair(15, "im pair"))}")

    val triple = testTriple(6)
    println("---> ${triple(Triple(16, "i m triple", 2L))}")

}

//region +折叠
fun needsFunction(block: () -> Unit) {
    block()
}

fun returnsFunction(): () -> Long {
    return { System.currentTimeMillis() }
}
//endregion


// 接收函数类型的参数
fun cost(block: () -> Unit) {
    val start = System.currentTimeMillis()
    block()
    println("${System.currentTimeMillis() - start}ms")
}


// 返回函数
fun fibonacci(): () -> Long {
    var first = 0L
    var second = 1L
    return {
        val next = first + second
        val current = first
        first = second
        second = next
        current
    }
}



fun testFun(i: Int): (a: Int) -> String {
    // it 表示的返回值类型 (Int) -> String 里的这个 int 值
    return {
        "$it $i"
    }
}

fun testPair(i: Int): (p : Pair<Int, String>) -> String {
    // it 表示的返回值类型 (Int) -> String 里的这个 int 值
    return {
        "$it $i"
    }
}

fun testTriple(i: Int): (p : Triple<Int, String,Long>) -> String {
    // it 表示的返回值类型 (Int) -> String 里的这个 int 值
    return {
        "$it $i"
    }
}