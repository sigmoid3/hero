package base.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

/**
 * @Author: sandro
 * @Create: 2019-10-04
 * @Description: 将udp监听放到一个线程中，当有客户端请求时就会进行响应
 **/
public class UdpServer extends Thread implements Runnable {
    private final int MAX_LENGTH = 1024;
    private final int PORT = 8090;
    private DatagramSocket datagramSocket;

    public void run() {
        try {
            init();
            while (true) {
                try {
                    byte[] buffer = new byte[MAX_LENGTH];
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                    receive(packet);
                    String receStr = new String(packet.getData(), 0, packet.getLength());
                    System.out.println("接收数据包" + receStr);
                    byte[] bt = new byte[packet.getLength()];

                    System.arraycopy(packet.getData(), 0, bt, 0, packet.getLength());
                    System.out.println(
                        packet.getAddress().getHostAddress() + "：" + packet.getPort() + "：" + Arrays.toString(bt));
                    packet.setData(bt);
                    response(packet);

                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("udp线程出现异常：" + e.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void receive(DatagramPacket packet) throws Exception {
        datagramSocket.receive(packet);
    }

    public void response(DatagramPacket packet) throws Exception {
        datagramSocket.send(packet);
    }

    /**
     * 初始化连接
     */
    public void init() {
        try {
            datagramSocket = new DatagramSocket(PORT);
            System.out.println("udp服务端已经启动！");
        } catch (Exception e) {
            datagramSocket = null;
            System.out.println("udp服务端启动失败！");
            e.printStackTrace();
        }
    }
}