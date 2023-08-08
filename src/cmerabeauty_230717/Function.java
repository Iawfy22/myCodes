package cmerabeauty_230717;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class Function extends FunctionFather {
    private Graphics g;
    Color c;  //记录当前画笔颜色
    String name;  //按钮名称
    int x1, y1, x2, y2, x3, y3;  //坐标
    public void setG(Graphics g){
        this.g = g;
    }
    public void actionPerformed(ActionEvent e) {
       String btn_function = e.getActionCommand();
       if(btn_function.equals("")){  //改变颜色
           JButton btn = (JButton) e.getSource();
           c = btn.getBackground();
           g.setColor(c);
       }else{
           name = btn_function;
       }
    }

    public void mousePressed(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();
        if(name.equals("直线")){
            g.drawLine(x1, y1, x2, y2);
        }else if(name.equals("矩形")){
            g.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
        }else if(name.equals("圆")){
            g.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
        }else if(name.equals("等腰三角形")){
            g.drawLine(x1, y2, x2, y2);
            g.drawLine(x1, y2, (x1 + x2) / 2, y1);
            g.drawLine(x2, y2, (x1 + x2) / 2, y1);
        }else if(name.equals("橡皮擦")){
            Color cc = g.getColor();  //记录之前颜色
            g.setColor(new Button().getBackground());
            g.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
            g.setColor(cc);
        }else if(name.equals("实心矩形")){
            g.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
        }else if(name.equals("实心圆")){
            g.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
        }
    }
}
