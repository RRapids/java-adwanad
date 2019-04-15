package com.soft1841.io;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ViewImage extends JFrame implements ActionListener {
    private JButton chooseBtn,copyBtn;
    private JFileChooser jFileChooser;
    private JPanel leftPanel, rightPanel;
    private Container leftContainer, container;

    public ViewImage() {
        init();
        setTitle("ViewImage");
        setSize(new Dimension(1500, 800));
        //居中
        setLocationRelativeTo(null);
        //可见
        setVisible(true);
        //关闭
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public void init() {
        //设置容器
        container = getContentPane();
        //将容器设置为网格布局
        container.setLayout(new GridLayout(1, 2, 10, 10));
        //定义左侧容器，为边界布局
        leftContainer = new Container();
        leftContainer.setLayout(new BorderLayout());

        //定义leftPanel为网格布局
        leftPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        //右侧面板
        rightPanel = new JPanel();
        chooseBtn = new JButton("选择");
        copyBtn = new JButton("备份");

        //添加按钮监听
        chooseBtn.addActionListener(this);
        copyBtn.addActionListener(this);

        rightPanel.setBackground(new Color(101, 86, 135));
        //左侧容器加入按钮
        leftContainer.add(chooseBtn, BorderLayout.SOUTH);
        leftContainer.add(copyBtn, BorderLayout.NORTH);
        leftContainer.add(leftPanel);
        container.add(leftContainer);
        container.add(rightPanel);
    }

    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new ViewImage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chooseBtn) {
            //创建
            jFileChooser = new JFileChooser();
            //设置文件选择器的默认路径
            jFileChooser.setCurrentDirectory(new File("C:\\tu"));
            jFileChooser.setMultiSelectionEnabled(true);
            //打开对话框
            int result = jFileChooser.showOpenDialog(null);
            //用户点击了“确定”按钮
            if (result == JFileChooser.APPROVE_OPTION) {
                File[] files = jFileChooser.getSelectedFiles();
                for (File f : files) {
                    System.out.println(f.getAbsolutePath());
                    //对每个f文件，创建字节输入流读入字节数组，构建Icon，并设置给JLabel
                    try {
                        InputStream inputStream = new FileInputStream(f);
                        byte[] bytes = new byte[(int) f.length()];
                        inputStream.read(bytes);
                        Icon icon = new ImageIcon(bytes);
                        JLabel imgLabel = new JLabel();
                        imgLabel.setIcon(icon);
                        imgLabel.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {

                            }
                        });
                        JLabel imageLable = new JLabel();
                        imageLable.setIcon(icon);
                        rightPanel.add(imageLable);
                        leftPanel.setBackground(new Color(222, 222, 222));
                        leftPanel.add(imgLabel);
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(null, "IO操作异常");
                    }
                }

            }
        }
        if (e.getSource() == copyBtn) {
            File srcFile = new File("C:\\tu");
            File[] files = srcFile.listFiles();
            for (File file : files) {
                String srcFileName = file.getName();
                int position = srcFileName.indexOf(".");
                //取得源文件的扩展名
                String suffixName = srcFileName.substring(position + 1);
                //指定目标文件
                String path = "D:\\tuCopy";
                for (int i = 1; i <= files.length; i++) {
                    byte[] a = new byte[(int) file.length()];
                    //创建字节输入流
                    try {
                        InputStream fileInputStream = new FileInputStream(file);
                        fileInputStream.read(a);
                        //创建字节输出流
                        OutputStream fileOutputStream = new FileOutputStream(path);
                        //将字节数组写入目标文件
                        fileOutputStream.write(a);
                        fileInputStream.close();
                        fileOutputStream.close();
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
            System.out.println("备份成功！");
        }
    }
}
