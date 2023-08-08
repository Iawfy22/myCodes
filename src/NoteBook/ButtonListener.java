package NoteBook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

    private String name;
    private JTextArea jta;
    private JFrame jf;

    public void setJta(JTextArea jta){
        this.jta = jta;
    }

    public void setJf(JFrame jf) {
        this.jf = jf;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        name = e.getActionCommand();
        Function function = new Function(jta, jf);


        if(name.equals("新建(N)"))
            function.NewText();
        else if(name.equals("打开(O)"))
            function.Open();
        else if(name.equals("保存(S)"))
            function.Save();
        else if(name.equals("删除"))
            function.Delete();
        else if(name.equals("查找"))
            function.Search();
        else if(name.equals("15号"))
            function.wordSize(15);
        else if(name.equals("20号"))
            function.wordSize(30);
        else if(name.equals("30号"))
            function.wordSize(50);
        else if(name.equals("50号"))
            function.wordSize(70);
        else if(name.equals("正常"))
            function.wordStyle(Font.PLAIN);
        else if(name.equals("粗体"))
            function.wordStyle(Font.BOLD);
        else if(name.equals("斜体"))
            function.wordStyle(Font.ITALIC);
//        else if(name.equals("红色"))
//            function.wordColor(Color.RED);
    }
}
