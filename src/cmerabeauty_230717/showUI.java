package cmerabeauty_230717;


import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class showUI extends JFrame {
    private String button[] = {"直线", "曲线", "矩形", "等腰三角形", "三角形", "任意多边形", "圆", "实心矩形", "实心圆", "橡皮擦"};
    private Color color[] = {Color.BLACK, Color.RED, Color.BLUE};
    private String menus[] = {"打开(O)", "保存(S)", "清空(C)", "撤回(Z)"};
    private Graphics g;

    public void addButton(Function function) {
        for (String s : button) {
            JButton btn = new JButton(s);
            this.add(btn);
            btn.addActionListener(function);
        }
    }

    public void addColor(Function function) {
        for (Color c : color) {
            JButton btn = new JButton();
            btn.setBackground(c);
            btn.setPreferredSize(new Dimension(30, 30));
            this.add(btn);
            btn.addActionListener(function);
        }
    }

    public void init() {
        this.setTitle("美颜相机");
        this.setSize(1000, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);

        Function function = new Function();

        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("菜单", true);
        jMenu.setPreferredSize(new Dimension(0, 35));
        jMenu.setPreferredSize(new Dimension(45, 38));
        jMenu.setFont(new Font("宋体", Font.BOLD, 16));
        for (String s : menus) {
            JMenuItem jMenuItem = new JMenuItem(s);
            if (s.equals("打开(O)")) {
                jMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
            } else if (s.equals("保存(S)")) {
                jMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
            } else if (s.equals("清空(C)")) {
                jMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
            } else if (s.equals("撤回(Z)")) {
                jMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
            }
            jMenu.add(jMenuItem);
            jMenuItem.addActionListener(function);
            jMenuItem.setFont(new Font("宋体", Font.PLAIN, 14));
        }
        jMenuBar.add(jMenu);
        this.setJMenuBar(jMenuBar);

        addButton(function);
        addColor(function);

        this.setVisible(true);

        g = this.getGraphics();
        function.setG(g);

        //添加鼠标监听
        this.addMouseListener(function);
        this.addMouseMotionListener(function);
    }
}
