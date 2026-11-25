//Agate Fridmane, 251RDB071, 6.grupa, Swing

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class Main extends JFrame implements ActionListener {

    private JLabel label;
    private JTextField textField;
    private JButton btnOK, btnNewGame;

    private int tries = 0;
    private int randomNum;
    private Random rand = new Random();
  
    public Main() throws Exception {

        randomNum = rand.nextInt(10) + 1;

        setSize(300,300);
        GridLayout layout = new GridLayout(5, 1);
        JPanel p = new JPanel();
        p.setLayout(layout);
        p.setBorder(BorderFactory
                .createEmptyBorder(15, 15, 15, 15));
        p.add(new JLabel("Input number (1-10):"));
        textField = new JTextField();
        p.add(textField);
        label = new JLabel("You have 3 attempts to guess a number");
        p.add(label);
        JPanel btnPanel = new JPanel();
        btnOK = new JButton("OK");
        btnOK.addActionListener(this);
        btnPanel.add(btnOK);
        p.add(btnPanel);
        btnNewGame = new JButton("New Game");
        btnNewGame.addActionListener(this);
        btnPanel = new JPanel();
        btnPanel.add(btnNewGame);
        p.add(btnPanel);
        add(p,BorderLayout.CENTER);
        setTitle("Guess a number");



    }
  
    public static void main(String[] args)
            throws Exception {

        Main win = new Main();
        win.setDefaultCloseOperation(
                EXIT_ON_CLOSE);
        win.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent arg) {
//      int tries = 0;
//        Random rand = new Random();
//        int randomNum = rand.nextInt((10 - 1) + 1) + 1;
      if (arg.getSource() == btnOK) {
//          textField.setText("OK");
        String value = textField.getText();

            try{
                int sk = Integer.parseInt(value);
                if (tries < 2){
                    if (sk >= 1 && sk <= 10) {

                        if (sk == randomNum){
    //                        System.out.println("");
                            label.setText("You win!");
                            tries = 3;
                            textField.setText("");

                        }
                        else if (sk > randomNum){
    //                        System.out.println("my number is less than yours");
                            label.setText("my number is less than yours");
                            tries++;
                            textField.setText("");

                        }
                        else{
    //                        System.out.println("my number is greater than yours");
                            label.setText("my number is greater than yours");
                            tries++;
                            textField.setText("");

                        }
                    }
                    else{
                        label.setText("error");
                        textField.setText("");

                        return;
                    }
                }
                else{
                    label.setText("You lose!");
                    textField.setText("");

                }

            } catch(NumberFormatException e) {
//                System.out.println("Input is not a number");
                label.setText("error");
                textField.setText("");
            }

      }
      else {
//          textField.setText("NewGame");
          textField.setText("");
          label.setText("You have 3 attempts to guess a number");
          tries = 0;
          randomNum = rand.nextInt(10) + 1;



      }
        
    }
}
