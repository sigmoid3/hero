package threads.observe;

import java.util.concurrent.TimeUnit;

/**
 * @Author: minqian
 * @Create: 2020/3/25
 * @Description:
 **/
public class Main {
    public static void main(String[] args) {
        Observable observable = new ObservableThread<>(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" finished done.");
            return null;
        });
        observable.start();
    }
}