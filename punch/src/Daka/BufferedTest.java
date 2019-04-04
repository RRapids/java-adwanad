package Daka;

import java.io.*;

/**
 * 带缓冲的输入输出流
 */
public class BufferedTest {
    public static void main(String[] args) {
        //定义字符串数组
        String content[] = {"你不喜欢我，","我一点都不介意。","因为我活下来，","不是为了取悦你！"};
        //创建文件对象
        File file = new File("word.txt");
        try {
            //创建FileWriter类对象
            FileWriter fw = new FileWriter(file);
            BufferedWriter bufw = new BufferedWriter(fw);
            //循环遍历数组
            for (int k = 0;k<content.length;k++){
                //将字符串数组中的元素写入到磁盘文件中
                bufw.write(content[k]);
                //将数组中的单个元素以单行形式写入文件
                bufw.newLine();
            }
            //将BufferedWriter流关闭
            bufw.close();
            //将FileWriter流关闭
            fw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        try {
            //创建FileReader类对象
            FileReader fr = new FileReader(file);
            BufferedReader bufr = new BufferedReader(fr);
            //创建字符串对象
            String s = null;
            //声明int型变量
            int i = 0;
            while ((s = bufr.readLine()) != null){
                i++;
                System.out.println("第"+i+"行:"+s);
            }
            bufr.close();
            fr.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
