/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airelinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{
    JTextField tfname, tfaadhar, tfphone, tfnationality, tfaddress;
    JRadioButton rbmale, rbfemale;
    
    public AddCustomer(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
        heading.setBounds(220,20,500,35);
        heading.setFont(new Font("Tahoma",Font.PLAIN,32));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60,80,150,25);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(230,80,150,25);
        add(tfname);
        
        
        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60,130,150,25);
        lblnationality.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblnationality);
        
        tfnationality = new JTextField();
        tfnationality.setBounds(230,130,150,25);
        add(tfnationality);
        
        
        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(60,180,150,25);
        lblaadhar.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(230,180,150,25);
        add(tfaadhar);
        
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60,230,150,25);
        lbladdress.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(230,230,150,25);
        add(tfaddress);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60,280,150,25);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblgender);
        
        ButtonGroup gendergroup = new ButtonGroup();
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(230,280,70,25);
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(310,280,70,25);
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        gendergroup.add(rbmale);
        gendergroup.add(rbfemale);
        
        JLabel lblphone = new JLabel("Phone Number");
        lblphone.setBounds(60,320,150,25);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(230,320,150,25);
        add(tfphone);
        
        JButton save = new JButton("SAVE");
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.setBounds(230,380,150,30);
        save.addActionListener(this);
        add(save);
        
        
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airelinemanagementsystem/icons/emp.jpg"));
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(420,80,400,400);
        add(lblimage);
        
        setSize(900,600);
        setLocation(300,150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        try{
            String name = tfname.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String nationality = tfnationality.getText();
            String aadhar = tfaadhar.getText();
            String gender = null;
            if(rbmale.isSelected()) {
                gender  = "Male";
            }
            else {
                gender = "Female";
            }
            
            Conn conn = new Conn();
            String query = "insert into passenger values('"+name+"','"+nationality+"','"+phone+"','"+address+"','"+aadhar+"','"+gender+"')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Customer Added Successfully");
            setVisible(false);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]) {
        new AddCustomer();
    }
    
}
