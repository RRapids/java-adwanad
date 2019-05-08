package work;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.net.URL;

public class FrameThread extends JFrame implements Runnable {
    private Container container;
    private JPanel topPanel, leftPanel, centerPanel, rightPanel, workPanel, desktopPanel, collectionPanel, updatePanel;
    private JLabel j1, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, imgLabels;
    private JButton btn1, btn2, saveBtn, nullBtn;
    private JTable jTable, recyclingTable;
    private JFileChooser jFileChooser;
    private JTextArea jTextArea, soupArea;
    private CardLayout cardLayout;

    public FrameThread() {
        init();
        setTitle("石灰文档");
        //居中
        setLocationRelativeTo(null);
        //窗口最大化
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        //可见
        setVisible(true);
        //关闭
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void run() {

    }

    private void init() {
        //容器边界布局
        container = getContentPane();
        container.setLayout(null);
        //顶部topPanel
        topPanel = new JPanel();
        topPanel.setLayout(null);
        topPanel.setBounds(0, 0, 1950, 60);
        topPanel.setBackground(new Color(255, 255, 255));
        Font font = new Font("楷体", Font.PLAIN, 30);
        j1 = new JLabel("石灰文档");
        j1.setFont(font);
        j1.setBounds(30, 20, 150, 30);
        JTextField txt = new JTextField("搜索文件");
        txt.setBounds(1500, 20, 200, 30);
        txt.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 2, Color.gray));
        URL url = FrameThread.class.getResource("/img/top.png");
        Icon icon = new ImageIcon(url);
        JLabel imgLabel = new JLabel();
        imgLabel.setIcon(icon);
        imgLabel.setBounds(1700, 20, 130, 30);
        //加入时间线程
        JLabel timeLabel = new JLabel();
        TimeThread timeThread = new TimeThread();
        timeThread.setTimeLabel(timeLabel);
        new Thread(timeThread).start();
        timeLabel.setBounds(1000, 20, 300, 20);
        Font timeFont = new Font("微软雅黑", Font.PLAIN, 20);
        timeLabel.setFont(timeFont);
        topPanel.add(timeLabel);
        topPanel.add(imgLabel);
        topPanel.add(txt);
        topPanel.add(j1);
        //左部leftPanel
        leftPanel = new JPanel();
        leftPanel.setLayout(null);
        leftPanel.setBounds(0, 60, 270, 1000);
        leftPanel.setBackground(new Color(238, 238, 238));
        Font font2 = new Font("微软雅黑", Font.PLAIN, 17);
        j2 = new JLabel("工作台");
        j2.setBounds(60, 180, 100, 20);
        j2.setForeground(new Color(162, 125, 144));

        j3 = new JLabel("我的桌面");
        j3.setBounds(60, 220, 100, 20);
        j3.setForeground(new Color(162, 125, 144));

        j4 = new JLabel("我的收藏");
        j4.setBounds(60, 260, 100, 20);
        j4.setForeground(new Color(162, 125, 144));

        j5 = new JLabel("回收站");
        j5.setBounds(60, 300, 100, 20);
        j5.setForeground(new Color(162, 125, 144));

        j6 = new JLabel("协作空间");
        j6.setBounds(60, 400, 100, 20);
        j6.setForeground(new Color(162, 125, 144));

