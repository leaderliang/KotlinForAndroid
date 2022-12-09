package com.kotlin.practice.types.extensions


/**
 * 拓展成员里面除了可以 拓展方法之外，还可以拓展的属性；
 *
 * 接口里面也可以定义属性，包括方法的默认实现，但是这些 都不能有状态（backing field）；setter，getter 是属于行为
 *
 *
 * 接口属性不能有 backing field；
 * 接口没有状态；
 * 接口不能存储东西，只能定义行为；
 *
 *
 */




class PoorGuy{
    var pocket: Double = 0.0
}

fun PoorGuy.noMoney(){

}

//property = backing field + getter + setter
var PoorGuy.moneyLeft: Double
    get() {
        return this.pocket
    }
    set(value) {
        pocket = value
    }


/**
 * 接口属性不能有 backing field；
 * 接口没有状态；
 * 接口不能存储东西，只能定义行为；
 */
interface Guy {
    var moneyLeft: Double
        get() {
            return 0.0 // field
        }
        set(value) {

        }

    fun noMoney(){
        println("no money called.")
    }
}


/**
 * kotlin 拓展方法，拓展 string 的 方法
 */
fun String.padding(count: Int, char: Char = ' '): String {
    val padding = (1 .. count).joinToString(""){ char.toString() }
    return "${padding}${this}${padding}"
}

fun String.isEmail(): Boolean {
    return matches(Regex("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])"))
}

fun String.times(count: Int): String {
    return (1 .. count).joinToString(separator= "--") { this }
}



fun main() {

    "admin@bennyhuo.com".isEmail()


    println("Hello".padding(1))

    println("*".times(10))

    val stringTimes = String::times
    val stringTimesBound = "*"::times

    arrayOf(1,3,3).forEach {  }

    val x = 2
}