/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airelinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class JourneyDetails extends JFrame implements ActionListener{
    JTable table;
    JTextField pnr;
    JButton show;
    public JourneyDetails(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel lblpnr = new JLabel("PNR NUMBER");
        lblpnr.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblpnr.setBounds(50,50,100,30);
        add(lblpnr);
        
        pnr = new JTextField();
        pnr.setBounds(160,50,120,30);
        add(pnr);
        
        show = new JButton("Show Details");
        show.setBackground(Color.BLACK);
        show.setForeground(Color.WHITE);
        show.setBounds(290,50,120,30);
        show.addActionListener(this);
        add(show);
        
        table = new JTable();
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,800,150);
        jsp.setBackground(Color.WHITE);
        add(jsp);
        
        
       setSize(800,600);
       setLocation(400,150);
       setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
         try{
             Conn conn = new Conn();
             ResultSet rs = conn.s.executeQuery("Select * from reservation where PNR = '"+pnr.getText()+"'");
             
             if(!rs.isBeforeFirst()){
                 JOptionPane.showConfirmDialog(null,"Invalid PNR");
                 return;
             }
             table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]) {
        new JourneyDetails();
    }
}
