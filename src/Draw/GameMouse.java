package Draw;

import LoginInterface.ButtonLinstener1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameMouse implements MouseListener, ActionListener , MouseMotionListener {
    private Graphics g;
    private int x1, y1, x2, y2, x3, y3;
   // private int startX, startY;  //用于任意图形绘制  开始位置
    private int clickX, clickY;
    private int choice;   //记录选择了哪个按钮  1直线  2矩形 3三角形 4任意图形 5曲线 6橡皮擦
    private String name;
    int count = 1;
    public static Shape[] shapeArr = new Shape[100010];
    private int idx_shapeArr = 0;
    private ClickLocation[] clickLocation = new ClickLocation[100010];
    private int idx_clickLocation = 0;


    public void setG(Graphics g){
        this.g = g;
    }

    //鼠标监听器
    public void mouseClicked(MouseEvent e) {
        // System.out.println(e.getClickCount());
//        if (count > 1){
//            clickX = e.getX();
//            clickY = e.getY();
//            if (e.getClickCount() == 2) {
//                clickDouble = true;
//            }
//        }
        if(choice == 3 && count == 2) {
            clickX = e.getX();
            clickY = e.getY();
            g.drawLine(x1, y1, clickX, clickY);
            g.drawLine(x2, y2, clickX, clickY);
            count = 1;  //恢复
            shapeArr[idx_shapeArr ++] = new Shape(x1, y1, x2, y2, clickX, clickY, "三角形");
        }
        if(choice == 4 && count > 1){
                clickX = e.getX();
                clickY = e.getY();

                if(e.getClickCount() == 2){   //双击退出
                    g.drawLine(x1, y1, clickX, clickY);
                    clickLocation[idx_clickLocation ++] = new ClickLocation(clickX, clickY);
                    shapeArr[idx_shapeArr ++] = new Shape(clickLocation, "任意图形");
                    count = 1;  //恢复
                    idx_clickLocation = 0;
                }else{
                    g.drawLine(x2, y2, clickX, clickY);
                    x2 = clickX; y2 = clickY;
                    clickLocation[idx_clickLocation ++] = new ClickLocation(clickX, clickY);
                }

        }
    }
    public void mousePressed(MouseEvent e){
        if(count == 1) {
            x1 = e.getX();
            y1 = e.getY();
        }
    }
    public void mouseReleased(MouseEvent e){

        if(choice == 1){
            x2 = e.getX();
            y2 = e.getY();
            g.drawLine(x1, y1, x2, y2);
            shapeArr[idx_shapeArr ++] = new Shape(x1, y1, x2, y2, "直线");
        }else if(choice == 2) {
            x2 = e.getX();
            y2 = e.getY();
            g.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
            shapeArr[idx_shapeArr ++] = new Shape(x1, y1, x2, y2, "矩形");
        }else if(choice == 3){
            if(count == 1) {
                x2 = e.getX();
                y2 = e.getY();
                g.drawLine(x1, y1, x2, y2);
                count++;
            }
        }else if(choice == 4){
            if(count == 1){
                x2 = e.getX();
                y2 = e.getY();
                g.drawLine(x1, y1, x2, y2);
                count ++;
                clickLocation[idx_clickLocation ++] = new ClickLocation(x1, y1);
                clickLocation[idx_clickLocation ++] = new ClickLocation(x2, y2);
            }
        }

    }
    public void mouseEntered(MouseEvent e){

    }
    public void mouseExited(MouseEvent e){

    }


    //动作监听器
    public void actionPerformed(ActionEvent e) {
        name = e.getActionCommand();
        if("".equals(name)){
            JButton btn = (JButton) e.getSource();
            Color c = btn.getBackground();
            g.setColor(c);
        }
        else{
            if (name.equals("直线")) {
                choice = 1;
                //System.out.println(choice);
            } else if (name.equals("矩形")) {
                choice = 2;
            } else if (name.equals("三角形")) {
                choice = 3;
            } else if (name.equals("任意图形")) {
                choice = 4;
            } else if(name.equals("曲线")) {
                choice = 5;
            }else if(name.equals("粗")){
                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(5));
            } else if (name.equals("中")) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(3));
            } else if(name.equals("细")){
                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(1));
            }else if(name.equals("橡皮")){
                choice = 6;
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //JButton btn = (JButton)e.getSource();
        Color c = g.getColor();

        if(choice == 1) {
            //x3 = e.getX();
            //y3 = e.getY();
            g.setColor(Color.WHITE);
            g.drawLine(x1, y1, x2, y2);
            //g.drawLine(x1, y1, x3, y3);
            g.setColor(c);
            x3 = e.getX();
            y3 = e.getY();
            g.drawLine(x1, y1, x3, y3);
            x2 = x3;
            y2 = y3;
        }
//       }else if(choice == 2) {
//            x2 = e.getX();
//            y2 = e.getY();
//            g.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
//        }

        if(choice == 5) {  //曲线
            x3 = e.getX();
            y3 = e.getY();
            g.drawLine(x1, y1, x3, y3);
            x1 = x3;
            y1 = y3;
        }else if(choice == 6){  //橡皮
            //设置大小
            Graphics2D g2 = (Graphics2D) g;
            Stroke startSize = g2.getStroke();   //保存原有画笔尺寸和颜色
            Color startColor = g2.getColor();
            g2.setStroke(new BasicStroke(15));
            g2.setColor(Color.WHITE);
            x3 = e.getX();
            y3 = e.getY();
            g.drawLine(x1, y1, x3, y3);
            x1 = x3;
            y1 = y3;

            g2.setStroke(startSize);   //还原最初尺寸和颜色
            g2.setColor(startColor);
        }
    }
    public void mouseMoved(MouseEvent e){

    }
}
