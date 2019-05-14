package com.soft1841.gui;

import javax.swing.*;

public class MusicFrame {
    private JPanel mainPanel;
    private JLabel top;
    private JLabel centerLabel;
    private JLabel recommend;
    private JLabel bottomLabel;
    private JButton 发现音乐Button;
    private JButton 私人FMButton;
    private JButton 视频Button;
    private JButton 朋友Button;
    private JButton 本地音乐Button;
    private JButton 下载管理Button;

    public static void main(String[] args) throws Exception{
        String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(lookAndFeel);
        JFrame frame = new JFrame("MusicFrame");
        frame.setContentPane(new MusicFrame().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
