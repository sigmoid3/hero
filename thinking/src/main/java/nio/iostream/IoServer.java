package nio.iostream;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class IoServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9000);
        //接收新连接
        new Thread(() -> {
            //也可不用死循环，该socket不受控制
            while (true) {
                try {
                    //阻塞方法获取新连接，保证socket是可控的
                    Socket socket = serverSocket.accept();
                    //按字节流获取数据，业务逻辑处理
                    new Thread(() -> {
                        try {
                            int len;
                            byte[] data = new byte[1024];
                            InputStream inputStream = socket.getInputStream();
                            while ((len = inputStream.read(data)) != -1) {
                                System.out.println(new String(data, 0, len));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }).start();

                } catch (IOException e) {
                }
            }
        }).start();
    }
}
