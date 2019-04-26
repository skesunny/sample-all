package com.honcz.sample.samplenio.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author honc.z
 * @date 2019/4/25
 *
 * NIO非阻塞客户端
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
                    //将pos,cap,mark这三个标志初始化
                    byteBuffer.clear();
                    byteBuffer.put(reqStr.getBytes());
                    //filp()从写模式转换到读模式，就能把buffer的当前位置更改为buffer缓冲区的第一个位置
                    //实际上就是把position赋值给limit,代表最多读limit个数据，然后position指针置0，即从头开始读
                    byteBuffer.flip();
                    //仍有数据
                    while (byteBuffer.hasRemaining()){
                        System.out.println(byteBuffer);
                        socketChannel.write(byteBuffer);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (socketChannel != null){
                try {
                    socketChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
