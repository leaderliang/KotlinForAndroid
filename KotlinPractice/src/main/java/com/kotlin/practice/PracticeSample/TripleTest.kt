package com.kotlin.practice.PracticeSample

/**
 * TODO
 *
 * Note:
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2022/12/07 22:53
 */

fun main() {
    val triple = Triple(1,2,"string")
    val first = triple.first
    val second = triple.second
    val third = triple.third

    // 解构表达式
    val(x,y,z) = triple

}