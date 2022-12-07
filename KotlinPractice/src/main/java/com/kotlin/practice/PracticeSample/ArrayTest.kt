package com.kotlin.practice.PracticeSample


/**
 * TODO
 *
 * Note:
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2022/12/07 16:26
 */

fun main() {

    val array = intArrayOf(1, 5, 3, 6, 25)
    for (a in array) {
        println(a)// 1 	5 	3 	6 	25
    }
    array.forEach {
        print("$it \t")// 1 	5 	3 	6 	25

    }

    println()

    for (a in array.iterator()) {
        print("$a \t") // 1 	5 	3 	6 	25
    }

    println()

    for (a in array.indices) {
        print("$a \t") // 0 	1 	2 	3 	4
    }

    println()

    for (a in array.indices) {
        print("${array[a]} \t" ) // 1 	5 	3 	6 	25
    }



}