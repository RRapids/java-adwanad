package Daka;

import javafx.scene.control.ComboBox;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    private  JLabel accountLabel ,passwordLabel ;
    private  JTextField accountField;
    private  JPasswordField passwordField;
    private  JButton comfirmButton ;
    private JButton cancelButton;
    private  JLabel bgLabel;
    public LoginFrame(){
        init();
        setTitle("登陆窗体");
        setSize(550,450);
        setLocationRelativeTo(null);
        //窗口大小不可变
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
    public  void init(){
        Font font = new Font("楷体",Font.PLAIN,20);
        accountLabel = new JLabel("账号");
        accountLabel.setFont(font);
        accountField = new JTextField();
        accountField.setFont(font);
        passwordLabel = new JLabel("密码");
        passwordLabel.setFont(font);
        passwordField = new JPasswordField();
        passwordField.setFont(font);
        cancelButton = new JButton("取消");
        comfirmButton = new JButton("登陆");
        JComboBox<String> comboBox = new JComboBox<String>();
        comboBox.addItem("教师");
        comboBox.addItem("学生");
        comboBox.addItem("管理员");

        comfirmButton.setFont(font);
        cancelButton.setFont(font);
        //窗口布局设为空布局，需要给每个组件定位
        setLayout(null);
        //setBounds 方法的四个参数分别为组件x、y坐标，组件宽高
        comboBox.setBounds(120,180,200,35);
        accountLabel.setBounds(50,60,100,35);
        accountField.setBounds(120,60,300,35);
        passwordLabel.setBounds(50,140,100,35);
        passwordField.setBounds(120,140,300,35);

        comfirmButton.setBounds(100,220,70,30);
        comfirmButton.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.green));
        cancelButton.setBounds(280,220,70,30);
        cancelButton.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.red));
        add(accountLabel);
        add(accountField);
        add(passwordLabel);
        add(passwordField);
        add(comfirmButton);
        add(cancelButton);
        add(comboBox);
        //背景
        bgLabel = new JLabel();
        Icon bgIcon = new ImageIcon(LoginFrame.class.getResource("/img/pic.jpg"));
        bgLabel.setIcon(bgIcon);
        bgLabel.setBounds(0,0,640,480);
        add(bgLabel);

    }

    public static void main(String[] args) {
        //用beautyeye样式
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        }catch (Exception e){
            e.printStackTrace();
        }
        new LoginFrame();

    }
}
