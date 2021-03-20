package com.kotlin.practice.advancedtypes.visibilities;


import com.kotlin.common.advancedtypes.visibilities.core.CoreApiKotlinA;


/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2020/03/05 17:12
 */
public class Test {

    public static void main(String[] args) {

        CoreApiKotlinA coreApiKotlinA = new CoreApiKotlinA();
//        coreApiKotlinA.a$Common();

//        可以通过 @JvmName("") 来阻止 java 调用 对应的这个方法。
//        coreApiKotlinA.%abcd();

        int a = 3, b = 4;
        if (a > 2 & b > 5) {
            System.out.println(" & ");
        } else if (a > 2 && b > 5) {
            System.out.println(" && ");
        }
    }
}
