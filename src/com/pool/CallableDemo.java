package com.pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo implements Callable {
    @Override
    public String call() throws Exception {
        Thread.sleep(3000L);

        return "111";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableDemo callableDemo = new CallableDemo();
        FutureTask<String> stringFutureTask = new FutureTask<String>(callableDemo);
        new Thread(stringFutureTask).start();
        System.out.println(stringFutureTask.get());

    }
}
