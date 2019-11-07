package com.android.kotlin.entity

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/11/07 15:57
 */
class User {
    // ？表示可空类型
    var userName: String? = null
    var passWord: String? = null
    var code: String? = null

    /**
     * 空构造，可以省略 { }
     */
    constructor()

    constructor(userName: String?, passWord: String?, code: String?) {
        this.userName = userName
        this.passWord = passWord
        this.code = code
    }


}