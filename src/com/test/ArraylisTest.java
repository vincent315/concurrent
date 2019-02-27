package com.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArraylisTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        System.out.println("原来的list:" + list);
        for (String string : list) {
            System.out.println(string);
            //如果获取的内容是"2"，就把它删除
            if ("2".equals(string)) {
                list.remove(string);
            }
        }
        System.out.println("修改后的list:: " + list);
    }
}
