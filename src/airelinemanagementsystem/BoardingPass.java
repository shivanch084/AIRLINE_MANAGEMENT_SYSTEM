/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package airelinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class BoardingPass extends JFrame implements ActionListener{
    JTextField tfpnr;
    JLabel tfname, tfnationality, lblsrc, labeldest, labelfname, labelfcode, labeldate, lblcode;
    JButton fetchButton;

    
    public BoardingPass(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("AIR INDIA");
        heading.setBounds(380,10,450,35);
        heading.setFont(new Font("Tahoma",Font.PLAIN,32));
        add(heading);
        
        JLabel subheading = new JLabel("BOARDING PASS");
        subheading.setBounds(365,50,300,30);
        subheading.setFont(new Font("Tahoma",Font.PLAIN,24));
        subheading.setForeground(Color.BLUE);
        add(subheading);
        
        JLabel lblaadhar = new JLabel("PNR DETAILS");
        lblaadhar.setBounds(60,100,150,25);
        lblaadhar.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblaadhar);
        
        tfpnr = new JTextField();
        tfpnr.setBounds(220,100,150,25);
        add(tfpnr);  
        
        fetchButton = new JButton("Fetch");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380,100,120,25);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60,140,150,25);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblname);
        
        tfname = new JLabel();
        tfname.setBounds(220,140,150,25);
        add(tfname);
        
        
        JLabel lblnationality = new JLabel("NATIONALITY");
        lblnationality.setBounds(60,180,150,25);
        lblnationality.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblnationality);
        
        tfnationality = new JLabel();
        tfnationality.setBounds(220,180,150,25);
        add(tfnationality);
        
        
        
        JLabel lbladdress = new JLabel("SOURCE");
        lbladdress.setBounds(60,220,150,25);
        lbladdress.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbladdress);
        
        lblsrc = new JLabel();
        lblsrc.setBounds(220,220,150,25);
        add(lblsrc);
        
        JLabel lblgender = new JLabel("DESTINATION");
        lblgender.setBounds(380,220,150,25);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblgender);
        
        labeldest = new JLabel(); 
        labeldest.setBounds(540,220,150,25);
        add(labeldest);
        
      
        
        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60,260,150,25);
        lblfname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblfname);
        
        labelfname = new JLabel();
        labelfname.setBounds(220,260,150,25);
        add(labelfname);
        
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(380,260,150,25);
        lblfcode.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblfcode);
        
        labelfcode = new JLabel();
        labelfcode.setBounds(540,260,150,25);
        add(labelfcode);
        
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60,300,150,25);
        lbldate.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbldate);
        
        labeldate = new JLabel();
        labeldate.setBounds(220,300,150,25);
        add(labeldate);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airelinemanagementsystem/icons/airindia.png"));
        Image i2 = i1.getImage().getScaledInstance(300,230,Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(600,0,300,300);
        add(lblimage);
        
   
        
        setSize(1000,450);
        setLocation(300,150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
      
            String pnr = tfpnr.getText();
           
            
            try{
            Conn conn = new Conn();
            String query = "Select * from reservation where PNR = '"+pnr+"'";
            ResultSet rs = conn.s.executeQuery(query);
            
           if(rs.next()) {
                 tfname.setText(rs.getString("NAME"));
                 tfnationality.setText(rs.getString("NATIONALITY"));
                 lblsrc.setText(rs.getString("SOURCE"));
                 labeldest.setText(rs.getString("DESTINATION"));
                 labelfname.setText(rs.getString("FLIGHTNAME"));
                 labelfcode.setText(rs.getString("FLIGHTCODE"));
                 labeldate.setText(rs.getString("TRAVELDATE"));
            }
            else {
                JOptionPane.showMessageDialog(null,"PNR not found . Please enter correct PNR number");
            }
            
        }catch(Exception e) {
            e.printStackTrace();
        }

    }
    public static void main(String args[]) {
        new BoardingPass();
    }
    
}

