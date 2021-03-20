package com.kotlin.practice.advancedtypes.visibilities

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2020/03/05 15:55
 */
fun main() {
    val p = Person("liang",2)
    p.firstName = "3"
    val str = p.firstName
    println(str)

//    val coreApiKotlinA = CoreApiKotlinA()
//    coreApiKotlinA.a()


}