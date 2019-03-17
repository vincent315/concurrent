package com.mj;

public class ThreadExceptionRunner extends Throwable implements Runnable{
    @Override
    public void run() {
        throw new RuntimeException("error !!!!");
    }
}
