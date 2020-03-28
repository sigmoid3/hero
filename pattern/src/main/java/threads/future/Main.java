package threads.future;

import java.util.concurrent.TimeUnit;

/**
 * @Author: minqian
 * @Create: 2020/3/28
 * @Description:
 **/
public class Main {
    public static void main(String[] args) throws InterruptedException {
        FutureService<String, Integer> service = FutureService.newService();
        service.submit(input -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return input.length();
        }, "Hello", System.out::println);
    }
}
