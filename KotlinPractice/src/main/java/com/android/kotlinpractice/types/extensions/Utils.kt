package com.android.kotlinpractice.types.extensions

/**
 * TODO
 *
 * kotlin  的拓展方法
 *
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2020/01/29 22:08
 */

/**
 * String is receiver;
 * 相当于为 string 类拓展了方法；
 *
 * 自己定义的类也可以拓展方法
 */
/*fun String.isEmail() : Boolean {
    // ...
    return false
}*/


fun main() {
    "dev.liang@outlook.com".isEmail()
}
