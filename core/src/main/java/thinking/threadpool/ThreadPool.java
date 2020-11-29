package thinking.threadpool;

/**
 * @Author: minqian
 * @Create: 2020/3/29
 * @Description:
 **/
public interface ThreadPool {

    void execute(Runnable runnable);

    void shutdown();

    int getInitSize();

    int getMaxSize();

    int getCoreSize();

    int getQueueSize();

    int getActiveCount();

    boolean isShutdown();
}
