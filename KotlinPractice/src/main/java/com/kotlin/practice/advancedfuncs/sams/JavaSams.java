package com.kotlin.practice.advancedfuncs.sams;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JavaSams {

    public static void main(String... args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("run in executor.");
            }
        });

        executor.submit(() -> System.out.println("run in executor."));

        submit(new Function() { // cannot sam.
            @Override
            void apply() {

            }
        });

        submit(() -> {

        });

        KotlinSamsKt.submit(() -> {
            System.out.println("Hello");
        });
    }

    public static void submit(Function function){
        function.apply();
    }

    public static void submit(Invokable invokable){
        invokable.invoke();
    }
}

abstract class Function {
    abstract void apply();
}