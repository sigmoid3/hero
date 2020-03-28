package threads.future;

/**
 * @Author: minqian
 * @Create: 2020/3/28
 * @Description:
 **/
@FunctionalInterface
public interface Callback<T> {
    void call(T t);
}
