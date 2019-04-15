package main.MR;

import javax.swing.*;

public class ImageThread extends Thread {
    private JLabel imageLabel;
    public void setImageLabel(JLabel imageLabel){
        this.imageLabel = imageLabel;
    }
    @Override
    public void run() {
        String[] imgPath = {"1.jpg","2.jpg","3.jpg","4.jpg","5.jpg","6.jpg","7.jpg","8.jpg","9.jpg","10.jpg",
                "11.jpg","12.jpg","13.jpg","14.jpg","15.jpg"};
        while (true){
            for(int i = 0; i < imgPath.length; i++){
                Icon icon = new ImageIcon(GridLayoutFrame.class.getResource("/img/" + imgPath[i]));
                imageLabel.setIcon(icon);
                try {
                    Thread.sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                if (i == imgPath.length - 1){
                    i = 0;
                }
            }
        }
    }
}
