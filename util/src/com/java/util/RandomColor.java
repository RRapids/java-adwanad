package com.java.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * 随机颜色
 *
 * @author 79876
 * 2019.3.12
 */
public class RandomColor {
    public static void main(String[] args) throws IOException {

        Random random = new Random();
        //生成redRandom
        int redRandom = random.nextInt(256);
        //生成greenRandom
        int greenRandom = random.nextInt(256);
        //生成blueRandom
        int blueRandom = random.nextInt(256);
        System.out.println("R: " + redRandom + ",G:" + greenRandom + ",B:" + blueRandom);
        //开始用随机色值绘制
        //指定图片大小及类型
        BufferedImage bufferedImage = new BufferedImage(120, 40, BufferedImage.TYPE_INT_BGR);
        //获取画笔
        Graphics g = bufferedImage.getGraphics();
        //设置字体
        Font font = new Font("微软雅黑", Font.BOLD, 16);
        g.setFont(font);
        //设置画笔颜色,使用随机生成的颜色
        Color color = new Color(redRandom, greenRandom, blueRandom);
        g.setColor(color);
        //绘制矩形，充满图片缓冲区
        g.fillRect(0, 0, 160, 40);
        //输入文字
        g.setColor(Color.BLACK);
        int number = 4;
        String codeNum = "";
        int[] code = new int[3];
        for (int i = 0; i < number; i++) {
            int num = random.nextInt(10) + 48;
            int uppercase = random.nextInt(26) + 65;
            int lowercase = random.nextInt(26) + 97;
            code[0] = num;
            code[1] = uppercase;
            code[2] = lowercase;
            codeNum += (char) code[random.nextInt(3)];
        }
        g.drawString(codeNum, 40, 30);

        //干扰线
        for (int i = 0; i < 20; i++) {

            Color color1 = new Color(greenRandom, blueRandom, redRandom);
            int x = random.nextInt(50);
            int y = random.nextInt(60);
            int xl = random.nextInt(160);
            int yl = random.nextInt(80);
            g.setColor(color1);
            g.drawLine(x, y, x + xl, y + yl);
        }

        //输出图片
        //指定文件路径
        File file = new File("D:/code.jpg");
        //获取字节输出流
        OutputStream outputStream = new FileOutputStream(file);
        //将图片从缓冲区通过字节流写到文件
        ImageIO.write(bufferedImage, "jpg", outputStream);
        //关闭
        outputStream.close();
    }
}

