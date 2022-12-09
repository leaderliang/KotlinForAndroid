package com.kotlin.practice.PracticeSample

import com.kotlin.practice.types.extensions.isEmail
import java.io.File

/**
 * TODO
 *
 * Note:
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2022/12/08 20:51
 */
class Test {


}

var tag:String? = null

fun main() {
    if (tag != null){
        // 外部 的 tag 在这里获取 length 会报错，虽然判断不为空，但其他线程可能对它做了修改
//        println(tag.length)
    }

    println("admin@bennyhuo.com".isEmail())

    val person = Person()
    val name = person.name
    val title = person.title

    val nameLength = name?.length
    val titleLength = title.length
    println(nameLength) // null
    println(titleLength) // 4


    File("").writeText("asdfasdf")
    File("asdfasdf").writer().buffered().use {
        it.write("")
    }

}
