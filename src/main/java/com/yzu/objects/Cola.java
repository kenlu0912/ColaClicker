package com.yzu.objects;
import com.yzu.Panel.LeftPanel;

import java.io.File;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.RenderingHints;

public class Cola extends JPanel{
    private LeftPanel window;
    private BufferedImage ColaImg = null;
    private int ImgWidth = 0;
    private int ImgHeight = 0;
    private final float mag = 0.3f;

    public Cola(LeftPanel w) {
        this.window = w;
        //System.out.println(ColaImg.getWidth() + " " + ColaImg.getHeight());
        try {
            ColaImg = ImageIO.read(new File("java_game_project/src/main/resources/img/cola.png"));
            ImgWidth = (int)(ColaImg.getWidth() * mag);
            ImgHeight = (int)(ColaImg.getHeight() * mag);
        } catch (IOException ex) {
            System.out.println("Image not found");
        }
        
        setBounds(window.getWidth() / 2 - ImgWidth / 2, window.getHeight() / 2 - ImgHeight / 2, ImgWidth, ImgHeight);
        setBackground(null);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        if(ColaImg != null)
            g2d.drawImage(ColaImg, getSize().width / 2 - ImgWidth / 2, getSize().height / 2 - ImgHeight / 2, ImgWidth, ImgHeight, this);
    }
}
