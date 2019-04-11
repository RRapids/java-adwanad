package main.MR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberFrame2 extends JFrame implements ActionListener {
    private JLabel numberLabel;
    private JButton pauseBtn, resumeBtn;
    private NumberThread2 numberThread2;

    public NumberFrame2() {
        init();
        setTitle("线程的暂停与恢复");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void init() {
        pauseBtn = new JButton("暂停");
        resumeBtn = new JButton("恢复");
        pauseBtn.addActionListener(this);
        resumeBtn.addActionListener(this);
        numberLabel = new JLabel();
        Font font = new Font("Lnk Free", Font.BOLD, 50);
        numberLabel.setFont(font);
        setLayout(new FlowLayout(FlowLayout.CENTER, 30, 100));
        add(numberLabel);
        add(pauseBtn);
        add(resumeBtn);
        numberThread2 = new NumberThread2();
        numberThread2.setNumLbel(numberLabel);
        Thread thread = new Thread(numberThread2);
        thread.start();
    }

    public static void main(String[] args) {
        new NumberFrame2();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pauseBtn) {
            numberThread2.pauseThread();
        }
        if (e.getSource() == resumeBtn) {
            numberThread2.resumeThread();
        }
    }
}