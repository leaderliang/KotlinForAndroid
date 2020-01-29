package com.android.kotlinpractice.types.smartcasts;


import com.android.kotlinpractice.types.smartcasts.java.Kotliner;
import com.android.kotlinpractice.types.smartcasts.java.Person;

public class JavaCasts {
    public static void main(String... args) {


        Kotliner kotliner = new Person("benny", 20);
        if(kotliner instanceof Person){
            System.out.println(((Person) kotliner).name);
        }



    }
}


