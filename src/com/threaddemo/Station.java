package com.threaddemo;

public class Station extends Thread{
    private static int tickets = 20;

    private static Object object = new Object();
    public Station(String name){
        super(name);
    }

    @Override
    public void run() {
        while(tickets > 0){
            synchronized (object){
                if(tickets > 0){
                    System.out.println(getName() + "卖出了第" + tickets + "票");
                    tickets--;
                }else{
                    System.out.println("卖完了");
                }
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Station s1 = new Station("窗口1");
        Station s2 = new Station("窗口2");
        Station s3 = new Station("窗口3");
        s1.start();
        s2.start();
        s3.start();
    }
}
