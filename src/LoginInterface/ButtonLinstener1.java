package LoginInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonLinstener1 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        ButtonLinstener1 enroll = new ButtonLinstener1();
        enroll.showEnroll();
    }

    public void showEnroll(){
        JFrame jfE = new JFrame();
        jfE.setSize(300,170 );
        jfE.setTitle("注册");
        jfE.setLocationRelativeTo(null);
        //布局管理
        FlowLayout f = new FlowLayout();
        jfE.setLayout(f);

        //信息
        JLabel jlName = new JLabel("设置用户名");
        JTextField jN = new JTextField();
        Dimension dN = new Dimension(200, 25);
        jN.setPreferredSize(dN);
        jfE.add(jlName);
        jfE.add(jN);

        JLabel jlPass = new JLabel("设置密码");
        JTextField jP = new JTextField();
        Dimension dP = new Dimension(200,25);
        jP.setPreferredSize(dP);
        jfE.add(jlPass);
        jfE.add(jP);

        JLabel jlPassAgain = new JLabel("确认密码");
        JTextField jPP = new JFormattedTextField();
        Dimension dPP = new Dimension(200, 25);
        jPP.setPreferredSize(dPP);
        jfE.add(jlPassAgain);
        jfE.add(jPP);

        //按钮
        JButton btn = new JButton("注册");
        jfE.add(btn);

        jfE.setVisible(true);
    }
}
