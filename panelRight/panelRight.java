package panelRight;

import javax.swing.*;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;

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
            buttons[i] = new JButton("Button " + i);
            buttons[i].setMargin(new Insets(0, 0, 0, 0));
            buttons[i].setBounds(x, i * (height / buttons.length - 3), width, height / buttons.length - 3);
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