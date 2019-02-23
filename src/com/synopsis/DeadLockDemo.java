package com.synopsis;

/**
 *
 * 死锁
 */
public class DeadLockDemo {
    private static final Object hairA = new Object();
    private static final Object hairB = new Object();


    public static void main(String[] args) {
        new Thread(()->{
            synchronized (hairA){
                try {
                    Thread.sleep(50L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (hairB){
                    System.out.println("A抓住了B的头发");
                }
            }
        }).start();
        new Thread(()->{
            synchronized (hairB){
                synchronized (hairA){
                    System.out.println("B成功抓住A的头发");
                }
            }
        }).start();
    }
}
