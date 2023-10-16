/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricitybillingsystem;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class updateinformation extends JFrame implements ActionListener{
JTextField tfaddress,tfcity,tfstate,tfpincode,tfemail,tfphone;
JButton update,cancel;
JLabel name,meternumber;
String meter;
    updateinformation(String meter){
    super("Update Customer Information");
    this.meter=meter;
    setBounds(250,120,850,500);
    setLayout(null);
    getContentPane().setBackground(Color.WHITE);
    
    JLabel heading=new JLabel("UPDATE CUSTOMER INFORMATION");
    heading.setFont(new Font("tohima",Font.BOLD,18));
    heading.setBounds(250,20,400,30);
    add(heading);
    
    JLabel lbname=new JLabel("Name");
    lbname.setBounds(25,65,80,25);
    add(lbname);
        
    name=new JLabel("");
    name.setBounds(140,65,150,23);
    add(name);
        
    
    
    JLabel lbmeter=new JLabel("Meter Number");
    lbmeter.setBounds(25,100,100,25);
    add(lbmeter);
        
    meternumber=new JLabel("");
    meternumber.setText(meter);
    meternumber.setBounds(140,100,150,23);
    add(meternumber);
        
    
     
    JLabel lbaddress=new JLabel("Address");
    lbaddress.setBounds(25,135,80,25);
    add(lbaddress);
       
    tfaddress=new JTextField();
    tfaddress.setBounds(140,135,180,23);
    add(tfaddress);
        
        
    JLabel lbcity=new JLabel("City");
    lbcity.setBounds(25,170,80,25);
    add(lbcity);
        
    tfcity=new JTextField();
    tfcity.setBounds(140,170,180,23);
    add(tfcity);
        
    JLabel lbpincode =new JLabel("Pincode");
    lbpincode.setBounds(25,205,80,25);
    add(lbpincode);
        
    tfpincode=new JTextField();
    tfpincode.setBounds(140,205,180,23);
    add(tfpincode);
        
    JLabel lbstate=new JLabel("State");
    lbstate.setBounds(25,240,80,25);
    add(lbstate);
        
    tfstate=new JTextField();
    tfstate.setBounds(140,240,180,23);
    add(tfstate);
        
    JLabel lbphone=new JLabel("Phone No.");
    lbphone.setBounds(25,275,80,25);
    add(lbphone);
        
    tfphone=new JTextField();
    tfphone.setBounds(140,275,180,23);
    add(tfphone);
        
    JLabel lbemail=new JLabel("Email");
    lbemail.setBounds(25,310,80,25);
    add(lbemail);
        
    tfemail=new JTextField();
    tfemail.setBounds(140,310,180,23);
    add(tfemail);
            
        
    try{
        conn c=new conn();
        ResultSet rs=c.s.executeQuery("Select * from addnewcustomer where meterno='"+meternumber.getText()+"'");
        while(rs.next()){
            name.setText(rs.getString("name"));
            tfaddress.setText(rs.getString("address"));
            tfcity.setText(rs.getString("city"));
            tfstate.setText(rs.getString("state"));
            tfpincode.setText(rs.getString("pincode"));
            tfphone.setText(rs.getString("phone"));
            tfemail.setText(rs.getString("email"));
        }
    }catch(Exception e){
        e.printStackTrace();
    }
    
  
    update=new JButton("Update");
    update.setBounds(140,360,80,28);
    update.setBackground(Color.BLACK);
    update.setForeground(Color.WHITE);
    update.addActionListener(this);
    add(update);
        
    cancel=new JButton("Cancel");
    cancel.setBounds(240,360,80,28);
    cancel.setBackground(Color.BLACK);
    cancel.setForeground(Color.WHITE);
    cancel.addActionListener(this);
    add(cancel);
        
    
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/update.jpg"));
    Image i2=i1.getImage().getScaledInstance(325, 300, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(390,90,400,325);
    add(image);
    
    
    setVisible(true);
    
}   

public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==update){
        String saddress=tfaddress.getText();
        String scity=tfcity.getText();
        String sstate=tfstate.getText();
        String spincode=tfpincode.getText();
        String sphone=tfphone.getText();
        String semail=tfemail.getText();

        try{
            conn c=new conn();
            c.s.executeUpdate("Update  addnewcustomer set  address='"+saddress+"', city='"+scity+"',state='"+sstate+"',pincode='"+spincode+"',phone='"+sphone+"',email='"+semail+"' where meterno='"+meternumber.getText()+"'");
            JOptionPane.showMessageDialog(null,"Customer Details Updated Successfully");
            setVisible(false);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        }else if(ae.getSource()==cancel){
            setVisible(false);
        }
}

public static void main(String[] args){
    new updateinformation("");
}
}
