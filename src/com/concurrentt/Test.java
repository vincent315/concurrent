package com.concurrentt;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> stringCopyOnWriteArrayList = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 1000; i++) {
            stringCopyOnWriteArrayList.add("demo" + i);
        }
//        stringCopyOnWriteArrayList.forEach(e->{
//            if(e.equals("demo2")){
//                stringCopyOnWriteArrayList.remove(e);
//            }
//        });
        //不支持迭代器移除
//        Iterator<String> iterator = stringCopyOnWriteArrayList.iterator();
//        while (iterator.hasNext()){
//            String next = iterator.next();
//            if(next.equals("demo2")){
//                iterator.remove();
//            }
//        }
        for (int i = 0; i < 4; i++) {
            new Thread(()->{
                stringCopyOnWriteArrayList.forEach(e->{
                    if(e.equals("demo2")){
                        stringCopyOnWriteArrayList.remove(e);
                     }
                });
            }).start();
        }
    }
}
