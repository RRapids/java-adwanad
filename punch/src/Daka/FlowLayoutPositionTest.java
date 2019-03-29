package Daka;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutPositionTest extends JFrame {
    public FlowLayoutPositionTest() {
        setTitle("流布局");
        Container c = getContentPane();
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JLabel jLabel = new JLabel("下面四句诗，哪一个是描写夏天的？");
        c.add(jLabel);
        JLabel jLabel2 = new JLabel("A.秋风萧瑟天气凉，树木摇荡露为霜。");
        c.add(jLabel2);
        JLabel jLabel3 = new JLabel("B.白雪纷纷何所似，撒盐空中差可似。");
        c.add(jLabel3);
        JLabel jLabel4 = new JLabel("C.接天莲叶无穷碧，映日荷花别样红。");
        c.add(jLabel4);
        JLabel jLabel5 = new JLabel("D.竹外桃花两三枝，春江水暖鸭先知。");
        c.add(jLabel5);
        //设置窗体大小
        setSize(300, 300);
        setResizable(false);
        //窗体关闭方式
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //设置窗体可见
        setVisible(true);
    }

    public static void main(String[] args) {
        new FlowLayoutPositionTest();
    }
}
