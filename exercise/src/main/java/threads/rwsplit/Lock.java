package threads.rwsplit;

/**
 * @Author: minqian
 * @Create: 2020/3/28
 * @Description:
 **/
public interface Lock {
    void lock() throws InterruptedException;

    void unlock();
}
