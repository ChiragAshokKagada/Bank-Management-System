package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pinChange extends JFrame implements ActionListener {

    String pinNumber;
    JButton change, back ;
    JPasswordField pin, rePinTextField;

    pinChange(String pinNumber){
        this.pinNumber = pinNumber;

        // Inserting Image in the panel
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        // Starting text for transactions
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(250,300,500,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        //---------------------------------------------------------------------------------- //

        // Creating label for action
        JLabel pinText = new JLabel("NEW PIN:");
        pinText.setBounds(165,340,180,25);
        pinText.setForeground(Color.white);
        pinText.setFont(new Font("System",Font.BOLD,16));
        image.add(pinText);

        // Creating text field for entering new pin-number
        pin = new JPasswordField();
        pin.setFont(new Font("Rale way",Font.BOLD,25));
        pin.setBounds(330,340,180,25);
        image.add(pin);

        // Creating same re-entering pin-number option
        JLabel rePinText = new JLabel("RE-ENTER NEW PIN:");
        rePinText.setBounds(165,375,180,25);
        rePinText.setForeground(Color.white);
        rePinText.setFont(new Font("System",Font.BOLD,16));
        image.add(rePinText);

        // Creating text field for entering pin again for confirmation
        rePinTextField = new JPasswordField();
        rePinTextField.setFont(new Font("Rale way",Font.BOLD,25));
        rePinTextField.setBounds(330,375,180,25);
        image.add(rePinTextField);

        // -------------------------------------------------------------------------------- //

        // Creating button for changing the pin number
        change = new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);

        // Creating button for exiting the action
        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        // Properties of main panel
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == change) {
            try {
                String newPin = pin.getText();
                String rePin = rePinTextField.getText();
                if (!newPin.equals(rePin)) {
                    JOptionPane.showMessageDialog(null, "Entered pin does not match");
                    return;
                }
                if (rePin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter PIN");
                    return;
                }

                Conn conn = new Conn();
                String query1 = "update bank set pin = '" + rePin + "' where pin = '" + pinNumber + "'";
                String query2 = "update login set pinNumber = '" + rePin + "' where pinNumber = '" + pinNumber + "'";
                String query3 = "update signupthree set pinNumber = '" + rePin + "' where pinNumber = '" + pinNumber + "'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully!!");
                setVisible(false);
                new Transactions(rePin).setVisible(true);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new pinChange("").setVisible(true);
    }
}
