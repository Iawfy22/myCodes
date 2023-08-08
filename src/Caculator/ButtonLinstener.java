package Caculator;

import LoginInterface.ButtonLinstener1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonLinstener implements ActionListener {
    private String name;  //获取文本框上字符
    private JTextField jtf;
    private Key[] getKey = new Key[5];
    private int idx;  //记录Key下标
    private String number = " ";
    private String s = ""; //记录点过的所有东西
    private JTextArea history = new JTextArea();
    private String[] instructions = {"使用说明：",
            "=：获取答案",
            "(下述两类符号说明为按钮点击顺序)",
            "+、-、*、/、% ：数字 符号 数字 等号",
            "其他符号：数字 符号",
            "C 为清屏健    Del为删除键",
            "支持小数运算，且最后结果自动保留三位小数"};

    public void setJtf(JTextField jtf) {
        this.jtf = jtf;
    }

    public void actionPerformed(ActionEvent e) {
        name = e.getActionCommand();

        //实现对应操作
        if(name.equals("0") || name.equals("1") || name.equals("2") || name.equals("3") || name.equals("4") || name.equals("5") || name.equals("6") || name.equals("7")
           || name.equals("8") || name.equals("9")){
            number += name;
            s += name;
            jtf.setText(s);
        }else if(name.equals("+")){
            s += name;
            jtf.setText(s);
            getKey[idx ++] = new Key(number);
            number = "0";   //数字清空
            //System.out.println(number);
            getKey[idx ++] = new Key("+");
        }else if(name.equals("-")){
            s += name;
            jtf.setText(s);
            getKey[idx ++] = new Key(number);
            number = "0";   //数字清空
            getKey[idx ++] = new Key("-");
        }else if(name.equals("*")){
            s += name;
            jtf.setText(s);
            getKey[idx ++] = new Key(number);
            number = "0";   //数字清空
            getKey[idx ++] = new Key("*");
        }else if(name.equals("/")){
            s += name;
            jtf.setText(s);
            getKey[idx ++] = new Key(number);
            number = "0";   //数字清空
            getKey[idx ++] = new Key("/");
        }else if(name.equals("%")){
            s += name;
            jtf.setText(s);
            getKey[idx ++] = new Key(number);
            number = "0";   //数字清空
            getKey[idx ++] = new Key("%");
        } else if(name.equals("=")){
            getKey[idx] = new Key(number);
            //System.out.println(idx);
            if(getKey[1].getK().equals("+")){
                double num = getKey[0].getNum() + getKey[2].getNum();
                //System.out.printf("%lf  %lf", getKey[0].getNum(), getKey[2].getNum());
                String num_ = String.format("%.3f", num);  //默认保留三位小数
                jtf.setText(num_);
                history.append(s + "=" + num_ + "\n");
            }else if(getKey[1].getK().equals("-")){
                double num = getKey[0].getNum() - getKey[2].getNum();
                String num_ = String.format("%.3f", num);
                jtf.setText(num_);
                history.append(s + "=" + num_ + "\n");
            }else if(getKey[1].getK().equals("*")){
                double num = getKey[0].getNum() * getKey[2].getNum();
                String num_ = String.format("%.3f", num);
                jtf.setText(num_);
                history.append(s + "=" + num_ + "\n");
            }else if(getKey[1].getK().equals("/")){
                double num = getKey[0].getNum() / getKey[2].getNum();
                String num_ = String.format("%.3f", num);
                jtf.setText(num_);
                history.append(s + "=" + num_ + "\n");
            }else if(getKey[1].getK().equals("%")){
                double num = getKey[0].getNum() % getKey[2].getNum();
                String num_ = String.format("%.3f", num);
                jtf.setText(num_);
                history.append(s + "=" + num_ + "\n");
            }

            //还原操作
            s = "";
            number = "";
            idx = 0;
        }else if(name.equals("C")){   //清屏
            jtf.setText("");
        }else if(name.equals(".")){
            s += name;
            number += name;
            jtf.setText(s);
        }else if(name.equals("sqrt")){
            getKey[idx] = new Key(number);
            double num = getKey[0].getNum();
            num = Math.sqrt(num);
            String num_ = String.format("%.3f", num);
            jtf.setText(num_);
            history.append("sqrt" + s + "=" + num_ + "\n");
            //还原
            s = "";
            idx = 0;
            number = "";
        }else if(name.equals("sin")){
            getKey[idx] = new Key(number);
            double num = getKey[0].getNum();
            num = Math.sin(num);
            String num_ = String.format("%.3f", num);
            jtf.setText(num_);
            history.append("sin" + s + "=" + num_ + "\n");
            //还原
            s = "";
            idx = 0;
            number = "";
        }else if(name.equals("cos")){
            getKey[idx] = new Key(number);
            double num = getKey[0].getNum();
            num = Math.cos(num);
            String num_ = String.format("%.3f", num);
            jtf.setText(num_);
            history.append("cos" + s + "=" + num_ + "\n");
            //还原
            s = "";
            idx = 0;
            number = "";
        }else if(name.equals("1/x")){
            getKey[idx] = new Key(number);
            double num = 1 / getKey[0].getNum();
            String num_ = String.format("%.3f", num);
            jtf.setText(num_);
            history.append("1 / " + s + "=" + num_ + "\n");
            //还原
            s = "";
            idx = 0;
            number = "";
        }else if(name.equals("x*x")){
            getKey[idx] = new Key(number);
            double num = getKey[0].getNum() * getKey[0].getNum();
            String num_ = String.format("%.3f", num);
            jtf.setText(num_);
            history.append(s + "*" + s + "=" + num_ + "\n");
            //还原
            s = "";
            idx = 0;
            number = "";
        }else if(name.equals("Del")){
            if(idx % 2 == 0 && idx >= 0){   //删除数字
                number = number.substring(0, number.length() - 1);
                s = s.substring(0, s.length() - 1);
                jtf.setText(s);
            }else if(idx % 2 != 0 && idx > 0){   //删除符号
                //System.out.println(idx);
                //getKey[-- idx] = null;
                idx --;
                //System.out.println(idx);
                s = s.substring(0, s.length() - 1);
                jtf.setText(s);
            }
        }else if(name.equals("说明")){
            JFrame instruction = new JFrame("使用说明");
            instruction.setSize(300, 400);
            instruction.setLocationRelativeTo(null);
            instruction.setLayout(new FlowLayout());

            //添加文本说明
            for(int i = 0; i < instructions.length; i ++){
                JTextField jtf = new JTextField(instructions[i]);
                jtf.setPreferredSize(new Dimension(270, 45));
                jtf.setEditable(false);  //只读状态
                instruction.add(jtf);
            }


            instruction.setVisible(true);
        }else if(name.equals("历史")){
            JFrame jFrame = new JFrame("历史记录");
            jFrame.setResizable(false);
            jFrame.setLocationRelativeTo(null);
            jFrame.setSize(150, 300);
            jFrame.add(history);
            history.setEditable(false);

            jFrame.setVisible(true);
        }
    }
}
