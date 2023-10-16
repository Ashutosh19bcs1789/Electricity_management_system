/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricitybillingsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class paybill extends  JFrame implements ActionListener{
    JLabel jmeternumber,jname,junits,jtotalbill,labelstatus;
    Choice cmonth;
    String meter;
    JButton pay,back;
    paybill(String meter){
        super("Pay Bill");
        this.meter=meter;
        setLayout(null);
        setBounds(260,145,800,450);
        
        JLabel heading=new JLabel("Electricity Bill");
        heading.setFont(new Font("monospace",Font.BOLD,17));
        heading.setBounds(120,10,200,30);
        add(heading);
        
        
        JLabel meternumber=new JLabel("Meter Number");
        meternumber.setBounds(30,60,100,28);
        add(meternumber);
        
        
        jmeternumber=new JLabel("");
        jmeternumber.setBounds(160,60,150,28);
        add(jmeternumber);
        
        
        JLabel name=new JLabel("Name");
        name.setBounds(30,95,100,28);
        add(name);
        
        
        jname=new JLabel("");
        jname.setBounds(160,95,150,28);
        add(jname);
        
        
        JLabel month=new JLabel("Month");
        month.setBounds(30,130,100,28);
        add(month);
        
        
        cmonth=new Choice();
        cmonth.setBounds(160,130,150,23);
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
        cmonth.setBackground(new Color(249,255,205));
        add(cmonth);
        
        JLabel units=new JLabel("Units");
        units.setBounds(30,165,100,28);
        add(units);
        
        
        junits=new JLabel("");
        junits.setBounds(160,165,150,28);
        add(junits);
        
        JLabel totalbill=new JLabel("Total Bill");
        totalbill.setBounds(30,200,100,28);
        add(totalbill);
        
        
        jtotalbill=new JLabel("");
        jtotalbill.setBounds(160,200,150,28);
        add(jtotalbill);
        
        JLabel status=new JLabel("Status");
        status.setBounds(30,235,100,28);
        add(status);
        
        
        labelstatus=new JLabel("");
        labelstatus.setBounds(160,235,150,28);
        labelstatus.setForeground(Color.RED);
        add(labelstatus);
        
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("Select * from addnewcustomer where meterno='"+meter+"'");
            while(rs.next()){
                jmeternumber.setText(meter);
                jname.setText(rs.getString("name"));
            }
            
            rs=c.s.executeQuery("Select * from bill where Meter_number='"+meter+"' AND Month='"+cmonth.getSelectedItem()+"'");
            while(rs.next()){
                junits.setText(rs.getString("Units"));
                jtotalbill.setText(rs.getString("Total_Bill"));
                labelstatus.setText(rs.getString("Status"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        cmonth.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent ie){
             try{
            conn c=new conn(); 
            ResultSet rs=c.s.executeQuery("Select * from bill where Meter_number='"+meter+"' AND Month='"+cmonth.getSelectedItem()+"'");
            while(rs.next()){
                junits.setText(rs.getString("Units"));
                jtotalbill.setText(rs.getString("Total_Bill"));
                labelstatus.setText(rs.getString("Status"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        }
    });
        
        pay=new JButton("Pay");
        pay.setBounds(90,340,90,30);
        pay.setForeground(Color.BLACK);
        pay.setBackground(new Color(165,247,187));
        pay.addActionListener(this);
        add(pay);
        
        back=new JButton("Back");
        back.setBounds(210,340,90,30);
        back.setForeground(Color.BLACK);
        back.setBackground(new Color(165,247,187));
        back.addActionListener(this);
        add(back);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
        Image i2=i1.getImage().getScaledInstance(500, 350, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,50,450,350);
        add(image);
        
        
        getContentPane().setBackground(new Color(240,231,247));
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==pay){
            try{
                conn c=new conn();
                c.s.executeUpdate("Update bill set Status='Paid' where Meter_number='"+meter+"' and Month='"+cmonth.getSelectedItem()+"'");
            
            }catch(Exception e){
                e.printStackTrace();
            }
            setVisible(false);
            new paytm(meter);
        }else{
            setVisible(false);
            
        }
    }
    public static void main(String[] args){
        new paybill("");
    }
}