        j6.setFont(font2);
        j5.setFont(font2);
        j4.setFont(font2);
        j3.setFont(font2);
        j2.setFont(font2);
        leftPanel.add(j2);
        leftPanel.add(j3);
        leftPanel.add(j4);
        leftPanel.add(j5);
        leftPanel.add(j6);
        //右边rightPanel
        rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBounds(1600, 60, 270, 1000);
        rightPanel.setBackground(new Color(238, 238, 238));
        Font font3 = new Font("黑体", Font.PLAIN, 20);
        btn1 = new JButton("新建");
        btn1.setBackground(new Color(54, 59, 62));
        btn1.setBounds(50, 180, 220, 40);
        btn2 = new JButton("导入");
        btn2.setBackground(new Color(243, 243, 243));
        btn2.setBounds(50, 240, 220, 40);
        btn1.setFont(font3);
        btn2.setFont(font3);
        btn1.setForeground(Color.WHITE);
        btn2.setForeground(new Color(149, 107, 111));
        j7 = new JLabel("快捷方式");
        j7.setFont(font2);
        j7.setBounds(65, 340, 200, 20);
        j8 = new JLabel("将常用文件拖拽到这里");
        j8.setBounds(65, 370, 200, 20);
        j8.setFont(font2);
        rightPanel.add(btn1);
        rightPanel.add(btn2);
        rightPanel.add(j7);
        rightPanel.add(j8);
        //中间centerPanel
        centerPanel = new JPanel();
        centerPanel.setLayout(null);
        centerPanel.setBackground(new Color(245, 245, 245));
        centerPanel.setBounds(270, 60, 1420, 1000);
        //1."工作台"
        workPanel = new JPanel();
        workPanel.setBounds(50, 50, 500, 200);
        j9 = new JLabel("最近更新       最近使用      我创建的     共享给我的");
        Font font4 = new Font("微软雅黑", Font.PLAIN, 20);
        j9.setForeground(new Color(162, 125, 144));
        j9.setFont(font4);
        workPanel.setBackground(new Color(245, 245, 245));
        workPanel.add(j9);
        //点击更新
        imgLabels = new JLabel("無");
        imgLabels.setBounds(500, 400, 200, 200);
        Font font1 = new Font("宋体",Font.BOLD,90);
        imgLabels.setFont(font1);
        imgLabels.setForeground(new Color(219, 219, 219));

