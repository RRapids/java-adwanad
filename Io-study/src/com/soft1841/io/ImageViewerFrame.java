package com.soft1841.io;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

/**
 * 使用卡片布局实现多图浏览功能
 */
public class ImageViewerFrame extends JFrame implements ActionListener {
    private JButton chooseBtn, preBtn, nextBtn,firstBtn,lastBtn;
    private JFileChooser jFileChooser;
    private JPanel centerPanel, bottomPanel;
    private CardLayout cardLayout;

    public ImageViewerFrame() {
        init();
        setTitle("ImageViewFrame");
        setSize(new Dimension(1500, 1000));
        //居中
        setLocationRelativeTo(null);
        //可见
        setVisible(true);
        //关闭
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void init() {
        bottomPanel = new JPanel();
        chooseBtn = new JButton("选择");
        preBtn = new JButton("前一张");
        nextBtn = new JButton("后一张");
        firstBtn = new JButton("第一张");
        lastBtn = new JButton("最后一张");
        bottomPanel.add(chooseBtn);
        bottomPanel.add(preBtn);
        bottomPanel.add(nextBtn);
        bottomPanel.add(firstBtn);
        bottomPanel.add(lastBtn);
        //添加监听
        chooseBtn.addActionListener(this);
        preBtn.addActionListener(this);
        nextBtn.addActionListener(this);
        firstBtn.addActionListener(this);
        lastBtn.addActionListener(this);

        //按钮加入底部
        add(bottomPanel, BorderLayout.SOUTH);

        //创建中间面板，
        centerPanel = new JPanel();
        cardLayout = new CardLayout();
        centerPanel.setLayout(cardLayout);
        centerPanel.setBackground(new Color(99, 89, 144));
        add(centerPanel);
    }

    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new ImageViewerFrame();
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
                                super.mouseClicked(e);
                            }
                        });
                        centerPanel.add(imgLabel);
                    } catch (IOException e1) {
                        System.out.println("IO异常");
                    }
                }
            }
        }
        if (e.getSource() == preBtn) {
            cardLayout.previous(centerPanel);
        }
        if (e.getSource() == nextBtn) {
            cardLayout.next(centerPanel);
        }
        if (e.getSource() == firstBtn) {
            cardLayout.first(centerPanel);
        }
        if (e.getSource() == lastBtn) {
            cardLayout.last(centerPanel);
        }

    }
}
