package com.concurrentt;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo2 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(8);
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                try {
                    if(semaphore.tryAcquire()){
                        System.out.println(Thread.currentThread().getName() + "开始执行");
                        Thread.sleep(5000L);
                        semaphore.release();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }
}
