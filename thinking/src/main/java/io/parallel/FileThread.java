package io.parallel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: sandro
 * @Create: 2019-09-27
 * @Description:
 **/
class DataCache {
    private Map<String, String> cachedMap = new HashMap<>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public long readSize() {
        try {
            readLock.lock();
            mockTimeConsumingOpt();
            return cachedMap.size();
        } finally {
            readLock.unlock();
        }
    }

    public long write(String key, String value) {
        try {
            writeLock.lock();
            mockTimeConsumingOpt();
            cachedMap.put(key, value);
            return cachedMap.size();
        } finally {
            writeLock.unlock();
        }
    }

    private void mockTimeConsumingOpt() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Reader extends Thread {
    public DataCache dataCache;

    public Reader(String name, DataCache dataCache) {
        super(name);
        this.dataCache = dataCache;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        long result = dataCache.readSize();
        System.out.println(name + "read current cache size is: " + result);
    }
}

class Writer extends Thread {
    public DataCache dataCache;

    public Writer(String str, DataCache dataCache) {
        super(str);
        this.dataCache = dataCache;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        String result = "" + dataCache.write(name, "Data-" + name);
        System.out.println(name + "write to current cache: " + result);
    }
}

public class FileThread {
    public static void main(String[] args) {
        final DataCache dataCache = new DataCache();
        ArrayList<Thread> worker = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                Writer writer = new Writer("Writer" + i, dataCache);
                worker.add(writer);
            } else {
                Reader reader = new Reader("Reader" + i, dataCache);
                worker.add(reader);
            }
        }
        for (Thread thread : worker) {
            thread.start();
        }
    }
}
