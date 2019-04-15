package join;

import javax.swing.*;
import java.awt.*;

public class Test extends JFrame {
    private JTextArea textArea;
    private JScrollPane scrollPane;

    private Test() {

        init();
        setTitle("Timer and Join");
        //窗口最大化
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        //可见
        setVisible(true);
        //关闭
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void init() {
        //同心圆
        CircleThread circleThread = new CircleThread();
        circleThread.setFrame(this);
        new Thread(circleThread).start();
        //
        textArea = new JTextArea();
        textArea.setSize(500,600);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        scrollPane = new JScrollPane(textArea);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setOpaque(false);

        add(scrollPane,BorderLayout.EAST);
        scrollPane.setBounds(0,0,500,600);
        //读入文本
        TypeThread typeThread = new TypeThread();
        new Thread(typeThread).start();

    }

    public static void main(String[] args) {
        new Test();
    }
}
