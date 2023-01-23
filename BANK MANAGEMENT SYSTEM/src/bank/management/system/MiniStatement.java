package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener {

    String pinNumber ;
    MiniStatement(String pinNumber) {
        this.pinNumber = pinNumber ;

        setLayout(null);
        setTitle("Mini Statement");

        JLabel mini = new JLabel();
        mini.setBounds(20,120,400,200);
        add(mini);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        bank.setFont(new Font("Rale way",Font.BOLD,16));
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);


        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pinNumber = '"+pinNumber+"'");
            while(rs.next()){
                card.setText("Card Number " + rs.getString("cardNumber").substring(0,4) + "XXXXXXXX" + rs.getString("cardNumber").substring(12));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            Conn conn = new Conn();
            int balance1 = 0 ;
            ResultSet rs = conn.s.executeQuery("select * from bank where pin ='"+pinNumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                        + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    balance1 += Integer.parseInt(rs.getString("amount"));
                }else {
                    balance1 -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your current account balance is : " + balance1);
        }catch(Exception e){
            e.printStackTrace();
        }


        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
}

    public void actionPerformed(ActionEvent ae){

    }

    public static void main(String [] args){
        new MiniStatement("");
    }
}
