package alg2020.threads.future;

/**
 * @Author: minqian
 * @Create: 2020/3/28
 * @Description:
 **/
public interface FutureService<IN, OUT> {
    Future<?> submit(Runnable runnable);

    Future<OUT> submit(Task<IN, OUT> task, IN input, Callback<OUT> callback);

    static <T, R> FutureService<T, R> newService() {
        return new FutureServiceImpl<T, R>();
    }
}
