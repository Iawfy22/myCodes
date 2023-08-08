package Pixel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import static java.lang.Math.min;

public class Image {
    private int[][] Pixels;
    private int[][] historyPixels = new int[900][900];
    public static int[][] HISTORY = new int[900][900];  //记录重绘
    //public static String name = "";
    private Graphics g;
    private int[][] CK= {{-1, -1, -1}, {-1, 9, -1}, {-1, -1, -1}};

    public void setG(Graphics g){
        this.g = g;
    }
    public void setImage(int[][]Pixels){
        this.Pixels = Pixels;
        this.HISTORY = Pixels;
        historyPixels = Pixels;
    }

    public void drawImage(){

        clearImage();
        historyPixels = Pixels;
        HISTORY = Pixels;

        //缓冲区
        BufferedImage bufferedImage = new BufferedImage(Pixels[0].length, Pixels.length, BufferedImage.TYPE_INT_RGB);
        for(int i = 0; i < Pixels.length; i ++){
            for(int j = 0; j < Pixels[0].length; j ++){
                int pixel = Pixels[i][j];

                //Color c = new Color(pixel);
                //this.g.setColor(c);
                //this.g.fillRect(j + 15, i + 100, 1, 1);

                bufferedImage.setRGB(j, i, pixel);
            }
        }

        g.drawImage(bufferedImage, 90, 100, null);
    }
    public void drawImage(int[][] Pixels){

        clearImage(Pixels);
        //historyPixels = Pixels;
        HISTORY = Pixels;

        //缓冲区
        BufferedImage bufferedImage = new BufferedImage(Pixels[0].length, Pixels.length, BufferedImage.TYPE_INT_RGB);
        for(int i = 0; i < Pixels.length; i ++){
            for(int j = 0; j < Pixels[0].length; j ++){
                int pixel = Pixels[i][j];

                //Color c = new Color(pixel);
                //this.g.setColor(c);
                //this.g.fillRect(j + 15, i + 100, 1, 1);

                bufferedImage.setRGB(j, i, pixel);
            }
        }

        g.drawImage(bufferedImage, 90, 100, null);
    }

    public void clearImage(){

        int white = 16777215;

        BufferedImage bufferedImage = new BufferedImage(Pixels[0].length + 100, Pixels.length + 100, BufferedImage.TYPE_INT_RGB);
        for(int i = 0; i < Pixels.length + 100; i ++){
            for(int j = 0; j < Pixels[0].length + 100; j ++){

                //Color c = new Color(pixel);
                //this.g.setColor(c);
                //this.g.fillRect(j + 15, i + 100, 1, 1);

                bufferedImage.setRGB(j, i, white);
            }
        }

        g.drawImage(bufferedImage, 50, 50, null);
    }
    public void clearImage(int[][] Pixels){
        int white = 16777215;

        BufferedImage bufferedImage = new BufferedImage(Pixels[0].length + 100, Pixels.length + 100, BufferedImage.TYPE_INT_RGB);
        for(int i = 0; i < Pixels.length + 100; i ++){
            for(int j = 0; j < Pixels[0].length + 100; j ++){

                //Color c = new Color(pixel);
                //this.g.setColor(c);
                //this.g.fillRect(j + 15, i + 100, 1, 1);

                bufferedImage.setRGB(j, i, white);
            }
        }

        g.drawImage(bufferedImage, 50, 50, null);
    }

    //马赛克
    public void mosaic(){
        clearImage();

        for(int i = 0; i < Pixels.length; i += 5){
            for(int j = 0; j < Pixels[0].length; j += 5){
                int pixel = Pixels[i][j];
                Color c = new Color(pixel);
                g.setColor(c);
                g.fillRect(j + 90, i + 100, 5, 5);
            }
        }
    }

    //油画
    public void oilPainting(){
        clearImage();

        for(int i = 8; i < Pixels.length - 8; i += 2){
            for(int j = 8; j < Pixels[0].length - 8; j += 2){
                Random ran = new Random();
                int range = ran.nextInt(8);
                Color c = new Color(Pixels[i + range][j + range]);
                g.setColor(c);
                g.fillRect(j + 90, i + 100, 2, 2);
            }
        }
    }

    //灰度
    public void gray(){
        clearImage();

        for(int i = 0; i < Pixels.length; i ++){
            for(int j = 0; j < Pixels[0].length; j ++){
                int pixel = Pixels[i][j];
                int r = pixel >> 16 & 0xFF;
                int g = pixel >> 8 & 0xFF;
                int b = pixel & 0xFF;

                int mid = (r + g + b) / 3;  //平均值法求灰度

                Color c = new Color(mid, mid, mid);
                this.g.setColor(c);
                this.g.fillRect(j + 90, i + 100, 1, 1);
            }
        }
    }

