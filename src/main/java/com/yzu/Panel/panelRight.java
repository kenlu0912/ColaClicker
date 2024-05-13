package com.yzu.Panel;

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

public class panelRight extends JPanel {
    private MainPanel window;

    public panelRight(MainPanel w) {
        this.window = w;

        // Initialize bounds for panelRight
        int x = window.getSize().width * 3 / 4;
        int y = 0;
        int width = window.getSize().width / 4;
        int height = window.getSize().height;
        setBounds(x, y, width, height);

        // Set the layout manager for panelRight to null
        setLayout(null);

        // Set the background color of panelRight
        setBackground(Color.BLUE);

        // Add ten button and separate vertically equally
        JButton[] buttons = new JButton[10];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("Item Name \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t 100");
            // cancel the focus border
            buttons[i].setFocusPainted(false);

            // * the reference of two labels
            // * Set the layout manager for each button to BorderLayout
            // * Warning: the label word could be cut off because of the area divide is not
            // accurately
            buttons[i].setLayout(new BorderLayout());
            JLabel l = new JLabel("XXXXXXXXX");
            // add label to the right of the button[i]
            buttons[i].add(l, BorderLayout.EAST);

            // Set font size
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 15));
            buttons[i].setMargin(new Insets(0, 0, 0, 0));
            buttons[i].setBounds(x, i * (height / buttons.length - 3), width, height / buttons.length - 3);

            try {
                Image img = ImageIO
                        .read(new File("java_game_project/src/main/resources/img/factory.png"));
                // Scale the image to fit the button which width is 1/4 of the frame width
                img = img.getScaledInstance(width / 4, height / buttons.length - 3, Image.SCALE_SMOOTH);
                // Let image align to the left of the button
                buttons[i].setIcon(new ImageIcon(img));
                buttons[i].setHorizontalAlignment(SwingConstants.LEFT);
            } catch (IOException ex) {
                System.out.println("Image not found");
            }

            add(buttons[i]);
        }

        // Add action listener to each button
        for (int i = 0; i < buttons.length; i++) {
            final int j = i;
            buttons[j].addActionListener((ActionEvent e) -> {
                System.out.println("Button " + j + " clicked");
            });
        }
    }
}