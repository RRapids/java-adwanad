package Daka;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.43.11", 10086);
        System.out.println("已和服务器建立链接，远程主机地址：" + socket.getRemoteSocketAddress());

    }
}
