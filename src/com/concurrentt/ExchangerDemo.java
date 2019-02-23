package com.concurrentt;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {
    public static void main(String[] args) {
        Exchanger<String> stringExchanger = new Exchanger<>();
        String str1 = "abc";
        String str2 = "def";

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "初始值======" + str1);
            try {
                String exchange = stringExchanger.exchange(str1);
                System.out.println(Thread.currentThread().getName() + "交换后的数据======" + exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程1").start();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "初始值======" + str2);
            try {
                String exchange = stringExchanger.exchange(str2);
                System.out.println(Thread.currentThread().getName() + "交换后的数据======" + exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程2").start();
    }
}
