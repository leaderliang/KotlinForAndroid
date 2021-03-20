package com.kotlin.practice.advancedtypes.inlineclasses

inline class BoxInt(val value: Int): Comparable<Int> {
    override fun compareTo(other: Int)
            = value.compareTo(other)

    operator fun inc(): BoxInt {
        return BoxInt(value + 1)
    }
}

inline class State(val ordinal: Int) {
    companion object {
        val Idle = State(0)
        val Busy = State(1)
    }

    fun values() = arrayOf(Idle, Busy)

    val name: String
        get() = when (this) {
            Idle -> "Idle"
            Busy -> "Busy"
            else -> throw  IllegalArgumentException()
        }
}

inline class Color(val value: UInt) {
    companion object {
        val Red = Color(0xFFFF0000u)
        val Green = Color(0xFF00FF00u)
        val Blue = Color(0xFF0000FFu)
    }

    fun values() = arrayOf(Red, Green, Blue)

    val name: String
        get() = when (this) {
            Red -> "Red"
            Green -> "Green"
            Blue -> "Blue"
            else -> throw  IllegalArgumentException()
        }
}

fun main() {
    var boxInt = BoxInt(5)
    if(boxInt < 10){
        println("value is less than 10")
    }

    val newValue = boxInt.value * 200
    println(newValue)
    boxInt++
    println(boxInt)
}