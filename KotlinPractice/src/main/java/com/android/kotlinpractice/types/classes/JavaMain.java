package com.android.kotlinpractice.types.classes;


import com.android.kotlinpractice.types.classes.java.Person;
import com.android.kotlinpractice.types.classes.kotlin.SimpleInterface;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2020/01/27 21:32
 */
public class JavaMain {

    public static void main(String[] args) {
        SimpleInterface simpleInterface = new Person("dev", 1,1);
        if(simpleInterface instanceof Person) {
            System.out.println(((Person) simpleInterface).getSex());
        }
    }

}
