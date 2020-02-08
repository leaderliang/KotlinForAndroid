package com.kotlin.practice.advancedfuncs.sequences;

import java.util.ArrayList;
import java.util.Arrays;

public class JavaStreams {
    public static void main(String... args) {
        //region for loop
//        for (int i = 0; i < 10; i++) {
//            System.out.println(i);
//        }
//        int x = 0;
//        while (x++ < 10) {
//            System.out.println(x);
//            if (x == 5) break;
//        }
        //endregion

        var list = new ArrayList<Integer>();
        list.addAll(Arrays.asList(1, 2, 3, 4));

        //region stream
//        list.stream()
//                .filter(e -> {
//                    System.out.println("filter: " + e);
//                    return e % 2 == 0;
//                })
//                .map(e -> {
//                    System.out.println("map: " + e);
//                    return e * 2 + 1;
//                })
//                .forEach(e -> {
//                    System.out.println("forEach: " + e);
//                });
        //endregion

        list.stream().flatMap(e -> {
            ArrayList<Integer> integers = new ArrayList<>(e);
            for (int i = 0; i < e; i++) {
                integers.add(i);
            }
            return integers.stream();
        });

        //[1,2,3] -> [0,0,1,0,1,2]






        //region
//        list.forEach((e) -> {
//            if (e == 2) return;
//            System.out.println(e);
//        });
//
//        list.stream()
//                .filter(e -> e % 2 == 0)
//                .forEach(System.out::println);
//
//        list.stream()
//                .map(e -> e * 2 + 1);
//
//        list.stream().flatMap(e -> {
//            ArrayList<Integer> integers = new ArrayList<>(e);
//            for (int i = 0; i < e; i++) {
//                integers.add(i);
//            }
//            return integers.stream();
//        });
//
////        list.stream().flatMap(e -> {
////
////        })
//
//
//        var string = list.parallelStream().reduce("", (stringBuilder, integer) -> {
//            return stringBuilder + integer;
//        }, (stringBuilder, stringBuilder2) -> {
//            System.out.println(stringBuilder.toString() + ", " + stringBuilder2.toString());
//            return stringBuilder + stringBuilder2;
//        });
//
//        var stringCollected = list.parallelStream().collect(() -> new StringBuilder(), (stringBuilder, integer) -> {
//            stringBuilder.append(integer);
//        }, (stringBuilder, stringBuilder2) -> {
//            System.out.println(stringBuilder.toString() + ", " + stringBuilder2.toString());
//            stringBuilder.append(stringBuilder2);
//        });
//
//        System.out.println(string);
//        System.out.println(stringCollected);
        //endregion
    }
}
