package main.MR;

import javax.swing.*;
import java.awt.*;

public class CarouseFrame2 extends JFrame {
    private JLabel bgLabel;
    private static final long serialVersionUID = 1L;
    private Thread threaddA;
    final JProgressBar progressBar = new JProgressBar();

    private CarouseFrame2() {
        init();
        setTitle("轮播窗体");
        //居中
        setLocationRelativeTo(null);
        //窗口最大化
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        //可见
        setVisible(true);
        //关闭
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void init() {
        bgLabel = new JLabel();
        CarouseThread2 ct = new CarouseThread2();
        getContentPane().add(progressBar, BorderLayout.NORTH);
        progressBar.setStringPainted(true);
        threaddA = new Thread(new Runnable() {
            int count = 0;

            public void run() {
                while (true) {
                    progressBar.setValue(++count);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (count == 100) {
                        try {
                            new Thread(ct).join();
                            add(bgLabel);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }

            }
        });
        threaddA.start();
        ct.setBgLabel(bgLabel);
        new Thread(ct).start();
    }

    public static void main(String[] args) {
        //背景音乐（jar包未找到）
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                String file = "D:/CloudMusic/Charlie Puth - 1984.mp3";
//                InputStream inputStream = this.getClass().getResourceAsStream(file);
//
//            }
//        }).start();
        new CarouseFrame2();
    }
}
