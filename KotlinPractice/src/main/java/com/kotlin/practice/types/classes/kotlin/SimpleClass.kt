package com.kotlin.practice.types.classes.kotlin

/**
 * TODO
 *
 * kotlin 中若要继承父类方法，如果不是 abstract 方法或者接口方法，那就必须要添加 open 关键字；要不然无法继承使用
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2020/01/27 21:23
 */
open class SimpleClass (var a:String,val b:Int) /*constructor( a:String, b:Int)*/ : AbstractClass(), SimpleInterface{


    override fun simpleMethod() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override var simpleProperty: Int = 0
        get(){
            return 19
        }

        set(value) {
            field = value
        }

    /**
     * kotlin 中若要继承父类方法，如果不是 abstract 方法或者接口方法，那就必须要添加 open 关键字；要不然无法继承使用
     */
    override fun overridable() {
        super.overridable()
    }


    override fun absMethod() {

    }

    /**
     * 默认构造器写法
     */
//    constructor(a:String, b:Int){
//    }

    val ss = a
    val cc = b

    fun aaa() {
        a = ""
//        b = 4
    }


}

class SimpleClass2(x: String, y: Int): SimpleClass(x, y){

}