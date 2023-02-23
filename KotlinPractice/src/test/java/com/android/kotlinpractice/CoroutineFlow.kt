package com.android.kotlinpractice

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test

/**
 * TODO
 * 返回多个值，集合-序列-挂起函数-Flow
 *
 * Note:
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2023/02/22 15:43
 */
class CoroutineFlow {

    /**
     * 返回多个值，但不是异步
     */
     private fun simpleList(): List<Int> = listOf(2,3,5,6,7)

    /**
     * 返回了多个值，但是 属于同步
     * public fun <T> sequence(@BuilderInference block: suspend SequenceScope<T>.() -> Unit): Sequence<T> = Sequence { iterator(block) }
     */
    fun simpleSequence(): Sequence<Int> = sequence {
        for (i in 0..6){
//            Thread.sleep(1000)  // 阻塞的，不是异步，线程被占用，假装在计算耗时的任务
//            delay(1000) // 不能使用，因为 参数里只允许使用  SequenceScope<T>.() -> Unit 类型的   拓展方法 里支持的挂起函数，其他类型的挂起函数在这里不能使用
             yield(i) // yield() 往序列 Sequence  里添加数据,  一次一个

        }
    }

    /**
     * 返回多个值，是异步，一次性返回了多个值
     */
    private suspend fun simpleList2():List<Int> {
        delay(1000)
        return listOf(2,3,6,7,8,0)
    }


    /**
     * 返回多个值，是异步操作
     *
     * Flow 与其他方式的区别
     *
     * 名为 flow 的 Flow 类型构建器函数；
     * flow{...} 构建块中的代码可以挂起；
     * 函数 simpleFlow 不再标有 suspend 修饰符；
     * 流  使用 emit 函数进行发射值；
     * 流  使用 collect  函数收集值。
     *
     */
    private fun simpleFlow() = flow<Int> {
        for (i in 1..5) {
            delay(1000)
            // emit(i) 发射，产生一个元素
            emit(i)
        }
    }


    @Test
    fun `test multiple values with List`() {
        /*simpleList().forEach {
            println(it)
        }*/

        /*simpleSequence().forEach { println(it) }*/

    }

    @Test
    fun `test multiple values with List `() = runBlocking{
        simpleList2().forEach {
            println(it)
        }
    }


    /**
     * 序列
     * 返回多个值，是同步 形式的
     */
    @Test
    fun `test multiple values with Sequence`() {
        simpleList().forEach {
            println(it)
        }
    }


    /**
     * 执行结果不阻塞  launch 和  simpleFlow() 里的打印，交织执行
     */
    @Test
    fun `test multiple values `(): Unit = runBlocking {

        launch {
            for (k in 1..4) {
                println("print $k")
                delay(1500)
            }
        }

        simpleFlow().collect {
            println(it)
        }


    }

    /**
     * 调换完位置后，会阻塞，暂不知原因
     * 打印结果：
        1
        2
        3
        4
        5
        print 1
        print 2
        print 3
     *
     */
    @Test
    fun `test multiple values`(): Unit = runBlocking {
        simpleFlow().collect {
            println(it)
        }

        launch {
            for (k in 1..3) {
                println("print $k")
                delay(1500)
            }
        }

        println("finish")
    }







}