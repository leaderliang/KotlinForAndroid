package com.kotlin.practice.advancedtypes.enums;

public class JavaEnums {
    enum State
            implements Runnable {
        Idle {
            @Override
            public void run() {

            }
        }, Busy {
            @Override
            public void run() {

            }
        };
    }





    public static void main(String... args) {
        System.out.println(State.Idle.getClass().getSuperclass().getSuperclass());

        System.out.println(State.Idle.name()); // Idle
        System.out.println(State.Idle.ordinal()); // 0
    }
}
