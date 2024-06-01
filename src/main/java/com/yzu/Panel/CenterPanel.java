package com.yzu.Panel;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.math.BigInteger;

class AchievePanel extends JPanel {
    AchievePanel() {
        super();
    }
}

public class CenterPanel extends JPanel {
    private final BigInteger achieveOne = new BigInteger("15001");
    public static int clickTime = 0;
    public static int buyTime = 0;

    private MainPanel window;
    private AchievePanel[] achievePanel;
    private JLabel[] TitleLabel = new JLabel[4];
    private JLabel[] EffectLabel = new JLabel[4];

    public static boolean[] achieve = {false, false, false, false};
    private Color[] colors = {Color.WHITE, Color.RED, Color.GREEN, Color.BLUE};
    private String[] achieveStrings = {"Earn 50000 Gallon Cola",
                                       "Click 1000 Times",
                                       "Buy 10 Items",
                                       "Find the Pepsi"};
    private String[] effectsString = {"After earning 50000 Gallon Cola, you will get 10000 Cola!",
                                      "After clicking 1000 times, you can get 1000 Gallon Cola per second!",
                                      "After buying 10 items, you can get a free item!",
                                      "Great! You find the Pepsi! You can get 1000000 Cola!"};

    public CenterPanel(MainPanel w) {
        this.window = w;

        // the magnification of area and set size
        float widthMag = 0.75f;
        setSize((int)((window.getWidth()) * widthMag), window.getHeight());
        //setBounds(window.lp.getX() + window.lp.getWidth(), 0, window.getWidth() * 4 / 10, window.getHeight());
        setBackground(Color.GREEN);

        // Slice the panel into 4 parts
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        achievePanel = new AchievePanel[4];
        for (int i = 0; i < 4; i++) {
            achievePanel[i] = new AchievePanel();
            achievePanel[i].setLayout(null);
            achievePanel[i].setBounds(0, i * getHeight() / 4, getWidth(), getHeight() / 4);
            achievePanel[i].setBackground(colors[i]);
        
            TitleLabel[i] = new JLabel(achieveStrings[i]);
            // TitleLabel[i].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));
            TitleLabel[i].setBounds(422, 0, 538, getHeight() / 4 - 120);
            TitleLabel[i].setFont(new Font("Arial", Font.PLAIN, 20));
            achievePanel[i].add(TitleLabel[i]);

            EffectLabel[i] = new JLabel(effectsString[i]);
            // EffectLabel[i].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));
            EffectLabel[i].setBounds(422 + 40, 0, 538, getHeight() / 4 - 20);
            EffectLabel[i].setFont(new Font("Arial", Font.PLAIN, 16));
            achievePanel[i].add(EffectLabel[i]);

            add(achievePanel[i]);

            // Check if the achievement is achieved every 1 second
            new Thread(new Runnable() {
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (MainPanel.PlayerCola.compareTo(achieveOne) == 1 && !achieve[0]) {
                            System.out.println("PlayerCola: " + MainPanel.PlayerCola);
                            achieve[0] = true;
                            TitleLabel[0].setForeground(Color.RED);
                            EffectLabel[0].setForeground(Color.RED);
                        }
                        if (clickTime >= 2 && !achieve[1]) {
                            achieve[1] = true;
                            TitleLabel[1].setForeground(Color.RED);
                            EffectLabel[1].setForeground(Color.RED);
                        }
                        if (buyTime >= 2 && !achieve[2]) {
                            achieve[2] = true;
                            TitleLabel[2].setForeground(Color.RED);
                            EffectLabel[2].setForeground(Color.RED);
                        }
                        // if (MainPanel.PlayerCola >= 1000000 && !achieve[3]) {
                        //     achieve[3] = true;
                        //     label.setForeground(Color.RED);
                        //     effect.setForeground(Color.RED);
                        // }
                    }
                }
            }).start();
        } 
    }
}