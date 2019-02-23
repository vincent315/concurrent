package com.interrupt;

public class MyInterrupDemo implements Runnable {
    private static volatile boolean flag = true;
    @Override
    public void run() {
        while (flag){
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyInterrupDemo());
        thread.start();
        Thread.sleep(1000L);
        flag = false;
    }
}
