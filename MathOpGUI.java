/**
 *@author - Cameron Arakaki
 *MathOpGUI - recursion GUI class. This program takes user input and runs the data through a recursive method.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MathOpGUI extends JFrame {
   private final int HEIGHT = 350;
   private final int WIDTH = 500;
   
   // buttons
   private JButton bInstructions = new JButton("Instructions");
   private JButton bPower = new JButton("Enter");
   private JButton bFactorial = new JButton("Enter");
   private JButton bSummation = new JButton("Enter");
   private JButton bExit = new JButton("Exit");
   
   // labels
   private int answer = 0;
   private JLabel lTitle = new JLabel("Math OPS!", SwingConstants.CENTER);
   private JLabel lAuthor = new JLabel("by Cameron Arakaki", SwingConstants.CENTER);
   private JLabel lEmpty = new JLabel("", SwingConstants.CENTER);
   private JLabel lEmpty1 = new JLabel("                    ", SwingConstants.CENTER);
   private JLabel lAnswer = new JLabel("", SwingConstants.CENTER);
    
   // text field
   private TextField tf = new TextField(20);
   private TextField tf1 = new TextField(20);
   private TextField tf2 = new TextField(20);
   private TextField tf3 = new TextField(20);
   
   
    // constructor
   public MathOpGUI() { 
      this.setSize(WIDTH, HEIGHT);  
      this.setTitle("Math Operations");
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setVisible(false);
      this.setResizable(false);
   }
   
   public void initialize() {
      ActionListener listener = new EventHandler();
      
      // initialize buttons
      bInstructions.addActionListener(listener);
      bPower.addActionListener(listener);
      bFactorial.addActionListener(listener);
      bSummation.addActionListener(listener);
      bExit.addActionListener(listener);
         
      // main panel
      JPanel mPanel = new JPanel();
      mPanel.setLayout(new BorderLayout());
      
      // top panel
      JPanel tPanel = new JPanel();
      tPanel.setLayout(new GridLayout(1, 3));
      tPanel.setBorder(BorderFactory.createEmptyBorder(10,30,10,30));
      tPanel.add(bInstructions);
      tPanel.add(lTitle);
      tPanel.add(lAuthor);
      mPanel.add("North", tPanel);
      
      // center panel
      JPanel cPanel = new JPanel();
      cPanel.setLayout(new GridLayout(4, 1));
      JPanel cPanelBase = new JPanel();
      JPanel cPanelPow = new JPanel();
      JPanel cPanelFact = new JPanel();
      JPanel cPanelSum = new JPanel();
      cPanel.add(cPanelBase);
      cPanel.add(cPanelPow);
      cPanel.add(cPanelFact);
      cPanel.add(cPanelSum);         
      cPanelBase.add(new Label("Base:           "));
      cPanelBase.add(tf);
      cPanelBase.add(bPower);
      cPanelPow.add(new Label("Power:         "));
      cPanelPow.add(tf1);
      cPanelPow.add(lEmpty1);
      cPanelFact.add(new Label("Factorial:      "));
      cPanelFact.add(tf2);
      cPanelFact.add(bFactorial);
      cPanelSum.add(new Label("Summation: "));
      cPanelSum.add(tf3);
      cPanelSum.add(bSummation);
      mPanel.add("Center", cPanel);
      
      // bottom panel
      JPanel bPanel = new JPanel();
      bPanel.setLayout(new GridLayout(1, 3));
      bPanel.setBorder(BorderFactory.createEmptyBorder(10,30,10,30));
      bPanel.add(lEmpty);
      bPanel.add(lAnswer);
      bPanel.add(bExit);
      mPanel.add("South", bPanel);        
      
      this.add(mPanel);
   }
   
   private class EventHandler implements ActionListener {
      
      //power recursion method
      public int power(int b, int e) {
         if (e == 0) {
            return 1;
         }
         else {
            return (b *= power(b, e-1));
         }
      }
      
       // factorial recursion method
      public int factorial(int n) {
         if (n == 0) {
            return 1;
         }
         if (n == 1) {
            return 1;
         }            
         else {
            return (n *= factorial(n - 1));
         }
      }
      
       // summation recursion method
      public int summation(int n) {
         if (n == 0) {
            return 0;
         }
         else {
            return (n + summation(n - 1));
         }
      }
      
      public void actionPerformed(ActionEvent event) {
         try {
         // instructions event
            if (event.getSource() == bInstructions) {
               JOptionPane.showMessageDialog(new JFrame(),                                   
                               "Power --- Enter two integers, one for base, one for Power. Program will output the\n" +
                               "                 exponential value.\n\n" +
                               "Factorial --- Enter integer into Factorial box. Program will output the factorial.\n\n" +
                               "Summation --- Enter integer into Summation box. Program will output the summation.\n\n" +
                               "Press \"Exit\" to terminate program.",
                               "Instructions",
                                JOptionPane.INFORMATION_MESSAGE);                                                                         
            }
         
         // power button event
            if (event.getSource() == bPower) {
               if (Integer.parseInt(tf.getText()) >= 0 && Integer.parseInt(tf1.getText()) >= 0) {
                  int x = Integer.parseInt(tf.getText());
                  int y = Integer.parseInt(tf1.getText());
               
                  answer = power(x, y);
                  lAnswer.setText("Answer: " + answer);
               }
               else {
                  JOptionPane.showMessageDialog(new JFrame(),
                     "Data missing/Input error in text-field.\n" +
                     "Please enter an integer >= 0.",
                     "Incorrect Input",
                     JOptionPane.ERROR_MESSAGE);
               }
            }
         
         // power button event
            if (event.getSource() == bFactorial) {
               if (Integer.parseInt(tf2.getText()) >= 0) {
                  int x = Integer.parseInt(tf2.getText());
               
                  answer = factorial(x);
                  lAnswer.setText("Answer: " + answer);
               }
               else {
                  JOptionPane.showMessageDialog(new JFrame(),
                     "Data missing/Input error in text-field.\n" +
                     "Please enter an integer >= 0.",
                     "Incorrect Input",
                     JOptionPane.ERROR_MESSAGE);
               }
            }
         
         // power button event
            if (event.getSource() == bSummation) {
               if (Integer.parseInt(tf3.getText()) >= 0) {
                  int x = Integer.parseInt(tf3.getText());
               
                  answer = summation(x);
                  lAnswer.setText("Answer: " + answer); 
               }
               else {
                  JOptionPane.showMessageDialog(new JFrame(),
                     "Data missing/Input error in text-field.\n" +
                     "Please enter an integer >= 0.",
                     "Incorrect Input",
                     JOptionPane.ERROR_MESSAGE);
               }           
            }
         
         // exit event
            if (event.getSource() == bExit) {
               System.exit(0);
            }
         }
         catch(NumberFormatException NFE) {
            JOptionPane.showMessageDialog(new JFrame(),
               "Data missing/Input error in text-field.\n" +
               "Please enter an integer >= 0.",
               "Incorrect Input",
               JOptionPane.ERROR_MESSAGE);
         }            
      }
   }
}