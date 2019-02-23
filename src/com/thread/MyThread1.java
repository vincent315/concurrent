package com.thread;

/**
 * 匿名内部类方式创建线程
 */
public class MyThread1 {
    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        thread.start();
    }
}
