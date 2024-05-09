package MainPanel;
import panelRight.*;
import panelLeft.*;

import javax.swing.*;
import java.awt.Color;

public class MainPanel extends JFrame{
   public static int totalPoints[] = new int[100]; // each element is in the range 0-999
   public static int totalPointsSize = 0; // save the points size

   private MainPanel() {
      // JFrame.setDefaultLookAndFeelDecorated(true);

      setTitle("The Game of Life");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      setSize(1280, 720);
      setLocationRelativeTo(null);

      JPanel panelLeft = new panelLeft(this);
      JPanel panelCenter = new JPanel();
      JPanel panelRight = new panelRight(this);

      panelLeft.setBounds(0, 0, getWidth() / 4, getHeight());
      panelCenter.setBounds(panelLeft.getX() + panelLeft.getWidth(), 0, getWidth() / 2, getHeight());
      panelRight.setBounds(panelCenter.getX() + panelCenter.getWidth(), 0, getWidth() / 4, getHeight());
      
      panelCenter.setBackground(Color.GREEN);

      add(panelLeft);
      add(panelCenter);
      add(panelRight);

      setResizable(false);
      setVisible(true);
   }


   public static void main(String[] args)  throws InterruptedException{
      MainPanel window = new MainPanel();
   }
}