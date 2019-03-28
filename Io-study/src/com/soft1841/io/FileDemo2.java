package com.soft1841.io;

import java.io.File;

public class FileDemo2 {
    public static void main(String[] args) {
        String[] strings = {"image","video","document"};
        File file = new File("D:\\upload");
        for (int i =0;i<=strings.length;i++){
            File folder = new File(file +"\\" + strings[i]);
            if (!folder.exists()){
                folder.mkdirs();
            }
        }
    }
}
