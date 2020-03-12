package proxy;

/**
 * @Author: Sandro
 * @Create: 2019-06-02 20:24
 * @Info:
 **/
public class RealSubject implements Subject {
    @Override
    public void doSomething(){
        System.out.println("call doSomething...");
    }
}
