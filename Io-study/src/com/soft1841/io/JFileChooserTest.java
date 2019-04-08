package com.soft1841.io;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class JFileChooserTest extends JFrame implements ActionListener {
    private JButton chooseBtn;
    private JLabel pathLabel;
    private JFileChooser fileChooser;

    public JFileChooserTest() {
        init();
        setTitle("JFileChooserTest");
        setSize(new Dimension(800, 600));
        //居中
        setLocationRelativeTo(null);
        //可见
        setVisible(true);
        //关闭
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void init() {
        chooseBtn = new JButton("选择文件");
        pathLabel = new JLabel("暂无选择");
        add(chooseBtn,BorderLayout.NORTH);
        chooseBtn.addActionListener(this);
        Font font = new Font("微软雅黑",Font.BOLD,26);
        pathLabel.setFont(font);
        add(pathLabel);

    }

    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new JFileChooserTest();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        System.out.println("click");
        //创建
        fileChooser = new JFileChooser();
        //设置文件选择器的默认路径
        fileChooser.setCurrentDirectory(new File("D:\\"));
        //打开对话框
        int result = fileChooser.showOpenDialog(null);
        //用户点击了“确定”按钮
        if (result == JFileChooser.APPROVE_OPTION);
        File file = fileChooser.getSelectedFile();
        try {
            InputStream inputStream = new FileInputStream(file);
            Scanner scanner = new Scanner(inputStream);
            String res = scanner.nextLine();
            pathLabel.setText(res);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

//        //获取该文件的绝对路径
//        String filePath = file.getAbsolutePath();
//        //将file的绝对路径显示在窗体中间
//        pathLabel.setText(filePath);


    }
}
