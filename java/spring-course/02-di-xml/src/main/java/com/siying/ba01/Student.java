package com.siying.ba01;

public class Student {
    private String name;
    private int age;

    public void setEmail(String email) {
        System.out.println("setEmail=" + email);
    }

    public void setName(String name) {
        System.out.println("setName: " + name);
        this.name = name;
    }

    public void setAge(int age) {
        System.out.println("setAge: " + age);
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
