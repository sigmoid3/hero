package alg2020.threads.event.bus;

/**
 * @Author: minqian
 * @Create: 2020/3/29
 * @Description:
 **/
public class SimpleSubscriber2 {
    @Subscribe
    public void method1(String message) {
        System.out.println("==SimpleSubscriber2==method1==" + message);
    }

    @Subscribe(topic = "test")
    public void method2(String message) {
        System.out.println("==SimpleSubscriber2==method2==" + message);
    }
}