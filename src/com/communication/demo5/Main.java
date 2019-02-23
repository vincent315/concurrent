package com.communication.demo5;

import java.io.*;

/**
 * 管道流
 */
public class Main {

    public static void main(String[] args) throws IOException {
        PipedInputStream pipedInputStream = new PipedInputStream();
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        pipedOutputStream.connect(pipedInputStream);
        new Thread(new Reader(pipedInputStream)).start();
        BufferedReader bufferedReader = null;
        try {
            //从控制台读取
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            pipedOutputStream.write(bufferedReader.readLine().getBytes());
        }finally {
            pipedOutputStream.close();
            if(bufferedReader!=null){
                bufferedReader.close();
            }
        }
    }
}
