package Draw;

import javax.swing.*;
import java.awt.*;

public class DrawUI {
    public void showUI(){
        //窗口页面
        MFrame mf = new MFrame();
        mf.setSize(800, 600);
        mf.setTitle("画图");
        mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mf.setLocationRelativeTo(null);

        //面板对象
        //上面板
        JPanel northPanel = new JPanel();
        northPanel.setBackground(Color.LIGHT_GRAY);
        northPanel.setPreferredSize(new Dimension(0,40));
        mf.add(northPanel, BorderLayout.NORTH);
        //右面板
        JPanel eastPanel = new JPanel();
        eastPanel.setBackground(Color.LIGHT_GRAY);
        eastPanel.setPreferredSize(new Dimension(40, 0));
        mf.add(eastPanel, BorderLayout.EAST);
        //左面板
        JPanel westPanel = new JPanel();
        westPanel.setBackground(Color.LIGHT_GRAY);
        westPanel.setPreferredSize(new Dimension(60, 0));
        mf.add(westPanel, BorderLayout.WEST);

        //画图面板
        JPanel drawPanel = new JPanel();
        drawPanel.setBackground(Color.WHITE);
        mf.add(drawPanel, BorderLayout.CENTER);

        //添加图形按钮以及监听器
        GameMouse mouse = new GameMouse();
        String buttonName[] = {"曲线","直线", "矩形", "三角形", "任意图形"};
        for(int i = 0; i < buttonName.length; i ++){
            JButton btn = new JButton(buttonName[i]);
            btn.addActionListener(mouse);
            northPanel.add(btn);
        }

        //画笔粗细
        String pen[] = {"粗", "中", "细"};
        for(int i = 0; i < pen.length; i ++){
            JButton btn = new JButton(pen[i]);
            btn.setPreferredSize(new Dimension(50, 30));
            btn.addActionListener(mouse);
            westPanel.add(btn);
        }
        //添加颜色按钮以及监听器
        //JButton btnBlack = new JButton();   //蓝色
        Color drawColor[] = {Color.BLACK, Color.BLUE, Color.RED};
        for(int i = 0; i < drawColor.length; i ++){
            JButton btn = new JButton();
            btn.setBackground(drawColor[i]);
            btn.setPreferredSize(new Dimension(30, 30));
            btn.addActionListener(mouse);
            eastPanel.add(btn);
        }

        //橡皮擦
        JButton erase = new JButton("橡皮");
        erase.setBackground(Color.WHITE);
        erase.addActionListener(mouse);
        northPanel.add(erase);


        //显示
        mf.setVisible(true);

        //画笔
        Graphics g = drawPanel.getGraphics();

        mouse.setG(g);
        //鼠标监听器
        drawPanel.addMouseListener(mouse);

        //拖动
        drawPanel.addMouseMotionListener(mouse);
    }

    public static void main(String[] args){
        DrawUI draw = new DrawUI();
        draw.showUI();
    }
}
