package work;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class workFrame extends JFrame {
    private JLabel accountLabel, passwordLabel,shiLabel,loginLabel;
    private JTextField accountField;
    private JPasswordField passwordField;
    private int width;
    private int height;
    private JButton confirmBtn;
    private workFrame() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = screenSize.width;
        height = screenSize.height;
        init();
        setTitle("登录窗口");
        setSize(width, height);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void init() {
        setLayout(null);
        //面板
        ShadePanel2 shadePanel2 = new ShadePanel2();
        shadePanel2.setLayout(null);
        shadePanel2.setBounds(0, 0, width, height);
        shadePanel2.setBackground(new Color(245, 245, 245));
        ImagePanel imagePanel = new ImagePanel();
        imagePanel.setLayout(null);
        imagePanel.setBackground(new Color(255, 255, 255));
        imagePanel.setBounds(600, 200, 653, 510);
        //文字
        Font login = new Font("宋体",Font.BOLD,30);
        shiLabel = new JLabel("石灰文档");
        shiLabel.setBounds(50, 20, 150, 30);
        shiLabel.setFont(login);
        loginLabel = new JLabel("登录");
        loginLabel.setBounds(900,130,120,30);
        loginLabel.setFont(login);
        //账号
        Font font = new Font("宋体", Font.BOLD, 15);
        accountLabel = new JLabel("输入注册手机号或邮箱");
        accountLabel.setFont(font);
        accountLabel.setForeground(Color.GRAY);
        accountField = new JTextField();
        accountField.setFont(font);
        //密码
        passwordLabel = new JLabel("输入密码");
        passwordLabel.setFont(font);
        passwordLabel.setForeground(Color.GRAY);
        passwordField = new JPasswordField();
        //按钮
        confirmBtn = new JButton("立即登录");
        confirmBtn.setBackground(new Color(54, 59, 62));
        Font font1 = new Font("微软雅黑", Font.PLAIN, 20);
        confirmBtn.setForeground(Color.WHITE);
        confirmBtn.setFont(font1);
        //位置
        accountLabel.setBounds(150, 110, 300, 22);
        accountField.setBounds(150, 150, 400, 50);
        passwordLabel.setBounds(150, 220, 200, 22);
        passwordField.setBounds(150, 260, 400, 50);
        confirmBtn.setBounds(150,330,400,50);
        //加入面板
        imagePanel.add(accountLabel);
        imagePanel.add(accountField);
        imagePanel.add(passwordLabel);
        imagePanel.add(passwordField);
        imagePanel.add(confirmBtn);
        shadePanel2.add(imagePanel);
        shadePanel2.add(shiLabel);
        shadePanel2.add(loginLabel);
        add(shadePanel2);
        //按钮监听
        confirmBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String account = accountField.getText().trim();
                String password = String.valueOf(passwordField.getPassword());
                if ("1".equals(account) && "123".equals(password)) {
                    //关闭登录
                    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    //打开主体线程
                    FrameThread frameThread = new FrameThread();
                    new Thread(frameThread).start();
                }
            }
        });
    }

    public static void main(String[] args) {
        new workFrame();
    }

    //登陆窗体
    class ImagePanel extends JPanel {

    }
    //背景
    class ShadePanel2 extends JPanel {

    }
}

