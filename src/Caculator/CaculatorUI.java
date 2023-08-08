package Caculator;

import LoginInterface.ButtonLinstener1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CaculatorUI {
    public void showUI(){
        JFrame jf = new JFrame("zyf的计算器");
        jf.setSize(370, 540);
        jf.setLocationRelativeTo(null);   //居中
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  //关闭

        //面板
        //下面板  运算按钮
        JPanel southPanel = new JPanel();
        southPanel.setBackground(Color.LIGHT_GRAY);
        southPanel.setPreferredSize(new Dimension(0, 380));
        jf.add(southPanel, BorderLayout.SOUTH);

        //上面版  选项——操作说明、历史记录
        JPanel northPanel = new JPanel();
        northPanel.setPreferredSize(new Dimension(0, 30));;
        northPanel.setBackground(Color.lightGray);
        northPanel.setLayout(new FlowLayout());
        jf.add(northPanel, BorderLayout.NORTH);

        //显示面板
        JPanel show = new JPanel();
        show.setBackground(Color.WHITE);
        jf.add(show, BorderLayout.CENTER);

        //细节添加
        //下面板添加按钮
        ButtonLinstener btnLinstener = new ButtonLinstener();
        String btns[] = {"%", "sin", "cos", "Del", "1/x", "sqrt", "x*x", "/", "7", "8", "9", "*", "4", "5", "6", "-", "1", "2", "3", "+", "C", "0", ".", "="};
        for(int i = 0; i < btns.length; i ++){
            JButton btn = new JButton(btns[i]);
            btn.setPreferredSize(new Dimension(80, 55));
            southPanel.add(btn);
            btn.addActionListener(btnLinstener);
        }

        //上面板  操作说明、历史记录
        String[] northDetails = {"说明", "历史"};
        for(int i = 0; i < northDetails.length; i ++){
            JButton btn = new JButton(northDetails[i]);
            btn.setPreferredSize(new Dimension(70, 27));
            northPanel.add(btn);
            btn.addActionListener(btnLinstener);
        }

        //显示面板添加文本框
        JTextField jtf = new JTextField();
        jtf.setPreferredSize(new Dimension(360, 110));
        jtf.setFont(new Font("", Font.BOLD, 40));
        jtf.setEditable(false);
        jtf.setHorizontalAlignment(JTextField.RIGHT);
        show.add(jtf);
        btnLinstener.setJtf(jtf);  //将文本框传进去，便于显示处理结果


        jf.setVisible(true);
    }
    public static void main(String[] args){
        CaculatorUI caculator = new CaculatorUI();
        caculator.showUI();
    }
}
