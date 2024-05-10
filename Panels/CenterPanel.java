package Panels;
import Panels.MainPanel;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.awt.Image;
import java.awt.Font;

public class CenterPanel extends JPanel {
    private MainPanel window;

    public CenterPanel(MainPanel w) {
        this.window = w;

        // set area
        setBounds(window.lp.getX() + window.lp.getWidth(), 0, window.getWidth() * 4 / 10, window.getHeight());
        setBackground(Color.GREEN);
    }
}