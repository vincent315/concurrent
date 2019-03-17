package com;



import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        int n = sc.nextInt();
        String[] str = new String[n];
        for(int i = 0; i < n; i++){
            str[i] = sc1.nextLine();
        }
        for(String s : str){
            String s1 = func1(s);
            System.out.println(s1);
        }

    }
    public static String  func1(String str){
        char[] ch = str.toCharArray();
        List<Character> list = new ArrayList<Character>();
        for(char c :ch){
            list.add(c);
        }
        for(int i = 0; i < list.size(); i ++){
            int num = 0;
            for(int j = i; j < list.size();j++){
                if(list.get(i) == list.get(j)){
                    num++;
                    if(num == 3){
                        list.remove(j);
                    }
                    continue;
                }else{
                    break;
                }
            }
        }
        char[] newch = new char[list.size()];
        for(int i = 0; i < newch.length; i ++){
            newch[i] = list.get(i);
        }
        String s = "";
        for(char c : newch){
            s = s + c;
        }

        return  s;
    }
}