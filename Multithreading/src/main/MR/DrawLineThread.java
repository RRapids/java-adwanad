package main.MR;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * 线程绘图
 */
public class DrawLineThread implements Runnable {
    int x = 100;
    int y = 100;
    private JFrame frame;
    private Color[] colors = {Color.ORANGE,Color.ORANGE,Color.ORANGE,Color.ORANGE,Color.GREEN,Color.GREEN,
            Color.GREEN,Color.GREEN,Color.ORANGE,Color.RED,Color.RED,Color.RED,Color.RED,Color.RED
    };
    public void setFrame(JFrame frame){
        this.frame = frame;
    }
    @Override
    public void run() {
        Random random = new Random();
        while (true){
            try {
                Thread.sleep(500);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Graphics graphics = frame.getGraphics();
            Graphics2D g2d=(Graphics2D)graphics;
            Stroke stroke=new BasicStroke(5.0f);//设置线宽为3.0
            g2d.setStroke(stroke);
            graphics.setColor(colors[random.nextInt(colors.length)]);
            graphics.drawLine(x,y,590,y);
            y += 50;
            if (y>=500){
                y=100;
            }
        }
    }
}
