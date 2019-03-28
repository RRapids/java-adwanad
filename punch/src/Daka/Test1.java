package Daka;

import javax.swing.*;
import java.awt.*;

public class Test1 extends JFrame {
    public Test1(){
        setTitle("射雕英雄传");
        Container container = getContentPane();
        setLayout(new BorderLayout());
        JButton centerBtn = new JButton("中通神");
        JButton northBtn = new JButton("北丐");
        JButton southBtn = new JButton("南帝");
        JButton westBtn = new JButton("西毒");
        JButton eastBtn = new JButton("东邪");
        container.add(centerBtn,BorderLayout.CENTER);
        container.add(northBtn,BorderLayout.NORTH);
        container.add(southBtn,BorderLayout.SOUTH);
        container.add(westBtn,BorderLayout.WEST);
        container.add(eastBtn,BorderLayout.EAST);
        setSize(400,300);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Test1();
    }
}

