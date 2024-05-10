package com.yzu.Panel;

import com.yzu.Panel.MainPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.awt.Image;

public class panelLeft extends JPanel {
    private MainPanel window;

    public panelLeft(MainPanel w) {
        this.window = w;

        setLayout(null);
        setBackground(Color.RED);

        try {
            Image img = ImageIO.read(new File("src/main/resources/img/cola.png"));
            img = img.getScaledInstance(1, 1, Image.SCALE_SMOOTH);

        } catch (IOException ex) {
            System.out.println("Image not found");
        }

        JPanel panel = new JPanel();
        panel.setSize(100, 100);
        JButton button = new JButton("Button");
        JButton button2 = new JButton("Button2");
        panel.add(button);
        panel.add(button2);
        add(panel);
        System.out.println("ObjCount in panelLeft.panel: " + panel.getComponentCount());
    }
}