package io.lock;/*
package thinkings.io.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;


*/
/**
 * @Author: sandro
 * @Create: 2019-09-28
 * @Description:
 **//*

public class ReadWriteLockTest {
    private final static String text = "this is a test sentance!!";

    public static void main(String[] args) {
        final ShareData shareData = new ShareData(50);

        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1024), threadFactory, new AbortPolicy());
        singleThreadPool.execute(()-> System.out.println(Thread.currentThread().getName()));
        singleThreadPool.shutdown();

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < text.length(); j++) {
                    try {
                        char c = text.charAt(j);
                        shareData.write(c);
                        System.out.println(Thread.currentThread() + " write " + c);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        System.out.println(Thread.currentThread() + " read " + new String(shareData.read()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
*/
