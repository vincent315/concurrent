package com.concurrentt;

import java.util.Iterator;
import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) {
        Vector<String> stringVector = new Vector<>();
        for (int i = 0; i < 1000; i++) {
            stringVector.add("demo" + i);
        }
        //错误的遍历
//        stringVector.forEach(e->{
//            if(e.equals("demo3")){
//                stringVector.remove(e);
//            }
//            System.out.println(e);
//        });
        //单线程正确的遍历
        Iterator<String> iterator = stringVector.iterator();
//        while (iterator.hasNext()){
//            String next = iterator.next();
//            if(next.equals("demo2")){
//                iterator.remove();
//            }
//        }
        //
        for(int i =0;i < 4;i++){
            new Thread(()->{
                synchronized (iterator){
                    while (iterator.hasNext()){
                        String next = iterator.next();
                        if(next.equals("demo2")){
                            iterator.remove();
                        }
                    }
                }
            }).start();
        }
    }
}
