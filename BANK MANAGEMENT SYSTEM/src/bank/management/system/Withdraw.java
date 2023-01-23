package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {
    JTextField amount;
    JButton  withdraw, back ;

    String pinNo;
    Withdraw(String pinNumber){
        this.pinNo = pinNumber;

        // Inserting Image in the panel
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        // Starting text for transactions
        JLabel text = new JLabel("Please enter the amount you want to withdraw");
        text.setBounds(170,300,400,20);
        text.setForeground(Color.white);
        text.setFont(new Font("Rale way",Font.BOLD,16));
        image.add(text);

        // TextField for entering amount
        amount = new JTextField();
        amount.setFont(new Font("Rale Way",Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        image.add(amount);

        // Creating button for Withdraw amount
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355,485,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        // Creating button for exiting
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
        if(ae.getSource() == withdraw){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter you want to deposit");
            }else{
                try {
                    Conn conn = new Conn();
                    String query = "insert into bank values('" + pinNo + "','" + date + "','Withdrawal','" + number + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + number + " withdraw successfully!!");
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
        new Withdraw("");
    }
}
