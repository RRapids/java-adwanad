package main.MR;

import javax.swing.*;
import java.awt.*;

public class GridLayoutFrame extends JFrame {
    private JLabel numberLabel;
    private JLabel timeLabel;
    private JPanel pictureJPanle;
    private JLabel imageLabel;

    //定义一个面板数组
    private JPanel[] panels;
    private GridLayoutFrame(){
        init();
        setTitle("多线程练习窗体");
        //界面启动最大化
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
    public void init() {
        //将整个容器背景设置为白色
        getContentPane().setBackground(new Color(255, 255, 255));
        //定义三行三列九宫格
        GridLayout gridLayout = new GridLayout(2, 2, 50, 30);
        setLayout(gridLayout);
        //创建面板数组
        panels = new JPanel[6];
        //循环创建每个面板对象
        for (int i = 0; i < 6; i++) {
            panels[i] = new JPanel();
            //面板加上边框
            panels[i].setBorder(BorderFactory.createTitledBorder("面板" + (i + 1)));
            //面板一次加入网格布局中
            add(panels[i]);
        }
        //第一个面板放系统时间
        timeLabel = new JLabel();
        Font font1 = new Font("微软雅黑",Font.BOLD,40);
        timeLabel.setFont(font1);
        panels[0].setLayout(new BorderLayout(20,20));
        panels[0].setBackground(new Color(131, 241, 231));
        panels[0].add(timeLabel,BorderLayout.CENTER);
        TimeThread timeThread = new TimeThread();
        timeThread.setTimeLabel(timeLabel);
        timeThread.start();
        //第二个面板放随机数
        numberLabel = new JLabel();
        java.awt.Font font = new java.awt.Font("微软雅黑", Font.PLAIN,60);
        numberLabel.setFont(font);
        panels[1].setLayout(new BorderLayout(20,20));
        panels[1].setBackground(new Color(0,172,193));
        panels[1].add(numberLabel,BorderLayout.CENTER);
        //NumberThread numberThread = new NumberThread();
       // numberThread.setNumberLabel(numberLabel);
       // numberThread.start();
//        //第三个面板放轮播图
//        imageLabel = new JLabel();
//        panels[2].setLayout(new BorderLayout(20,20));
//        panels[2].add(imageLabel,BorderLayout.CENTER);
//        ImageThread imageThread = new ImageThread();
//        imageThread.setImageLabel(imageLabel);
//        imageThread.start();

        //第四个面板放随机产生的背景
        pictureJPanle =new JPanel();
        panels[3].setLayout(new BorderLayout(20,20));
        panels[3].add(pictureJPanle,BorderLayout.CENTER);
        BackgroundThread backgroundThread = new BackgroundThread();
        backgroundThread.setPicturePanel(pictureJPanle);
        backgroundThread.start();
    }

    public static void main(String[] args) {
        new GridLayoutFrame();
    }
}
