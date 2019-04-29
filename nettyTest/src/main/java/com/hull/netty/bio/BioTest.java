package com.hull.netty.bio;

/**
 *
 *
 * @author
 * @create 2019-04-27 22:44
 **/

public class BioTest {

    public static void main(String[] args) {

        BioService.start();
        NioClient.send("1111");
        NioClient.send("2222");
        NioClient.send("3333");
    }
}
