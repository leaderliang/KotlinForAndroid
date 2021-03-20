package com.kotlin.practice.advancedtypes.enums;

/**
 * @author devliang
 */
public class JavaEnums {
    enum State implements Runnable {
        Idle {
            @Override
            public void run() {

            }
        },
        Busy {
            @Override
            public void run() {

            }
        };
    }

    public enum TestEnum {
        /**
         * agree
         */
        agree("agree"),
        /**
         * reject
         */
        reject("reject");

        private String action;

        TestEnum(String action) {
            this.action = action;
        }

        public String getAction() {
            return action;
        }
    }









    public static void main(String... args) {
        System.out.println(State.Idle.getClass().getSuperclass().getSuperclass());

        // Idle
        System.out.println(State.Idle.name());
        // Busy
        System.out.println(State.Busy.name());

        // 0  顺序
        System.out.println(State.Idle.ordinal());
        System.out.println(State.Busy.ordinal());


    }
}
