package Draw;

import java.awt.*;

public class Shape {
    private int x1, y1, x2, y2, x3, y3;
    private ClickLocation[] clickLocation = new ClickLocation[100010];
    private String name;

    //构造方法初始化
    public Shape(int x1, int y1, int x2, int y2, String name){  //直线
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.name = name;
    }
    public Shape (int x1, int y1, int x2, int y2, int x3, int y3, String name){  //三角形
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.name = name;
    }
    public Shape (ClickLocation[] clickLocation, String name) {
        this.clickLocation = clickLocation;
        this.name = name;
    }

    //重绘
    public void drawShape(Graphics g){
        switch(name){
            case "直线":
                g.drawLine(x1, y1, x2, y2);
                //System.out.println(x1 + "---" + y1);
                break;
            case "矩形":
                g.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
                break;
            case "三角形":
                g.drawLine(x1, y1, x2, y2);
                g.drawLine(x1, y1, x3, y3);
                g.drawLine(x3, y3, x2, y2);
                break;
            case "任意图形":
                for(int i = 1; i < clickLocation.length; i ++){
                    if(i == clickLocation.length - 1){   //最后一个点连向起始点
                        g.drawLine(clickLocation[0].getX(), clickLocation[0].getY(), clickLocation[i].getX(), clickLocation[i].getY());
                    }else{
                        g.drawLine(clickLocation[i].getX(), clickLocation[i].getY(), clickLocation[i - 1].getX(), clickLocation[i - 1].getY());
                    }
                }

        }
    }
}
