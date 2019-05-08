package First;

import java.io.*;
import java.net.Socket;

public class Client4 {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",10086);
        System.out.println("成功！");
        //客户端需要发送的文件，先通过字节输入流读入字节数组b
        File file = new File("C:/bg.jpg");
        byte[] bytes = new byte[(int) file.length()];
        InputStream is = new FileInputStream(file);
        is.read(bytes);
        //将数组b通过缓冲直接输出流传送出去
        BufferedOutputStream bos = new BufferedOutputStream(client.getOutputStream());
        bos.write(bytes);
        is.close();
        bos.close();
    }
}
