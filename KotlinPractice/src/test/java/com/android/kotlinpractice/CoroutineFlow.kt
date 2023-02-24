package com.android.kotlinpractice

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
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
     * 调换完位置后，会阻塞，暂不知原因 ？？？？？
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


    /**************************************************************************************************/

    /**
     * Flow 是一种类似于序列的冷留，flow 构建器中的代码直到流被收集的时候才开始运行。
     *
     * 也就是只有去调用 collect 的时候，才会开始构建流，才会在里面发射元素。
     *
     *
     *
     * 冷流：相当于冷启动，临阵磨枪；
     * 热流：相当于热启动， 类似去创业，已经有一定的经验或资金积累了。
     */
    private fun simpleFlow2() = flow<Int> {
        println("simpleFlow2 start")
        for (i in 1..6) {
            delay(1000)
            // emit(i) 发射，产生一个元素
            emit(i)
        }
    }

    @Test
    fun `test flow is  code`() = runBlocking {
        val flow = simpleFlow2()
        println("call first collect")
        flow.collect{
            println(it)
        }

        println("call second collect")

        flow.collect{
            println(it)
        }
    }

    /*    执行结果：
        call first collect
        simpleFlow2 start
        1
        2
        3
        4
        5
        6
        call second collect
        simpleFlow2 start
        1
        2
        3
        4
        5
        6*/


    /**************************************************************************************************/

    /**
     * 流的连续性
     *
     * asFlow()：流的快速构建器
     */
    @Test
    fun `test flow continuation`() = runBlocking {
        (0..10).asFlow()
            .filter {
                it % 2 == 0
            }.map {
                "result $it"
            }.collect{
                println("collect  $it")
            }
    }

/*    打印：
   collect result 0
   collect result 2
   collect result 4
   collect result 6
   collect result 8
   collect result 10*/

    /**************************************************************************************************/

    /**
     * flowOf 构建器定义了一个发射固定值集的 流
     *
     * .asFlow() 拓展函数，可以将各种集合与序列转换为流。
     */
    @Test
    fun `test flow builder`() = runBlocking {
        flowOf("123",123,34f,"789")
            .onEach { delay(1000) }
            .collect{
                println(it)
            }

        (1..3).asFlow().collect{
            println(it)
        }

    }








}