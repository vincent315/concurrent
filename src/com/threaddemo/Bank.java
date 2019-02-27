package com.threaddemo;

public class Bank {
      static int money = 1000;
    public void counter(int money){
        Bank.money-=money;
        System.out.println("a取走了" + money + ",还剩下" + Bank.money + "元");
    }
    public void ATM(int money){
        Bank.money -=money;
        System.out.println("b取走了" + money + "，还剩下" + Bank.money + "元");
    }
}
