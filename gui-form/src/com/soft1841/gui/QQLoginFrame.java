package com.soft1841.gui;

import javax.swing.*;

public class QQLoginFrame {
    private JPanel mainPanel;
    private JLabel headLogin;
    private JLabel JLabel;
    private JTextField textField1;
    private JTextField textField2;
    private JCheckBox 记住密码CheckBox;
    private JCheckBox 自动登录CheckBox;
    private JButton button1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("QQLoginFrame");
        frame.setContentPane(new QQLoginFrame().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
