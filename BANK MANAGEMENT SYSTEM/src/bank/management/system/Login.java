package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JLabel label1,label2,label3;
    JTextField textField1;
    JPasswordField passwordField2;
    JButton login,clear,signup;
    Login() {
        // Setting title for the application panel
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);

        // Setting an image in the panel
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        // Setting text beside the logo
        label1 = new JLabel("WELCOME TO ATM");
        label1.setFont(new Font("Arial", Font.BOLD, 38));
        label1.setBounds(200,40,450,40);
        add(label1);

        // Creating Text Field for the Card number
        label2 = new JLabel("Card No:");
        label2.setFont(new Font("Arial", Font.BOLD, 28));
        label2.setBounds(125,150,375,30);
        add(label2);

        textField1 = new JTextField(15);
        textField1.setBounds(300,150,230,30);
        textField1.setFont(new Font("Arial", Font.BOLD, 14));
        add(textField1);

        // Creating Text Field for the Pin_Number
        label3 = new JLabel("PIN:");
        label3.setFont(new Font("Arial", Font.BOLD, 28));
        label3.setBounds(125,220,375,30);
        add(label3);

        passwordField2 = new JPasswordField(15);
        passwordField2.setFont(new Font("Arial", Font.BOLD, 14));
        passwordField2.setBounds(300,220,230,30);
        add(passwordField2);

        login = new JButton("Sign in : ");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("Clear ");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("Sign up : ");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        // Setting background color white for the panel
        getContentPane().setBackground(Color.WHITE);

        // Setting size and location of the panel
        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            textField1.setText("");
            passwordField2.setText("");
        } else if (ae.getSource() == login){
             Conn conn = new Conn();
             String cardNumber = textField1.getText();
             String pinNumber = passwordField2.getText();
             String query = "select * from login where cardNumber = '"+cardNumber+"' and pinNumber = '"+pinNumber+"'";

             try{
                 ResultSet rs = conn.s.executeQuery(query);
                 if(rs.next()){
                     setVisible(false);
                     new Transactions(pinNumber).setVisible(true);
                 }else{
                     JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                 }
             }catch(Exception ex){
                 ex.printStackTrace();
            }
        } else if (ae.getSource() == signup) {
             setVisible(false);
             new SignUpOne().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}
