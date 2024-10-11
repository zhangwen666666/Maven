package com.zw.service;

public class Hello {
    // 加法运算
    public int sum(int num1, int num2) {
        return num1 + num2;
    }

    // 乘法运算
    public int mul(int num1, int num2) {
        return num1 * num2;
    }

    public static void main(String[] args) {
        Hello hello = new Hello();
        System.out.println(hello.sum(2, 6));
        System.out.println(hello.mul(2, 6));
    }
}
