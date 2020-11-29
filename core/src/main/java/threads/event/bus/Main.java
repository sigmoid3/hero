package alg2020.threads.event.bus;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: minqian
 * @Create: 2020/3/29
 * @Description:
 **/
public class Main {
    public static void main(String[] args) {
        Bus bus = new EventBus("TestBus");
        bus.register(new SimpleSubscriber1());
        bus.register(new SimpleSubscriber2());
        bus.post("Hello");
        System.out.println("--------------------------");
        bus.post("Hello", "test");
    }

    public static void main2(String[] args) {
        Bus bus = new AsyncEventBus("TestBus", (ThreadPoolExecutor) Executors.newFixedThreadPool(10));
        bus.register(new SimpleSubscriber1());
        bus.register(new SimpleSubscriber2());
        bus.post("Hello");
        System.out.println("--------------------------");
        bus.post("Hello", "test");
    }
}
