package threads.observe;

/**
 * @Author: minqian
 * @Create: 2020/3/24
 * @Description:
 **/
public interface TaskLifecycle<T> {
    /**
     * 启动触发
     *
     * @param thread
     */
    void onStart(Thread thread);

    /**
     * 运行触发
     *
     * @param thread
     */
    void onRunning(Thread thread);

    /**
     * 结束触发
     *
     * @param thread
     * @param result
     */
    void onFinish(Thread thread, T result);

    /**
     * 报错触发
     *
     * @param thread
     * @param e
     */
    void onError(Thread thread, Exception e);

    /**
     * 生命周期的空实现
     *
     * @param <T>
     */
    class EmptyLifecycle<T> implements TaskLifecycle<T> {
        @Override
        public void onStart(Thread thread) {

        }

        @Override
        public void onRunning(Thread thread) {

        }

        @Override
        public void onFinish(Thread thread, T result) {

        }

        @Override
        public void onError(Thread thread, Exception e) {

        }
    }
}
