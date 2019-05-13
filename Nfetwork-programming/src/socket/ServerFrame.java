package socket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 客户端向服务器端发送信息——GUI版
 */

public class ServerFrame extends JFrame {
    private JTextArea contentTextArea;
    private JButton runButton;
    private JPanel topPanel;

    private ServerFrame() {
        init();
        setTitle("服务器端");
        setSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void init() {
        topPanel = new JPanel();
        runButton = new JButton("启动");
        runButton.setPreferredSize(new Dimension(70, 40));
        topPanel.add(runButton);
        topPanel.setBackground(new Color(126, 126, 126));
        contentTextArea = new JTextArea();
        Font font = new Font("微软雅黑", Font.PLAIN, 20);
        contentTextArea.setFont(font);
        add(topPanel, BorderLayout.NORTH);
        add(contentTextArea, BorderLayout.CENTER);
        //启动监听，打开中间桥梁线程
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                linkThread linkThread = new linkThread();
                new Thread(linkThread).start();
            }
        });
    }

    public static void main(String[] args) {
        new ServerFrame();
    }

    //中间桥梁线程，启功server线程
    class linkThread implements Runnable {
        @Override
        public void run() {
            try {
                ServerSocket serverSocket = new ServerSocket(10010);
                System.out.println("服务器启动！");
                JOptionPane.showMessageDialog(null, "服务器启动！");
                while (true) {
                    Socket socket = serverSocket.accept();
                    ServerThread4 server = new ServerThread4();
                    server.setSocket(socket);
                    new Thread(server).start();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    //Server线程
    class ServerThread4 implements Runnable {
        private Socket socket;
        public void setSocket(Socket socket) {
            this.socket = socket;
        }
        @Override
        public void run() {
            System.out.println("客户端" + socket.getInetAddress() + "连接成功！");
            InputStream inputStream = null;
            String str = null;
            try {
                inputStream = socket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                while (br.read() != -1) {
                    str = br.readLine();
                }
                System.out.println(str);
                contentTextArea.append(str);
                br.close();
                socket.close();
            } catch (IOException e) {
                //弹出窗口
                JOptionPane.showMessageDialog(null, "IO操作异常！");
            }
        }
    }
}
