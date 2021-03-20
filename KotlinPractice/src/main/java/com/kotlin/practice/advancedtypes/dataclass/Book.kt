package com.kotlin.practice.advancedtypes.dataclass

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2020/02/28 21:20
 */


//data class Book(val id:Int,val name:String,val author:String)

data class Book(val id: Long,
                val name: String,
                val author: Person) {

}

data class Person(val id: Long, val name: String, val age: Int)

fun main() {
    val book = Book(0, "Kotlin in Action", Person(1, "Dmitry", 40))
    book.copy()
    val id = book.component1() // companion 用来声明伴生对象
    val name = book.component2()
    val author = book.component3()

    // 解构表达式
//    val (id, name, author) = book

    val pair = "Hello" to "World"
    val (hello, world) = pair

//    val book = Book::class.java.newInstance()


    // list 集合也支持解构表达式
    val(a,b,c,d,e) = listOf<Int>()

}
