package com.kotlin.practice.advancedtypes.visibilities

/**
 * TODO
 *
 * 类构造器里参数
 * var/val name:String 使用了 var/val 后，表示构造器的参数，同时还表示定义类的属性！！ ----> 类内全局可见
 * 反之没有使用 var/val 声明，则就是 普通的构造器参数；如 age:Int； ----> 构造器内可见（init 块、属性初始化）
 *
 *
 * class Person constructor(var name:String, age:Int) 可简写为
 * classPerson(var name:String, age:Int)
 *
 *
 * @JvmOverloads 添加 @JvmOverloads 后，主构造器默认参数在 java 代码中可以以重载的形式存在；在 java 中调用时候；
 *
 *
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2020/02/19 12:44
 */
class Person @JvmOverloads constructor(var name: String = "dev.liang", age: Int) {// 设置默认参数; private 私有构造

    var age: Int
    var firstName: String? = null
        // getter 的可见性必须与 属性可见性一致。
        get() {
            return "${field}234"
        }
        // private 私有化属性 setter 方法后，外部只能读取属性不能设置，设置只能 内部设置
        // setter 可见性 不能大于 属性的可见性
        set(value) {
            field = value
        }


    /**
     * 副构造器
     * 定义了主构造器后，在类内部再定义的构造器，叫做 副构造器
     *
     * : this(name,2) 调用主构造器，确保 构造路径唯一性
     */
    constructor(name: String) : this(name, 2)

    /**
     * init 块 类似于主构造器的方法体
     *
     * init 块里 可以访问到构造器里的参数
     */
    init {
        this.age = age
        this.firstName = name
    }
}

fun main() {
    val p = Person("liang",2)
    p.firstName = "3"
    val str = p.firstName
    println(str)
}

