package com.android.kotlinpractice.types.classes.kotlin


/**
 * TODO
 *
 * 这里定义的 var age、name、sex 和 java 中定义的变量不同，java 是 field，kotlin 中是 Property
 * Property 相当于 java 中的 field + get + set
 *
 * 这里的 get 和 set 默认可以不写，也可以自定义书写
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2020/01/28 11:48
 */
class Person(age: Int, name: String, sex: Int) :AbstractClass(),SimpleInterface {

    override fun absMethod() {
    }

    override fun simpleMethod() {

    }

    override var simpleProperty: Int
//        get() = 3
        get() {
            return 3
        }
        set(value) {}


    var age: Int = age
        get() {
            return field // field 相当于 backing field
        }
        set(value) {
            field = value
        }

    var name: String = name
    var sex: Int = sex


}


fun main() {
    var person = Person(18,"dev",0)
    // kotlin 的 属性引用；和 函数引用很类似
    val ageReference = Person::age // 未绑定 Receiver
    ageReference.set(person, 29)
    println("ageReference = ${ageReference.get(person)}")

    val nameReference = person::name  // 绑定 Receiver （person）
    nameReference.set("dev.liang")
    println("nameReference = ${nameReference.get()}")



}







