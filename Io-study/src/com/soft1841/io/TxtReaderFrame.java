package com.soft1841.io;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class TxtReaderFrame extends JFrame implements ActionListener {
    private JTextField inputFileld;
    private JButton confirmButton;
    private JPanel topPanel;
    private JTextArea contentArea;
    private JLabel contentLable;
    private Icon icon;


    public TxtReaderFrame(){
        init();
        setTitle("文本阅读窗体");
        setSize(new Dimension(800,600));
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void init(){
        //顶部面板
        inputFileld = new JTextField(20);
        inputFileld.setPreferredSize(new Dimension(150,40));
        confirmButton = new JButton("确认");
        confirmButton.setPreferredSize(new Dimension(70,40));
        contentLable = new JLabel();
        contentLable.setPreferredSize(new Dimension(300,300));
        //给按钮注册监听
        confirmButton.addActionListener(this);
        topPanel = new JPanel();
        topPanel.add(inputFileld);
        topPanel.add(confirmButton);
        add(topPanel,BorderLayout.NORTH);
        //图片
        add(contentLable,BorderLayout.CENTER);
        //中间的多行文本域
//        contentArea = new JTextArea();
//        add(contentArea,BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new TxtReaderFrame();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //获取输入框内容
        String filePath = inputFileld.getText().trim();
        //创建文件
        File file = new File(filePath);
        //使用三种方法将file中的内容读入
        byte[] bytes = new byte[0];
        try {
            InputStream inputStream = new FileInputStream(file);
            bytes = new byte[(int) file.length()];
            //读入内容，到字节数组
            inputStream.read(bytes);
            //使用bytes构建一个新的输出字符串
            //String resultStr = new String(bytes);
            //换行
            //contentArea.append("\n");
        } catch (IOException e1) {
            //System.out.println("IO异常");
            //弹出窗口
            JOptionPane.showMessageDialog(null,"IO操作异常！");
        }
        icon = new ImageIcon(bytes);
        contentLable.setIcon(icon);
    }
}
