package com.kotlin.practice.advancedtypes.innerclasses.kotlin

/**
 * kotlin 中定义非静态内部类添加关键字 inner
 *
 */
class Outer {

    /**
     *  kotlin 中定义非静态内部类添加关键字 inner
     */
    inner class Inner

    /**
     *  kotlin 中的静态内部类
     */
    class StaticInner
}

object OuterObject {
    object StaticInnerObject
}

fun main() {

    val inner = Outer().Inner()

    val staticInner = Outer.StaticInner()
}