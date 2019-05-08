package First;

import java.io.IOException;
import java.net.Socket;

public class Client {
    //创建客户端对象，指定连接的服务器IP和端口
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8080);
        System.out.println("已和服务器建立链接，远程主机地址：" + socket.getRemoteSocketAddress());
    }
}
