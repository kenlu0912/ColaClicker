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

public class Pepsi extends JPanel{
    private LeftPanel ColaWindow;
    private BufferedImage ColaImg = null;
    private int ImgWidth = 0;
    private int ImgHeight = 0;
    private int g2dW = 0;
    private int g2dH = 0;
    private final float mag = 0.1f;
    public static boolean clickedPepsi = false;

    public Pepsi() {}

    public Pepsi(LeftPanel w) {
        this.ColaWindow = w;

        try {
            ColaImg = ImageIO.read(new File("src/main/resources/img/pepsi.png"));
            ImgWidth = g2dW = (int)(ColaImg.getWidth() * mag);
            ImgHeight = g2dH = (int)(ColaImg.getHeight() * mag);
        } catch (IOException ex) {
            System.out.println("Image not found");
        }

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (clickedPepsi == false) {
                    MainPanel.PlayerCola = MainPanel.PlayerCola.add(new BigInteger("1000000"));
                    setBounds(0, 0, 0, 0);
                    MainPanel.UpdatePoints();
                    clickedPepsi = true;
                }
            }
        });

        setBounds(0, 600, ImgWidth, ImgHeight);
        setBackground(null);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if(ColaImg != null)
            g2d.drawImage(ColaImg, 0, 0, g2dW, g2dH, this);
    }

    static public boolean getClicked() {
        return clickedPepsi;
    }
}
