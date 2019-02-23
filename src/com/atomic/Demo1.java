package com.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AcomicInteger Demo2
 */
public class Demo1 {
    private static AtomicInteger sum = new AtomicInteger(0);
    public static void inCreate(){
        sum.incrementAndGet();
    }

    public static void main(String[] args)  {
        for(int i = 0;i < 10; i++){
            new Thread(()->{
                for(int j =0;j < 10;j++){
                    inCreate();
                    System.out.println(sum);
                }
            }).start();
        }
    }
}