        //点击"工作台"
        j2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                imgLabels.setVisible(true);
                recyclingTable.setVisible(false);
                recyclingTable.getTableHeader().setVisible(false);
                soupArea.setVisible(false);
                collectionPanel.setVisible(false);
                nullBtn.setVisible(false);
                saveBtn.setVisible(false);
                jTextArea.setVisible(false);
                desktopPanel.setVisible(false);
                jTable.setVisible(false);
                jTable.getTableHeader().setVisible(false);
                workPanel.setVisible(true);
                centerPanel.add(workPanel);
                centerPanel.add(imgLabels);
            }
        });


        //2."我的桌面"
        desktopPanel = new JPanel();
        desktopPanel.setBounds(50, 50, 100, 200);
        j10 = new JLabel("我的桌面");
        j10.setFont(font4);
        desktopPanel.setBackground(new Color(245, 245, 245));
        desktopPanel.add(j10);

        Object[][] table = {
                new Object[]{"表格功能实例", "袁腾飞", "2018年9月11日 袁腾飞"},
                new Object[]{"文档功能实例", "袁腾飞", "2018年9月12日 袁腾飞"},
                new Object[]{"项目进度安排", "袁腾飞", "2018年9月13日 袁腾飞"},
                new Object[]{"超市收银系统构架设计", "袁腾飞", "2012年9月11日 袁腾飞"},
                new Object[]{"商品类别", "袁腾飞", "2018年9月16日 袁腾飞"},
                new Object[]{"商品信息收集表", "袁腾飞", "2018年9月41日 袁腾飞"},
                new Object[]{"会员表", "袁腾飞", "2018年9月01日 袁腾飞"},
                new Object[]{"小组成员github仓库地址", "袁腾飞", "2018年9月14日 袁腾飞"},
                new Object[]{"管理系统界面", "袁腾飞", "2018年9月13日 袁腾飞"},
                new Object[]{"表格功能实例", "袁腾飞", "2018年1月11日 袁腾飞"},
                new Object[]{"表格功能实例", "袁腾飞", "2018年3月11日 袁腾飞"},
                new Object[]{"表格功能实例", "袁腾飞", "2018年4月11日 袁腾飞"},
                new Object[]{"表格功能实例", "袁腾飞", "2018年5月11日 袁腾飞"},
        };
        Object[] title = {"文件名", "所有者", "更新时间"};
        jTable = new JTable(table, title);
        jTable.setBounds(20, 230, 1300, 500);
        jTable.getTableHeader().setBounds(20, 200, 1300, 30);
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        jTable.setRowHeight(50);
        jTable.setFont(font2);
        jTable.getTableHeader().setFont(font2);
        jTable.setBackground(new Color(245, 245, 245));
        //点击"我的桌面"
        j3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                imgLabels.setVisible(false);
                recyclingTable.setVisible(false);
                recyclingTable.getTableHeader().setVisible(false);
                collectionPanel.setVisible(false);
                soupArea.setVisible(false);
                nullBtn.setVisible(false);
                saveBtn.setVisible(false);
                jTextArea.setVisible(false);
                workPanel.setVisible(false);
                desktopPanel.setVisible(true);
                jTable.setVisible(true);
                jTable.getTableHeader().setVisible(true);
                centerPanel.add(jTable.getTableHeader());
                centerPanel.add(jTable);
                centerPanel.add(desktopPanel);
            }
        });

        //3.我的收藏
        collectionPanel = new JPanel();
        collectionPanel.setBounds(50, 50, 100, 100);
        j11 = new JLabel("我的收藏");
        j11.setFont(font4);
        j11.setForeground(Color.RED);
        collectionPanel.add(j11);
        collectionPanel.setBackground(new Color(245, 245, 245));
        soupArea = new JTextArea();
        soupArea.setFont(font2);
        soupArea.setBackground(new Color(245, 245, 245));
        soupArea.setBounds(60, 200, 1000, 1000);
        //点击我的收藏
        j4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                recyclingTable.setVisible(false);
                recyclingTable.getTableHeader().setVisible(false);
                soupArea.setVisible(true);
                nullBtn.setVisible(false);
                saveBtn.setVisible(false);
                jTextArea.setVisible(false);
                imgLabels.setVisible(false);
                workPanel.setVisible(false);
                desktopPanel.setVisible(false);
                jTable.setVisible(false);
                jTable.getTableHeader().setVisible(false);
                j11.setVisible(true);
                collectionPanel.setVisible(true);
                //爬取
                String url = "https://www.jianshu.com/";
                Connection connection = Jsoup.connect(url);
                Document document = null;
                try {
                    document = connection.get();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                Elements elements = document.getElementsByClass("content");
                System.out.println(elements.size());
                for (Element element : elements) {
                    Element link = element.child(0);
                    String titleString = link.text();
                    System.out.println(titleString);
                    soupArea.setLineWrap(true);
                    soupArea.append(titleString);
                }
                centerPanel.add(collectionPanel);
                centerPanel.add(soupArea);
            }
        });

        //4.回收站
        recyclingTable = new JTable();
        Object[][] table2 = {
                new Object[]{"表格功能实例", "袁腾飞", "2018年9月11日 袁腾飞"},
                new Object[]{"表格功能实例", "袁腾飞", "2018年9月11日 袁腾飞"},

        };
        Object[] title2 = {"文件名", "所有者", "更新时间"};
        recyclingTable = new JTable(table2, title2);
        recyclingTable.setBounds(20, 230, 1300, 500);
        recyclingTable.getTableHeader().setBounds(20, 200, 1300, 30);
        recyclingTable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        recyclingTable.setRowHeight(50);
        recyclingTable.setFont(font2);
        recyclingTable.getTableHeader().setFont(font2);
        recyclingTable.setBackground(new Color(245, 245, 245));

        //点击回收站
        j5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                imgLabels.setVisible(false);
                soupArea.setVisible(false);
                nullBtn.setVisible(false);
                saveBtn.setVisible(false);
                jTextArea.setVisible(false);
                workPanel.setVisible(false);
                desktopPanel.setVisible(false);
                jTable.setVisible(false);
                jTable.getTableHeader().setVisible(false);
                collectionPanel.setVisible(false);
                recyclingTable.setVisible(true);
                recyclingTable.getTableHeader().setVisible(true);
                centerPanel.add(recyclingTable.getTableHeader());
                centerPanel.add(recyclingTable);
            }
        });

        //新建
        jTextArea = new JTextArea();
        jTextArea.setBounds(20, 150, 1300, 1200);
        jTextArea.setFont(font4);
        //自动换行
        jTextArea.setLineWrap(true);
        saveBtn = new JButton("保存");
        saveBtn.setBounds(50, 100, 100, 30);
        saveBtn.setFont(font2);
        saveBtn.setBackground(Color.GRAY);
        nullBtn = new JButton("清空");
        nullBtn.setBounds(250, 100, 100, 30);
        nullBtn.setFont(font2);
        nullBtn.setBackground(Color.GRAY);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imgLabels.setVisible(false);
                recyclingTable.setVisible(false);
                recyclingTable.getTableHeader().setVisible(false);
                soupArea.setVisible(false);
                jTextArea.setVisible(true);
                collectionPanel.setVisible(false);
                saveBtn.setVisible(true);
                nullBtn.setVisible(true);
                workPanel.setVisible(false);
                desktopPanel.setVisible(false);
                jTable.setVisible(false);
                jTable.getTableHeader().setVisible(false);
                centerPanel.add(jTextArea);
                centerPanel.add(saveBtn);
                centerPanel.add(nullBtn);
            }
        });


        //导入
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imgLabels.setVisible(false);
                recyclingTable.setVisible(false);
                recyclingTable.getTableHeader().setVisible(false);
                soupArea.setVisible(false);
                collectionPanel.setVisible(false);
                nullBtn.setVisible(true);
                saveBtn.setVisible(true);
                jTextArea.setVisible(true);
                workPanel.setVisible(false);
                desktopPanel.setVisible(false);
                jTable.setVisible(false);
                jTable.getTableHeader().setVisible(false);
                jFileChooser = new JFileChooser();
                //设置文件选择器的默认路径
                jFileChooser.setCurrentDirectory(new File("D:\\test"));
                jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                //打开对话框
                int result = jFileChooser.showOpenDialog(null);
                //用户点击了“确定”按钮
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = jFileChooser.getSelectedFile();
                    byte[] bytes = null;
                    try {
                        InputStream inputStream = new FileInputStream(file);
                        bytes = new byte[(int) file.length()];
                        inputStream.read(bytes);
                        inputStream.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    String str = new String(bytes);
                    jTextArea.setText("");
                    jTextArea.append(str);
                }
                centerPanel.add(jTextArea);
                centerPanel.add(saveBtn);
            }
        });

        //保存
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = new File(getTitle());
                jFileChooser = new JFileChooser();
                jFileChooser.setCurrentDirectory(new File("D:\\test"));
                jFileChooser.setFileFilter(new FileNameExtensionFilter("txt(*.txt)",
                        "txt"));
                jFileChooser.setSelectedFile(new File("新建文本文档.txt"));
                int result = jFileChooser.showSaveDialog(null);
                System.out.println(result);
                if (result == JFileChooser.APPROVE_OPTION) {
                    String str = jTextArea.getText();
                    File file2 = jFileChooser.getSelectedFile();
                    try {
                        file.createNewFile();
                        OutputStream out = new FileOutputStream(file2);
                        PrintStream printStream = new PrintStream(out);
                        printStream.print(str);
                        out.close();
                        printStream.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    setTitle(file.getAbsolutePath());
                }

            }
        });
        //清空
        nullBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextArea.setText("");
                setTitle("新建");
            }
        });

        //各组件加入到container
        container.add(topPanel);
        container.add(leftPanel);
        container.add(rightPanel);
        container.add(centerPanel);
    }
}
