package com.kotlin.practice.advancedfuncs.common_func

import java.io.File

/**
 *
 * let
 * run
 * 二者返回值是高阶函数 lambda 表达式自己的返回值
 *
 * also
 * apply
 * 二者返回值是是自己的 receiver
 *
 *
 * let、also、use 比较好用；
 *
 * run、apply 很容易嵌套很多 receiver；
 *
 * 
 *
 *
 * with
 */

class Person(var name: String, var age: Int)


fun main() {
    val person = Person("benny", 20)

    person.let(::println)
    person.run(::println)


    val person2 = person.also {
        it.name = "hhh"
    }

    val person3 = person.apply {
        name = "xxx"
    }

    /**
     * inputStream() 打开一个文件，读取 二进制
     * reader() 读取 char
     * buffered() BufferedReader
     *
     */
    File("build.gradle.kts").inputStream().reader().buffered()
        .use {
            // 单条打印
            println(it.readLine())
            // 全部打印
            println(it.readLines())
        }


}