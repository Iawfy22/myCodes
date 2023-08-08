package Draw;

import javax.swing.*;
import java.awt.*;

public class MFrame extends JFrame {

    public void paint(Graphics g){
        //保留原方法
        super.paint(g);

        //恢复图像
        for(int i = 0; i < GameMouse.shapeArr.length; i ++){
            GameMouse.shapeArr[i].drawShape(g);
        }
    }
}
