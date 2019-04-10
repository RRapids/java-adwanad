package main.MR;

import javax.swing.*;
import java.awt.*;

/**
 * 窗体绘图
 */
public class DrawImageTest extends JFrame {
    public DrawImageTest() {
        setSize(200, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new CanvasTest());
        this.setTitle("绘制图像");
    }

    public static void main(String[] args) {
        new DrawImageTest().setVisible(true);
    }

    class CanvasTest extends Canvas {
        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2 = (Graphics2D) g;
            Image img = new ImageIcon(this.getClass().getResource("/resources/2.png")).getImage();
            g2.drawImage(img, 0, 0, this);
        }
    }

}
