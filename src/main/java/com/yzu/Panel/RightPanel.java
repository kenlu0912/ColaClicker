package com.yzu.Panel;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.awt.Image;
import java.awt.Font;
import java.math.*;
import java.util.TimerTask;
import java.util.Timer;

public class RightPanel extends JPanel {
    private MainPanel window;

    // An array to store the current item number
    public static int[] itemNumber = new int[10];

    // An array to initial the first item price
    // name: X, X, X, X, X, X, X, X, X, Joke
    private static int[] InitialItemPrice = {0, 15, 100, 500, 3000, 10000, 40000, 200000, 1666666, 10000000};
    
    public static final int[] ItemAutoClickValue = {0, 1, 5, 20, 100, 500, 3500, 8888, 123456, 500000};
    
    // formula: InitialPrice * (IncRate ^ itemAvailable) = "next" item price
    // private static double IncreaseRate = 1.15f;

    // An array to store the display item price
    public static String[] displayItemPrice = new String[10];
    public static BigInteger[] realItemPrice = new BigInteger[10];
    // An array to store the item cliked times
    public static int[] itemClickedTimes = new int[10];
    public static String[] itemName = {"",
                                      "Factory", 
                                      "Hen House", 
                                      "Bank", 
                                      "Mine", 
                                      "Temple", 
                                      "Shipment", 
                                      "Farm", 
                                      "Lab",
                                      "Nuclear Power Plant"};
    public static String[] itemDiscription = {"", 
                                              "<html>This is <b>Factory</b></html>", 
                                              "<html>This is <b>Hen House</b></html>", 
                                              "<html>This is <b>Bank</b></html>", 
                                              "<html>This is <b>Mine</b></html>", 
                                              "<html>This is <b>Temple</b></html>", 
                                              "<html>This is <b>Shipment</b></html>", 
                                              "<html>This is <b>Farm</b></html>", 
                                              "<html>This is <b>Lab</b></html>", 
                                              "<html>This is <b>Nuclear Power Plant</b></html>"};
    private final String[] imgPath = {"",
                                      "src/main/resources/img/factory.png",
                                      "src/main/resources/img/hen_house.png",
                                      "src/main/resources/img/bank.png",
                                      "src/main/resources/img/mine.png",
                                      "src/main/resources/img/temple.png",
                                      "src/main/resources/img/shipment.png",
                                      "src/main/resources/img/farm.png",
                                      "src/main/resources/img/lab.png",
                                      "src/main/resources/img/nuclear.png"};
    
                        
    // Add ten button and separate vertically equally
    static JButton[] buttons = new JButton[10];
    static boolean []currentfactor = {true, false, false, false};
    static int []factorList = {1, 10, 100, 1000};

