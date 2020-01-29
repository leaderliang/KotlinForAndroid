package com.android.kotlinpractice.types.classes

import com.android.kotlinpractice.types.classes.java.Person
import com.android.kotlinpractice.types.classes.kotlin.SimpleInterface

//import com.android.kotlinpractice.types.classes.kotlin.Person
//import com.android.kotlinpractice.types.classes.kotlin.SimpleClass

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2020/01/27 21:32
 */


var tag: String? = null

fun main() {

//    val simple = SimpleClass("123", 5)
//    var person = Person(18, "dev.liang", 1)


    // ? 可空类型
    // !!.  notNull 比较危险，因可能会在别的地方赋值为空
    // ?. 安全访问符，就是不确定 会不会为空。
    var str: String? = "adsf"
//    str = null
//    val length = str!!.length
//    val length = str?.length
    val length = str?.length ?: 0 // elvis 运算符
    println(length)


    // 空类型的继承关系
    var x: String = "hello"
    var y: String? = "hello"

//    x = y // type mismatch
    y = x // OK

    var a: Int = 10
    var b: Number = 11
//    a = b // type mismatch
    b = a // OK


    // 平台类型
    val p = Person()
    // :String! 表示平台类型；不知道是否为空。开发者自己决定
    var name = p.name




    // kotlin 的类型转换

    var simpleInterface: SimpleInterface = com.android.kotlinpractice.types.classes.kotlin.Person(1,"dev",1)
    if(simpleInterface is Person){
        println((simpleInterface as com.android.kotlinpractice.types.classes.kotlin.Person).name)
        // 自动转换类型，和 java 相比
        println(simpleInterface.name)
    }


    // 智能类型转换
    // 可空类型
    var value: String? = null
    //在这里是 String？
    value = "dev.liang"
    if(value != null){
        //到这里就 转换为 String
        println(value.length)
    }
    // 出了这个 if 后，就还是之前类型




    // 不支持智能转换的情况
    if(tag != null){ // 虽然判断不为空，但其他线可能对他进行修改
        println(tag!!.length)
    }



















}