package join;

import main.MR.TimeThread;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimeFrame extends JFrame {
    private JPanel jPanel;
    private TimerTask clockTask;
    private java.util.Timer timer;

    public TimeFrame() {
        init();
        setTitle("组件绘制");
        setSize(800, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void init() {
        //创建JPanel对象的同时，将背景图绘制上去
        jPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                try {
                    BufferedImage bg = ImageIO.read(new File("D:/bg.jpg"));
                    g.drawImage(bg, 0, 0, getWidth(), getHeight(), null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        jPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 200));
        add(jPanel);
        //
        JLabel timeLabel = new JLabel();
        Font font = new Font("AxureHandwriting-Bold", Font.BOLD, 30);
        timeLabel.setFont(font);
        TimeThread timeThread = new TimeThread();
        timeThread.setTimeLabel(timeLabel);
        jPanel.add(timeLabel);
        timeThread.start();
        clockTask = new TimerTask() {
            @Override
            public void run() {
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String timeString = sdf.format(date);
                if (timeString.equals("2019-04-16 09:20:50")) {
                    JOptionPane.showMessageDialog(jPanel, "时间到~~");
                    this.cancel();
                }
            }
        };
        timer = new Timer();
        timer.scheduleAtFixedRate(clockTask, 0, 1000);
    }

    public static void main(String[] args) {
        new TimeFrame();
    }
}
