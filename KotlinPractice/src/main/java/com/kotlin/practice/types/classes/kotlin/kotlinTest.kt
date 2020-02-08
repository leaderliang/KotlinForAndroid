package com.kotlin.practice.types.classes.kotlin


/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2020/01/29 18:25
 */

fun main() {

    // kotlin 的类型转换

    var simpleInterface: SimpleInterface = Person(1,"",1)

    if( simpleInterface is Person){
        println((simpleInterface as Person).name)
        // 自动转换类型，和 java 相比
        println(simpleInterface.name)
    }

}

