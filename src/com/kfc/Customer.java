package com.kfc;

public class Customer extends Thread {
    private KFC kfc;
    public Customer(KFC kfc){
        this.kfc = kfc;
    }

    @Override
    public void run() {
        int size = (int) (Math.random() * 5);
        while (true){
            kfc.consu(size);
        }
    }
}
