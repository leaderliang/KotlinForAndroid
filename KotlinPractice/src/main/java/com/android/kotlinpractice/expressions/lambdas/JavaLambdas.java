package com.android.kotlinpractice.expressions.lambdas;

public class JavaLambdas {
    public static void main(String... args) {
        Runnable lambda = () -> {
            System.out.println("Hello");
        };

//        var lambda2 = () -> {
//            System.out.println("Hello");
//        };

        Function1 f1 = (p) -> {
            System.out.println(p);
            return "Hello";
        };

        Function2 f2 = (p0, p1) -> {
            System.out.println(p0 + p1);
            return "World";
        };

        String result = f1.invoke(2);
        f2.apply(1, 2);
    }

    //SAM = Single abstract method

    interface Function1 {
        String invoke(int p);
    }

    interface Function2 {
        String apply(int p0, long p1);
    }
}
