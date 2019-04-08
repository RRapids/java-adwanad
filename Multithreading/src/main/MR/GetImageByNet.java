package main.MR;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 读取网络图片
 * @author 袁腾飞
 * 2019/4/9
 */
public class GetImageByNet {
    public static void main(String[] args) throws IOException {
        //new一个URL对象
        URL url = new URL("https://upload.jianshu.io/users/upload_avatars/14261279/e625c28b-efac-4822-90c3-7011042192b3?imageMogr2/auto-orient/strip|imageView2/1/w/120/h/120");
        //打开链接
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        //设置请求方式为"GET"
        connection.setRequestMethod("GET");
        //超时响应时间为5秒
        connection.setConnectTimeout(5*1000);
        //通过输入流获取图片数据
        InputStream inputStream  = connection.getInputStream();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();//得到图片的二进制数据，以二进制封装得到的数据，具有通用性
        byte[] buffer = new byte[1024];//准备缓冲字节数组
        int len = 0;
        while ((len = inputStream.read(buffer))!= -1){//每次读入一个缓冲区大小的字节数
            outputStream.write(buffer,0,len);//将缓冲去内容写出

        }
        inputStream.close();
        byte[] data = outputStream.toByteArray();//通过输出流获取到字节数组
        File imageFile = new File("1.jpg");//new 一个文件对象用来保存图片，默认保存当前工程根目录
        OutputStream outputStream1 = new FileOutputStream(imageFile);//创建输出流
        outputStream1.write(data);
        outputStream1.close();
    }
}
