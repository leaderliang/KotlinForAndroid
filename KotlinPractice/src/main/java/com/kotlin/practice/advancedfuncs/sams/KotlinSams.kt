package com.kotlin.practice.advancedfuncs.sams

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

fun main() {
    val executor: ExecutorService = Executors.newSingleThreadExecutor()

    executor.submit(object : Runnable {
        override fun run() {
            println("run in executor.")
        }
    })

    executor.submit(Runnable {
        println("run in executor.")
    })


    executor.submit { println("run in executor.") }

    println("run in main thread.")

    /*submitRunnable {
        println("Hello")
    }*/

    submit {  }
}


fun Runnable(block: () -> Unit): Runnable {
    return object : Runnable {
        override fun run() {
            block()
        }
    }
}

fun submitRunnable(runnable: Runnable){
    runnable.run()
}

fun submit(invokable: Invokable) {
    invokable.invoke()
}

typealias FunctionX = ()->Unit

fun submit(lambda: FunctionX){

}

interface Invokable {
    fun invoke()
}



