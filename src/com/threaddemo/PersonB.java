package com.threaddemo;

public class PersonB extends Thread{
    Bank bank;
    public PersonB(Bank bank){
        this.bank = bank;
    }

    @Override
    public void run() {
        while (bank.money >=200){
            bank.ATM(200);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        PersonA personA = new PersonA(bank);
        PersonB personB = new PersonB(bank);
        personA.start();
        personB.start();
    }
}
