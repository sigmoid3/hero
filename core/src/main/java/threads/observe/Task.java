package alg2020.threads.observe;

/**
 * @Author: minqian
 * @Create: 2020/3/24
 * @Description:
 **/
@FunctionalInterface
public interface Task<T> {
    /**
     * 任务执行接口，该接口允许有返回值
     *
     * @return
     */
    T call();
}
