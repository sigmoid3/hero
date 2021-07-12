package thinking.threadpool;

/**
 * @Author: minqian
 * @Create: 2020/3/29
 * @Description:
 **/
public interface ThreadFactory {
    Thread createThread(Runnable runnable);
}
