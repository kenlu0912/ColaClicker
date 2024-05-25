package com.yzu.Panel;

import javax.swing.*;
import java.awt.Color;

public class CenterPanel extends JPanel {
    private MainPanel window;

    public CenterPanel(MainPanel w) {
        this.window = w;

        // the magnification of area and set size
        float widthMag = 0.75f;
        setSize((int)((window.getWidth()) * widthMag), window.getHeight());
        //setBounds(window.lp.getX() + window.lp.getWidth(), 0, window.getWidth() * 4 / 10, window.getHeight());
        setBackground(Color.GREEN);
    }
}