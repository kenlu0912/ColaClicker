package com.yzu.Panel;

import com.yzu.objects.Cola;
import javax.swing.*;
import java.awt.Color;

public class LeftPanel extends JPanel {
    private MainPanel window;

    public LeftPanel(MainPanel w) {
        this.window = w;

        // the magnification of area and set size
        float widthMag = 0.33f;
        setSize((int)(window.getWidth() * widthMag), window.getHeight());

        JPanel ColaPanel = new Cola(this);
        add(ColaPanel);
 
        setLayout(null);
        setBackground(Color.RED);
    }
}