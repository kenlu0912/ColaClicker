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

public class RightPanel extends JPanel {
    private MainPanel window;

    // An array to store the current item number
    public static int[] itemNumber = new int[10];

    // An array to store the current item price
    public static int[] itemPrice = new int[10];

    public RightPanel(MainPanel w) {
        this.window = w;

        // set area
        int sizeAdjustment = 0;
        setSize(window.getWidth() - window.cp.getWidth() + sizeAdjustment, window.getHeight());

        // Get the range of panelRight
        int x = window.cp.getWidth();
        int width = getWidth();
        int height = getHeight();

        // Set the layout manager for panelRight to null
        setLayout(null);

        // Set the background color of panelRight
        setBackground(Color.BLUE);

        // Add a label at the top of the panelRight
        JLabel label = new JLabel();
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        label.setBounds(x, 0, width, height / 10 - 3);

        // Add four buttons into label
        JButton[] buttonsInLabel = new JButton[4];
        int []factorList = {1, 10, 100, 1000};
        boolean []currentfactor = {true, false, false, false};
        for (int i = 0; i < buttonsInLabel.length; i++) {
            // Change factorList[i] to a string
            buttonsInLabel[i] = new JButton(String.valueOf(factorList[i]));
            buttonsInLabel[i].setFocusPainted(false);
            buttonsInLabel[i].setBorderPainted(false);
            buttonsInLabel[i].setBounds(x + i * width / 4, 0, width / 4, height / 10 - 3);
            buttonsInLabel[i].setOpaque(false);
            buttonsInLabel[i].setContentAreaFilled(false);
            if (i == 0)
                buttonsInLabel[i].setForeground(Color.YELLOW);
            else
                buttonsInLabel[i].setForeground(Color.BLACK);
            add(buttonsInLabel[i]);
        }

        // If the button is clicked, the corresponding factor will be set to true
        // The false item's Transparency will be set to 0.5
        for (int i = 0; i < buttonsInLabel.length; i++) {
            final int j = i;
            buttonsInLabel[j].addActionListener((ActionEvent e) -> {
                for (int k = 0; k < buttonsInLabel.length; k++) {
                    if (k == j) {
                        currentfactor[k] = true;
                        buttonsInLabel[k].setForeground(Color.YELLOW);
                    } else {
                        currentfactor[k] = false;
                        buttonsInLabel[k].setForeground(Color.BLACK);
                    }
                    System.out.print(currentfactor[k] + " ");
                }
                System.out.println();
            });
        }


        add(label);

        // Add ten button and separate vertically equally
        JButton[] buttons = new JButton[10];
        for (int i = 1; i < buttons.length; i++) {
            buttons[i] = new JButton("Item Name");
            // cancel the focus border
            buttons[i].setFocusPainted(false);

            // * the reference of two labels
            // * Set the layout manager for each button to BorderLayout
            // * Warning: the label word could be cut off because of the area divide is not
            // accurately
            buttons[i].setLayout(new BorderLayout());
            JLabel l = new JLabel("0");
            // add label to the right of the button[i]
            buttons[i].add(l, BorderLayout.EAST);

            // Set font size
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 15));
            buttons[i].setMargin(new Insets(0, 0, 0, 0));
            buttons[i].setBounds(x, i * (height / buttons.length - 3), width, height / buttons.length - 3);

            try {
                Image img = ImageIO
                        .read(new File("src/main/resources/img/factory.png"));
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
        for (int i = 1; i < buttons.length; i++) {
            final int j = i;
            buttons[j].addActionListener((ActionEvent e) -> {
                // Increase the total points which is in MainPanel by 1 when the button is
                // clicked
                System.out.println(
                        "Button " + buttons[j].getText() + " clicked, id: " + j);

                int currentfactorInt = 0;
                for (int k = 0; k < currentfactor.length; k++) {
                    if (currentfactor[k]) {
                        currentfactorInt = factorList[k];
                    }
                }

                // Add the item number by currentfactorInt
                itemNumber[j] += currentfactorInt;

                // Random the array itemPrice
                itemPrice[j] = (int) (Math.random() * 100);

                // Update the JLabel text
                JLabel labelInButton = (JLabel) buttons[j].getComponent(0);

                labelInButton.setText(String.valueOf(currentfactorInt) + ", " + String.valueOf(itemPrice[j]) + ", " + String.valueOf(itemNumber[j]));
            });
        }
    }
}