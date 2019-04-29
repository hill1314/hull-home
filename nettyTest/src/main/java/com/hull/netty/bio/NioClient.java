package com.hull.netty.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 *
 * @author
 * @create 2019-04-27 22:37
 **/

public class NioClient {

    private static String host = "127.0.0.1";
    private static Integer port = 7777;
    private static Socket socket;

    public static void send(String requestMsg){
        send(port,requestMsg);
    }

    public static void send(int port,String requestMsg){
        System.out.println("client requestMsg:"+requestMsg);
        Socket socket = null;
        BufferedReader reader = null;
        PrintWriter writer = null;
        try {
            socket = new Socket(host,port);
            writer = new PrintWriter(socket.getOutputStream(),true);
            writer.println(requestMsg);

            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("client reader:"+reader.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
