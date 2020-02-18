package com.kotlin.practice.advancedfuncs.eg

import java.io.File

/**
 * TODO
 * 打印文件字符数
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2020/02/15 16:32
 */


class BlockNodes(val name: String) {

    val children = ArrayList<Node>()
    val properties = HashMap<String, Any>()


    operator fun String.invoke(block: BlockNode.()-> Unit): BlockNode {
        val node = BlockNode(this)
        node.block()
        this@BlockNodes.children += node
        return node
    }

    operator fun String.invoke(value: Any) {
        this@BlockNodes.properties[this] = value // "charset"("UTF-8")， this 指的是 charset
    }

    operator fun String.unaryPlus(){
        this@BlockNodes.children += StringNode(this)
    }

    fun test(){
        "charset"("UTF-8")
        properties.forEach{
            println("${it.key} ${it.value}")
        }
    }
}



fun main() {
    File("settings.gradle").readText() // read file
        .toCharArray()
//        .filterNot { it.isWhitespace() } // 不包含 空格
//        .filterNot(Char::isWhitespace)
        .filter { !it.isWhitespace() }
        .groupBy { it }
        .map {
            it.key to it.value.size
        }.let {
            println(it)
        }





    BlockNodes("").test()



}

