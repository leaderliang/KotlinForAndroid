package com.kotlin.common.advancedtypes.visibilities;

public class ApiJava {
    private CoreApiJavaA coreApiJavaA = new CoreApiJavaA();
    private CoreApiJavaB coreApiJavaB = new CoreApiJavaB();

    public void a(){
        coreApiJavaA.a();
    }

    public void b(){
        coreApiJavaB.b();
    }
}
