package com.yzu.Panel;

import javax.swing.*;

import com.yzu.objects.PointsText;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Point;
import java.math.BigInteger;

class AchievePanel extends JPanel {
    AchievePanel() {
        super();
    }
}

public class CenterPanel extends JPanel {
    private final BigInteger achieveOne = new BigInteger("50000");
    public static int clickTime = 0;
    public static int buyTime = 0;

    private MainPanel window;
    private AchievePanel[] achievePanel;
    private JLabel[] TitleLabel = new JLabel[5];
    private JLabel[] EffectLabel = new JLabel[5];

    public static boolean[] achieve = {false, false, false, false, false};
    private String[] achieveStrings = {"",
                                       "Earn 50000 Cola",
                                       "Click 1000 Times",
                                       "Buy 10 Items",
                                       "Find the Pepsi"};
    private String[] effectsString = {"",
                                      "After earning 50000 Cola, you will get 10000 Cola!",
                                      "After clicking 1000 times, you can get 1000 Cola per second!",
                                      "After buying 10 items, you can get a free item!",
                                      "Great! You find the Pepsi! You can get 1000000 Cola!"};

    public CenterPanel(MainPanel w) {
        this.window = w;

        // the magnification of area and set size
        float widthMag = 0.75f;
        setSize((int)((window.getWidth()) * widthMag), window.getHeight());
        //setBounds(window.lp.getX() + window.lp.getWidth(), 0, window.getWidth() * 4 / 10, window.getHeight());
        setBackground(Color.GREEN);

        // Slice the panel into 5 parts
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        achievePanel = new AchievePanel[5];
        for (int i = 0; i < 5; i++) {
            achievePanel[i] = new AchievePanel();
            achievePanel[i].setLayout(null);
            achievePanel[i].setBounds(0, i * getHeight() / 5, getWidth(), getHeight() / 5);
            achievePanel[i].setBackground(Color.decode("#09c8f6"));

            if (i == 0) {
                TitleLabel[i] = new JLabel("<html><h1>Achievements</h1></html>", SwingConstants.CENTER);
                TitleLabel[i].setBounds(422, 50, 538, getHeight() / 5 - 120);
                // TitleLabel[i].set
                // TitleLabel[i].setFont(new Font("Arial", Font.PLAIN, 20));
                achievePanel[i].add(TitleLabel[i]);
            } else {
                TitleLabel[i] = new JLabel(achieveStrings[i]);
                // TitleLabel[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
                TitleLabel[i].setBounds(422, 0, 538, getHeight() / 5 - 120);
                TitleLabel[i].setFont(new Font("Arial", Font.PLAIN, 20));
                achievePanel[i].add(TitleLabel[i]);

                EffectLabel[i] = new JLabel("<html><p>" + effectsString[i] + "</p></html>");
                // EffectLabel[i].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));
                EffectLabel[i].setBounds(422 + 40, 0, 538, getHeight() / 5 - 20);
                EffectLabel[i].setFont(new Font("Arial", Font.PLAIN, 16));
                achievePanel[i].add(EffectLabel[i]);
            }

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
                        if (MainPanel.PlayerCola.compareTo(achieveOne) == 1 && !achieve[1]) {
                            System.out.println("PlayerCola: " + MainPanel.PlayerCola);
                            achieve[1] = true;
                            TitleLabel[1].setText("<html><s>" + achieveStrings[1] + "</s></html>");
                            EffectLabel[1].setText("<html><s>" + effectsString[1] + "</s></html>");

                            MainPanel.PlayerCola = MainPanel.PlayerCola.add(BigInteger.valueOf(10000));
                        }
                        if (clickTime >= 10 && !achieve[2]) {
                            achieve[2] = true;
                            TitleLabel[2].setText("<html><s>" + achieveStrings[2] + "</s></html>");
                            EffectLabel[2].setText("<html><s>" + effectsString[2] + "</s></html>");

                            MainPanel.AutoClickValue = MainPanel.AutoClickValue.add(BigInteger.valueOf(1000));
                            PointsText.UpdateAutoPointsText();
                        }
                        if (buyTime >= 10 && !achieve[3]) {
                            achieve[3] = true;
                            TitleLabel[3].setText("<html><s>" + achieveStrings[3] + "</s></html>");
                            EffectLabel[3].setText("<html><s>" + effectsString[3] + "</s></html>");

                            RightPanel.buyAllItems();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
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