package com.kotlin.practice.advancedtypes.inlineclasses

/**
 * TODO 内联类
 *
 *
 * 构造方法里必须有一个参数，而且还要声明为 val；
 * 不能继承父类或者被继承；内联类可以实现接口；
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2020/03/05 18:51
 */
inline class InlineClasses(val b:String) :Comparable<Int>{

    val a:Int
    get() {
        return 1
    }

    override fun compareTo(other: Int): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}