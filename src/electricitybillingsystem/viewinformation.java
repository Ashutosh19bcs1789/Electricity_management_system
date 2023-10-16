/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricitybillingsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class viewinformation extends JFrame implements ActionListener {
    
    JButton cancel;
    String meter;
    viewinformation(String meter){
        super("View Customer Information");
        this.meter=meter;
        setBounds(240,100,850,550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("VIEW CUSTOMER INFORMATION");
        heading.setBounds(260,20,500,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        add(heading);
        
        JLabel lbname=new JLabel("Name");
        lbname.setBounds(30,65,80,25);
        add(lbname);
        
        JLabel name=new JLabel("");
        name.setBounds(140,65,150,25);
        add(name);
        
        
        JLabel lbmeter=new JLabel("Meter Number");
        lbmeter.setBounds(30,100,100,25);
        add(lbmeter);
        
        JLabel meternumber=new JLabel("");
        meternumber.setBounds(140,100,150,25);
        add(meternumber);
        
        
        JLabel lbaddress=new JLabel("Address");
        lbaddress.setBounds(30,135,80,25);
        add(lbaddress);
        
        JLabel address=new JLabel("");
        address.setBounds(140,135,180,25);
        add(address);
        
        
        JLabel lbcity=new JLabel("City");
        lbcity.setBounds(30,170,80,25);
        add(lbcity);
        
        JLabel city=new JLabel("");
        city.setBounds(140,170,180,25);
        add(city);
        
        JLabel lbpincode =new JLabel("Pincode");
        lbpincode.setBounds(420,65,80,25);
        add(lbpincode);
        
        JLabel pincode=new JLabel("");
        pincode.setBounds(530,65,180,25);
        add(pincode);
        
        JLabel lbstate=new JLabel("State");
        lbstate.setBounds(420,90,80,25);
        add(lbstate);
        
        JLabel state=new JLabel("");
        state.setBounds(530,100,180,25);
        add(state);
        
        JLabel lbphone=new JLabel("Phone No.");
        lbphone.setBounds(420,135,80,25);
        add(lbphone);
        
        JLabel Phone=new JLabel("");
        Phone.setBounds(530,135,180,25);
        add(Phone);
        
        JLabel lbemail=new JLabel("Email");
        lbemail.setBounds(420,170,80,25);
        add(lbemail);
        
        JLabel email=new JLabel("");
        email.setBounds(530,170,180,25);
        add(email);
        
        
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("Select * from addnewcustomer where meterno='"+meter+"'");
            while(rs.next()){
                name.setText(rs.getString("name"));
                address.setText(rs.getString("address"));
                city.setText(rs.getString("city"));
                state.setText(rs.getString("state"));
                pincode.setText(rs.getString("pincode"));
                Phone.setText(rs.getString("phone"));
                email.setText(rs.getString("email"));
                meternumber.setText(rs.getString("meterno"));


                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        cancel=new JButton("Cancel");
        cancel.setBounds(375,230,100,28);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/viewcustomer.jpg"));
        Image i2=i1.getImage().getScaledInstance(600, 250, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(25,250,800,260);
        add(image);
        
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    public static void main(String[] args){
        new viewinformation("");
    }
}
