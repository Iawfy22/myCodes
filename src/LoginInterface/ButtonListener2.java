package LoginInterface;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ButtonListener2 implements ActionListener {
    //默认
    private String name = "zyf", pass = "123";
    private JTextField jtfUser, jtfPass;
    //构造方法
    public ButtonListener2(JTextField jtfU, JTextField jtfP){
        jtfUser = jtfU;
        jtfPass = jtfP;
    }

    public void actionPerformed(ActionEvent e){
        //获取账号和密码
        String userName = jtfUser.getText();
        String password = jtfPass.getText();

        //验证
        if(name.equals(userName) && pass.equals(password)){
            JFrame jfSuccess = new JFrame();
            jfSuccess.setSize(200, 100);
            jfSuccess.setLocationRelativeTo(null);
            //jfSuccess.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel jlSuccess = new JLabel("登录成功");
            jfSuccess.add(jlSuccess);
            jfSuccess.setVisible(true);
            //System.out.println("Yes");
        }else{
            JFrame jfFail = new JFrame();
            jfFail.setSize(200, 100);
            jfFail.setLocationRelativeTo(null);
            //jfFail.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel jlFail = new JLabel("账号或密码错误，请重新输入");
            jfFail.add(jlFail);
            jfFail.setVisible(true);
        }
    }
}
