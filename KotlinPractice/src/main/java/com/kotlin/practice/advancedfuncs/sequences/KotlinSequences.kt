package com.kotlin.practice.advancedfuncs.sequences


fun main() {
    val list = listOf(1, 2, 3, 4)

    // filter
    val lists1 = list.filter {
        it % 2 == 0
    }
    // asSequence() 转换为懒序列
    val lists2 = list.asSequence()
        .filter{
            it % 2 == 0
        }

    println("lists1 --> ${lists1.joinToString()}")
    println("lists2 --> ${lists2.joinToString()}") // 懒序列


    // map
    val map1 = list.map { it * 2 + 1 }
    val map2 = list.asSequence().map { it * 2 + 1 }

    println("map1 -->${map1.joinToString()}")// -->3, 5, 7, 9
    println("map2 -->${map2.joinToString()}")// -->3, 5, 7, 9


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
    println()
    //rxjava


    list.forEach {
        if (it == 2) {
            return@forEach // return@forEach 相当于 跳出这一次的内联函数调用;也就是当前这一次的循环，然后继续执行
        }
        println(it)// 输出 1、3、4
    }
    println("out----")

    // sum 所有元素求和
    // reduce 将元素依次按规则聚合，结果与元素类型一致
    // fold 给定初始化值，将元素按规则聚合，结果与初始化值类型一致；另外还有 foldRight,是从右往左
//    val reduce =list.reduce { acc, i -> acc + 1  }
    val fold = list.fold(StringBuilder()) { acc, i ->
        acc.append(i) // 返回值类型为 stringBuilder，作为下一个元素的 acc
    }
//    println(reduce)
    print(fold)





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

