package task;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Sandro
 * @Create: 2019-07-18 16:45
 * @Info:
 **/
public class ScheduleTask {


    public void testSchedule() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("test");
            }
        };
        long delay = 5;
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(runnable, 10, 1, TimeUnit.SECONDS);
        service.schedule(runnable, delay, TimeUnit.MILLISECONDS);
    }
}
