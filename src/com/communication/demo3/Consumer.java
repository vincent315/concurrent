package com.communication.demo3;

public class Consumer implements Runnable {
    private Medium medium;
    public Consumer(Medium medium){
        this.medium = medium;
    }
    @Override
    public void run() {
        while(true){
            medium.take();
        }
    }
}
