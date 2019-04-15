package join;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class CircleThread implements Runnable {
    int x = 1500;
    int y = 800;
    private JFrame frame;
    private Graphics graphics;
    private Thread typeThread;


    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
    public void setTypeThread(Thread typeThread) {
        this.typeThread = typeThread;
    }


    @Override
    public void run() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                for (int i = 1; i <= 8;i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    graphics = frame.getGraphics();
                    graphics.drawOval(x / 2 - (i + 1) * 10, y / 2 - (i + 1) * 10, 10 + 20 * i, 10 + 20 * i);
                    if (i == 8) {
                        try {
                            typeThread.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask,1,1000);
    }
}
