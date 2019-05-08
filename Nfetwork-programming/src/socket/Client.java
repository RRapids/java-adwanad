package socket;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",10086);
        System.out.println(socket.getRemoteSocketAddress()+"连接成功！");
    }
}
