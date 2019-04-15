package main.MR;

import javax.swing.*;
import java.time.LocalTime;

public class TimeThread extends Thread {
    private JLabel timeLabel;
    public void setTimeLabel(JLabel timeLabel){
        this.timeLabel = timeLabel;
    }

    @Override
    public void run() {
        while (true){
            LocalTime localTime = LocalTime.now();
            timeLabel.setText(String.valueOf(localTime));
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
