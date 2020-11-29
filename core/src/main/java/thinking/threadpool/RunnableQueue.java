package thinking.threadpool;

/**
 * @Author: minqian
 * @Create: 2020/3/29
 * @Description:
 **/
public interface RunnableQueue {

    void offer(Runnable runnable);

    Runnable take() throws InterruptedException;

    int size();
}
