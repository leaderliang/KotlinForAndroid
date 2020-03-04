package com.kotlin.practice.advancedtypes.innerclasses.kotlin

class Outer {
    inner class Inner
    class StaticInner
}

object OuterObject {
    object StaticInnerObject
}

fun main() {
    val inner = Outer().Inner()
    val staticInner = Outer.StaticInner()
}