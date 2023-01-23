package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignUpOne extends JFrame implements ActionListener{
    long random ;
    JTextField nameText , fatherNameText , emailText , addressText , cityText , stateText , pinText ;
    JButton next ;
    JRadioButton male , female , transgender , married , unmarried , other ;
    JDateChooser dateChooser ;

    SignUpOne(){
        setLayout(null);

        Random ran = new Random();
        random = Math.abs(ran.nextLong() % 9000L) + 1000L;

        // Application Number
        JLabel formNo = new JLabel("Application Form No : " + random );
        formNo.setFont(new Font("Rale way",Font.BOLD,38));
        formNo.setBounds(140,20,600,40);
        add(formNo);


        // Personal Details
        JLabel personalDetails = new JLabel("Page 1 : Personal Details");
        personalDetails.setFont(new Font("Rale way",Font.BOLD,22));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);

        // Name
        JLabel name = new JLabel("Name : ");
        name.setFont(new Font("Rale way",Font.BOLD,20));
        name.setBounds(100,140,200,30);
        add(name);

        // Creating TextField for Name
        nameText = new JTextField();
        nameText.setFont(new Font("Rale way",Font.BOLD,22));
        nameText.setBounds(300,140,400,30);
        add(nameText);

        // Father's Name
        JLabel fatherName = new JLabel("Father's Name : ");
        fatherName.setFont(new Font("Rale way",Font.BOLD,20));
        fatherName.setBounds(100,190,200,30);
        add(fatherName);

        // Creating TextField for Father's Name
        fatherNameText = new JTextField();
        fatherNameText.setFont(new Font("Rale way",Font.BOLD,22));
        fatherNameText.setBounds(300,190,400,30);
        add(fatherNameText);

        // Date of Birth
        JLabel dob = new JLabel("Date of Birth : ");
        dob.setFont(new Font("Rale way",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);

        // Created Calendar for date of birth
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setForeground(Color.gray);
        add(dateChooser);

        // Gender
        JLabel gender = new JLabel("Gender : ");
        gender.setFont(new Font("Rale way",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);

        // Created radio button for male gender
        male = new JRadioButton("Male ");
        male.setBackground(Color.white);
        male.setFont(new Font("Arial",Font.BOLD,15));
        male.setBounds(300,290,80,30);
        add(male);

        // Created radio button for female gender
        female = new JRadioButton("Female ");
        female.setBackground(Color.white);
        female.setFont(new Font("Arial",Font.BOLD,15));
        female.setBounds(400,290,100,30);
        add(female);

        // Created radio button for transgender
        transgender = new JRadioButton("Transgender ");
        transgender.setBackground(Color.white);
        transgender.setFont(new Font("Arial",Font.BOLD,15));
        transgender.setBounds(550,290,150,30);
        add(transgender);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(transgender);

        // Email Address
        JLabel email = new JLabel("Email Address : ");
        email.setFont(new Font("Rale way",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);
        
        // Creating TextField for email address
        emailText = new JTextField();
        emailText.setFont(new Font("Rale way",Font.BOLD,22));
        emailText.setBounds(300,340,400,30);
        add(emailText);

        // Marital Status
        JLabel marital = new JLabel("Marital Status : ");
        marital.setFont(new Font("Rale way",Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);

        // Created radio button for marital status
        married = new JRadioButton("Married ");
        married.setBackground(Color.white);
        married.setFont(new Font("Arial",Font.BOLD,15));
        married.setBounds(300,390,100,30);
        add(married);

        //---------------------------------------------------------//        
        unmarried = new JRadioButton("Unmarried ");
        unmarried.setBackground(Color.white);
        unmarried.setFont(new Font("Arial",Font.BOLD,15));
        unmarried.setBounds(450,390,120,30);
        add(unmarried);
        
        //----------------------------------------------------------//
        other = new JRadioButton("Other");
        other.setBackground(Color.white);
        other.setFont(new Font("Arial",Font.BOLD,15));
        other.setBounds(630,390,100,30);
        add(other);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);
        
        // Residential Address
        JLabel address = new JLabel("Address : ");
        address.setFont(new Font("Rale way",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);

        // Creating TextField for residential address
        addressText = new JTextField();
        addressText.setFont(new Font("Rale way",Font.BOLD,22));
        addressText.setBounds(300,440,400,30);
        add(addressText);

        // City
        JLabel city = new JLabel("City : ");
        city.setFont(new Font("Rale way",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);

        // Creating TextField for City
        cityText = new JTextField();
        cityText.setFont(new Font("Rale way",Font.BOLD,22));
        cityText.setBounds(300,490,400,30);
        add(cityText);
        
        // State
        JLabel state = new JLabel("State : ");
        state.setFont(new Font("Rale way",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);

        // Creating TextField for State
        stateText = new JTextField();
        stateText.setFont(new Font("Rale way",Font.BOLD,22));
        stateText.setBounds(300,540,400,30);
        add(stateText);
        
        // PinCode
        JLabel pinCode = new JLabel("Pin Code : ");
        pinCode.setFont(new Font("Rale way",Font.BOLD,20));
        pinCode.setBounds(100,590,200,30);
        add(pinCode);

        // Creating TextField for Pin Code
        pinText = new JTextField();
        pinText.setFont(new Font("Rale way",Font.BOLD,22));
        pinText.setBounds(300,590,400,30);
        add(pinText);
        
        /*  Country
        JLabel country = new JLabel("Country : ");
        country.setFont(new Font("Rale way",Font.BOLD,20));
        country.setBounds(100,640,200,30);
        add(country); */

        // Creating Next(Submit) Button
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setFont(new Font("Arial",Font.BOLD,14));
        next.setBounds(620,660,80,40);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae){
        String formNo = "" +  random ;  // long
        String name = nameText.getText(); // setText
        String fname = fatherNameText.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        } else if (transgender.isSelected()) {
            gender = "Transgender";
        }

        String email = emailText.getText();
        String marital = null ;
        if(married.isSelected()){
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        } else if (other.isSelected()) {
            marital = "Other";
        }

        String address = addressText.getText();
        String city = cityText.getText();
        String state = stateText.getText();
        String pinCode = pinText.getText();

        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null ,"Name is Required");
            }
            else{
                Conn c = new Conn();
                String query = "insert into signup values('"+formNo+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pinCode+"','"+state+"')";
                c.s.executeUpdate(query);

                // Creating signupTwo object
                new SignUpTwo("").setVisible(true);
                setVisible(false);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        new SignUpOne();
    }
}
