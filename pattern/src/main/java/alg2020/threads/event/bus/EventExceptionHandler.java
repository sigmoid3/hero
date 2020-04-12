package alg2020.threads.event.bus;

/**
 * @Author: minqian
 * @Create: 2020/3/29
 * @Description:
 **/
public interface EventExceptionHandler {
    void handle(Throwable cause, EventContext context);
}