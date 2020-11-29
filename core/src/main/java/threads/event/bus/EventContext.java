package alg2020.threads.event.bus;

import java.lang.reflect.Method;

/**
 * @Author: minqian
 * @Create: 2020/3/29
 * @Description:
 **/
public interface EventContext {

    String getSource();

    Object getSubscriber();

    Method getSubscribe();

    Object getEvent();
}
