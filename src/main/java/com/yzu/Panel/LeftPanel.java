package com.yzu.Panel;

import com.yzu.objects.Cola;
import com.yzu.objects.Pepsi;
import com.yzu.objects.PointsText;
import javax.swing.*;
import java.awt.Color;

public class LeftPanel extends JPanel {
    private MainPanel window;

    public LeftPanel(MainPanel w) {
        this.window = w;

        setLayout(null);
        
        // the magnification of area and set size
        float widthMag = 0.33f;
        setSize((int)((window.getWidth()) * widthMag), window.getHeight());

        JPanel ColaPanel = new Cola(this);
        add(ColaPanel);

        JPanel Points = new PointsText(this);
        add(Points);

        setBackground(Color.RED);

        JPanel pepsiPanel = new Pepsi(this);
        add(pepsiPanel);
    }
}