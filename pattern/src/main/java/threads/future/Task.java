package threads.future;

/**
 * @Author: minqian
 * @Create: 2020/3/28
 * @Description:
 **/
@FunctionalInterface
public interface Task<IN, OUT> {
    OUT get(IN input);
}
