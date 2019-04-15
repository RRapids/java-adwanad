package main.MR;

/**
 * 售票线程程序3
 * 实现Runnable接口并同步线程（加锁）
 */
public class TicketThreadTest3 {
    public static void main(String[] args) {
        TicketThread3 tt = new TicketThread3();
        Thread thread1 = new Thread(tt, "一食堂");
        thread1.start();
        Thread thread2 = new Thread(tt, "二食堂");
        thread2.start();
        Thread thread3 = new Thread(tt, "三食堂");
        thread3.start();
    }
}

class TicketThread3 implements Runnable {
    private int ticket = 10;

    @Override
    public void run() {
        while (true) {
            //同步售票代码块
            synchronized (this) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.err.println("中断异常");
                    }
                    System.out.println(Thread.currentThread().getName() + "售票，当前票数 " + --ticket);
                }else {
                    break;
                }
            }
        }
    }
}
