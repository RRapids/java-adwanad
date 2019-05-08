package JFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class loginFrame extends JFrame {
    private Button cancel;
    private Button login;
    private Font font1;
    private JTextField admin;
    private JPasswordField password;

    public loginFrame() {
        init();
        shezhi();
        UpPanel();
        DownPanel();
        MidPanel();
        this.repaint();
    }

    private void init() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) { // 重写windowClosing(关闭窗体)这个方法
                System.exit(0); // 退出java虚拟机
            }
        });

        cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }

    private void DownPanel() {
        Panel one = new Panel();
        font1 = new Font("SansSerif", Font.BOLD, 15);
        login = new Button("登录");
        cancel = new Button("取消");
        login.setFont(font1);
        cancel.setFont(font1);
        login.setForeground(Color.BLUE);
        cancel.setForeground(Color.BLUE);
        one.add(login);
        one.add(cancel);
        this.add(one, BorderLayout.SOUTH);
    }

    public void UpPanel() {
        Panel up = new Panel(); // 创建上面的Pabel
        up.setSize(460, 220);
        up.setLocation(60, 200);
        up.setLayout(new GridLayout(3, 3, 3, 2));

        admin = new JTextField(10);
        password = new JPasswordField(10);

        JLabel label1 = new JLabel("用户名:");
        JLabel label2 = new JLabel("密码:");

        Button registered = new Button("注册账号");
        Button forgetPassword = new Button("找回密码");

        up.add(label1);
        up.add(admin);

        up.add(label2);
        up.add(password);

        up.add(registered);
        up.add(forgetPassword);

        label1.setForeground(Color.BLUE);
        label2.setForeground(Color.BLUE);

        this.add(up, BorderLayout.NORTH);
    }

    public void MidPanel() {
        Panel south = new Panel(); // 创建下边的Panel

        south.setLayout(new GridLayout(1, 2));

        Checkbox rememberPassword = new Checkbox("记住密码");
        Checkbox automaticlogon = new Checkbox("自动登录");

        south.add(rememberPassword);
        south.add(automaticlogon);

        this.add(south, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        loginFrame ss = new loginFrame(); // 构造方法
        ss.repaint();
    }

    private void shezhi() {
        this.setSize(350, 200); // 设置窗体大小
        this.setTitle("学生成绩管理系统"); // 设置窗体标题
        this.setResizable(true); // 设置是否可调整大小
        this.setLocation(400, 200);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setVisible(true); // 设置窗体是否可见
        this.repaint();
    }
}
