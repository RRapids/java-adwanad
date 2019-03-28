package com.soft1841.io;

import java.io.*;
import java.util.UUID;

public class FileCopy {
    public static void main(String[] args) throws Exception {
        //指定源文件
        File srcFile = new File("C:/bg.jpg");
        String srcFileName = srcFile.getName();
        int position = srcFileName.indexOf(".");
        //取得源文件的扩展名
        String suffixName = srcFileName.substring(position + 1);
        //新的主文件名
        String newName = UUID.randomUUID().toString();
        //指定目标文件
        File muFile = new File("D:/" + newName + "." + srcFileName);
        //创建一个字节数组，大小为源文件长度，长度转成int
        byte[] a = new byte[(int) srcFile.length()];
        //创建字节输入流
        InputStream fileInputStream = new FileInputStream(srcFile);
        //将源文件读入字节数组
        fileInputStream.read(a);
        //创建字节输出流
        OutputStream fileOutputStream = new FileOutputStream(muFile);
        //将字节数组写入目标文件
        fileOutputStream.write(a);
        fileInputStream.close();
        fileOutputStream.close();
    }
}
