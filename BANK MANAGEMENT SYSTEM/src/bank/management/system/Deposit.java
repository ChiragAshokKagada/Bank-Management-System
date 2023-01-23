package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    JTextField amount;
    JButton  deposit, back ;

    String pinNo;
    Deposit(String pinNumber){
        this.pinNo = pinNumber;

        // Inserting Image in the panel
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        // Starting text for transactions
        JLabel text = new JLabel("Please enter the amount you want to deposit");
        text.setBounds(170,300,400,20);
        text.setForeground(Color.white);
        text.setFont(new Font("Rale way",Font.BOLD,16));
        image.add(text);

        // TextField for entering amount
        amount = new JTextField();
        amount.setFont(new Font("Rale Way",Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        image.add(amount);

        // Creating button for Deposit
        deposit = new JButton("Deposit");
        deposit.setBounds(355,485,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        // Creating button for Deposit
        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);


        // -------------------------------------------------------------------------//


        // Properties of main panel
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
         if(ae.getSource() == deposit){
              String number = amount.getText();
              Date date = new Date();
              if(number.equals("")){
                  JOptionPane.showMessageDialog(null,"Please enter you want to deposit");
              }else{
                  try {
                      Conn conn = new Conn();
                      String query = "insert into bank values('" + pinNo + "','" + date + "','Deposit','" + number + "')";
                      conn.s.executeUpdate(query);
                      JOptionPane.showMessageDialog(null, "Rs " + number + " deposited successfully!!");
                      setVisible(false);
                      new Transactions(pinNo).setVisible(true);
                  }
                  catch(Exception ex){
                      System.out.println("Exceptional error");
                  }
              }
         }else if(ae.getSource() == back){
             setVisible(false);
             new Transactions(pinNo).setVisible(true);
         }
    }
    public static void main(String[] args){
        new Deposit("");
    }
}
