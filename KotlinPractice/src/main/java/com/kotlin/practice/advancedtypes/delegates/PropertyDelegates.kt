package com.kotlin.practice.advancedtypes.delegates

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * TODO
 *
 * 属性代理
 *
 * 作用：减少代码编写，让代码更具表现力；
 *
 * by lazy
 *
 * by Delegates.observable
 *
 *
 * 拓展：
 *
 * by vetoable 的使用场景 和 原理？
 *
 * 分析 Delegates 下的 notNull() 使用方法 和 lateinit 做对比？
 *
 * 思考属性代理在简化配置读写方面有哪些作用？
 * 代理文件，代理 property、android SP 的读写，像读写变量一样
 *
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2020/02/20 16:14
 */
class Person(val name: String){

    // 接口 lazy 的实例 代理了 Person 实例的属性 firstName 的 getter
    val firstName by lazy {
        name.split(" ")[0] // [0] 使用的索引运算符
    }
    val lastName by lazy {
        name.split(" ")[1]
    }
}

class StateManager {

    // 代理执行 setter 操作
    // ReadWriteProperty 的实例代理了属性 state 的 getter 和 setter ；
    // to see @kotlin.properties.ReadWriteProperty
    var state:Int by Delegates.observable(0, {
        property: KProperty<*>, oldValue: Int, newValue: Int ->
        // 实现监听 属性变化操作
        println("State changed from  $oldValue -> $newValue")
    })

/*    var state: Int by Delegates.observable(0) {
            property, oldValue, newValue ->
        println("State changed from  $oldValue -> $newValue")
    }*/


    /**
     * 这是  ReadWriteProperty 接口
     *
     * Base interface that can be used for implementing property delegates of read-write properties.
     *
     * This is provided only for convenience; you don't have to extend this interface
     * as long as your property delegate has methods with the same signatures.
     *
     * @param R the type of object which owns the delegated property.
     * @param T the type of the property value.
     */
    public interface ReadWriteProperty<in R, T> {
        /**
         * Returns the value of the property for the given object.
         * @param thisRef the object for which the value is requested.
         * @param property the metadata for the property.
         * @return the property value.
         */
        public operator fun getValue(thisRef: R, property: KProperty<*>): T

        /**
         * Sets the value of the property for the given object.
         * @param thisRef the object for which the value is requested.
         * @param property the metadata for the property.
         * @param value the value to set.
         */
        public operator fun setValue(thisRef: R, property: KProperty<*>, value: T)
    }


}


class Foo {
    val x: Int by X()

    var y: Int by X()
}

/**
 * 参考 接口类 ReadWriteProperty 里的实现即可，不一定需要实现 接口  ReadWriteProperty
 */
class X {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return 2
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, i: Int) {

    }
}

fun main() {
//    Person("Yuan Liang").firstName
//    Person("Yuan Liang").lastName

    // "liang dev".split(" ") 类型是 List<String>[3] 相当于 索引 也可写成，"liang dev".split(" ").get(0)
    var listString = "liang dev".split(" ")[0]
    println(Person("liang dev").firstName)


    val stateManager = StateManager()
    stateManager.state = 3
    stateManager.state = 4



    println(Foo().x)
}
