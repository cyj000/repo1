package com.lagou.domain;

/**
 * @ClassName: User
 * @Author: CYJ
 * @Date: 2021-08-02 10:02:56
 * @Description:
 */
public class User {

    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
