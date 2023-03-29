package com.android.kotlinpractice

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.selects.select
import org.junit.Test

/**
 * TODO
 *
 * Note:
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2023/03/27 18:09
 */
class CoroutineChannel {


    /**
     * channel 的迭代
     */
    @Test
    fun `test iterator channel`() = runBlocking {


        val channel = Channel<Int>(Channel.UNLIMITED)
        // 发送端，生产者
        val producer = GlobalScope.launch {
            for (i in 1..5) {
                channel.send(i * i)
                println("send   ${i * i}")
            }
        }


        //接收端， 消费者
        val consumer = GlobalScope.launch {

            val iterator = channel.iterator()
            while (iterator.hasNext()){
                val next = iterator.next()
                println("receive   $next")
                delay(1000)
            }

            // 用下面方式也可以迭代
            /*for (element in channel){
                println("receive   $element")
                delay(1000)
            }*/
        }

        // 使用 cancelAndJoin 不行
//        producer.cancelAndJoin()
//        consumer.cancelAndJoin()

//        producer.join()
//        consumer.join()
        // 或使用下面这种方式
        joinAll(producer, consumer)

    }


    /**
     * 测试多个接收端通过 channel 能否接收到消息
     */
    @Test
    fun `test iterator channel more consumer`() = runBlocking {


        val channel = Channel<Int>(Channel.UNLIMITED)
        // 发送端，生产者
        val producer = GlobalScope.launch {
            for (i in 1..5) {
                channel.send(i * i)
                println("send   ${i * i}")
            }
        }


        //接收端， 消费者
        val consumer = GlobalScope.launch {

            val iterator = channel.iterator()
            while (iterator.hasNext()){
                val next = iterator.next()
                println("receive1   $next")
                delay(1000)
            }

        }

        //接收端， 消费者
        val consumer2 = GlobalScope.launch {
            val iterator = channel.iterator()
            while (iterator.hasNext()){
                val next = iterator.next()
                println("receive2   $next")
                delay(1000)
            }

        }

        joinAll(producer, consumer, consumer2)
    }


    /****************************************** 复用多个 Channel  ******************************************/

    /**
     *
     * select 会选择 内部的执行，得到对应  onReceive  的返回结果；
     * select 就会返回对应发送的两条数据中其中一条的数据；
     *
     * 跟 await 类似，会接收到最快的那个 channel 消息;
        哪个先返回就先用哪个。

     */
    @Test
    fun `test select channel`() = runBlocking {
        val channels = listOf(Channel<String>(), Channel<String>())
        GlobalScope.launch {
            delay(100)
            channels[0].send("channel 1")
        }

        GlobalScope.launch {
            delay(50)
            channels[1].send("channel 2")
        }


        val result = select<String?> {
            channels.forEach{it ->
                // onReceive  onAwait 都属于  SelectClause1 类型
                it.onReceive{
                    it
                }
            }
        }
        println(result)
    }




    /****************************************** 复用多个 Channel  ******************************************/


}