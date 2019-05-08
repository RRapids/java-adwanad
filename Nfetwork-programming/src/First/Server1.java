package First;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server1 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10086);
        System.out.println("服务器启动");
        OutputStream out;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要发送的内容：");
        String str = scanner.next();
        System.out.println("已发送!");
        while (true) {
            Socket socket = ss.accept();
            System.out.println(socket.getInetAddress() + "上线了!");
            out = socket.getOutputStream();
            out.write(str.getBytes());
            out.close();
            socket.close();
        }
    }
}
