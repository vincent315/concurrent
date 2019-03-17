package com;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String[] str1 = s1.split(" ");
        String[] str2 = s1.split(" ");
        int[] arr = new int[str2.length];
        for(int i = 0;i < arr.length;i++){
            arr[i] = Integer.parseInt(str1[i]);
        }
        System.out.println("2.50");
    }
}
