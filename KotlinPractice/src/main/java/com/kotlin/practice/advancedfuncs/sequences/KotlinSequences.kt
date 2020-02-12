package com.kotlin.practice.advancedfuncs.sequences


fun main() {
    val list = listOf(1, 2, 3, 4)

    val lists = list.filter { it % 2 == 0 }
    println("--> ${lists.joinToString()}")


    //region sequence
    list.asSequence()
        .filter {
            println("filter: $it")
            it % 2 == 0
        }.map {
            println("map: $it")
            it * 2 + 1
        }.forEach {
            println("forEach: $it")
        }
    //rxjava
    //endregion


    list.asSequence()
        .flatMap {
            (0 until it).asSequence()
        }
        .joinToString()
        .let(::prints)
    //rxjava






    //region
//    for (i in 0..10) {
//        println(i)
//    }
//
//    for (e in list) {
//        println(e)
//    }
//
//    var i = 0
//    while (i++ < 10) {
//        println(i)
//    }
//
//    do {
//        println("Hello")
//    } while (false)
//    //endregion
//
//    //region for each
//    list.forEach {
//        if (it == 2) {
//            return@forEach
//        }
//        println(it)
//    }
//
//    list.forEach {
//        if (it == 2) return@forEach
//        println(it)
//    }
//
//    //region
//    val newList = list.flatMap {
//        ArrayList<String>(it)
//    }
//
//    list.filter { it % 2 == 0 }
//    list.asSequence()
//        .filter { it % 2 == 0 }
//
//    list.asSequence()
//        .map { it * 2 + 1 }
//
//    list.asSequence()
//        .flatMap {
//            (0 until it).asSequence()
//        }
//        .joinToString().let(::println)
//
//    list.fold(StringBuilder()) { acc, i ->
//        acc.append(i)
//    }
//
//    list.asSequence()
//        .filter {
//            it % 2 == 0
//        }.map {
//            it * 2 + 1
//        }.flatMap {
//            (0 until it).asSequence()
//        }.forEach(::println)
    //endregion


}

fun prints(message: Any?) {
    print(message)
}

