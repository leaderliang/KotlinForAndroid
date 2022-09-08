package com.kotlin.common.advancedtypes.visibilities

import com.kotlin.common.advancedtypes.visibilities.core.CoreApiKotlinA
import com.kotlin.common.advancedtypes.visibilities.core.CoreApiKotlinB


class ApiKotlin {
    private val coreApiKotlinA = CoreApiKotlinA()
    private val coreApiKotlinB = CoreApiKotlinB()


    fun a(){
        coreApiKotlinA.a()
    }

    fun b(){
        coreApiKotlinB.b()
    }
}
