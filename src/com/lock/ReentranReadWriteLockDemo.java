package com.lock;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
public class ReentranReadWriteLockDemo {
    private int i = 0;
    private int j = 0;
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    Lock readLock = lock.readLock();
    Lock writeLock = lock.writeLock();
    public void out(){
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "i的值" + i+"j的值" + j);
        }finally {
            readLock.unlock();
        }
    }
    public void inCreate(){
        writeLock.lock();
        try {
            i++;
            Thread.sleep(500L);
            j++;
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentranReadWriteLockDemo reentranReadWriteLockDemo = new ReentranReadWriteLockDemo();
        for(int i =0;i < 3;i++){
            new Thread(()->{
                reentranReadWriteLockDemo.inCreate();
                reentranReadWriteLockDemo.out();
            }).start();
        }
    }
}
