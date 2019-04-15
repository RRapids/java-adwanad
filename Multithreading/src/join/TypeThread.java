package join;
import javax.swing.*;
import java.io.*;
import java.util.Timer;
import java.util.TimerTask;

public class TypeThread extends Thread {
    private JTextArea textArea;

    public void setTextArea(JTextArea textArea) {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                //创建文件对象
                File file = new File("D:/word.txt/");
                //创建FileInputStream对象
                FileInputStream fileInputStream = null;
                //创建BufferedInputStream对象
                BufferedInputStream bufferedInputStream = null;
                byte[] bContent = new byte[1024];
                try {
                    //实例化FileInputStream对象
                    fileInputStream = new FileInputStream(file);
                    //实例化BufferedInputStream对象
                    bufferedInputStream = new BufferedInputStream(fileInputStream);
                    //从文件中读取信息，并存入字节数组中
                    int len = bufferedInputStream.read(bContent);
                    //输出文件数据
                    String string = new String(bContent, 0, len);
                    textArea.append(string);
                } catch (IOException e) {
                    System.out.println("io异常");
                } finally {
                    try {
                        bufferedInputStream.close();
                        fileInputStream.close();
                    } catch (IOException e) {
                        System.out.println("io异常");
                    }
                }
            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask, 5, 1000);
        this.textArea = textArea;
    }
}
