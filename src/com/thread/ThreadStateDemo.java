package com.thread;

import java.io.IOException;

public class ThreadStateDemo {
    public static void main(String[] args) throws InterruptedException {
      /*  //RUNNABLE
        Thread thread = new Thread(()->{
            try {
                System.in.read();//为的线程不那么快的退出
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread.start();*/
        Object o = new Object();
        Thread thread = new Thread(()->{
           synchronized (o){
               try {
                   Thread.sleep(100000000L);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        });
        thread.start();
        Thread.sleep(20000L);
        Thread thread2 = new Thread(()->{
            synchronized (o){
            }
        });
        thread2.start();
    }
}