    //浮雕
    public void relief(){
        int[][] newPixels = new int[Pixels.length][Pixels[0].length];

        int finalred=0;
        int finalblue=0;
        int finalgreen=0;

        Color[][] colors = new Color[Pixels.length][Pixels[0].length];
        int[][] red = new int[Pixels.length][Pixels[0].length];
        int[][] green = new int[Pixels.length][Pixels[0].length];
        int[][] blue = new int[Pixels.length][Pixels[0].length];

        for(int i=1;i<newPixels.length - 1;i++) {
            for(int j=1;j<newPixels[i].length - 1;j++) {

                colors[i-1][j-1] = new Color(Pixels[i-1][j-1]);
                colors[i-1][j] = new Color(Pixels[i-1][j]);
                colors[i-1][j+1] = new Color(Pixels[i-1][j+1]);
                colors[i][j-1] = new Color(Pixels[i][j-1]);
                colors[i][j] = new Color(Pixels[i][j]);
                colors[i][j+1] = new Color(Pixels[i][j+1]);
                colors[i+1][j-1] = new Color(Pixels[i+1][j-1]);
                colors[i+1][j] = new Color(Pixels[i+1][j]);
                colors[i+1][j+1] = new Color(Pixels[i+1][j+1]);


                for(int m=i-1;m<i+2;m++) {
                    for(int n = j-1;n<j+2;n++) {
                        red[m][n] = colors[m][n].getRed();
                        green[m][n] = colors[m][n].getGreen();
                        blue[m][n] = colors[m][n].getBlue();
                    }
                }

                //浮雕矩阵
                int [][] maxtrix= {{-1,-1,0},{-1,0,1},{0,1,1}};

                for(int k=i-1;k<i+2;k++) {
                    for(int l=j-1;l<j+2;l++) {
                        finalred+=red[k][l]*maxtrix[k-(i-1)][l-(j-1)];
                        finalblue+=red[k][l]*maxtrix[k-(i-1)][l-(j-1)];
                        finalgreen+=red[k][l]*maxtrix[k-(i-1)][l-(j-1)];
                    }
                }

                if(finalred<0) finalred=0;
                if(finalred>255) finalred=255;

                if(finalblue<0) finalblue=0;
                if(finalblue>255) finalblue=255;

                if(finalgreen<0) finalgreen=0;
                if(finalgreen>255) finalgreen=255;

                Color newcolor = new Color(finalred,finalgreen,finalblue);
                newPixels[i][j] = newcolor.getRGB();

            }
        }

        //画图
        BufferedImage bufferedImage = new BufferedImage(newPixels[0].length, newPixels.length, BufferedImage.TYPE_INT_RGB);
        for(int i = 0; i < newPixels.length; i ++){
            for(int j = 0; j < newPixels[0].length; j ++){
                int pixel = newPixels[i][j];

                bufferedImage.setRGB(j, i, pixel);
            }
        }

        g.drawImage(bufferedImage, 90, 100, null);

    }

    //右转
    public void right(){
        //先清除已有图片
        clearImage(historyPixels);

        int[][] newPixels = new int[historyPixels[0].length][historyPixels.length];
        //旋转矩阵
        for(int i = 0; i < historyPixels.length; i ++){
            for(int j = 0; j < historyPixels[0].length; j ++){
                newPixels[j][historyPixels.length - i - 1] = historyPixels[i][j];
            }
        }

        historyPixels = newPixels;

        drawImage(newPixels);
    }

    //左转
    public void left(){
        clearImage(historyPixels);

        int[][] newPixels = new int[historyPixels[0].length][historyPixels.length];
        //旋转矩阵
        for(int i = 0; i < historyPixels.length; i ++){
            for(int j = 0; j < historyPixels[0].length; j ++){
                newPixels[historyPixels[0].length - j - 1][i]= historyPixels[i][j];
            }
        }

        historyPixels = newPixels;
        drawImage(newPixels);
    }

    //水印
    public void watermark(int[][] watermark){
        int w = min(watermark[0].length, Pixels[0].length);
        int h = min(watermark.length, Pixels.length);
        int[][] newPixels = new int[h][w];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                Color color = new Color(watermark[i][j]);
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();

                Color colorN = new Color(Pixels[i][j]);
                int redN = colorN.getRed();
                int greenN = colorN.getGreen();
                int blueN = colorN.getBlue();
                //其中0.5为融合比例，视情况更改
                int redR = (int) (red*0.5+redN*0.5);
                int greenR = (int) (green*0.5+greenN*0.5);
                int blueR = (int) (blue*0.5+blueN*0.5);
                //bi.setRGB(i, j, new Color(redR,greenR,blueR).getRGB());
                newPixels[i][j] = ((0xFF << 24)|(redR << 16)|(greenR << 8)|blueR);
            }
        }

        drawImage(newPixels);
    }

    public void haha(int clickX, int clickY){
        BufferedImage bufferedImage = new BufferedImage(Pixels[0].length, Pixels.length, BufferedImage.TYPE_INT_RGB);

        clickX -= 90;
        clickY -= 100;

        int r = 50;  //范围

        for(int i = 0; i < historyPixels.length; i ++){
            for(int j = 0; j < historyPixels[i].length; j ++){
                int y = i - clickY;
                int x = j - clickX;
                int dis = (int)Math.sqrt(x * x + y * y);

                if(dis < r) {
                    int nx = x * dis / r + clickX;
                    int ny = y * dis / r + clickY;
                    bufferedImage.setRGB(j, i, historyPixels[ny][nx]);
                    historyPixels[i][j] = historyPixels[ny][nx];
                }else {
                    bufferedImage.setRGB(j, i, historyPixels[i][j]);
                }
            }
        }

        g.drawImage(bufferedImage, 90, 100, null);
    }

    public void CNN(){
        int[][] cnnArray = new int[Pixels.length - CK.length + 1][Pixels[0].length - CK[0].length + 1];

        for(int i = 0; i < Pixels.length - CK.length + 1; i ++){
            for(int j = 0; j < Pixels[i].length - CK[0].length + 1; j ++){
                int[][] temp = new int[CK.length][CK[0].length];

                for(int k = 0; k < CK.length; k ++){
                    for(int t = 0; t < CK[0].length; t ++){
                        temp[k][t] = Pixels[i + k][j + t] * CK[k][t];
                    }
                }

                int sum = 0;
                for(int k = 0; k < temp.length; k ++){
                    for(int t = 0; t < temp[0].length; t ++){
                        sum += temp[k][t];
                    }
                }

                if(sum < 0) sum = 0;
                if(sum > 255) sum = 255;

                cnnArray[i][j] = sum;
            }
        }

        drawImage(cnnArray);
    }
}
