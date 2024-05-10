package Panels;
import Panels.*;

import javax.swing.*;
import java.awt.Color;

public class MainPanel extends JFrame{
   public static int totalPoints[] = new int[100]; // each element is in the range 0-999
   public static int totalPointsSize = 0; // save the points size
   public JPanel lp;
   public JPanel cp;
   public JPanel rp;

   private MainPanel() {
      // set JFrame title
      setTitle("The Game of Life");

      // set default close operation
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // set JFrame size and display it in the center of the screen
      setSize(1280, 720);
      setLocationRelativeTo(null);

      // define the three areas of the frame
      lp = new LeftPanel(this);
      cp = new CenterPanel(this);
      rp = new RightPanel(this);

      // add the three areas to the frame
      add(lp);
      add(cp);
      add(rp);

      // set the frame to fixed resizable and visible
      setResizable(false);
      setVisible(true);
   }


   public static void main(String[] args)  throws InterruptedException{
      MainPanel window = new MainPanel();
      System.out.println("ObjCount in panelLeft: " + window.lp.getComponentCount());
   }
}