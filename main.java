import javax.swing.*;
import java.awt.Color;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class main
{
   private static void createAndShowGUI() {
      JFrame.setDefaultLookAndFeelDecorated(true);

      JFrame frame = new JFrame("The Game of Life");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      //JLabel label = new JLabel("Hello World");
      //frame.getContentPane().add(label);

      frame.setSize(1280, 720);
      frame.setLocationRelativeTo(null);
      System.out.println();

      //在frame中，把frame分成直的三個區塊，分別為1/4, 1/2, 1/4, 且背景顏色設為紅色、綠色、藍色
      frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
      JPanel panel1 = new JPanel();
      panel1.setBackground(Color.RED);
      panel1.setMaximumSize(new java.awt.Dimension(frame.getSize().width / 20, frame.getSize().height));
      panel1.setMinimumSize(new java.awt.Dimension(frame.getSize().width / 40, frame.getSize().height));
      frame.add(panel1);
      //frame.add(Box.createVerticalStrut(1));
      JPanel panel2 = new JPanel();
      panel2.setBackground(Color.GREEN);
      panel2.setMaximumSize(new java.awt.Dimension(frame.getSize().width / 20, frame.getSize().height));
      panel2.setMinimumSize(new java.awt.Dimension(frame.getSize().width / 20, frame.getSize().height));
      frame.add(panel2);
      //frame.add(Box.createVerticalStrut(1));
      JPanel panel3 = new JPanel();
      panel3.setBackground(Color.BLUE);
      panel3.setMaximumSize(new java.awt.Dimension(frame.getSize().width / 20, frame.getSize().height));
      panel3.setMinimumSize(new java.awt.Dimension(frame.getSize().width / 40, frame.getSize().height));
      frame.add(panel3);

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
