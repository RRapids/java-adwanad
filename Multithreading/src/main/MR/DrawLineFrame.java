package main.MR;

import javax.swing.*;
import java.awt.*;

/**
 * 线程绘图窗口
 */
public class DrawLineFrame extends JFrame {
    public DrawLineFrame(){
        init();
        setTitle("绘制彩色线段");
        setSize(800,600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    private void init(){
        getContentPane().setBackground(new Color(117, 110, 162));
        DrawLineThread drawLineThread = new DrawLineThread();
        drawLineThread.setFrame(this);
        new Thread(drawLineThread).start();
    }

    public static void main(String[] args) {
        new DrawLineFrame();
    }
}
