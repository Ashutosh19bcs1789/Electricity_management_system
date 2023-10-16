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

public class depositdetails extends JFrame implements ActionListener {
    Choice meternumber ,cmonth;
    JTable table;
    JButton search,print;
    depositdetails(){
        super("Deposit Details");
        setSize(700,500);
        setLocation(300,125);
        setLayout(null);
        getContentPane().setBackground(new Color(240,231,247));
        setVisible(true);
        
        
        
        
        JLabel lblmeternumber=new JLabel("Search By Meter Number");
        lblmeternumber.setBounds(20,30,150,20);
        add(lblmeternumber);
        
        meternumber=new Choice();
        meternumber.setBounds(205,30,120,25);
        meternumber.setBackground(new Color(165,247,187));
        add(meternumber);
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("Select * from addnewcustomer");
            while(rs.next()){
                meternumber.add(rs.getString("meterno"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel lblmonth=new JLabel("Search By Month");
        lblmonth.setBounds(360,30,120,20);
        add(lblmonth);
        
        
        cmonth=new Choice();
        cmonth.setBounds(500,30,120,25);
        cmonth.add("January");
        cmonth.add("February");
        cmonth.add("March");
        cmonth.add("April");
        cmonth.add("May");
        cmonth.add("June");
        cmonth.add("July");
        cmonth.add("August");
        cmonth.add("September");
        cmonth.add("October");
        cmonth.add("November");
        cmonth.add("December");
        cmonth.setBackground(new Color(165,247,187));
        add(cmonth);
        
        
        
        table=new JTable();
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("Select * from bill");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        JScrollPane sptable=new JScrollPane(table);
        sptable.setBounds(0,130,700,400);
        add(sptable);
        
        
        search=new JButton("Search");
        search.setBounds(40,85,80,25);
        search.addActionListener(this);
        search.setForeground(Color.BLACK);
        search.setBackground(new Color(165,247,187));
        add(search);
        
        print=new JButton("Print");
        print.setBounds(135,85,80,25);
        print.addActionListener(this);
        print.setForeground(Color.BLACK);
        print.setBackground(new Color(165,247,187));
        add(print);
        
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            String query="Select * from bill where Meter_number='"+meternumber.getSelectedItem()+"' and Month='"+cmonth.getSelectedItem()+"'";
            try{
                conn c=new conn();
                ResultSet rs=c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            try{
                table.print();  
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] agrs){
        new depositdetails();
    }
}
