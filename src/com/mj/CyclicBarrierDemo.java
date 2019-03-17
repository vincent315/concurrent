package com.mj;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(8);
        for (int i = 0; i < 1; i++) {
            int finalI = i;
            new Thread(()->{
                try {
                    Thread.sleep(0);
                    System.out.println(Thread.currentThread().getName() + "准备就绪");
                    int m = 5/0;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("准备就绪，开始比赛");
            }).start();

        }
        for (int i = 0; i < 8; i++) {
            int finalI = i;
            new Thread(()->{
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "准备就绪");
                    int m = 5/0;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("准备就绪，开始比赛");
            }).start();

        }
    }
}
