package join;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CountdownFrame extends JFrame {
    private JButton btn;
    private int time = 10;
    private JPanel countdownLabel;
    private JTextArea timeArea;

    private CountdownFrame() {
        init();
        setTitle("倒计时窗体");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void init() {
        //创建JPanel对象的同时，将背景图绘制上去
        countdownLabel = new JPanel() {
            protected void paintComponent(Graphics g) {
                try {
                    BufferedImage bg = ImageIO.read(new File("D:/bg.jpg"));
                    g.drawImage(bg, 0, 0, getWidth(), getHeight(), null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        countdownLabel.setLayout(new FlowLayout(FlowLayout.CENTER, 400, 300));
        btn = new JButton("Start");
        timeArea = new JTextArea();
        Font font = new Font("AxureHandwriting-Bold", Font.BOLD, 50);
        timeArea.setFont(font);
        setLayout(new FlowLayout());
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(new timeThread()).start();
            }
        });

        countdownLabel.add(btn);
        countdownLabel.add(timeArea);
        add(countdownLabel);
    }

    class timeThread implements Runnable {

        @Override
        public void run() {
            while (time > 1) {
                time--;
                timeArea.setText(time + " ");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (time == 1) {
                timeArea.setText("OK!");
            }
        }
    }


    public static void main(String[] args) {
        new CountdownFrame();
    }
}
