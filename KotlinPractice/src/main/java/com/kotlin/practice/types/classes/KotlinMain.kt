package com.kotlin.practice.types.classes

import com.kotlin.practice.types.classes.java.Person
import com.kotlin.practice.types.classes.kotlin.SimpleInterface

//import com.kotlin.practice.types.classes.kotlin.Person
//import com.kotlin.practice.types.classes.kotlin.SimpleClass

/**
 * TODO
 *
 *
 *
 * null 类型转换方面的一些建议
 * 尽可能使用 val 来声明不可变引用，让程序的含义更加清晰确定。
 * 尽可能减少函数对外部变量的访问，也为函数式编程提供基础。
 * 必要时创建局部变量指向外部变量，避免因他变化引起程序错误。
 *
 * 类型强转
 * java		(TextView) v
 * kotlin	v as TextView   	一般都省略，比如判断条件里面
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
    // !!.  notNull （不可空类型） 比较危险，因可能会在别的地方赋值为空
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

    var simpleInterface: SimpleInterface = com.kotlin.practice.types.classes.kotlin.Person(1,"dev",1)
    if(simpleInterface is Person){
        // as? 安全类型转换，当失败返回会 null
        println((simpleInterface as? com.kotlin.practice.types.classes.kotlin.Person)?.name)

        println((simpleInterface as com.kotlin.practice.types.classes.kotlin.Person).name)
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