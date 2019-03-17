package com.aaa;

public class Test {
    public static void main(String[] args) {
        int a = 1;
        float b = 2.2f;
        a = (int) ((int)a + b);
        a += b;
        System.out.println(a);
    }
}
