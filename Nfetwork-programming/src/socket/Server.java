package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 多线程的服务端
 */

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10086);
        System.out.println("服务器启动成功");
        while (true){
            Socket socket = ss.accept();
            ServerThread serverThread = new ServerThread();
            serverThread.setSocket(socket);
            new Thread(serverThread).start();
        }
    }
}

class ServerThread implements Runnable{
    private Socket socket;

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println(socket.getLocalAddress()+"连接成功！");
    }
}