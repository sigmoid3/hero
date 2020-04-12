package alg2020.threads.balking;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Author: minqian
 * @Create: 2020/3/29
 * @Description: 自动保存线程
 **/
public class AutoSaveThread extends Thread {
    private final Document document;

    public AutoSaveThread(Document document) {
        super("DocumentAutoSaveThread");
        this.document = document;
    }

    @Override
    public void run() {
        while (true) {
            try {
                document.save();
                TimeUnit.SECONDS.sleep(1);
            } catch (IOException | InterruptedException e) {
                break;
            }
        }
    }
}
