package com.mj;

public class StopThreadTest {
    static boolean b = true;
    public static void main(String[] args) {
            new Thread(()->{
                try {
                    if(b){
                        int n = 5/0;
                    }else{
                        Thread.interrupted();
                    }
                }catch (Exception e){
                    System.out.println(Thread.currentThread().getName() +"异常捕获");
                    b = false;
                }
            }).start();
        for (int i = 0; i < 3; i++){
            new Thread(()->{
                try {
                    Thread.sleep(500);
                    if(b){
                        int n = 5/0;
                    }else{
                        Thread.interrupted();
                    }
                }catch (Exception e){
                    System.out.println(Thread.currentThread().getName() + "异常捕获");
                    b = false;
                }
            }).start();
        }
    }
}
