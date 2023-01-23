package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpTwo  extends JFrame implements ActionListener {

        JTextField  panText , aadhaarText ;
        JButton next ;
        JRadioButton existingYes , existingNo , seniorYes , seniorNo ;
        JComboBox religion , category , occupation , educational , income ;

        String formNo ;
        SignUpTwo(String formNo){
            setLayout(null);

            this.formNo = formNo ;
            setTitle("NEW ACCOUNT APPLICATION FORM - PAGE2");
            
            // Additional Details
            JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
            additionalDetails.setFont(new Font("Rale way",Font.BOLD,22));
            additionalDetails.setBounds(290,80,400,30);
            add(additionalDetails);


            // Religion
            JLabel religion1 = new JLabel("Religion : ");
            religion1.setFont(new Font("Rale way",Font.BOLD,20));
            religion1.setBounds(100,140,200,30);
            add(religion1);


            // Creating ComboBox for Religion
            String[] valReligion = {"Hindu","Christian","Muslim","Jain","Sikh","Others"};
            religion = new JComboBox(valReligion);
            religion.setBackground(Color.WHITE);
            religion.setBounds(300,140,400,30);
            add(religion);


            // Category
            JLabel category1 = new JLabel("Category : ");
            category1.setFont(new Font("Rale way",Font.BOLD,20));
            category1.setBounds(100,190,200,30);
            add(category1);


            // Creating ComboBox for category
            String[] valCategory = {"General","OBC","SC","ST","Other"};
            category = new JComboBox(valCategory);
            category.setBounds(300,190,400,30);
            category.setBackground(Color.white);
            add(category);


            // Income
            JLabel income1 = new JLabel("Income : ");
            income1.setFont(new Font("Rale way",Font.BOLD,20));
            income1.setBounds(100,240,200,30);
            add(income1);


            // Creating ComboBox for income
            String[] valIncome = {"Null"," < 1,50,000"," < 2,50,000 "," > 5,00,000 "," > 10,00,000 "};
            income = new JComboBox(valIncome);
            income.setBounds(300,240,400,30);
            income.setBackground(Color.white);
            add(income);


            // Educational Qualification
            JLabel educational1 = new JLabel("Educational ");
            educational1.setFont(new Font("Rale way",Font.BOLD,20));
            educational1.setBounds(100,290,200,30);
            add(educational1);
            
            JLabel qualification = new JLabel("Qualification : ");
            qualification.setFont(new Font("Rale way",Font.BOLD,20));
            qualification.setBounds(100,315,200,30);
            add(qualification);


            // Creating ComboBox for Qualification
            String[] valEducation = {"Non-Graduate","Graduate","Post-Graduate","Doctorate","Others"};
            educational = new JComboBox(valEducation);
            educational.setBounds(300,315,400,30);
            educational.setBackground(Color.white);
            add(educational);


            // Occupation
            JLabel occupation1 = new JLabel("Occupation : ");
            occupation1.setFont(new Font("Rale way",Font.BOLD,20));
            occupation1.setBounds(100,390,200,30);
            add(occupation1);


            // Creating ComboBox for Occupation
            String[] valOccupation = {"Engineer","Doctor","Banking Service","Farmer","Soldier","IAS","IPS","Others"};
            occupation = new JComboBox(valOccupation);
            occupation.setBounds(300,390,400,30);
            occupation.setBackground(Color.white);
            add(occupation);


            // Permanent Account Number
            JLabel panNo = new JLabel("Pan No : ");
            panNo.setFont(new Font("Rale way",Font.BOLD,20));
            panNo.setBounds(100,440,200,30);
            add(panNo);

            panText = new JTextField();
            panText.setFont(new Font("Rale way",Font.BOLD,22));
            panText.setBounds(300,440,400,30);
            add(panText);


            // Aadhaar Number
            JLabel aadhaarNo = new JLabel("Aadhaar No : ");
            aadhaarNo.setFont(new Font("Rale way",Font.BOLD,20));
            aadhaarNo.setBounds(100,490,200,30);
            add(aadhaarNo);

            aadhaarText = new JTextField();
            aadhaarText.setFont(new Font("Rale way",Font.BOLD,22));
            aadhaarText.setBounds(300,490,400,30);
            add(aadhaarText);


            // Senior Citizen
            JLabel seniorCitizen = new JLabel("Senior citizen : ");
            seniorCitizen.setFont(new Font("Rale way",Font.BOLD,20));
            seniorCitizen.setBounds(100,540,200,30);
            add(seniorCitizen);


            // Created radio button for Senior Citizen
            seniorYes = new JRadioButton("Yes ");
            seniorYes.setBackground(Color.white);
            seniorYes.setFont(new Font("Arial",Font.BOLD,15));
            seniorYes.setBounds(300,540,100,30);
            add(seniorYes);


            //---------------------------------------------------------//
            seniorNo = new JRadioButton("No ");
            seniorNo.setBackground(Color.white);
            seniorNo.setFont(new Font("Arial",Font.BOLD,15));
            seniorNo.setBounds(450,540,120,30);
            add(seniorNo);


            //---------------------------------------------------------//
            ButtonGroup seniorGroup = new ButtonGroup();
            seniorGroup.add(seniorYes);
            seniorGroup.add(seniorNo);


            // Existing Account
            JLabel existingAccount = new JLabel("Existing Account : ");
            existingAccount.setFont(new Font("Rale way",Font.BOLD,20));
            existingAccount.setBounds(100,590,200,30);
            add(existingAccount);


            // Created radio button for Senior Citizen
            existingYes = new JRadioButton("Yes ");
            existingYes.setBackground(Color.white);
            existingYes.setFont(new Font("Arial",Font.BOLD,15));
            existingYes.setBounds(300,590,100,30);
            add(existingYes);


            //---------------------------------------------------------//
            existingNo = new JRadioButton("No ");
            existingNo.setBackground(Color.white);
            existingNo.setFont(new Font("Arial",Font.BOLD,15));
            existingNo.setBounds(450,590,120,30);
            add(existingNo);


            //---------------------------------------------------------//
            ButtonGroup existingGroup = new ButtonGroup();
            existingGroup.add(existingYes);
            existingGroup.add(existingNo);

            // Next Button
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

            String sReligion = (String)religion.getSelectedItem();
            String sCategory = (String)category.getSelectedItem();
            String sIncome = (String)income.getSelectedItem();
            String sEducation = (String)educational.getSelectedItem();
            String sOccupation = (String)occupation.getSelectedItem();

            String sPan = panText.getText();
            String aadhaar = aadhaarText.getText();

            String seniorCitizen = null;
            if(seniorYes.isSelected()){
                seniorCitizen = "Yes";
            } else if (seniorNo.isSelected()) {
                seniorCitizen = "No";
            }


            String existingAccount = null ;
            if(existingYes.isSelected()){
                existingAccount = "Yes";
            } else if (existingNo.isSelected()) {
                existingAccount = "No";
            }


            try{
                if(aadhaarText.getText().equals("")){
                    JOptionPane.showMessageDialog(null ,"Aadhaar Card Number is Necessary");
                }
                else{
                    Conn c = new Conn();
                    String query = "insert into signupTwo values('"+formNo+"','"+sReligion+"','"+sCategory+"','"+sIncome+"','"+sEducation+"','"+sOccupation+"','"+sPan+"','"+aadhaar+"','"+seniorCitizen+"','"+existingAccount+"')";
                    c.s.executeUpdate(query);

                    // Creating signupThree Object
                    setVisible(false);
                    new SignUpThree(formNo).setVisible(true);
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }


        }
        public static void main(String[] args) {
            new SignUpTwo("").setVisible(true);
        }
    }