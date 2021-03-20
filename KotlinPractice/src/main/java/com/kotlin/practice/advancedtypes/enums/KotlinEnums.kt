package com.kotlin.practice.advancedtypes.enums

enum class State: Runnable{
    Idle, Busy{
        override fun run() {
            println("For Busy State.")
        }
    };

    override fun run() {
        println("For  Every State.")
    }
}


//region fold
fun State.successor(): State? {
    return State.values().let {
        if (ordinal + 1 >= it.size) null
        else it[ordinal + 1]
    }
}

fun State.predecessor(): State? {
    return State.values().let {
        if (ordinal - 1 < 0) null
        else it[ordinal - 1]
    }
}

enum class Color {
    White, Red, Green, Blue, Yellow, Black
}
//endregion



fun main() {
    State.Idle.run()
    State.Busy.run()

    println(State.Idle.successor())
    println(State.Busy.successor())

    State.Idle.name // Idle
    State.Idle.ordinal // 0

    val state = State.Idle
    val value = when (state) {
        State.Idle -> { 0 }
        State.Busy -> { 1 }
    }

    if(state <= State.Idle){

    }


    val colorRange = Color.White..Color.Green
    val color = Color.Blue
    println(color in colorRange)
}