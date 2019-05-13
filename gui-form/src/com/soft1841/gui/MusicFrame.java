package com.soft1841.gui;

import javax.swing.*;

public class MusicFrame {
    private JPanel mainPanel;
    private JLabel topLabel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("MusicFrame");
        frame.setContentPane(new MusicFrame().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
