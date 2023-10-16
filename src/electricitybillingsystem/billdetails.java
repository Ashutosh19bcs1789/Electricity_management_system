/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricitybillingsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class billdetails extends JFrame implements ActionListener {
    
    String meter;
    JTable table;
    billdetails(String meter){
        super("Bill Details");
        this.meter=meter;
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        setSize(700,500);
        setLocation(285,110);
        
        table=new JTable();
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("Select * from bill where meter_number='"+meter+"'");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        JScrollPane sp=new JScrollPane(table);
        sp.setBounds(0,0,700,500);
        add(sp);
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        
    }
    public static void main(String[] args){
        new billdetails("");
    }
}
