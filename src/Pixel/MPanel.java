package Pixel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

import static java.lang.Math.min;

//重绘
public class MPanel extends JPanel {

    public void paint(Graphics g){
        super.paint(g);

        //重绘

        BufferedImage bufferedImage = new BufferedImage(Image.HISTORY[0].length, Image.HISTORY.length, BufferedImage.TYPE_INT_RGB);
        for(int i = 0; i < Image.HISTORY.length; i ++){
            for(int j = 0; j < Image.HISTORY[0].length; j ++){
                int pixel = Image.HISTORY[i][j];

                    bufferedImage.setRGB(j, i, pixel);
                }
            }

            g.drawImage(bufferedImage, 90, 100, null);
        }
        
}