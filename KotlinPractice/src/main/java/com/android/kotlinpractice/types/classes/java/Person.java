package com.android.kotlinpractice.types.classes.java;

import com.android.kotlinpractice.types.classes.kotlin.SimpleInterface;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2020/01/29 16:34
 */
public class Person implements SimpleInterface {

    private String name;
    private int age;
    private int sex;


    public Person() {
    }

    public Person(String name, int age, int sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public void simpleMethod() {

    }

    @Override
    public int getSimpleProperty() {
        return 0;
    }

    @Override
    public void setSimpleProperty(int i) {

    }
}
