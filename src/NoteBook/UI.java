package NoteBook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class UI {
    public void showUI(){
        //主页面
        JFrame jf = new JFrame("记事本");
        jf.setSize(1000, 750);
        //jf.setResizable(false);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setLayout(new BorderLayout());

        //动作监听器
        ButtonListener btnlis = new ButtonListener();
        // 上页面
        JMenuBar jMenuBar = new JMenuBar();
        jMenuBar.setPreferredSize(new Dimension(0, 35));
        jf.add(jMenuBar, BorderLayout.NORTH);

        //文件栏
        JMenu jMenu1 = new JMenu("文件");
        jMenuBar.add(jMenu1);
        jMenu1.setPreferredSize(new Dimension(50, 30));
        JMenuItem jMenuItem1 = new JMenuItem("新建(N)");
        jMenu1.add(jMenuItem1);
        jMenuItem1.addActionListener(btnlis);
        jMenuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));  //设置快捷键
        JMenuItem jMenuItem2 = new JMenuItem("打开(O)");
        jMenu1.add(jMenuItem2);
        jMenuItem2.addActionListener(btnlis);
        jMenuItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        JMenuItem jMenuItem3 = new JMenuItem("保存(S)");
        jMenu1.add(jMenuItem3);
        jMenuItem3.addActionListener(btnlis);
        jMenuItem3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));

        //编辑
        JMenu jMenu2 = new JMenu("编辑");
        jMenuBar.add(jMenu2);
        jMenu2.setPreferredSize(new Dimension(50, 30));
        String[] edit = {"删除", "查找"};
        for(int i = 0; i < edit.length; i ++){
            JMenuItem jMenuItem = new JMenuItem(edit[i]);
            jMenuItem.addActionListener(btnlis);
            jMenu2.add(jMenuItem);
        }

        //格式
        JMenu jMenu3 = new JMenu("格式");
        jMenuBar.add(jMenu3);
        jMenu3.setPreferredSize(new Dimension(50, 30));

        JMenu jMenu3_1 = new JMenu("字体");
        String[] wordFormat = {"正常", "粗体", "斜体"};
        for(int i = 0; i < wordFormat.length; i ++){
            JMenuItem jMenuItem = new JMenuItem(wordFormat[i]);
            jMenuItem.addActionListener(btnlis);
            jMenu3_1.add(jMenuItem);
        }
        jMenu3.add(jMenu3_1);
        JMenu jMenu3_2 = new JMenu("大小");
        String[] wordSize = {"15号", "20号", "30号", "50号"};
        for(int i = 0; i < wordSize.length; i ++){
            JMenuItem jMenuItem = new JMenuItem(wordSize[i]);
            jMenuItem.addActionListener(btnlis);
            jMenu3_2.add(jMenuItem);
        }
        jMenu3.add(jMenu3_2);
//        JMenu jMenu3_3 = new JMenu("颜色");
//        String[] wordColor = {"红色", "蓝色", "黄色"};
//        for(int i = 0; i < wordColor.length; i ++){
//            JMenuItem jMenuItem = new JMenuItem(wordColor[i]);
//            jMenuItem.addActionListener(btnlis);
//            jMenu3_3.add(jMenuItem);
//        }
//        jMenu3.add(jMenu3_3);

        //主页面
        JTextArea jta = new JTextArea();
        JScrollPane jScrollPane = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //jta.add(jScrollPane);
        jta.setFont(new Font("宋体", Font.PLAIN, 20));
        jf.add(jta, BorderLayout.CENTER);


        jf.setVisible(true);

        //参数设置
        btnlis.setJta(jta);
        btnlis.setJf(jf);


    }


    public static void main(String[] args){
        UI showUI = new UI();
        showUI.showUI();
    }
}
