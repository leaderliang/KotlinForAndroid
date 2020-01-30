package com.android.kotlinpractice.expressions.conditions;

public class JavaConditions {
    public static void main(String... args) {
        int a = 2;
        int c;
        if (a == 3) {
            c = 4;
        } else {
            c = 5;
        }

        c = a == 3 ? 4 : 5;


        switch (a) {
            case 0:
                c = 5;
                break;
            case 1:
                c = 100;
                break;
            default:
                c = 20;
        }

        int b = 0;

        try {
            c = a / b;
        } catch (ArithmeticException | NullPointerException e) {
            e.printStackTrace();
            c = 0;
        }


    }
}
