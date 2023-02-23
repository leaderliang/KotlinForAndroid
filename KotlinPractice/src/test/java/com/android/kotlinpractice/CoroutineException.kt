package com.android.kotlinpractice

import kotlinx.coroutines.*
import org.junit.Test

/**
 * TODO
 *
 * Note:
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2023/02/20 10:03
 */
class CoroutineException {

    /**
     * current thread name DefaultDispatcher-worker-1 @test CoroutineContext#2
     */
    @Test
    fun `test CoroutineContext`(): Unit = runBlocking {
        launch (Dispatchers.Default  + CoroutineName(name = "test CoroutineContext")) {
            println("current thread name ${Thread.currentThread().name}")
        }
    }

    @Test
    fun `test CoroutineContext `() = runBlocking<Unit> {
        launch (Dispatchers.Default  + CoroutineName(name = "test CoroutineContext")) {
            println("current thread name ${Thread.currentThread().name}")
        }
    }

    /**
     * JUnit test should return Unit
     * 不添加返回值类型，会报错
     * Execution failed for task ':KotlinPractice:testDebugUnitTest'.
     * > No tests found for given includes: [com.android.kotlinpractice.CoroutineException.test CoroutineContext](filter.includeTestsMatching)
     */
    @Test
    fun `test CoroutineContext  `() = runBlocking {
        launch (Dispatchers.Default  + CoroutineName(name = "test CoroutineContext")) {
            println("current thread name ${Thread.currentThread().name}")
        }
        println("thread name ${Thread.currentThread().name}")
    }















    @Test
    fun `test supervisorScope`(): Unit = runBlocking {
        supervisorScope {
            val child = launch {
                try {
                    println("in launch")
                    delay(Long.MAX_VALUE)
                }finally {
                    println("this child is canceled")
                }
            }
            yield()

            println("throw an exception")
            throw RuntimeException("作用域中抛出异常")
        }
    }


}