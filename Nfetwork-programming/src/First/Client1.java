package First;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client1 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.43.11",10086);
        //获取客户端的输入流
        InputStream in = socket.getInputStream();
        byte[] b =new byte[1024];
        in.read(b);
        System.out.println("服务器发送的是："+ new String(b));
        in.close();
        socket.close();
    }
}
