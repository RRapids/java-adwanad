package com.java.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.NumberFormat;
import java.util.Random;

public class RandomPoint {
    public static void main(String[] args) throws Exception{
        Random random = new Random();
        //指定图片大小及类型
        BufferedImage bufferedImage = new BufferedImage(1024, 768, BufferedImage.TYPE_INT_BGR);
        //获取随机点
        int x1 = random.nextInt(1024);
        int y1 = random.nextInt(768);
        int x2 = random.nextInt(1024);
        int y2 = random.nextInt(768);
        //计算距离
        double distance = (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
        //输出距离
        System.out.println("两点坐标为：( " + x1 + "," + y1 + " )  ，"+ " ( " + x2 + "," + y2 + " )");
        System.out.printf("两点距离为：" + "%.2f",Math.sqrt(distance));
        //获取画笔
        Graphics graphics = bufferedImage.getGraphics();
        //设置颜色
        graphics.setColor(Color.yellow);
        //绘制线段
        graphics.drawLine(x1, y1, x2, y2);
        //将double转为String
        NumberFormat numberFormat = NumberFormat.getInstance();
        String x = numberFormat.format(distance);
        //输入长度
        graphics.drawString(x,(x1+x2)/2,(y1+y2)/2);
        //指定文件路径
        File file = new File("D:/point.jpg");
        //获取字节输出流
        OutputStream outputStream = new FileOutputStream(file);
        //将图片从缓冲区通过字节流写到文件
        ImageIO.write(bufferedImage, "jpg", outputStream);
        //关闭
        outputStream.close();
    }
}
