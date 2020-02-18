package com.kotlin.practice.expressions.operators

/**
 * 运算符 和
 *
 * 中缀表达式（有一个 receiver 和 只有一个参数 就是中缀表达式）
 * 使用 infix 关键字作为标识
 */
fun main() {
    //https://kotlinlang.org/docs/reference/operator-overloading.html

    "Hello" == "World"
    "Hello".equals("World")

    2 + 3
    2.plus(3)

    val list = listOf(1, 2, 3, 4)

    2 in list

    list.contains(2)

    val map = mutableMapOf(
        "Hello" to 2,
        "World" to 3 // "World".to(3)
    )
    val value = map["Hello"]

//    val value = map.com.kotlin.practice.expressions.operators.get("Hello")

    map["World"] = 4
    map.set("World", 4)


    // fun(){ println("Hello") } 匿名函数
    val func = fun() {
        println("Hello")
    }


    2 > 3
    2.compareTo(3) > 0

    func.invoke()

    func()


    // 中缀表达式
    // 中缀表达式（有一个 receiver 和 只有一个参数 就是中缀表达式）
    // 加 infix 关键字 标识；
    // 多种写法

    2 to 3
    2 to (3)
    2.to(3)

    // 中缀表达式
    println("HelloWorld".rotate(5))
    println("HelloWorld" rotate (5))
    println("HelloWorld" rotate 5)


    val book = Book()
    val desk = Desk()
    book on desk

    test()


    //lambda 表达式
//    var c = IntArray(5) { (it + 1) * 3 }
//    val array = Array<String>(5,{"123"})
    val array = Array<String>(5) { "123" }

    IntArray(4)
    println(array.contentToString())

}

val test = fun(): String {
    return "Hello"
}

/**
 * 中缀表达式（有一个 receiver 和 只有一个参数 就是中缀表达式）
 * 加 infix 关键字 标识
 */
infix fun <A, B> A.to(that: B): Pair<A, B> {
    return Pair(this, that)
}

/*infix fun <A, B> A.to(that: B) {
     Pair(this, that)
}*/

//infix fun <A, B> A.to(that: B): Pair<A, B> = Pair(this, that)// 函数体为一个表达式时候，可直接写作简化的形式


/**
 * 中缀表达式（有一个 receiver 和 只有一个参数 就是中缀表达式）
 * 使用 infix 关键字 标识
 */
infix fun String.rotate(count: Int): String {
    val index = count % length
    return this.substring(index) + this.substring(0, index)
}


class Book
class Desk

infix fun Book.on(desk: Desk) {

}


// 表达式 简化为 lambda 表达式
/*val lala = fun haha(){
    println("sfdasdfas")
}*/

// 可以直接简化成下面形式 lambda 表达式
// anonymous function 匿名方法
// return 可以省略

/*val lala = fun(){
    println("sfdasdfas")
}*/

/*val lala = fun(p:Int):String{
    println("sfdasdfas")
    "hello"
}*/

/*val lala = fun(p:Int){
    println("sfdasdfas")
    "hello"
}*/

val lala = { p: Int ->
    println("sfdasdfas")
    "hello"
}
