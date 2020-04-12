package alg2020.threads.future;

/**
 * @Author: minqian
 * @Create: 2020/3/28
 * @Description:
 **/
public interface Future<T> {
    T get() throws InterruptedException;

    boolean done();
}
