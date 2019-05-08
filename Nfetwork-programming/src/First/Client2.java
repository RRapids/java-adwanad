package First;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args)throws IOException {
        Socket socket = new Socket("192.168.43.11",8080);
        OutputStream out = socket.getOutputStream();
        Scanner scanner  = new Scanner(System.in);
        System.out.println("请输入：");
        String info = scanner.nextLine();
        System.out.println("已发送！");
        out.write(info.getBytes());
        out.close();
        socket.close();
    }
}
