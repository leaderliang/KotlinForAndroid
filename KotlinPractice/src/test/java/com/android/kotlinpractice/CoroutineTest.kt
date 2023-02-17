package com.android.kotlinpractice

import kotlinx.coroutines.*
import org.junit.Test
import java.lang.IllegalStateException

/**
 * TODO
 *
 * Note:
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2023/02/17 11:32
 */
public class CoroutineTest {
    //  runBlocking{} 需要嵌套 coroutineScope{} 来执行
    // coroutineScope: 一个协程失败了，所有其他兄弟协程也会被取消；
    @Test
    public fun `test coroutine scope builder`() = runBlocking {
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
    public fun `test supervisor scope builder`() = runBlocking {
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


