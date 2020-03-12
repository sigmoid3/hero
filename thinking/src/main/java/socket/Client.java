package socket;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @Author: sandro
 * @Create: 2019-09-10
 * @Description:
 **/
public class Client {
    private Socket socket;
    private InputStream in;
    private OutputStream out;
    private String exit = "exit";

    /**
     * 启动客户端
     */
    private Client(String address, int port) {
        try {
            socket = new Socket(address, port);
            this.in = socket.getInputStream();
            this.out = socket.getOutputStream();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("CLIENT INIT SUCCESS");
    }

    public void start() {
        ClientReader reader = new ClientReader();
        ClientWriter writer = new ClientWriter();
        reader.start();
        writer.start();
    }

    public void close() {
        try {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
            if (socket != null) {
                socket.close();
            }
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ClientWriter extends Thread {
        private PrintWriter writer = new PrintWriter(out);
        private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        @Override
        public void run() {
            try {
                String line = "";
                while (!socket.isClosed() && line != null && !exit.equals(line)) {
                    line = reader.readLine();
                    if ("".equals(line)) {
                        System.out.print("WARNING: MESSAGE IS NULL");
                    } else {
                        writer.println(line);
                        writer.flush();
                    }
                }
                System.out.println("CLIENT EXIT");
                close();
            } catch (IOException e) {
                System.out.println("ERROR: DISCONNECTED");
            } finally {
                try {
                    if (writer != null) {
                        writer.close();
                    }
                    if (reader != null) {
                        reader.close();
                    }
                    close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class ClientReader extends Thread {
        private InputStreamReader streamReader = new InputStreamReader(in);
        private BufferedReader reader = new BufferedReader(streamReader);

        @Override
        public void run() {
            try {
                String line = "";
                while (!socket.isClosed() && line != null && !exit.equals(line)) {
                    line = reader.readLine();
                    if (line != null) {
                        System.out.println("SERVER: " + line);
                    }
                }
                System.out.println("SERVER EXIT");
                close();
            } catch (IOException e) {
                System.out.println("DISCONNECTED");
            } finally {
                try {
                    if (streamReader != null) {
                        streamReader.close();
                    }
                    if (reader != null) {
                        reader.close();
                    }
                    close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static boolean isOpen(String ip, int port, int timeout) {
        //1-65535
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(ip, port), timeout);
            socket.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        String address = null;
        try {
            InetAddress ip = InetAddress.getByName("target.colab.duke.edu");
            address = ip.toString().split("/")[1];
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (address == null) {
            address = "127.0.0.1";
        }
        int port = 22;
        int timeout = 2000;
        if (isOpen(address, port, timeout)) {
            new Client(address, port).start();
        } else {
            System.out.println("PORT IS NOT OPENED");
            return;
        }
    }
}