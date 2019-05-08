package First;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

/**
 * 客户端向服务器发送非文本数据(控制台)
 */

public class Server4 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10086);
        System.out.println("服务器启动成功");
        while (true) {
            Socket socket = ss.accept();
            ServerThread2 serverThread = new ServerThread2();
            serverThread.setSocket(socket);
            new Thread(serverThread).start();
        }
    }
}

class ServerThread2 implements Runnable {
    private Socket socket;

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println(socket.getLocalAddress() + "连接成功！");
        try {
            //从客户端输入流中读
            InputStream inputStream = socket.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(inputStream);
            //写道服务器指定路径
            File file = new File("D:/test/" + UUID.randomUUID().toString()+".jpg");
            OutputStream os = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(os);
            //缓冲区
            byte[] data = new byte[1024];
            int tmp;
            //每次循环从输入流读取缓冲区大小的字节，立刻通过输出流写出去
            while ((tmp = bis.read(data))!= -1) {
                bos.write(data, 0, tmp);
            }
            bos.close();
            bis.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}