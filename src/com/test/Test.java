package com.test;

public class Test {
    public static void main(String[] args) {
        get();
    }
    public static boolean get(){

        try {
            System.out.println("#####");
            System.exit(0);
            return true;
        }finally {
            System.out.println(2222);
        }
    }
}
