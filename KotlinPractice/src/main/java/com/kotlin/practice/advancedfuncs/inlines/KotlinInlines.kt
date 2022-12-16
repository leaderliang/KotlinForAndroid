package com.kotlin.practice.advancedfuncs.inlines

/**
 * TODO 内联函数
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2020/02/05 16:36
 */
fun main() {

    // region local return
    // forEach 内联函数

    /*public inline fun IntArray.forEach(action: (Int) -> Unit): Unit {
        for (element in this) action(element)
    }*/

    val ints = intArrayOf(1, 2, 3, 4)
    ints.forEach {
        if(it == 3) return@forEach // return@forEach 相当于 跳出这一次的内联函数调用
        println("Hello $it")
    }

    // 和下面这个 for 循环使用 continue 类似
    for (element in ints) {
        if(element == 3)
//            break
            continue
        println("Hello $element")
    }
    //endregion


    // region non-local return
    nonLocalReturn {
        // return 不是退出这个 lambda 表达式，而是退出 这个函数所在的外部函数，也就是从 main 函数中返回；
        // 当 nonLocalReturn 参数中添加 crossinline 后，这个 return 就会报错，不被允许；
        // 可以使用 return@nonLocalReturn
//        return@nonLocalReturn // 当 nonLocalReturn 参数中添加 crossinline 后，这个 return 就会报错，不被允许；
        return
    }
    // endregion

    println("test out nonLocalReturn")// 上面的 nonLocalReturn



    //region inline property 内联属性
    money = 5.0
    //endregion

}

inline fun nonLocalReturn(block: () -> Unit){// crossinline 表示 禁止 non-local return
    block()
}


// crossinline
// 函数参数前 添加 crossinline，表示 禁止 non-local return
// 需再参数 block 前添加 crossinline，否则 block() 会报错
// 有可能存在不合法的 non-local return
// 因为 block 的调用处与定义处不在同一个调用上下文
inline fun Runnable(crossinline block: () -> Unit):Runnable{
    return object:Runnable{
        override fun run() {
            block()
        }
    }
}

// noinline 禁止函数参数被内联 （不让 block inline 到 run 函数里面）
/*inline fun Runnable(noinline block: () -> Unit): Runnable {
    return object : Runnable {
        override fun run() {
            block()
        }
    }
}*/


// 内联属性；没有 backing-field 的属性，他只有 getter/setter ，getter/setter 本身也是函数，加了 inline 后，就可以和这些属性内联，
// 他的 getter/setter 可以被内联；
var pocket: Double = 0.0
var money: Double
    inline get() = pocket
    inline set(value) {
        pocket = value
    }






