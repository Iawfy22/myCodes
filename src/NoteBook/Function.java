package NoteBook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Function {
    private JTextArea jta;
    private JFrame jf;
    private Font f;

    public Function(){
    }

    public Function(JTextArea jtp, JFrame jf){
        this.jta = jtp;
        this.jf = jf;
        this.f = jtp.getFont();
    }

    public void setJta(JTextArea jta) {
        this.jta = jta;
    }
    public void setJf(JFrame jf){
        this.jf = jf;
    }

    //新建
    public void NewText(){
        jta.setText("");
    }

    //打开
    public void Open(){
        FileDialog fileDialog = new FileDialog(jf, "打开");
        fileDialog.setLocationRelativeTo(null);
        fileDialog.setVisible(true);

        //读取文件
        String name = fileDialog.getFile();
        String path = fileDialog.getDirectory();
        if(name == null || path == null) return ;  //点击取消
        File file = new File(path, name);
        //IO流
        BufferedReader l = null;
        try {
            l = new BufferedReader(new FileReader(file));
            String line = null;
            // 清空多行文本中的数据
            jta.setText("");
            while ((line = l.readLine()) != null) {
                jta.append(line + "\r\n");// 在文本最后增加换行符
            }
        } catch (IOException e1) {
            throw new RuntimeException();
        } finally {
            try {
                if (l != null)
                    l.close();
            } catch (IOException e1) {
                throw new RuntimeException();
            }
        }
    }

    //保存
    public void Save(){
        FileDialog fileDialog = new FileDialog(jf, "保存", FileDialog.SAVE);
        fileDialog.setLocationRelativeTo(null);
        fileDialog.setVisible(true);

        String name = fileDialog.getFile() + ".txt";
        String path = fileDialog.getDirectory();
        if(name == null || path == null) return ;  //点击取消

        File file = new File(path, name);
        PrintWriter l = null;
        try {
            l = new PrintWriter(new FileWriter(file), true);
            l.println(jta.getText());
        } catch (IOException e1) {
            throw new RuntimeException();
        } finally {
            if (l != null)
                l.close();
        }

    }

    //删除
    public void Delete(){
        jta.requestFocus();  //获取光标
        jta.replaceRange("", jta.getSelectionStart(), jta.getSelectionEnd());  //替换选取内容
    }

    //查找
    public void Search(){
        JDialog search = new JDialog(jf, "查找");
        search.setVisible(true);
        search.setLayout(new FlowLayout());
        search.setSize(new Dimension(300, 125));
        search.setLocationRelativeTo(null);

        JLabel jbl = new JLabel("请输入查找内容：");
        search.add(jbl);
        JTextField jtf = new JTextField();
        jtf.setPreferredSize(new Dimension(150, 30));
        search.add(jtf);
        JButton searchBtn = new JButton("查找");
        search.add(searchBtn);
        searchBtn.addActionListener(new ActionListener() {  //单独创建 实现具体功能
            @Override
            public void actionPerformed(ActionEvent e) {
                String findText = jtf.getText();  //查找的内容
                String text = jta.getText();  //当前文本内容
                int start = text.indexOf(findText);
                int end = start + findText.length();

                //int start = -1;
                if(start < 0){   //没找到
                    JDialog error = new JDialog(search, "错误");
                    error.setLocationRelativeTo(null);
                    error.setLayout(new FlowLayout());
                    error.setPreferredSize(new Dimension(100, 50));

                    JLabel errorLabel = new JLabel("不存在此内容");
                    error.add(errorLabel);

                    error.setVisible(true);
                }else{
                    jta.select(start, end);
                }
            }
        });

    }

    //更改字体
    //大小
    public void wordSize(int size){
        String name = f.getName();
        int style = f.getStyle();
        Font newFont = new Font(name, style, size);
        jta.setFont(newFont);
        f = newFont;
    }

    //字体
    public void wordStyle(int style){
        String name = f.getName();
        int size = f.getSize();
        Font newFont = new Font(name, style, size);
        jta.setFont(newFont);
        f = newFont;
    }

//    public void wordColor(Color color){
//        jta.setSelectionColor(color);
//    }
}
