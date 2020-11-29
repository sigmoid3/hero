package alg2020.threads.observe;

/**
 * @Author: minqian
 * @Create: 2020/3/24
 * @Description:
 **/
public interface Observable {

    enum Cycle {
        /**
         * 任务生命周期的枚举类型
         */
        STARTED, RUNNING, DONE, ERROR
    }

    /**
     * 获取当前任务的生命周期状态
     */
    Cycle getCycle();

    /**
     * 启动线程方法
     */
    void start();

    /**
     * 线程打断方法
     */
    void interrupt();
}