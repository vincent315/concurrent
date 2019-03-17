package com;


import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
    }
    public static void func1(String str){
        char[] ch = str.toCharArray();

        for(int i = 0; i < ch.length; i ++){
            int num = 0;
            for(int j = i; j < ch.length;j++){
               if(ch[j] == ch[i]){
                   num++;
                   if(num == 3){

                   }
                   continue;
               }else{
                   break;
               }
            }
        }
    }
    public static String  func2(String str){
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
        String s = Arrays.toString(newch);
        return  s;
    }
}
