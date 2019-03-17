package com.mj;

import java.util.concurrent.CountDownLatch;

/**
 * 使用CountDownLatch测试几个线程，一个挂掉，另外几个会怎么样
 */
public class CountdownTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(8);
        new Thread(() -> {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("结束了");
        }).start();
        for (int i = 0; i < 8; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    Thread.sleep(finalI * 1000L);
                    System.out.println(Thread.currentThread().getName() + "异常开始前");
                    int j = 5 / 0;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            }).start();

        }
    }
}