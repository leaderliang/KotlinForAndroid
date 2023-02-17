package com.android.kotlinpractice

import kotlinx.coroutines.*
import org.junit.Test
import java.lang.IllegalStateException
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

/**
 * TODO
 *
 * Note:
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2023/02/17 11:32
 */

class CoroutineTest {

    // launch 和 async 的用法
    @Test
    fun `test coroutine builder launch and async`() = runBlocking {
        val job1 = launch {
            delay(200)
            println("job1 finished")
            "job1 result"
        }

        val job2 = async {
            delay(1000)
            println("job2 finished")
            "job2 result"
        }

//        println(job2.start()) // false
        println(job2.await()) // job2 result
//        println(job2.join()) // kotlin.Unit

//        println(job1.join())

    }


    /**
     *  不使用 join ，执行顺序为 Two, Three，One
     *  使用 join 启动协程后，顺序为 One, Two, Three
     */
    @Test
    fun `test coroutine join`() = runBlocking {
        val job1 = launch {
            delay(2000)
            println("One")
        }
        job1.join()

        val job2 = launch {
            delay(200)
            println("Two")
        }

        val job3 = launch {
            delay(200)
            println("Three")
        }
    }


    // await 使用
    // await 可以拿到协程的返回结果
    @Test
    fun `test coroutine await`() = runBlocking {
        val job1 = async {
            delay(2000)
            println("One")
            "async job1 result"
        }
        println(job1.await())

        val job2 = async {
            delay(200)
            println("Two")
        }

        val job3 = async {
            delay(200)
            println("Three")
        }
    }



//    async 组合并发
//    下面为同步方式执行，耗时两秒多
    @Test
    fun `test async`() = runBlocking {
        val time = measureTimeMillis {
            val one = doOne()
            val two = doTwo()
            println("result: ${one + two}")
        }

        println("spend time $time  ms")


    }


    /**
     * result: 143
        spend time 1023  ms
     */
    @Test
    fun `test combine async`() = runBlocking {
        val time = measureTimeMillis {
            val one = async {
                doOne()
            }
            val two = async {
                doTwo()
            }
            println("result: ${one.await() + two.await()}")
        }
        println("spend time $time  ms")
    }


    /**
     * 下面这种方式写法有问题，耗时两秒多
     *
     * result: 143
    spend time 2035  ms
     */
    @Test
    fun `test combine async   `() = runBlocking {
        val time = measureTimeMillis {
            val one = async {
                doOne()
            }.await()
            val two = async {
                doTwo()
            }.await()
            println("result: ${one + two}")
        }
        println("spend time $time  ms")
    }


    private suspend fun doTwo():Int {
        delay(1000)
        return 66
    }

    private suspend fun doOne():Int {
        delay(1000)
        return 77
    }






    // join   ( launch 配合 join 一起使用)

    //      runBlocking{} 需要嵌套 coroutineScope{} 来执行
//     coroutineScope: 一个协程失败了，所有其他兄弟协程也会被取消；
//    使用场景：
//    多个接口请求结果，要求其中一个返回数据异常或其他问题，其他未执行的就全部取消任务；
    @Test
    fun `test coroutine scope builder`() = runBlocking {
        coroutineScope {
            val job1 = launch {
                delay(400)
                println("job1 finished")
            }

            val job2 = async {
                delay(200)
                println("job2 finished")
                "job2 result"
                throw IllegalStateException()
            }

//            println(job2.await())

        }
    }


    // supervisorScope: 一个协程失败了，不会影响其他兄弟协程。
    @Test
    fun `test supervisor scope builder`() = runBlocking {
        supervisorScope {
            val job1 = launch {
                delay(400)
                println("job1 finished")
            }

            val job2 = async {
                delay(200)
                println("job2 finished")
                "job2 result"
                throw IllegalStateException()
            }
        }
    }
}


