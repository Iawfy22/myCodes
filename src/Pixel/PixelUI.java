package Pixel;

import javax.swing.*;
import java.awt.*;

public class PixelUI {
    public void showUI(){
        JFrame jf = new JFrame("图像处理");
        jf.setLayout(new FlowLayout());
        jf.setSize(800, 800);
        jf.setLocationRelativeTo(null);
        jf.getContentPane().setBackground(Color.white);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setLayout(new BorderLayout());

        ButtonListener btnlis = new ButtonListener();  //监听器

        //菜单栏
        JMenuBar jMenuBar = new JMenuBar();
        jMenuBar.setPreferredSize(new Dimension(0, 40));
        jf.add(jMenuBar, BorderLayout.NORTH);

        //菜单选项
        String[] menu = {"文件", "效果", "旋转"};

        //文件
        JMenu jMenu1 = new JMenu(menu[0]);
        jMenuBar.add(jMenu1);
        JMenuItem jMenuItem1 = new JMenuItem("打开");
        jMenuItem1.addActionListener(btnlis);
        jMenu1.add(jMenuItem1);
        JMenuItem jMenuItem2 = new JMenuItem("保存");
        jMenuItem2.addActionListener(btnlis);
        jMenu1.add(jMenuItem2);

        //效果
        JMenu jMenu2 = new JMenu("效果");
        jMenuBar.add(jMenu2);
        String[] name = {"原图", "马赛克", "油画", "灰度", "浮雕", "水印", "哈哈镜", "锐化"};
        for(int i = 0; i < name.length; i ++){
            JMenuItem jMenuItem = new JMenuItem(name[i]);
            jMenuItem.addActionListener(btnlis);
            jMenu2.add(jMenuItem);
        }

        //旋转
        JMenu jMenu3 = new JMenu("旋转");
        jMenuBar.add(jMenu3);
        String[] revolve = {"左转90°", "右转90°"};
        for(int i = 0; i < revolve.length; i ++){
            JMenuItem jMenuItem = new JMenuItem(revolve[i]);
            jMenuItem.addActionListener(btnlis);
            jMenu3.add(jMenuItem);
        }

        //画板
        MPanel drawPanel = new MPanel();
        drawPanel.setBackground(Color.WHITE);
        jf.add(drawPanel, BorderLayout.CENTER);
        drawPanel.addMouseListener(btnlis);

        //下面板实现缩放
        JPanel southPanel = new JPanel();
        jf.add(southPanel, BorderLayout.SOUTH);
        JLabel jLabel = new JLabel("缩放");
        southPanel.add(jLabel);
        JSlider js = new JSlider();  //滑动条
        js.setPreferredSize(new Dimension(300, 30));
        southPanel.add(js);
        js.addChangeListener(btnlis);
        btnlis.setjSlider(js);

        jf.setVisible(true);

        btnlis.setG(drawPanel.getGraphics()); //
    }

    public static void main(String[] args) {
        PixelUI pixel = new PixelUI();
        pixel.showUI();
    }
}
