package MainPanel;
import panelRight.*;
import panelLeft.*;

import javax.swing.*;
import java.awt.Color;

public class MainPanel extends JFrame{
   public static int totalPoints[] = new int[100]; // each element is in the range 0-999
   public static int totalPointsSize = 0; // save the points size
   JPanel panelLeft;
   JPanel panelCenter;
   JPanel panelRight;

   private MainPanel() {
      // set JFrame title
      setTitle("The Game of Life");

      // set default close operation
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // set JFrame size and display it in the center of the screen
      setSize(1280, 720);
      setLocationRelativeTo(null);

      // define the three areas of the frame
      panelLeft = new panelLeft(this);
      panelCenter = new JPanel();
      panelRight = new panelRight(this);

      // set the bounds of the three areas
      panelLeft.setBounds(0, 0, getWidth() / 4, getHeight());
      panelCenter.setBounds(panelLeft.getX() + panelLeft.getWidth(), 0, getWidth() / 2, getHeight());
      panelRight.setBounds(panelCenter.getX() + panelCenter.getWidth(), 0, getWidth() / 4, getHeight());

      panelCenter.setBackground(Color.GREEN);

      // add the three areas to the frame
      add(panelLeft);
      add(panelCenter);
      add(panelRight);

      // set the frame to fixed resizable and visible
      setResizable(false);
      setVisible(true);
   }


   public static void main(String[] args)  throws InterruptedException{
      MainPanel window = new MainPanel();
      System.out.println("ObjCount in panelLeft: " + window.panelLeft.getComponentCount());
   }
}