package com.yzu.objects;
import com.yzu.Panel.LeftPanel;
import com.yzu.Panel.MainPanel;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;

public class PointsText extends JPanel{
    private LeftPanel PointsWindow = null;
    private static JLabel text = null;
    public static String TextStr = null;
    private static int firstNum;
    private static int secondNum;
    private static int unitSize;

    public PointsText(LeftPanel w) {
        PointsWindow = w;
        setBackground(null);
        setSize(PointsWindow.getWidth(), 130);
        setLocation(0, 15);
        setBackground(new Color(50, 50, 50, 50));
        setLayout(null);

        firstNum = MainPanel.totalPoints[MainPanel.totalPointsSize];
        secondNum = MainPanel.totalPoints[MainPanel.totalPointsSize - 1];
        unitSize = MainPanel.totalPointsSize;
        TextStr = Integer.toString(firstNum) + "." + Integer.toString(secondNum / 100);
        if(MainPanel.totalPointsSize <= 5)
            TextStr += MainPanel.units[MainPanel.totalPointsSize];
        else{
            String UnitsTemp = "";
            if((MainPanel.totalPointsSize - 5 - 1) / 26 > 0){
                UnitsTemp = Character.toString('a' + (((MainPanel.totalPointsSize - 5 - 1) / 26) - 1));
            }
            TextStr += UnitsTemp + Character.toString('a' + ((MainPanel.totalPointsSize - 5 - 1) % 26));
        }
        text = new JLabel(TextStr);
        text.setSize(getSize());
        text.setFont(new Font("Arial", Font.PLAIN, 40));
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setVerticalAlignment(JLabel.CENTER);
        add(text);
        
        setVisible(true);
    }

    public static void UpdatePoints(){
        firstNum = MainPanel.totalPoints[MainPanel.totalPointsSize];
        secondNum = MainPanel.totalPoints[MainPanel.totalPointsSize - 1];
        unitSize = MainPanel.totalPointsSize;

        TextStr = Integer.toString(firstNum) + "." + Integer.toString(secondNum / 100);

        if(unitSize <= 5)
            TextStr += MainPanel.units[unitSize];
        else{
            String UnitsTemp = "";
            if((unitSize - 5 - 1) / 26 > 0){
                UnitsTemp = Character.toString('a' + (((unitSize - 5 - 1) / 26) - 1));
            }
            TextStr += UnitsTemp + Character.toString('a' + ((unitSize - 5 - 1) % 26));
        }

        text.setText(TextStr);
    }
}
