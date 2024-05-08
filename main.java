import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;

public class main
{
   private static void createAndShowGUI() {
      //JFrame.setDefaultLookAndFeelDecorated(true);

      JFrame frame = new JFrame("The Game of Life");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      JLabel label = new JLabel("Hello World");
      frame.getContentPane().add(label);

      frame.setSize(1280, 720);
      frame.setLocationRelativeTo(null);
      System.out.println();

      JPanel panelLeft = new JPanel();
      JPanel panelCenter = new JPanel();
      JPanel panelRight = new JPanel();
      panelLeft.setBounds(0, 0, frame.getSize().width / 4, frame.getSize().height);
      panelCenter.setBounds(frame.getSize().width / 4, 0, frame.getSize().width / 2, frame.getSize().height);
      panelRight.setBounds(frame.getSize().width * 3 / 4, 0, frame.getSize().width / 4, frame.getSize().height);
      panelLeft.setBackground(Color.RED);
      panelCenter.setBackground(Color.GREEN);
      panelRight.setBackground(Color.BLUE);
      frame.add(panelLeft);
      frame.add(panelCenter);
      frame.add(panelRight);

      frame.setResizable(false);
      frame.setVisible(true);
   }

   public static void main(String[] args)
   {
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
         public void run() {
               createAndShowGUI();
         }
      });
   }
}
