package Daka;

import javax.swing.*;
import java.awt.*;

/**
 * 边界布局
 */
public class BorderLayoutPosition extends JFrame {
    public BorderLayoutPosition() {
        setTitle("这个窗体使用边界布局管理器");
        //定义一个容器
        Container container = getContentPane();
        //设置容器为边界布局管理器
        setLayout(new BorderLayout());
        JButton centerBtn = new JButton("中");
       /* northBtn = new JButton("北");
        southBtn = new JButton("南");
        westBtn = new JButton("西");*/
    }
}
