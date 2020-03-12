package base.net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Author: sandro
 * @Create: 2019-09-10
 * @Description:
 **/
public class Client {
    public static void main(String[] args) {
        try {
            InetAddress ip = InetAddress.getByName("target.colab.duke.edu");
            String address = ip.toString().split("/")[1];
            if (address == null) {
                System.out.println("DOMAIN DNS ERROR");
                return;
            }
            Socket socket = new Socket(address, 22);
            socket.setSoTimeout(3000);
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            System.out.println("CLIENT INIT SUCCESS");
            PrintWriter printWriter = new PrintWriter(outputStream, true);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                printWriter.printf("QUIT\n");
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}