package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器向客户端发送非文本数据
 * 将服务器端文件发送到各个客户端的指定路径
 */
public class Server6 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10086);
        System.out.println("服务器启动成功");
        while (true) {
            Socket socket = ss.accept();
            ServerThread6 serverThread = new ServerThread6(socket);
            new Thread(serverThread).start();
        }
    }
}

class ServerThread6 implements Runnable {
    private Socket socket;

    public ServerThread6(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("客户端：" + socket.getInetAddress() + "连接成功");
        File file = new File("C:/bg.jpg");
        try {
            InputStream inputStream = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            inputStream.read(bytes);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(bytes);
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
