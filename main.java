import javax.swing.*;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;

public class main {
   private static void createAndShowGUI() {
      // JFrame.setDefaultLookAndFeelDecorated(true);

      JFrame frame = new JFrame("The Game of Life");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      JLabel label = new JLabel("Hello World");
      frame.getContentPane().add(label);

      frame.setSize(1280, 720);
      frame.setLocationRelativeTo(null);

      JPanel panelLeft = new JPanel();
      JPanel panelCenter = new JPanel();
      JPanel panelRight = new JPanel();
      panelLeft.setBounds(0, 0, frame.getSize().width / 4, frame.getSize().height);
      panelCenter.setBounds(frame.getSize().width / 4, 0, frame.getSize().width / 2, frame.getSize().height);
      panelLeft.setBackground(Color.RED);
      panelCenter.setBackground(Color.GREEN);

      setPanelRight(frame, panelRight);

      frame.add(panelLeft);
      frame.add(panelCenter);
      frame.add(panelRight);

      frame.setResizable(false);
      frame.setVisible(true);
   }

   static void setPanelRight(JFrame frame, JPanel panelRight) {
      // Initialize bounds for panelRight
      int x = frame.getSize().width * 3 / 4;
      int y = 0;
      int width = frame.getSize().width / 4;
      int height = frame.getSize().height;
      panelRight.setBounds(x, y, width, height);

      // Set the layout manager for panelRight to null
      panelRight.setLayout(null);

      // Set the background color of panelRight
      panelRight.setBackground(Color.BLUE);

      // Add ten button and separate vertically equally
      JButton[] buttons = new JButton[10];
      for (int i = 0; i < buttons.length; i++) {
         buttons[i] = new JButton("Button " + i);
         buttons[i].setMargin(new Insets(0, 0, 0, 0));
         buttons[i].setBounds(x, i * (height / buttons.length - 3), width, height / buttons.length - 3);
         panelRight.add(buttons[i]);
      }

      // Add action listener to each button
      for (int i = 0; i < buttons.length; i++) {
         int j = i;
         buttons[i].addActionListener((ActionEvent e) -> {
            System.out.println("Button " + j + " is clicked");
         });
      }
   }

   public static void main(String[] args) {
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGUI();
         }
      });

   }
}
