package com.kotlin.common.advancedtypes.visibilities.core

internal class CoreApiKotlinA {

    /**
     * 可以通过 @JvmName("") 来阻止 java 调用 对应的这个方法。
     *
     * 不添加  @JvmName("%abcd") 时候，java 代码调用时候是  coreApiKotlinA.a$Common();
     */
    @JvmName("%abcd")
    internal fun a(){
        println("Hello A")
    }
}