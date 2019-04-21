package main.MR;

import javax.swing.*;

/**
 * 交通红绿灯
 * 2019/4/15
 * @author 腾飞
 */
public class TurnColor extends Thread {
    private JLabel bgLabel;

    public void setBgLabel(JLabel bgLabel) {
        this.bgLabel = bgLabel;
    }

    @Override
    public void run() {
        while (true) { // 线程始终处于被启用状态
            try {
                Thread.sleep(2000); // 线程休眠5秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            bgLabel.setIcon(new ImageIcon(TraficLights.class.getResource("/img/Yellow.png"))); // 黄灯
            try {
                Thread.sleep(2000); // 线程休眠2秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            bgLabel.setIcon(new ImageIcon(TraficLights.class.getResource("/img/Red.png"))); // 红灯
            try {
                Thread.sleep(2000); // 线程休眠8秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            bgLabel.setIcon(new ImageIcon(TraficLights.class.getResource("/img/Green.png"))); // 绿灯
        }
    }
}
