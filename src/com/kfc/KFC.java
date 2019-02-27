package com.kfc;

import java.util.ArrayList;

public class KFC {
    String[] names = {"香蕉", "烧板", "苹果", "可乐", "鸡翅", "糖果"};
    static final int threshold = 20;
    ArrayList<Food> foodArrayList = new ArrayList<>();

    public void prod(int index){
        synchronized (this){
            //如果食物数量大于20
            while (foodArrayList.size() > 20){
                System.out.println("食物够了，不生产了");
                this.notifyAll();

                try {
                    String name = Thread.currentThread().getName();
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //开始生产
            System.out.println("开始生产食物");
            for(int i = 0; i < index;i++){
                Food food = new Food(names[(int)(Math.random()* 4)]);
                foodArrayList.add(food);
                System.out.println("生成了" + food.getName() + foodArrayList.size());

            }
        }

    }
    //消费食物的方法
    public void consu(int index){
        synchronized (this){
            while(foodArrayList.size() < index){
                System.out.println("食材不够了");
                this.notifyAll();
                try {
                    String name = Thread.currentThread().getName();
                    this.wait();
                    System.out.println("消费者");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for(int i = 0;i < index;i++){
                Food food = foodArrayList.remove(foodArrayList.size() - 1);
                System.out.println("消费了一个" + food.getName() + foodArrayList.size());

            }
        }
    }
}