    public RightPanel(MainPanel w) {
        this.window = w;
        
        // set area
        setSize(window.getWidth() - MainPanel.cp.getWidth() - (MainPanel.ins.left + MainPanel.ins.right), window.getHeight());

        // Get the range of panelRight
        int x = MainPanel.cp.getWidth();
        int width = getWidth();
        int height = getHeight();

        // Set the layout manager for panelRight to null
        setLayout(null);

        // Set the background color of panelRight
        setBackground(Color.GRAY);

        // Add a label at the top of the panelRight
        JLabel label = new JLabel();
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        label.setBounds(x, 0, width, height / 10 - 3);

        // Add four buttons into label
        JButton[] buttonsInLabel = new JButton[4];
        
        // which factor is selected
        
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
                    // Set the selected factor to true
                    if (k == j) {
                        currentfactor[k] = true;
                        buttonsInLabel[k].setForeground(Color.YELLOW);
                        
                        // Calculate the real price of each item and simplify the number to display
                        for(int m = 1; m < 10; m++){
                            realItemPrice[m] = calPrice(InitialItemPrice[m], itemNumber[m] + factorList[k] - 1).subtract(calPrice(InitialItemPrice[m], itemNumber[m] - 1));
                            displayItemPrice[m] = simplifyNumber(realItemPrice[m]);
                        }
                        // set the simplified number to the label
                        for(int m = 1; m < 10; m++){
                            JLabel labelInButton = (JLabel) buttons[m].getComponent(0);
                            labelInButton.setText(displayItemPrice[m] + ", " + String.valueOf(itemNumber[m]));
                        }
                    } else {
                        currentfactor[k] = false;
                        buttonsInLabel[k].setForeground(Color.BLACK);
                    }
                }
            });

            // Add hover effect
            buttonsInLabel[j].addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    buttonsInLabel[j].setForeground(Color.YELLOW);
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    for (int k = 0; k < buttonsInLabel.length; k++) {
                        if (currentfactor[k]) {
                            buttonsInLabel[k].setForeground(Color.YELLOW);
                        } else {
                            buttonsInLabel[k].setForeground(Color.BLACK);
                        
                        }
                    }
                }
            });
        }


        add(label);

        for (int i = 1; i < buttons.length; i++) {
            buttons[i] = new JButton(itemName[i]);
            // cancel the focus border
            buttons[i].setFocusPainted(false);
            buttons[i].setBorderPainted(false);

            // * the reference of two labels
            // * Set the layout manager for each button to BorderLayout
            // * Warning: the label word could be cut off because of the area divide is not accurately
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
                        .read(new File(imgPath[i]));
                // Scale the image to fit the button which width is 1/4 of the frame width
                img = img.getScaledInstance(width / 4, height / buttons.length - 3, Image.SCALE_SMOOTH);
                // Let image align to the left of the button
                buttons[i].setIcon(new ImageIcon(img));
                buttons[i].setHorizontalAlignment(SwingConstants.LEFT);
            } catch (IOException ex) {
                System.out.println("Image not found");
            }

            add(buttons[i]);

            // initial the price and number
            itemNumber[i] = 0;
            realItemPrice[i] = new BigInteger(Integer.toString(InitialItemPrice[i]));
            displayItemPrice[i] = simplifyNumber(realItemPrice[i]);
            l.setText(displayItemPrice[i] + ", " + itemNumber[i]);
        }

        // Add action listener to each button
        for (int i = 1; i < buttons.length; i++) {
            final int j = i;
            buttons[j].addActionListener((ActionEvent e) -> {
                int currentfactorInt = 0;
                for (int k = 0; k < currentfactor.length; k++) {
                    if (currentfactor[k]) {
                        currentfactorInt = factorList[k];
                    }
                }

                // if can't be purchased
                if(MainPanel.PlayerCola.compareTo(realItemPrice[j]) < 0)
                    return;

                // Add CenterPanel buy times for achievement
                CenterPanel.buyTime += currentfactorInt;

                // Subtract the colas you have by realItemPrice[j]
                MainPanel.PlayerCola = MainPanel.PlayerCola.subtract(realItemPrice[j]);
                
                // Add the item number by currentfactorInt
                itemNumber[j] += currentfactorInt;

                // Calculate and Set the next consumption
                realItemPrice[j] = calPrice(InitialItemPrice[j], itemNumber[j] + currentfactorInt - 1).subtract(calPrice(InitialItemPrice[j], itemNumber[j] - 1));

                // set the display itemPrice
                displayItemPrice[j] = simplifyNumber(realItemPrice[j]);

                // set JLabel text
                JLabel labelInButton = (JLabel) buttons[j].getComponent(0);
                labelInButton.setText(displayItemPrice[j] + ", " + String.valueOf(itemNumber[j]));

                // Update the points
                MainPanel.UpdatePoints();
                MainPanel.UpdateAutoValue();
            }); 

            // Add hover effect
            buttons[j].addMouseListener(new java.awt.event.MouseAdapter() {
                Color originalColor = buttons[j].getBackground();

                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    if (MainPanel.PlayerCola.compareTo(realItemPrice[j]) >= 0) {
                        buttons[j].setBackground(Color.YELLOW);
                        buttons[j].setOpaque(true);
                    }
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    buttons[j].setBackground(originalColor);
                    buttons[j].setOpaque(false);
                }
            });

            // Add ToolTipText, which is 200*100 pixels
            buttons[j].setToolTipText(itemDiscription[j]);
            UIManager.put("ToolTip.background", Color.ORANGE);
            UIManager.put("ToolTip.foreground", Color.BLACK);
            UIManager.put("ToolTip.font", new Font("Arial", Font.PLAIN, 14));
        }

        // compare with MainPanel.PlayerCola every 1 second
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                for (int i = 1; i < 10; i++) {
                    if (buttons[i].getBackground() == Color.YELLOW && MainPanel.PlayerCola.compareTo(realItemPrice[i]) >= 0)
                        continue;

                    if (MainPanel.PlayerCola.compareTo(realItemPrice[i]) >= 0){
                        buttons[i].setBackground(Color.GREEN);
                        buttons[i].setOpaque(true);
                        buttons[i].setEnabled(true);
                    } else {
                        buttons[i].setBackground(Color.GRAY);
                        buttons[i].setEnabled(false);
                    }
                }
            }
        };

        // Schedule the task to run every 1 second starting from the current time
        timer.schedule(task, new java.util.Date(), 10);
    }

    // x: initial price, y: amount of items
    static BigInteger calPrice(int x, int y){
        if(y < 0)
            return BigInteger.valueOf(0);

        return (
                    BigDecimal.valueOf(1.0 / 3).multiply(
                        BigDecimal.valueOf(-20).add(
                            BigDecimal.valueOf(20).pow(
                                -y, MathContext.DECIMAL64
                            ).multiply(
                                BigDecimal.valueOf(23).pow(1 + y, MathContext.DECIMAL64)
                            )
                        )
                    ).multiply(BigDecimal.valueOf(x))
                ).setScale(0, RoundingMode.HALF_UP).toBigInteger();
    }

    // x: initial price, y: amount of items
    static BigDecimal calPrice(float x, int y){
        if(y < 0)
            return BigDecimal.valueOf(0);

        return (
                    BigDecimal.valueOf(1.0 / 3).multiply(
                        BigDecimal.valueOf(-20).add(
                            BigDecimal.valueOf(20).pow(
                                -y, MathContext.DECIMAL64
                            ).multiply(
                                BigDecimal.valueOf(23).pow(1 + y, MathContext.DECIMAL64)
                            )
                        )
                    ).multiply(BigDecimal.valueOf(x))
                ).setScale(3, RoundingMode.HALF_UP);
    }

    public static String simplifyNumber(BigInteger b){
        String str = b.toString(), result = "";
        int len = str.length();
        int myUnits = (len - 1) / 3;
        int first = (len % 3 == 0)? 3: len % 3;

        if(myUnits < 1){
            result = str;
        }else if(myUnits < 2){
            result = str.substring(0, first) + "," + str.substring(first);
        }else if(myUnits < 5){
            result = str.substring(0, first) + "." + str.substring(first, first + 1) + MainPanel.units[myUnits];
        }else{
            myUnits -= 5;
            String firstUnit = (myUnits / 26 == 0)? "" : Character.toString('a' + myUnits / 26 - 1);
            String secondUnit = Character.toString('a' + myUnits % 26);
            result = str.substring(0, first) + "." + str.substring(first, first + 1) + firstUnit + secondUnit;
        }

        return result;
    }

    public static void buyAllItems() {
        for (int i = 1; i < buttons.length; i++) {
            int currentfactorInt = 0;
            for (int k = 0; k < currentfactor.length; k++) {
                if (currentfactor[k]) {
                    currentfactorInt = factorList[k];
                }
            }

            // Add the item number by currentfactorInt
            itemNumber[i] += 1;

            // set the display itemPrice
            displayItemPrice[i] = simplifyNumber(realItemPrice[i]);

            // set JLabel text
            JLabel labelInButton = (JLabel) buttons[i].getComponent(0);
            labelInButton.setText(displayItemPrice[i] + ", " + String.valueOf(itemNumber[i]));

            // Update the points
            MainPanel.UpdatePoints();
            MainPanel.UpdateAutoValue();
        }
    }
}