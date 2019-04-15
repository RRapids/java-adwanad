package main.MR;

import javax.swing.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CarouseThread2 implements Runnable {

    private String[] imgs = {"http://www.ghostw7.com/uploadslxy/allimg/160125/1U51L043-1.jpg",
            "http://pic1.win4000.com/wallpaper/8/553ee258e2289.jpg"
            , "http://d.5857.com/gqfz_140115/001.jpg"};
    private JLabel bgLabel;

    public void setBgLabel(JLabel bgLabel) {
        this.bgLabel = bgLabel;
    }

    @Override
    public void run() {
        int i = 0;
        int length = imgs.length;
        while (true) {
            try {
                URL url = new URL(imgs[i]);
                //打开链接
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                //设置请求方式为“GET”
                conn.setRequestMethod("GET");
                //超时响应时间为5秒
                conn.setConnectTimeout(5 * 1000);
                //通过输入流获取图片数据
                InputStream inStream = conn.getInputStream();
                //得到图片的二进制数据，以二进制封装得到数据，具有通用性
                ByteArrayOutputStream out1 = new ByteArrayOutputStream();
                //准备缓冲字节流数组
                byte[] buffer = new byte[1024];
                int len = 0;
                //每次读入一个缓冲区大小的字节数
                while ((len = inStream.read(buffer)) != -1) {
                    //将缓冲区内容写出
                    out1.write(buffer, 0, len);
                }
                //通过输出流获取到字节数组
                byte[] data = out1.toByteArray();
                inStream.read(data);
                Icon icon = new ImageIcon(data);
                bgLabel.setIcon(icon);
                Thread.sleep(800);
                inStream.close();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
            if (i == length) {
                i = 0;
            }
        }
    }
}
