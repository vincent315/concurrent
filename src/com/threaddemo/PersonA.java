package com.threaddemo;

public class PersonA extends Thread{
    Bank bank;
    public PersonA(Bank bank){
        this.bank  = bank;
    }

    @Override
    public void run() {
        while(bank.money >=100){
            bank.counter(100);
        }
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
