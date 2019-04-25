package com.honcz.sample.samplenio.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author honc.z
 * @date 2019/4/24
 *
 * io举例
 */
public class IoSample {
    public static void main(String[] args){
        InputStream in = null;
        try{
            in = new BufferedInputStream(new FileInputStream("F:\\myPro\\sample-all\\sample-nio\\src\\main\\resources\\test.txt"));
            byte [] buf = new byte[1024];
            int bytesRead = in.read(buf);
            while(bytesRead != -1)
            {
                for(int i=0;i<bytesRead;i++) {
                    System.out.print((char) buf[i]);
                }
                bytesRead = in.read(buf);
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }finally{
            try{
                if(in != null){
                    in.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
