package com.android.kotlinpractice

import kotlinx.coroutines.*
import org.junit.Test
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
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
    /**
     * result: 143
    spend time 2025  ms
     */
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


    private suspend fun doTwo(): Int {
        delay(1000)
        return 66
    }

    private suspend fun doOne(): Int {
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
//        CoroutineScope
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


    @Test
    fun `test cancellationException`() = runBlocking {
        var job = GlobalScope.launch {
            try {
                delay(5000)
                println("job print")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        delay(100)
//        job.cancel()
        job.join()
//        job.cancelAndJoin()

    }


    /**
     * cpu 密集型任务，执行取消操作
     */
    @Test
    fun `test cancel cpu task by isActive`() = runBlocking {
        val startTime = System.currentTimeMillis()
        val job = launch(Dispatchers.Default) {
            var nextPrintTime = startTime
            var i = 0
            // 调用 cancel 后，任务就会进入到 canceling 状态，此状态 isActive = false，isCancelled = true；
            while (i < 5 && isActive) {
                // if 条件里的（System.currentTimeMillis()）时间是在不断的进行累加，如果时间小于后面的 nextPrintTime，则不会执行，然后不断进行if 判断，cpu 密集型的抢占任务，抢站 CPU 的资源
                if (System.currentTimeMillis() >= nextPrintTime) {
                    nextPrintTime += 500
                    println("job: I'm sleeping ${i++}....")
                }
            }
        }
        delay(1300)
        println("main: I'm tired of waiting!")
        job.cancelAndJoin()
        println("main: Now I can quit.")
    }


    /**
     * ensureActive()  通过抛出异常，来退出对应的 while 循环
     */
    @Test
    fun `test cancel cpu task by ensureActive`() = runBlocking {
        val startTime = System.currentTimeMillis()
        val job = launch(Dispatchers.Default) {
            var nextPrintTime = startTime
            var i = 0
            // 调用 cancel 后，任务就会进入到 canceling 状态，此状态 isActive = false，isCancelled = true；
            while (i < 5) {
//                try {
                ensureActive()
//                }catch (e: Exception) {
//                    e.printStackTrace()
//                }
                // if 条件里的（System.currentTimeMillis()）时间是在不断的进行累加，如果时间小于后面的 nextPrintTime，则不会执行，然后不断进行if 判断，cpu 密集型的抢占任务，抢站 CPU 的资源
                if (System.currentTimeMillis() >= nextPrintTime) {
                    nextPrintTime += 500
                    println("job: I'm sleeping ${i++}....")
                }
            }
        }
        delay(1300)
        println("main: I'm tired of waiting!")
        job.cancelAndJoin()
        println("main: Now I can quit.")
    }


    /**
     * yield()  yield 函数会检查所在协程的状体啊，如果已经取消，则抛出 CancellationException 予以响应，此外，它还会尝试出让线程的执行权，给其他协程提供执行机会。
     */
    @Test
    fun `test cancel cpu task by yield`() = runBlocking {
        val startTime = System.currentTimeMillis()
        val job = launch(Dispatchers.Default) {
            var nextPrintTime = startTime
            var i = 0
            // 调用 cancel 后，任务就会进入到 canceling 状态，此状态 isActive = false，isCancelled = true；
            while (i < 5) {
//                try {
                yield()
//                }catch (e: Exception) {
//                    e.printStackTrace()
//                }
                // if 条件里的（System.currentTimeMillis()）时间是在不断的进行累加，如果时间小于后面的 nextPrintTime，则不会执行，然后不断进行if 判断，cpu 密集型的抢占任务，抢站 CPU 的资源
                if (System.currentTimeMillis() >= nextPrintTime) {
                    nextPrintTime += 500
                    println("job: I'm sleeping ${i++}....")
                }
            }
        }
        delay(1300)
        println("main: I'm tired of waiting!")
        job.cancelAndJoin()
        println("main: Now I can quit.")
    }


    /**
     * 释放资源，  finally
     */
    @Test
    fun `test release resources`() = runBlocking {
        val job = launch {
            try {
                repeat(1000) {
                    println("job: I'm sleeping ${it}....")
                    delay(500)
                }
            } finally {
                println("finally: release resource ")
            }
        }

        delay(1300)
        println("main: I'm tired of waiting!")
        job.cancelAndJoin()
        println("main: Now I can quit.")
    }


    /**
     * use 自动关闭资源
     *
     *
     * inputStream() 打开一个文件，读取 二进制
     * reader() 读取 char
     * buffered() BufferedReader
     *
     */
    fun printFileContent() {
        File("/Users/liangyanqiao/AndroidStudioProjects/KotlinForAndroid/build.gradle.kts").inputStream()
            .reader().buffered()
            .use {
                // 只打印第一行内容
                println(it.readLine())
                // 全部打印
                println(it.readLines())
            }
    }


    /**
     * use
     *
     */
    @Test
    fun `test use function`() = runBlocking {

        var br =
            BufferedReader(FileReader(File("/Users/liangyanqiao/AndroidStudioProjects/KotlinForAndroid/README.md")))
        with(br) {
            var line: String
            // try-finally can be replaced with 'use()'
            try {
                while (true) {
                    line = readLine() ?: break
                    println(line)
                }
            } finally {
                close()
            }

            // 可转化为使用 use
            use {
                while (true) {
                    line = readLine() ?: break
                    println(line)
                }
            }
        }


        BufferedReader(FileReader(File("/Users/liangyanqiao/AndroidStudioProjects/KotlinForAndroid/build.gradle.kts")))
            .use {
                var line: String
                while (true) {
                    line = it.readLine() ?: break
                    println(line)
                }
            }
    }



    /**
     * nonCancelable
     */
    @Test
    fun `test cancel with nonCancelable`() = runBlocking {
        val job = launch {
            try {
                repeat(1000) {
                    println("job: I'm sleeping ${it}....")
                    delay(500)
                }
            } finally {
                println("finally: release resource ")
                delay(1000)
                println("test nonCancelable")
            }
        }

        delay(1300)
        println("main: I'm tired of waiting!")
        job.cancelAndJoin()
        println("main: Now I can quit.")
    }


    /**
     * 测试在 finally 中再次启动协程，不受 cancel 的影响
     * 这个  withContext(NonCancellable){} 不仅仅只能用在 finally 中，常驻任务不想被取消也可以直接使用这个
     * nonCancelable
     */
    @Test
    fun `test cancel with nonCancelable   `() = runBlocking {
        val job = launch {
            try {
                repeat(1000) {
                    println("job: I'm sleeping ${it}....")
                    delay(500)
                }
            } finally {
                println("finally: release resource ")
                withContext(NonCancellable){
                    delay(1000)
                    println("test nonCancelable")
                }
            }
        }

        delay(1300)
        println("main: I'm tired of waiting!")
        job.cancelAndJoin()
        println("main: Now I can quit.")
    }


    /**
     * 超时任务
     */
    @Test
    fun `test timeout with coroutine`() = runBlocking {
        withTimeout(1300){
            repeat(1000) {
                println("job: I'm sleeping ${it}....")
                delay(500)
            }
        }
    }


    /**
     * 超时任务
     */
    @Test
    fun `test timeout with coroutine `() = runBlocking {
         val result = withTimeoutOrNull(1300){
            repeat(1000) {
                println("job: I'm sleeping ${it}....")
                delay(500)
            }
             "可以添加任意类型返回值，timeOut 的话，就会返回 null"
        }  ?: "超时返回的值"

        println("result is $result")
    }

}


