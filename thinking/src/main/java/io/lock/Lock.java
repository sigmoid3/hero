package io.lock;

/**
 * @Author: sandro
 * @Create: 2019-09-28
 * @Description:
 **/
public interface Lock {
    void lock() throws InterruptedException;
    void unlock();
}
