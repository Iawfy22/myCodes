package LoginInterface;

import javax.swing.*;
import java.awt.*;

public class Login {

    //登录界面
    public void showUI(){
        //窗体
        JFrame jf = new JFrame();
        jf.setSize(400, 550);
        jf.setTitle("登录");
        //居中设置
        jf.setLocationRelativeTo(null);
        //关闭
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //布局管理（流式）
        FlowLayout flow = new FlowLayout();
        jf.setLayout(flow);

        //图片
        ImageIcon image = new ImageIcon("C:\\Users\\张艺丰\\Pictures\\Screenshots\\1.png");
        //标签
        JLabel jla = new JLabel(image);
        jf.add(jla);

        //用户提示
        //账号
        JLabel user = new JLabel("账号");
        jf.add(user);
        JTextField jtfUser = new JFormattedTextField();  //框
        Dimension dmUser = new Dimension(330,30);  //大小
        jtfUser.setPreferredSize(dmUser);
        jf.add(user);
        jf.add(jtfUser);
        //密码
        JLabel pass = new JLabel("密码");
        JTextField jtfPass = new JFormattedTextField();  //框
        Dimension dimPass = new Dimension(330, 30);
        jtfPass.setPreferredSize(dimPass);
        jf.add(pass);
        jf.add(jtfPass);

        //按钮
        JButton btn1 = new JButton("注册");
        jf.add(btn1);
        JButton btn2 = new JButton("登录");  //登录
        jf.add(btn2);

        //显示
        jf.setVisible(true);

        //添加监听器 -> 使按钮有反馈
        //注册
        ButtonLinstener1 btnLis1 = new ButtonLinstener1();
        btn1.addActionListener(btnLis1);
        //登录
        ButtonListener2 btnLis2 = new ButtonListener2(jtfUser, jtfPass);
        btn2.addActionListener(btnLis2);
    }

    public static void main(String[] args){
        Login lg = new Login();
        lg.showUI();
    }
}
