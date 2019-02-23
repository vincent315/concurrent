package com.pool;

import java.util.concurrent.*;


public class ThreadPoolDemo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        LinkedBlockingQueue<Runnable> objectLinkedBlockingQueue = new LinkedBlockingQueue<>(20);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,20,3L, TimeUnit.SECONDS,objectLinkedBlockingQueue,new CustomPolicy());
        threadPoolExecutor.prestartAllCoreThreads();
        //提交任务数量x
        for (int i = 0; i < 50; i++) {
            threadPoolExecutor.submit(()->{
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(threadPoolExecutor.getActiveCount());//活跃数量
            });
        }
//        Future<String> submit = null;
//        for (int i = 0; i < 100; i++) {
//            submit = threadPoolExecutor.submit(new CallableDemo());
//        }
//        for (int i = 0; i < 100; i++) {
//            System.out.println(submit.get());
//        }
    }
}