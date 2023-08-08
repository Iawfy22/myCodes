package Test;

import javax.swing.*;
import java.util.Arrays;

public class Test {
    double bR, sR;
    static final double pi = Math.PI;
    int m = 10, n;

    public Test(){
        bR = 32.0;
        sR = 10.0;
    }
    public double per(double br, double sr){
        return 2 * pi * (br + sr);
    }
    public double area(double br, double sr){
        return pi * (br * br - sr * sr);
    }

    public static void main(String[] args){
        double[][] a = {{1, 2, 3}, {2, 3, 4, 5}};
        String s = Arrays.toString(a[0]);
        System.out.println(s);

        String ss = "abc";
        final String sss = "abc";

        Demo demo = new Demo();
        demo.a = 2;

        final int[] aa = {1, 2, 3, 4};
        float f = 123.41f;
        System.out.printf("%4.2f", f);

//        JFrame jf = new JFrame();
//        jf.setBounds(400, 400, 400, 400);
//        JButton jb = new JButton("香蕉");
//        jb.setSize(200, 200);
//        JScrollPane jp = new JScrollPane();
//        jp.add(jb);
//        jf.add(jp);
//        JLabel jl = new JLabel("zh");
//
//        jf.setVisible(true);
//        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Demo d = new ddd();
        System.out.println(" ");
        System.out.println(d.a);

        d.speak();
    }
}

class Demo{
    public int a = 1;
    public void speak(){
        System.out.println("父类");
    }
}

class ddd extends Demo{
    public int a = 2;
    public void speak(){
        System.out.println("子类");
    }
}
