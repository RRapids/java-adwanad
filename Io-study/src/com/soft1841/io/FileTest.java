package com.soft1841.io;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 创建并获取文件的基本信息
 */
public class FileTest {
    public static void main(String[] args) {
        //创建文件对象
        File file = new File("test.txt");
        //文件不存在（程序第一次运行时，执行的语句块）
        if (!file.exists()) {
            System.out.println("未在指定目录下找到文件名为“test”的文本文件！正在创建...");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }           //创建文件
            System.out.println("文件创建成功！");
        } else { //文件存在（程序第二次运行时，执行的语句块）
            System.out.println("找到文件名为“test”的文本文件！");
            //该文件文件是一个标准文件且该文件可读
            if (file.isFile() && file.canRead()) {
                System.out.println("文件可读！正在读取文件信息...");
                //获取文件名
                String fileName = file.getName();
                //获取该文件的绝对路径
                String filePath = file.getAbsolutePath();
                //获得该文件是否被隐藏
                boolean hidden = file.isHidden();
                //获取该文件中的字节数
                long len = file.length();
                //获取该文件最后的修改时间
                long tempTime = file.lastModified();
                //创建SimpleDateFormat对象，指定目标格式
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy/MM/dd HH:mm:ss");
                //使用文件最后修改时间创建Date对象
                Date date = new Date(tempTime);
                //格式化文件最后的修改时间
                String time = simpleDateFormat.format(date);
                System.out.println("文件名：" + fileName);
                System.out.println("文件的绝对路径：" + filePath);
                System.out.println("文件是否是隐藏文件：" + hidden);
                System.out.println("文件中的字节数：" + len);
                System.out.println("文件最后的修改时间：" + time);
                //查完该文件信息后，删除文件
                file.delete();
                System.out.println("文件已被删除！");
            }else{  //文件不可读
                System.out.println("文件不可读！");
            }

        }
    }
}
