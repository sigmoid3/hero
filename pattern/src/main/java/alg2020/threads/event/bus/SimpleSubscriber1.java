package alg2020.threads.event.bus;

/**
 * @Author: minqian
 * @Create: 2020/3/29
 * @Description:
 **/
public class SimpleSubscriber1 {
    @Subscribe
    public void method1(String message) {
        System.out.println("==SimpleSubscriber1==method1==" + message);
    }

    @Subscribe(topic = "test")
    public void method2(String message) {
        System.out.println("==SimpleSubscriber1==method2==" + message);
    }
}
