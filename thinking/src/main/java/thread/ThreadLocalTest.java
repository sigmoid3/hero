package thread;

/**
 * @Author: Sandro
 * @Create: 2019-08-04 23:07
 * @Info: threadlocal
 **/
public class ThreadLocalTest {
    private static String strLabel;
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String... args) {
        strLabel = "main";
        threadLocal.set(strLabel);
        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                strLabel = "child";
                threadLocal.set(strLabel);
            }
        };
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("strLabel = " + strLabel);
        System.out.println("threadLocal = " + threadLocal.get());
    }
}
