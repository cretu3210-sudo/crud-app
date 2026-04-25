package com.example.crud_app.entity;

public class Test {
    public static void main(String[] args) {
        Student student1 = new Student("Munteanu","Igor","sabaca@gmail.com");
        String text = student1.toString();
        System.out.println(text);
    }
}
