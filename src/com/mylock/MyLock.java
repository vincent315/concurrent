package com.mylock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MyLock implements Lock {
    /**
     * 同一个时刻，能且仅能有一个线程获取到锁，其他线程，只能等待该
     * 线程释放锁之后才能获取到锁
     */
    private boolean isHoldLock = false;
    private Thread holdLockThread = null;
    //重入的次数
    private int rentryCount = 0;

    @Override
    public synchronized void lock() {
        if(isHoldLock && Thread.currentThread() != holdLockThread){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        holdLockThread = Thread.currentThread();
        isHoldLock = true;
        rentryCount++;
    }
    @Override
    public synchronized void unlock() {
        //判断当前线程是否是持有锁的线程，是，重入次数-1；不是啥都不干
        if(Thread.currentThread() == holdLockThread){
            rentryCount--;
            if(rentryCount == 0){
                notify();
                isHoldLock = false;
            }
        }


    }
    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }



    @Override
    public Condition newCondition() {
        return null;
    }
}
