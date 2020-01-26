package com.android.kotlinpractice.builtin_types

import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 * TODO
 * kotlin 集合框架
 *
 *
 * 不可变 List kotlin   List<T>
 * 可变 List kotlin   MutableList<T>
 * 对应 java List<T>
 *
 * 不可变 Map kotlin  Map<K,V>
 * 可变 Map kotlin   MutableMap<K,V>
 * 对应 java Map<K,V>
 *
 * 不可变 Set kotlin   Set<T>
 * 可变 Set kotlin   MutableSet<T>
 * 对应 java Set<T>
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2020/01/24 16:11
 */

fun main() {
    // 不能添加和删除元素
    val intList = listOf(1,2,3)
    // 可操作元素的添加和删除
    val intList2 = mutableListOf(1,2,3)
    intList2.add(3)
    println(intList2.joinToString())

    // 此处的 ArrayList 使用的是 kotlin.collections.ArrayList 的 ArrayList
    // 使用的类型别名  typealias
    /*
    typealias ArrayList<E> = java.util.ArrayList<E>
    typealias LinkedHashMap<K, V> = java.util.LinkedHashMap<K, V>
    typealias HashMap<K, V> = java.util.HashMap<K, V>
    typealias LinkedHashSet<E> = java.util.LinkedHashSet<E>
    typealias HashSet<E> = java.util.HashSet<E>
    */
    val stringList = ArrayList<String>()

    // "name" to "liang" 理解为 K-V 即可
    val map = mapOf("name" to "devliang")
    val map2:Map<String, Any> = mapOf("name" to "liang","age" to 29)


    // 集合的读写   增删，还有一些高阶用法，运算符重载
    /*for(i in 0..10){
        stringList.add("num:$i")
    }*/

    for(i in 0..10){
        stringList += "num:$i"
    }
    println(stringList.joinToString())


    /*for(i in 0..10){
        stringList.remove("num:$i")
    }

    for(i in 0..10){
        stringList -= "num:$i"
    }
    println("remove${stringList.joinToString()}")*/


    // 集合框架读写
    stringList[5] = "Hello"
    val value5 = stringList[5]
    println(value5)

    // ["hi"] 里面的值 就是 key
    val hashMap = HashMap<String,Int>()
    hashMap["hello"] = 10
    hashMap["hi"] = 22
    println(hashMap["hello"])



    // Pair
    val pair = "hello" to "world"
    val pair2 = Pair("hello","kotlin")

    val first = pair.first
    val second = pair.second

    // 解构表达式 x y 分别是 first 和 second
    val (x,y) = pair


    // Triple
    // 和上面了类似，三个元素
    val triple = Triple("hello",1,2.0)
    val first1 = triple.first
    val second1 = triple.second
    val third1 = triple.third
    val(a,b,c) = triple







































}







