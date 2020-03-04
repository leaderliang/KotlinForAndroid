package com.kotlin.practice.advancedtypes.delegates


/**
 * 接口代理 "by"，代理接口对象
 *
 * 接口代理作用：减少代码编写，让代码更具表现力；
 *
 */

//region api
interface Api {
    fun a()
    fun b()
    fun c()
}

class ApiImpl : Api {
    override fun a() {}
    override fun b() {}
    override fun c() {}
}

// ": Api by api"  对象 api 代替类 ApiWrapper 实现接口 Api
class ApiWrapper(val api: Api) : Api by api {
    override fun c() {
        println("c is called.")
        api.c()
    }
}
//endregion


/**
 * 超级数组
 *
 * 接口代理，可以实现接口里面的部分方法和属性
 * by list
 * by map
 *
 */
class SuperArray<E>(
    private val list: MutableList<E?> = ArrayList(),
    private val map: MutableMap<Any, E> = HashMap()
) : MutableList<E?> by list, MutableMap<Any, E> by map {

    override fun isEmpty() = list.isEmpty() && map.isEmpty()

     override val size: Int
        get() {
            return list.size + map.size
        }
//        get() = list.size + map.size

    override fun clear() {
        list.clear()
        map.clear()
    }

    override operator fun set(index: Int, element: E?): E? {
        if (list.size <= index) {
            repeat(index - list.size + 1) {
                list.add(null)
            }
        }
        return list.set(index, element)
    }

    override fun toString(): String {
        return """List: [$list]; Map: [$map]"""
    }

}

fun main() {
    val superArray = SuperArray<String>()
    val superArray2 = SuperArray<String>()
    superArray += "Hello"
    superArray["Hello"] = "World"
    superArray2[superArray] = "World"

    superArray[1] = "world"
    superArray[4] = "!!!"

    println(superArray)
    println(superArray2)
}

