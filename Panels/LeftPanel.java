package Panels;
import Panels.MainPanel;

import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class LeftPanel extends JPanel {
    private MainPanel window;
    private BufferedImage ColaImg = null;

    public LeftPanel(MainPanel w) {
        this.window = w;

        setBounds(0, 0, window.getWidth() * 3 / 10, window.getHeight());
        setLayout(null);
        setBackground(Color.RED);

        setVisible(true);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        try {
            ColaImg = ImageIO.read(new File("img/cola.png"));
            g2d.drawImage(ColaImg, 20, 20, 100, 100, this);
        } catch (IOException ex) {
            System.out.println("Image not found");
        }
    }
}