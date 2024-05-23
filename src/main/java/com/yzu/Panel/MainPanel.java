package com.yzu.Panel;

import javax.swing.*;

import com.yzu.objects.PointsText;

import java.awt.BorderLayout;
import java.math.*;
import java.util.TimerTask;
import java.util.Timer;
import java.util.Date;

public class MainPanel extends JFrame {
    public static final String units[] = {"", "", "M", "G", "T"};
    public static BigInteger PlayerCola = new BigInteger("15000");
    public static BigInteger AutoClickValue = new BigInteger("0");
    public static JPanel lp;
    public static JPanel cp;
    public static JPanel rp;

    public MainPanel() {
        // set JFrame title
        setTitle("The Game of Life");
        // set layout
        setLayout(new BorderLayout());

        // set default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set JFrame size and display it in the center of the screen
        setSize(1280, 720);
        setLocationRelativeTo(null);

        // set the Point in saving File
        /*totalPoints[5] = 863;
        totalPoints[4] = 29;
        totalPointsSize = 5;*/

        // define the three areas of the frame
        lp = new LeftPanel(this);
        cp = new CenterPanel(this);
        rp = new RightPanel(this);

        // add the three areas to the frame
        add(lp);
        add(cp);
        add(rp);

        // create a timer
        Timer timer = new Timer();

        // create a task to be executed by the timer
        TimerTask task = new TimerTask() {
            public void run() {
                PlayerCola = PlayerCola.add(AutoClickValue);
                UpdatePoints();
            }
        };

        // Schedule the task to run every 0.05 seconds starting from the current time
        Date startTime = new Date();
        timer.schedule(task, startTime, 1000);

        // set the frame to fixed resizable and visible
        setResizable(true);
        setVisible(true);
    }

    public static void UpdateAutoValue() {
        AutoClickValue = BigInteger.ZERO;
        for(int i = 1; i < 10; i++) {
            AutoClickValue = AutoClickValue.add(
                                BigInteger.valueOf(RightPanel.ItemAutoClickValue[i]).multiply(
                                    BigInteger.valueOf(RightPanel.itemNumber[i])
                                )
                            );
        }

        PointsText.UpdateAutoPointsText();
    }

    public static void UpdatePoints() {
        PointsText.UpdatePointsText();
    }
}
