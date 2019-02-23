package com.pool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class ThreadPoolDemo {
    public static void main(String[] args) {
        LinkedBlockingQueue<Runnable> objectLinkedBlockingQueue = new LinkedBlockingQueue<>(20);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,20,3L, TimeUnit.SECONDS,objectLinkedBlockingQueue);
        for (int i = 0; i < 100; i++) {
            threadPoolExecutor.submit(()->{
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }
    }
}