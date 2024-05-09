package panelRight;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.awt.Image;
import java.awt.Font;

public class panelRight extends JPanel {
    public panelRight(JFrame frame) {
        // Initialize bounds for panelRight
        int x = frame.getSize().width * 3 / 4;
        int y = 0;
        int width = frame.getSize().width / 4;
        int height = frame.getSize().height;
        setBounds(x, y, width, height);

        // Set the layout manager for panelRight to null
        setLayout(null);

        // Set the background color of panelRight
        setBackground(Color.BLUE);

        // Add ten button and separate vertically equally
        JButton[] buttons = new JButton[10];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("Item Name \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t 100");
            // Set font size
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 15));
            buttons[i].setMargin(new Insets(0, 0, 0, 0));
            buttons[i].setBounds(x, i * (height / buttons.length - 3), width, height / buttons.length - 3);

            try {
                Image img = ImageIO
                        .read(new File("/Users/ken/Documents/University/1122/Java/java_game_project/img/factory.png"));
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
        for (JButton button : buttons) {
            button.addActionListener((ActionEvent e) -> {
                System.out.println("Button " + button.getText() + " clicked");
            });
        }
    }
}