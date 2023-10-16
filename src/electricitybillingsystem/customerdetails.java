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


public class customerdetails extends JFrame implements ActionListener {
    JTable table;
    JButton print;
    customerdetails(){
        super("Customer Details");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        
        table=new JTable();
        try{
            conn c=new conn();
            String str="Select * from addnewcustomer";
            ResultSet rs=c.s.executeQuery(str);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        JScrollPane sctable=new JScrollPane(table);
        add(sctable);
        
        
        print=new JButton("Print");
        print.addActionListener(this);
        add(print,"South");
        
        
        
        setVisible(true);

    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==print){
            try{
                table.print();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        new customerdetails();
    }
}
