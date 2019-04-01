package Daka;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 遍历文件夹
 */
public class FolderTest {
    public static void main(String[] args) {
        //要遍历的路径
        String path = "D:\\Download";
        //获取其file对象
        File file = new File(path);
        //遍历path下的文件和目录，放在File数组中
        File[] fs = file.listFiles();
        //遍历File[]数组
        for (File f:fs) {
            String fileName = f.getName();
            List<File> list = new ArrayList<File>();
            //若非目录（即文件），则打印
            if(fileName.endsWith(".jpg")||fileName.endsWith(".png")){
                list.add(f);
                System.out.println(f);
            }
        }
    }
}
