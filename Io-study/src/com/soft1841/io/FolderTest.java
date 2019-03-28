package com.soft1841.io;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class FolderTest {
    public static void main(String[] args) throws IOException {
        LocalDate today = LocalDate.now();
        File file = new File("D:\\"+today);
        if (!file.exists()){
            file.mkdirs();
        }

        File folder = new File(file + "/" + "hello.md"+today);
            if (!folder.exists()){
                folder.createNewFile();
            }

        System.out.println("创建成功");

    }
}
