package proxy;

/**
 * @Author: Sandro
 * @Create: 2019-06-02 20:14
 * @Info:
 **/
public class ProxyTest {
    public static void main(String[] args) {
        ProxyHandler proxyHandler = new ProxyHandler();
        Subject sub = (Subject) proxyHandler.bind(new RealSubject());
        sub.doSomething();
    }
}
