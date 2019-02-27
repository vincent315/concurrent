package com.demo;

public class Test01 {
    public static Thread t1;
    public static Thread t2;
    public static Thread t3;
    public static void main(String[] args) {

        t1 = new Thread(()->{
            System.out.println("我是t1线程");
            t2.start();
        });
        t2 = new Thread(()->{
            System.out.println("我是t2线程");
            t3.start();
        });
        t3 = new Thread(()->{
            System.out.println("我是t3线程");
        });
        t1.start();
    }
}
