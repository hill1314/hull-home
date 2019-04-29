package com.hull.netty.bio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 *
 * @author
 * @create 2019-04-27 21:46
 **/

//@Slf4j
public class BioService {

    private static Integer port = 7777;
    private static ServerSocket serverSocket;

    public static void start() {
        start(port);
    }

    public synchronized static void start(int port) {
        try {
            if(serverSocket==null){
                serverSocket = new ServerSocket(port);
                System.out.println("service start at port:"+port);
            }
            while (true){
                Socket socket = serverSocket.accept();
                System.out.println("get a new connect！");
                new Thread(new ServerHandle(socket)).start();
            }
        }catch (Exception e){

        }finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("service close");
        }
    }

}
