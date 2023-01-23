package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class SignUpThree extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4 ;
    
    JCheckBox c1,c2,c3,c4,c5,c6,c7 ;

    JButton submit, cancel;

    String formNo;

    SignUpThree(String formNo){
        this.formNo = formNo ;

        setLayout(null);

        // Setting Form Name
        JLabel l1 = new JLabel("Page 3 : Account Details");
        l1.setFont(new Font("Rale way",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);

        // Selecting Account Type
        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Rale way",Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);

        // Radio Buttons
        r1 = new JRadioButton("Savings Account");
        r1.setFont(new Font("Rale way",Font.BOLD,16));
        r1.setBackground(Color.white);
        r1.setBounds(100,180,160,20);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Rale way",Font.BOLD,16));
        r2.setBackground(Color.white);
        r2.setBounds(350,180,220,20);
        add(r2);
        
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Rale way",Font.BOLD,16));
        r3.setBackground(Color.white);
        r3.setBounds(100,220,160,20);
        add(r3);
        
        
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Rale way",Font.BOLD,16));
        r4.setBackground(Color.white);
        r4.setBounds(350,220,240,20);
        add(r4);

        ButtonGroup groupAccount = new ButtonGroup();
        groupAccount.add(r1);
        groupAccount.add(r2);
        groupAccount.add(r3);
        groupAccount.add(r4);

        //-------------------------------------------------------------------//

        // Card Details
        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Rale way",Font.BOLD,22));
        card.setBounds(100,300,200,30);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-7895");
        number.setFont(new Font("Rale way",Font.BOLD,22));
        number.setBounds(330,300,270,30);
        add(number);

        JLabel cardDetails = new JLabel("Your 16 Digit Card Number");
        cardDetails.setFont(new Font("Rale way",Font.BOLD,12));
        cardDetails.setBounds(100,330,270,15);
        add(cardDetails);

        // ------------------------------------------------------------------//

        // Pin Details
        JLabel pin = new JLabel("PIN : ");
        pin.setFont(new Font("Rale way",Font.BOLD,22));
        pin.setBounds(100,370,200,30);
        add(pin);

        JLabel pinNumber = new JLabel("XXXX");
        pinNumber.setFont(new Font("Rale way",Font.BOLD,22));
        pinNumber.setBounds(330,370,300,30);
        add(pinNumber);

        JLabel pinDetails = new JLabel("Your 4 Digit Password");
        pinDetails.setFont(new Font("Rale way",Font.BOLD,12));
        pinDetails.setBounds(100,400,300,20);
        add(pinDetails);

        // --------------------------------------------------- //

        // Services Available
        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Rale way",Font.BOLD,22));
        services.setBounds(100,450,250,30);
        add(services);

        // Types of Services
        c1 = new JCheckBox("ATM Card");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Rale way",Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Rale way",Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Rale way",Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3);

        c4 = new JCheckBox("Email Alerts");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Rale way",Font.BOLD,16));
        c4.setBounds(350,550,200,30);
        add(c4);
        
        c5 = new JCheckBox("ChequeBook");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Rale way",Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);

        c6 = new JCheckBox("E-statement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Rale way",Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        add(c6);

        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Rale way",Font.BOLD,16));
        c7.setBounds(100,680,600,30);
        add(c7);

        // ------------------------------------------------------------------------ //

        // Creating Submit Button
        submit = new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Rale way",Font.BOLD,14));
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        add(submit);

        // Creating Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Rale way",Font.BOLD,14));
        cancel.setBounds(430,720,100,30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.white);

        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String accountType = null ;
            if(r1.isSelected()){
                accountType = "Savings Account";
            } else if (r2.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (r3.isSelected()) {
                accountType = "Current Account";
            } else if (r4.isSelected()) {
                accountType = "Recurring Deposit Account";
            }

            Random random = new Random();
            String cardNumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);

            String pinNumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String facility = "";
            if(c1.isSelected()){
                facility = facility + "ATM Card";
            } else if (c2.isSelected()) {
                facility = facility + " Internet Banking";
            } else if (c3.isSelected()) {
                facility = facility + " Mobile Banking";
            } else if (c4.isSelected()) {
                facility = facility + " Email & SMS Alerts";
            } else if (c5.isSelected()) {
                facility = facility + " Cheque Book";
            } else if (c6.isSelected()) {
                facility = facility + " E-Statement";
            }

            try{
               if(accountType.equals("")){
                   JOptionPane.showMessageDialog(null,"Account type field cannot be empty");
               }else{
                   Conn conn = new Conn();
                   String query1 = "insert into signupThree values('"+formNo+"','"+accountType+"','"+cardNumber+"','"+pinNumber+"','"+facility+"')";
                   String query2 = "insert into login values('"+formNo+"','"+cardNumber+"','"+pinNumber+"')";
                   conn.s.executeUpdate(query1);
                   conn.s.executeUpdate(query2);

                   JOptionPane.showMessageDialog(null,"Card Number : " + cardNumber + "\n" + "Pin : " + pinNumber);

                   setVisible(false);
                   new Deposit(pinNumber).setVisible(false);

               }
            }catch(Exception ex){
                System.out.println(ex);
            }
        }else if(ae.getSource() == cancel){
             setVisible(false);
             new Login().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new SignUpThree("");
    }
}
