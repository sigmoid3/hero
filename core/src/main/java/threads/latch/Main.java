package alg2020.threads.latch;

import java.util.concurrent.TimeUnit;

/**
 * @Author: minqian
 * @Create: 2020/3/29
 * @Description:
 **/
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Latch latch = new CountDownLatch(4);
        new ProgrammerTravel(latch, "Alex", "Bus").start();
        new ProgrammerTravel(latch, "Gavin", "Walking").start();
        new ProgrammerTravel(latch, "Jack", "Subway").start();
        new ProgrammerTravel(latch, "Dillon", "Bicycle").start();
        try {
            latch.await(TimeUnit.SECONDS, 5);
            System.out.println("== all of programmer arrived ==");
        } catch (WaitTimeoutException e) {
            e.printStackTrace();
        }
    }
}
