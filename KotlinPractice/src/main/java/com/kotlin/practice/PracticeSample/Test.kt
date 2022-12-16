package com.kotlin.practice.PracticeSample


/**
 * TODO
 *
 * Note:
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2022/12/08 20:51
 */
class Test(size: Int) {
//    public  constructor(size: Int, init: (Int) -> Int) : this()

}


var tag: String? = null

const val b: Int = 0

const val bb = "asdf"

const val bbb = 2.0

fun main() {

//    b = 5 // 不能重新赋值

    if (tag != null) {
        // 外部 的 tag 在这里获取 length 会报错，虽然判断不为空，但其他线程可能对它做了修改
//        println(tag.length)
    }

//    println("admin@bennyhuo.com".isEmail())

    val person = Person()
    val name = person.name
    val title = person.title

    val nameLength = name?.length
    val titleLength = title.length
    println(nameLength) // null
    println(titleLength) // 4


    // 拓展方法
    /*File("").writeText("asdfasdf")
    File("asdfasdf").writer().buffered().use {
        it.write("")
    }*/

    // 运算符重载
    /*var a = 1¥
    println(a.inc())
    println(a++)
    println(++a)

    println(a--)
    println(a.dec())
    println(--a)*/


    println("hello world" rotate 5)

/*    func()// 用变量调用函数
    func.invoke()*/


    val intArray = IntArray(5) { it + 1 }
    println(intArray.joinToString())
    println(intArray.contentToString())

    intArray.forEach(::print)
    intArray.forEach(::println)// println 的类型 (Int) -> Unit

    // 只有一个 lambda 表达式作为参数的函数，可省略掉小括号
    intArray.forEach {
        println("int 数组数据: $it")
    }

    println()

    // 内联函数
//    cost(func)
    cost {
        println("test cost $it")
    }
    costNoInline{
        println("test costNoInline $it")
    }
}


// 匿名函数，func 是变量名
val func = fun() {
    println("hello world")
}

/**
 * 中缀表达式（有一个 receiver 和 只有一个参数 就是中缀表达式）
 * 必须使用 infix 关键字 标识
 */
infix fun String.rotate(count: Int): String {
    val index = count % length
    return this.substring(index) + this.substring(0, index)
}

/*内联函数*/
/**
 * 调用
 *  cost {
        println("test cost $it")
    }
 * 内联函数
 * 相当于在调用处直接执行的
 *  val start = System.currentTimeMillis()
    println("test cost 23333")
    println("${System.currentTimeMillis() - start }ms")
 *
 *
 */
inline fun cost(block: (Int) -> Unit) {
    val start = System.currentTimeMillis()
    block(23333)
    println("${System.currentTimeMillis() - start }ms")
}

fun costNoInline(block: (Int) -> Unit) {
    val start = System.currentTimeMillis()
    block(23333)
    println("${System.currentTimeMillis() - start }ms")
}

