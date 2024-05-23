package com.yzu.objects;
import com.yzu.Panel.LeftPanel;
import com.yzu.Panel.MainPanel;
import com.yzu.Panel.RightPanel;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;

public class PointsText extends JPanel{
    private LeftPanel PointsWindow = null;
    private static JLabel upperText = null;
    private static JLabel lowerText = null;

    public PointsText(LeftPanel w) {
        PointsWindow = w;

        setLayout(null);
        setSize(PointsWindow.getWidth(), 130);
        setLocation(0, 30);
        setBackground(new Color(50, 50, 50, 50));

        float scale = 3f / 5f;

        upperText = new JLabel(RightPanel.simplifyNumber(MainPanel.PlayerCola));
        upperText.setSize(getWidth(), (int)(getHeight() * scale));
        upperText.setFont(new Font("Arial", Font.PLAIN, 40));
        upperText.setHorizontalAlignment(JLabel.CENTER);
        upperText.setVerticalAlignment(JLabel.CENTER);
        add(upperText);

        lowerText = new JLabel("Cola per second: " + RightPanel.simplifyNumber(MainPanel.AutoClickValue));
        lowerText.setLocation(getX(), (int)(getHeight() * scale));
        lowerText.setSize(getWidth(), (int)(getHeight() *  (1 - scale)));
        lowerText.setFont(new Font("Arial", Font.PLAIN, 20));
        lowerText.setHorizontalAlignment(JLabel.CENTER);
        lowerText.setVerticalAlignment(JLabel.CENTER);
        add(lowerText);

        // Problem solution: https://tips4java.wordpress.com/2009/05/31/backgrounds-with-transparency/
        // the overwrite transparent background problem can be solved by setOpaque(false) and paintComponent
        setOpaque(false); // background of parent will be painted first
        setVisible(true);
    }

    public static void UpdatePointsText(){
        Component parent = upperText.getParent();
        upperText.setText(RightPanel.simplifyNumber(MainPanel.PlayerCola));
    }

    public static void UpdateAutoPointsText(){
        lowerText.setText("Cola per second: " + RightPanel.simplifyNumber(MainPanel.AutoClickValue));
    }

    protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
}
