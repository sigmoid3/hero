package alg2020.threads.latch;

import java.util.concurrent.TimeUnit;

/**
 * @Author: minqian
 * @Create: 2020/3/29
 * @Description:
 **/
public abstract class Latch {
    protected int limit;

    public Latch(int limit) {
        this.limit = limit;
    }

    public abstract void await()
            throws InterruptedException;

    public abstract void await(TimeUnit unit, long time)
            throws InterruptedException, WaitTimeoutException;

    public abstract void countDown();

    public abstract int getUnarrived();
}