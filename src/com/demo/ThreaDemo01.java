package com.demo;

import java.util.concurrent.Semaphore;

public class ThreaDemo01 extends Thread{
    private String name;
    private Semaphore wc;

    public ThreaDemo01(String name,Semaphore wc){
        this.name  = name;
        this.wc = wc;
    }

    @Override
    public void run() {
       int permits = wc.availablePermits();
       if(permits > 0){
           System.out.println(name + "真好，可以上厕所了");
       }else {
           System.out.println(name + "为什么没了呀");
       }
       try {
           wc.acquire();
       }catch (InterruptedException e){

       }
        System.out.println(name + "终于上厕所了");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "上完了，开心");
        wc.release();
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for( int i = 1; i <=10; i++){
            ThreaDemo01 threaDemo01 = new ThreaDemo01("第" + i + "个人", semaphore);
            threaDemo01.start();
        }
    }
}
