package com.android.kotlinpractice.advanced_functions.common_func

import java.io.File


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

    File("build.gradle").inputStream().reader().buffered()
        .use {
            println(it.readLines())
        }


}