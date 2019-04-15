package main.MR;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {
    public static void main(String[] args) {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println(new Date());
            }
        };
        TimerTask timerTask2 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello !");
            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask, 0, 1000);
        timer.schedule(timerTask2, 0, 2000);
    }
}
