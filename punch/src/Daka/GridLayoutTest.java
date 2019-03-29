package Daka;

import javax.swing.*;
import java.awt.*;

/**
 * GridLayout网格布局示例
 * 2019/3/26
 */

public class GridLayoutTest extends JFrame {
    //定义一个面板数组
    private JPanel[] panels;

    private GridLayoutTest() {
        init();
        setTitle("GirdLayout网格布局管理器");
        //界面启动最大化
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void init() {
        //将整个容器背景置为白色
        getContentPane().setBackground(new Color(255, 255, 255));
        //定义三行三列九宫格，放置9个面板，水平间距，垂直间距
        GridLayout gridLayout = new GridLayout(3, 3, 50, 30);
        setLayout(gridLayout);
        //创建面板数组
        panels = new JPanel[9];
        //循环创建每个面板对象
        for (int i = 0; i < 9; i++) {
            panels[i] = new JPanel();
            //面板加上边框
            panels[i].setBorder(BorderFactory.createTitledBorder("面板" + (i + 1)));
            //面板以此
            //面板依次加入网格布局管理器，变成九宫格
            add(panels[i]);
        }
        //设置第一个面板背景色，其布局方式默认为FlowLayout居中对齐
        panels[0].setBackground(new Color(178, 233, 219));
        //在第一个面板内部加入5个按钮
        for (int i = 0; i < 5; i++) {
            panels[0].add(new JButton("JAVA"));
        }
        //设置第二个面板为BorderLayout边界布局，设置背景色
        panels[1].setLayout(new BorderLayout(20, 20));
        panels[1].setBackground(new Color(0, 123, 231));
        //5个方向加入按钮
        panels[1].add(new JButton("北"), BorderLayout.NORTH);
        panels[1].add(new JButton("南"), BorderLayout.SOUTH);
        panels[1].add(new JButton("东"), BorderLayout.EAST);
        panels[1].add(new JButton("西"), BorderLayout.WEST);
        panels[1].add(new JButton("中"), BorderLayout.CENTER);

        //设置第三个面板为GirdLayout网格布局，设置背景色
        panels[2].setLayout(new GridLayout(3, 3, 10, 10));
        panels[2].setBackground(new Color(213, 23, 213));
        //以此加入9个按钮
        for (int i = 0; i < 9; i++) {
            panels[2].add(new JButton(String.valueOf(i + 1)));
        }
        //第四个面板中加入下拉框,设置背景色
        panels[3].setBackground(new Color(230, 21, 44));
        //创建一个下拉框
        JComboBox<String> comboBox = new JComboBox<>();
        //设置坐标
        comboBox.setBounds(110, 11, 80, 21);
        //为下拉框添加项
        comboBox.addItem("身份证");
        comboBox.addItem("军人证");
        comboBox.addItem("学生证");
        comboBox.addItem("工作证");
        panels[3].add(comboBox);

        //第五个面板中加入带滚动条大的文字编辑器,设置背景色
        panels[4].setBackground(new Color(230, 210, 44));
        //创建文本区域组件，文本域默认大小为20行50列
        JTextArea ta = new JTextArea(10, 30);
        //创建JScrollPane滚动面板，并将文本域放到滚动面板中
        JScrollPane sp = new JScrollPane(ta);
        panels[4].add(sp);

        //第六个面板中加入标签设置图标
        //创建标签
        JLabel jLabel = new JLabel("JFrame窗体", JLabel.CENTER);
        /*//获取图片所在的URL
        URL url = GridLayoutTest.class.getResource("pic.jpg");
        //创建Icon对象
        Icon icon = new ImageIcon(url);
        //为标签设置图片
        jLabel.setIcon(icon);*/
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel.setOpaque(true);
        jLabel.setSize(200, 100);
        jLabel.setBackground(new Color(233, 23, 123));
        panels[5].add(jLabel);

    }


    public static void main(String[] args) {
        //用系统样式替代Swing默认样式，会稍微好看点
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new GridLayoutTest();
    }

}
