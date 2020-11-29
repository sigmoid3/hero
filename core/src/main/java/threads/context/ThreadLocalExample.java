package alg2020.threads.context;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @Author: minqian
 * @Create: 2020/3/29
 * @Description:
 **/
public class ThreadLocalExample {
    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        IntStream.range(0, 10).forEach(i -> new Thread(() -> {
            try {
                threadLocal.set(i);
                System.out.println(Thread.currentThread() + " set i " + threadLocal.get());
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread() + " get i " + threadLocal.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start());
    }
}
