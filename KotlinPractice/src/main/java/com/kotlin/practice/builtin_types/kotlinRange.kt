package com.kotlin.practice.builtin_types

/**
 * TODO
 * 区间
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2020/01/23 15:58
 */

fun main() {

    // 创建闭区间；离散值
    val intRange = 1..10 // [1,10]
    val charRange = 'a'..'z'
    val longRange = 1L..10L

    // 连续的值
    val floatRange = 1.0f..2.0f
    val doubleRange = 1.0..5.0


    // 创建开区间  前闭后开区间，until 不包含结束值
    val intRangeExclusive = 1 until 10

    // 倒序区间
    val intRangeReverse = 10 downTo 1

    // 区间的步长
    val intRangeWithStep = 1 .. 10 step 2



    println(intRange.joinToString())
    println(charRange.joinToString())
    println(longRange.joinToString())

    // 没有 joinToString 方法，因为是不可数的；
    println(floatRange)

    println(intRangeExclusive.joinToString())
    println(intRangeReverse.joinToString())
    println(intRangeWithStep.joinToString())

    // 无符号类型
    val uIntRange = 1u..10u
    val uLongRange = 1UL..10UL
    println(uIntRange.joinToString())
    println(uLongRange.joinToString())

    // 区间的迭代
    for(e in intRange){
        println("迭代->$e")
    }

    intRange.forEach {it->
        println("forEach-> $it")
    }

    // 对于浮点型的数值区间，in 只能用来判断是否在区间内   !in
    if(3.0 in doubleRange){
        println("3 in range 'intRange'")
    }

    // 对于整型的数值离散区间，in 除了用来判断是否在区间内，还能进行迭代！
    if(12 !in intRange)
        println("12 not in range 'intRange'")

    // 类似 java 中 i++ 的写法
    val array = intArrayOf(1,2,3,4,5)
    for(i in 0 until array.size){
        println(array[i])
    }
    // indices 返回 [0，array.size）;   0 until array.size ---> array.indices
    for(i in array.indices){
        println("{${array[i]}}  {${array.indices.joinToString()}}")
    }



































}