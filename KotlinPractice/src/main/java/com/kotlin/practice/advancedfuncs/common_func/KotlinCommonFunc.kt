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

class Person(var name: String, var age: Int){
    override fun toString(): String {
        return "Person(name='$name', age=$age)"
    }
}


fun main() {
    val person = Person("kevin", 30)

    person.let(::println)

    person.run(::println)

    val a: () -> Unit = ::println

    // 返回表达式结果
    val use1 = person.let {
        it.name = "liang"
        it.age = 29
        "asdfasd"// 可以增加返回值
    }
    use1

    val use2: Int = person.run {
        name = "tom"
        age = 100
        12345// 可以增加返回值
    }

    // 返回 Receiver
    val person2 = person.also {
        it.name = "hhh"
    }

    val person3 = person.apply {
        name = "xxx"
    }

    /**
     * use 自动关闭资源
     *
     *
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

/*
fun println(message: Any?, other: String) {
    System.out.println(message)
}*/
