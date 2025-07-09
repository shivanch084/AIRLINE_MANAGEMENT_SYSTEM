/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package airelinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class cancel extends JFrame implements ActionListener{
    JTextField tfpnr;
    JLabel tfname, cancellationno, lblcode, lbldateoftravel;
    JButton  fetchButton, flight;
    
    public cancel(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        Random random = new Random();
        
        JLabel heading = new JLabel("CANCELLATION");
        heading.setBounds(180,20,250,35);
        heading.setFont(new Font("Tahoma",Font.PLAIN,32));
        add(heading);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airelinemanagementsystem/icons/cancel.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(470,140,250,250);
        add(image);
        
        JLabel lblaadhar = new JLabel("PNR Number");
        lblaadhar.setBounds(60,80,150,25);
        lblaadhar.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblaadhar);
        
        tfpnr = new JTextField();
        tfpnr.setBounds(220,80,150,25);
        add(tfpnr);  
        
        fetchButton = new JButton("Show Details");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380,80,120,25);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60,130,150,25);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblname);
        
        tfname = new JLabel();
        tfname.setBounds(220,130,150,25);
        add(tfname);
        
        
        JLabel lblnationality = new JLabel("Cancellation No");
        lblnationality.setBounds(60,180,150,25);
        lblnationality.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblnationality);
        
        cancellationno = new JLabel(""+random.nextInt(1000000));
        cancellationno.setBounds(220,180,150,25);
        add(cancellationno);
        
        
        
        JLabel lbladdress = new JLabel("Flight Code");
        lbladdress.setBounds(60,230,150,25);
        lbladdress.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbladdress);
        
        lblcode = new JLabel();
        lblcode.setBounds(220,230,150,25);
        add(lblcode);
        
        JLabel lblgender = new JLabel("Date");
        lblgender.setBounds(60,280,150,25);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblgender);
        
        lbldateoftravel = new JLabel(); 
        lbldateoftravel.setBounds(220,280,150,25);
        add(lbldateoftravel);
        
      
        flight = new JButton("Cancel");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        flight.setBounds(220,330,120,30);
        flight.addActionListener(this);
        add(flight);
        
        
       
        
        setSize(800,450);
        setLocation(350,150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == fetchButton){
            String pnr = tfpnr.getText();
           
            
            try{
            Conn conn = new Conn();
            String query = "Select * from reservation where PNR = '"+pnr+"'";
            ResultSet rs = conn.s.executeQuery(query);
            
            if(rs.next()) {
                tfname.setText(rs.getString("NAME"));
                lblcode.setText(rs.getString("FLIGHTCODE"));
                lbldateoftravel.setText(rs.getString("TRAVELDATE"));
            }
            else {
                JOptionPane.showMessageDialog(null,"PNR not found . Please enter correct PNR number");
            }
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        }
        else if(ae.getSource() == flight){
            String name = tfname.getText();
            String pnr = tfpnr.getText();
            String cancelno = cancellationno.getText();
            String fcode = lblcode.getText();
            String date = lbldateoftravel.getText();
            
            
           
            
            try{
            Conn conn = new Conn();
            String query = "insert into cancel values('"+pnr+"','"+name+"','"+cancelno+"','"+fcode+"','"+date+"')";
            conn.s.executeUpdate(query);
            
            String d_query = "delete from reservation where PNR = '"+pnr+"'";
            conn.s.executeUpdate(d_query);
            JOptionPane.showMessageDialog(null,"Cancellation Successfull");
            setVisible(false);
          
        }catch(Exception e) {
            e.printStackTrace();
        }
        }
        

    }
    public static void main(String args[]) {
        new cancel();
    }
    
}

