package threads.rwsplit;

/**
 * @Author: minqian
 * @Create: 2020/3/28
 * @Description: 读写锁分离设计
 **/
public class Main {
    private final static String text = "This is the example for readWriteLock";

    public static void main(String[] args) {
       /* final ShareData shareData = new ShareData(50);
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < text.length(); j++) {
                    try {
                        char c = text.charAt(j);
                        shareData.write(c);
                        System.out.println(Thread.currentThread() + " write " + c);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        System.out.println(Thread.currentThread() + " read " + new String(shareData.read()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }*/
    }
}
