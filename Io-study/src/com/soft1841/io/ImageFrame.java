package com.soft1841.io;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;

/**
 * 图片窗体程序
 *
 * @author 腾飞
 */
public class ImageFrame extends JFrame {
    private JPanel topPanel;
    private JLabel timeLabel;
    private JLabel pathLabel;
    private JButton[] buttons;
    private JLabel imageLabel;
    private JLabel sizeLabel;
    private Icon icon;

    public ImageFrame() {
        init();
        setTitle("标题");
        setSize(1000, 300);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    //设置布局，设置组件
    public void init() {
        topPanel = new JPanel();
        buttons = new JButton[5];
        for (int i = 0; i < 5; i++) {
            buttons[i] = new JButton("按钮" + i + 1);
            topPanel.add(buttons[i]);
        }
        add(topPanel, BorderLayout.NORTH);
        imageLabel = new JLabel("图片");
        //读入本地图片到内存的字节数组
        File srcFile = new File("C:/bg.jpg");
        InputStream inputStream;
        byte[] bytes = new byte[0];
        try {
            inputStream = new FileInputStream(srcFile);
            bytes = new byte[(int) srcFile.length()];
            inputStream.read(bytes);
        } catch (IOException e) {
            System.out.println("IO异常");
        }
        icon = new ImageIcon(bytes);
        //图片
        imageLabel.setIcon(icon);
        //时间
        LocalDate today = LocalDate.now();
        //时间加入左侧
        timeLabel = new JLabel(String.valueOf(today));
        //路径
        String path = srcFile.getAbsolutePath();
        //大小
        long size = srcFile.length();
        //大小加入下侧
        sizeLabel = new JLabel(String.valueOf(size));
        //路径加入下侧
        pathLabel = new JLabel(path);
        add(sizeLabel, BorderLayout.SOUTH);
        add(pathLabel, BorderLayout.SOUTH);
        add(timeLabel, BorderLayout.WEST);
        add(imageLabel, BorderLayout.CENTER);
    }


    public static void main(String[] args) {
        new ImageFrame();

    }
}
