package com.soft1841.io;

import java.io.*;

public class TxtCopy {
    public static void main(String[] args) throws Exception {
        File srcFile = new File("C:/hello.txt");
        File destFile = new File("C:/hello副本.txt");
        Reader in = new FileReader(srcFile);
        char[] chars = new char[(int) srcFile.length()];
        in.read(chars);
        Writer out = new FileWriter(destFile);
        out.write(chars);
        in.close();
        out.close();

    }
}
