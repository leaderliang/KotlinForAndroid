package com.kotlin.practice.advancedtypes.innerclasses;

public class JavaInnerClasses {
    public static void main(String... args) {
        class LocalClass implements Cloneable, Runnable {
            @Override
            public void run() { }
        }

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
    }
}
