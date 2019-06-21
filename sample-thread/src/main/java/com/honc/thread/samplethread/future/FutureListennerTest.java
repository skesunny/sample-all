package com.honc.thread.samplethread.future;

import org.slf4j.Logger;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author honc.z
 * @date 2019/6/17
 */
public class FutureListennerTest {
    public void test(){
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        Future f = threadPoolTaskScheduler.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("试试");
            }
        });

    }
}
