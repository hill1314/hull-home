package com.hull.netty.bio;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.Socket;

/**
 *
 *
 * @author
 * @create 2019-04-27 21:58
 **/

//@Slf4j
public class ServerHandle implements Runnable{
    private static Socket socket;

    public ServerHandle(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run() {

        BufferedReader reader = null;
        PrintWriter writer = null;

        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(),true);

            while (true){
                if(reader.readLine()==null)
                    break;
                String receive = reader.readLine();
                System.out.println("receive:"+receive);
                writer.println("hello "+receive);
            }

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
