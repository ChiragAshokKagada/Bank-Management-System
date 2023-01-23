package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;


public class FastCash  extends JFrame implements ActionListener {

    JButton option1, option2, option3, option4, option5, option6, back ;

    String pinNo ;
    FastCash(String pinNumber){
        this.pinNo = pinNumber;
        setLayout(null);

        // Inserting Image in the panel
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        // Starting text for transactions
        JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(230,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("Rale way",Font.BOLD,16));
        image.add(text);

        // Creating different buttons for direct cash options........
        option1 = new JButton("Rs 100");
        option1.setBounds(170,415,150,30);
        option1.addActionListener(this);
        image.add(option1);

        option2 = new JButton("Rs 500");
        option2.setBounds(355,415,150,30);
        option2.addActionListener(this);
        image.add(option2);

        option3 = new JButton("Rs 1000");
        option3.setBounds(170,450,150,30);
        option3.addActionListener(this);
        image.add(option3);

        option4 = new JButton("Rs 2000");
        option4.setBounds(355,450,150,30);
        option4.addActionListener(this);
        image.add(option4);

        option5 = new JButton("Rs 5000");
        option5.setBounds(170,485,150,30);
        option5.addActionListener(this);
        image.add(option5);

        option6 = new JButton("Rs 10000");
        option6.setBounds(355,485,150,30);
        option6.addActionListener(this);
        image.add(option6);

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
        if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinNo).setVisible(true);
        } else{
            String amount =((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNo+"'");
                int balance = 0 ;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource() != back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('"+pinNo+"','"+date+"','Withdrawal','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs " + amount + " debited successfully!!" );
                setVisible(false);
                new Transactions(pinNo).setVisible(true);
            }catch (Exception ex){
                System.out.println("Exceptional error");
            }
        }
    }
    public static void main(String[] args) {
        new FastCash("");
    }
}
