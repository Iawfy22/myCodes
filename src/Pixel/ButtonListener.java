package Pixel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class ButtonListener implements ActionListener, MouseListener, ChangeListener {
    private String name;
    private Graphics g;
    private int[][] historyPixels = new int[900][900];
    //private File file = new File("C:\\Users\\张艺丰\\Pictures\\Saved Pictures\\狗和自行车和汽车.jpg");
    private int[][] Pixels = new int[900][900];
    private Image image = new Image();
    private File waterFile = new File("C:\\Users\\张艺丰\\Pictures\\Saved Pictures\\水印.jpg");
    private int[][] watermark = getImagePixel(waterFile);
    private Boolean hahaSwitch = false;
    private JSlider jSlider;

    public ButtonListener(){
        readImage("C:\\Users\\张艺丰\\Pictures\\Saved Pictures\\狗和自行车和汽车.jpg");
    }
    public void setG(Graphics g){
        this.g = g;
        image.setG(g);
    }
    public void setjSlider(JSlider jSlider){
        this.jSlider = jSlider;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        name = e.getActionCommand();
        //System.out.println("1");

        if(name.equals("原图")){
            image.drawImage();
        }else if(name.equals("马赛克")){
            image.mosaic();
        }else if(name.equals("油画")){
            image.oilPainting();
        }else if(name.equals("灰度")){
            image.gray();
        } else if(name.equals("右转90°")){
            image.right();
        }else if(name.equals("左转90°")){
            image.left();
        }else if(name.equals("浮雕")){
            image.relief();
        }else if(name.equals("打开")){
            JFileChooser jFileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "JPG & GIF Images", "jpg", "gif");
            jFileChooser.setFileFilter(filter);
            int returnVal = jFileChooser.showOpenDialog(null);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                //System.out.println("file = "+jFileChooser.getSelectedFile());
                readImage(jFileChooser.getSelectedFile().getPath());
            }

            //并且展示图片
            image.clearImage();  //先清除默认图片
            image.drawImage();
        }else if(name.equals("水印")){
            image.watermark(watermark);
        }else if(name.equals("哈哈镜")){
            hahaSwitch = true;
        }else if(name.equals("锐化")){
            image.CNN();
        }
    }

    public void readImage(String path){
        File file = new File(path);
        Pixels = getImagePixel(file);
        image.setImage(Pixels);
    }
    //获取像素点
    public int[][] getImagePixel(File file){
        BufferedImage bufferedImage = null;
        try{
            bufferedImage = ImageIO.read(file);
        }catch(Exception e){
            e.printStackTrace();
        }

        int w = bufferedImage.getWidth();
        int h = bufferedImage.getHeight();
        int[][] Pixels = new int[h][w];
        Color[][] colorArr = new Color[h][w];
        for(int i = 0; i < h; i ++){
            for(int j = 0 ; j < w; j ++){
                int pixel = bufferedImage.getRGB(j, i);
                Pixels[i][j] = pixel;
            }
        }

        historyPixels = Pixels;
        return Pixels;
    }

    public void mouseClicked(MouseEvent e){
        if(hahaSwitch){
            image.haha(e.getX(), e.getY());
            hahaSwitch = false;
        }
    }

    public void mousePressed(MouseEvent e){

    }
    public void mouseReleased(MouseEvent e){

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource().equals(this.jSlider)){
            System.out.println(jSlider.getValue());
        }
    }
}
