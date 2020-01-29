package com.android.kotlinpractice.types.classes.kotlin

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2020/01/28 20:55
 */
abstract class AbstractClass {
    abstract fun absMethod()

    open fun overridable(){}

    // kotlin 中若要继承父类方法，如果不是 abstract 方法或者接口方法，那就必须要添加 open 关键字；要不然无法继承使用
    fun nonOverridable(){}
}