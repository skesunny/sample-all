package com.honcz.sample.samplenio.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author honc.z
 * @date 2019/4/25
 */
public class NioSampleClient {
    public static void main(String[] args){
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        SocketChannel socketChannel = null;

        try {
            //打开一个socket通道
            socketChannel = SocketChannel.open();
            //非阻塞模式
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("localhost",8080));
            if (socketChannel.finishConnect()){
                int i = 0;
                String reqStr = "I'm "+i+++"-th information from client";
                while (true){
                    byteBuffer.clear();
                    byteBuffer.put(reqStr.getBytes());
                    byteBuffer.flip();
                    while (byteBuffer.hasRemaining()){

                    }
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
