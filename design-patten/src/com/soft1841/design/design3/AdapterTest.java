package com.soft1841.design.design3;

public class AdapterTest {
    public static void main(String[] args) {
        System.out.println("特长生招募中.....");
        Student student = new Student() {
            @Override
            public void javaStudy() {
                System.out.println("我是一名java大神");
            }
        };
        student.javaStudy();
        Student student1 = new Student() {
            @Override
            public void playBasketball() {
                System.out.print("我篮球打的好，");
            }

            @Override
            public void playFootball() {
                System.out.print("足球踢得也好");
            }
        };

        student1.playBasketball();
        student1.playFootball();
    }
}
