package com.concurrentt;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<String> strings = new LinkedBlockingQueue<>();
        //往队列中存放元素的方法
        strings.add("aaa");
        strings.offer("bbb");
        strings.put("ccc");

        //往队列中取元素的操作
        String remove = strings.remove();
        strings.poll();
        strings.take();
    }
}
