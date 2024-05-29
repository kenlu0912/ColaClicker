package com.yzu.objects;
import com.yzu.Panel.CenterPanel;
import com.yzu.Panel.LeftPanel;
import com.yzu.Panel.MainPanel;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.event.*;

public class Cola extends JPanel{
    private LeftPanel ColaWindow;
    private BufferedImage ColaImg = null;
    private int ImgWidth = 0;
    private int ImgHeight = 0;
    private int g2dW = 0;
    private int g2dH = 0;
    private final float mag = 0.3f;

    public Cola(LeftPanel w) {
        this.ColaWindow = w;

        try {
            ColaImg = ImageIO.read(new File("src/main/resources/img/cola.png"));
            ImgWidth = g2dW = (int)(ColaImg.getWidth() * mag);
            ImgHeight = g2dH = (int)(ColaImg.getHeight() * mag);
        } catch (IOException ex) {
            System.out.println("Image not found");
        }

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                ZoomImg(95);
            }
       
            public void mouseClicked(MouseEvent e) {
                CenterPanel.clickTime++;
                MainPanel.PlayerCola = MainPanel.PlayerCola.add(BigInteger.ONE);
                PointsText.UpdatePointsText();
                ZoomImg(100);
            }
        });

        setBounds(ColaWindow.getWidth() / 2 - ImgWidth / 2, ColaWindow.getHeight() / 2 - ImgHeight / 2, ImgWidth, ImgHeight);
        setBackground(null);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if(ColaImg != null)
            g2d.drawImage(ColaImg, 0, 0, g2dW, g2dH, this);
    }

    private void ZoomImg(int zoomLevel) {
        //zoom in the picture
        g2dW = (int)(ImgWidth * (float)zoomLevel / 100);
        g2dH = (int)(ImgHeight * (float)zoomLevel / 100);
        setBounds(ColaWindow.getWidth() / 2 - g2dW / 2, ColaWindow.getHeight() / 2 - g2dH / 2, g2dW, g2dH);
    }
}
