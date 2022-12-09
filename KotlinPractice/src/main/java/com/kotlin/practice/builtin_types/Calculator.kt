package com.kotlin.practice.builtin_types


/**
 * TODO
 * 四则计算器
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2020/01/27 16:28
 */
fun main() {
    calculator("3", "*", "5")
//    calculator("3", "6", "5")
}

// vararg 变长参数
fun calculator(vararg arg: String) {

    if (arg.size < 3) {
        return showLog()
    }

    val algorithm = mapOf(
        "+" to ::plus,
        "-" to ::minus,
        "*" to ::times,
        "/" to ::division
    )

    val sign = arg[1]
    val signFunction = algorithm[sign] ?: return showLog()


//    println("${signFunction(arg[0].toInt(), arg[2].toInt())}")


    try {
        println("Input: ${arg.joinToString(" ")}")
        println("Output: ${signFunction(arg[0].toInt(), arg[2].toInt())}")
    } catch (e: Exception) {
        println("Invalid Arguments.")

        showLog()
    }
}


fun showLog() {
    // raw string
    println(
        """
        
        Calculator
            Input 3 * 5
            Output 15
    """.trimIndent()
    )

}

fun plus(arg0: Int, arg1: Int): Int {
    return arg0 + arg1
}

fun minus(arg0: Int, arg1: Int): Int {
    return arg0 - arg1
}

fun times(arg0: Int, arg1: Int): Int {
    return arg0 * arg1
}

fun division(arg0: Int, arg1: Int): Int {
    return arg0 / arg1
}





