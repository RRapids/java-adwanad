package join;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class LoginFrame extends JFrame implements ActionListener {
    private JLabel accountLabel, passwordLabel;
    private JTextField accountField;
    private JPasswordField passwordField;
    private BgButton loginBtn, centerBtn;
    private int width;
    private int height;

    public LoginFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = screenSize.width;
        height = screenSize.height;
        init();
        setTitle("渐变色背景窗体");
        setSize(width, height);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void init() {
        setLayout(null);
        ShadePanel shadePanel = new ShadePanel();
        shadePanel.setLayout(null);
        shadePanel.setBounds(0, 0, width, height);
        ImgPanel imgPanel = new ImgPanel();
        imgPanel.setLayout(null);
        imgPanel.setImgPath("loginBg2.jpg");
        imgPanel.setBounds(700, 100, 500, 400);

        Font font = new Font("楷体", Font.PLAIN, 25);
        accountLabel = new JLabel("账号");
        accountLabel.setFont(font);
        accountLabel.setForeground(new Color(242, 242, 242));
        accountField = new JTextField();
        accountField.setFont(font);

        passwordLabel = new JLabel("密码");
        passwordLabel.setFont(font);
        passwordLabel.setForeground(new Color(242, 242, 242));
        passwordField = new JPasswordField();
        passwordField.setFont(font);

        loginBtn = new BgButton();
        loginBtn.setPreferredSize(new Dimension(80, 80));
        //不获取焦点
        loginBtn.setFocusPainted(false);
        loginBtn.setBgIcon("login.png");
        //背景透明
        loginBtn.setContentAreaFilled(false);
        //无边框
        loginBtn.setBorderPainted(false);
        loginBtn.addActionListener(this);
        loginBtn.setBounds(100, 300, 50, 35);

        centerBtn = new BgButton();
        centerBtn.setPreferredSize(new Dimension(80, 80));
        centerBtn.setFocusPainted(false);
        centerBtn.setBgIcon("center.png");
        centerBtn.setContentAreaFilled(false);
        centerBtn.setBorderPainted(false);
        centerBtn.addActionListener(this);
        centerBtn.setBounds(280, 300, 50, 35);

        accountLabel.setBounds(60, 150, 100, 35);
        accountField.setBounds(180, 150, 260, 35);
        passwordLabel.setBounds(60, 220, 100, 35);
        passwordField.setBounds(180, 220, 260, 35);

        imgPanel.add(accountLabel);
        imgPanel.add(accountField);
        imgPanel.add(passwordLabel);
        imgPanel.add(passwordField);
        imgPanel.add(loginBtn);
        imgPanel.add(centerBtn);

        shadePanel.add(imgPanel);
        add(shadePanel);
    }

    public static void main(String[] args) {
        new LoginFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "成功");
    }
}

/**
 * 继承JPanel的自定义面板，实现渐变背景色，paintComponent重绘组件
 */
class ShadePanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        //创建填充模式对象
        GradientPaint paint = new GradientPaint(0, 0, Color.cyan, 0, height, Color.PINK);
        g.setPaint(paint);
        g.fillRect(0, 0, width, height);
    }
}

/**
 * 继承JPanel的自定义面板，绘制背景图
 */
class ImgPanel extends JPanel {
    private String imgPath;

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    protected void paintComponent(Graphics g) {
        String basePath = System.getProperty("user.dir");
        Image bg = null;
        try {
            bg = ImageIO.read(new File(basePath + "/Multithreading/src/img/" + imgPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
}

class BgButton extends JButton {
    private String bgIcon;

    public void setBgIcon(String bgIcon) {
        this.bgIcon = bgIcon;
    }

    @Override
    protected void paintComponent(Graphics g) {
        String basePath = System.getProperty("user.dir");
        Image bg = null;
        try {
            bg = ImageIO.read(new File(basePath + "/Multithreading/src/img/" + bgIcon));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
}
