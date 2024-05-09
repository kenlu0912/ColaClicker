package panelLeft;
import MainPanel.*;

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

        setBackground(Color.RED);

        try {
            Image img = ImageIO.read(new File("img/cola.png"));
            img = img.getScaledInstance(1, 1, Image.SCALE_SMOOTH);

        } catch (IOException ex) {
            System.out.println("Image not found");
        }
    }
}