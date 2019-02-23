package com.concurrentt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        List<String> stringList = Collections.synchronizedList(stringArrayList);
    }
}
