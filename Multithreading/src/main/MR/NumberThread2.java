package main.MR;

import javax.swing.*;

public class NumberThread2 implements Runnable {
    private JLabel numLbel;
    public void setNumLbel(JLabel numLbel) {
        this.numLbel = numLbel;
    }
    private final Object lock = new Object();
    private boolean pause = false;
//     调用该方法实现线程的暂停
    void pauseThread() {
        pause = true;
    }
    // 调用该方法实现恢复线程的运行
    void resumeThread() {
        pause = false;
        synchronized (lock) {
            lock.notify();
        }
    }
    // 这个方法只能在run 方法中实现，不然会阻塞主线程，导致页面无响应
    void onPause() {
        synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        int index = 0;
        while (true) {
            while (pause) {
                onPause();
            }
            try {
                numLbel.setText(String.valueOf(index));
                Thread.sleep(500);
                ++index;
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
