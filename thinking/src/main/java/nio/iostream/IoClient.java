package nio.iostream;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

public class IoClient {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    Socket socket = new Socket("127.0.0.1", 9000);
                    while (true) {
                        try {
                            //每隔两秒发送一个消息
                            socket.getOutputStream().write((new Date() + ":how are you").getBytes());
                            Thread.sleep(2000);
                        } catch (Exception e) {
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
