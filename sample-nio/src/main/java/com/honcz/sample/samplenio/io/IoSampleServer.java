package com.honcz.sample.samplenio.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @author honc.z
 * @date 2019/4/26
 *
 * IO 阻塞server服务器
 */
public class IoSampleServer {
    public static void main(String[] args){
        ServerSocket serverSocket = null;
        InputStream in = null;

        try {
            serverSocket = new ServerSocket(8080);
            int recvMsgSize = 0;
            byte[] recv = new byte[1024];
            while (true){
                Socket clientSocket = serverSocket.accept();
                SocketAddress clientAddress = clientSocket.getRemoteSocketAddress();
                System.out.println("Handling client at "+clientAddress);
                in = clientSocket.getInputStream();
                while((recvMsgSize=in.read(recv))!=-1){
                    byte[] temp = new byte[recvMsgSize];
                    System.arraycopy(recv, 0, temp, 0, recvMsgSize);
                    System.out.println(new String(temp));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }  finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
