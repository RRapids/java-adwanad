package com.soft1841.io;

import java.io.*;
import java.util.Scanner;

public class WriteCopy {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        byte[] bytes = str.getBytes();
        File file = new File("C:/hello.txt");
        OutputStream out = new FileOutputStream(file, true);
        out.write(bytes);
    }
}
