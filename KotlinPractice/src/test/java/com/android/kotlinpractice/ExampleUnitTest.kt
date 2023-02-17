package com.kotlin.practice

import kotlinx.coroutines.*
import org.junit.Test

import org.junit.Assert.*
import java.lang.IllegalStateException

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }


    /**
     * 反引号中的函数名
    Kotlin可以使用空格和特殊字符对函数命名，不过函数名要用一对反引号括起来。(测试时可用)

    为了支持Kotlin和Java互操作，而Kotlin和Java各自却有着不同的保留关键字，不能作为函数名，使用反引号括住函数名就能避免任何冲突。


    使用空格和特殊字符对函数命名
    fun main() {
    `20211202 世界对称日`("公众号：帅次")
    }
    private fun `20211202 世界对称日`(name :String ){
    println(name)
    }
    ————————————————

    原文链接：https://blog.csdn.net/g984160547/article/details/121753664
     */

    // kotlin 反引号的使用
    // 首先需要明确反引号是哪个，反引号：键盘左上角与波浪线在一起的符号

    @Test
    fun main() {
        `string function name`("liang 。。。 ")

        `test coroutine scope builder`()
    }

    /// ```````
    fun `string function name`(name: String){
        println(name)

    }

    /*@Test
    fun 'string function name'() = runBlocking {
*/
    }

/*    @Test
    fun 'person from beijing' () {
        println("")
    }*/


/*'string function name'("liang 。。。 ")

private fun 'string function name'(name: String){
    println(name)

}*/

    //  runBlocking{} 需要嵌套 coroutineScope{} 来执行
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




