/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricitybillingsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;


public  class newcustomer extends JFrame implements ActionListener {
    
    JTextField tfaddress,tfname,tfcity,tfstate,tfpincode,tfphone,tfemail;
    JLabel lbmeterno1;
    JButton next,back;
    newcustomer(){
        super("Add New Customer");
        setSize(600,450);
        setLocation(340,175);
        
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(173,216,230));
        add(panel);
        
        
        JLabel heading=new JLabel("New Customer");
        heading.setBounds(150,15,200,30);
        heading.setFont(new Font("Cusrive",Font.BOLD,20));
        panel.add(heading);
        
        JLabel lblname=new JLabel("Customer Name");
        lblname.setBounds(30,65,100,20);
        lblname.setFont(new Font("cursive",Font.PLAIN,14));
        panel.add(lblname);
        
        tfname=new JTextField();
        tfname.setBounds(155,65,150,23);
        panel.add(tfname);
        
        
        JLabel lbmeterno=new JLabel("Meter Number");
        lbmeterno.setBounds(30,100,100,20);
        lbmeterno.setFont(new Font("cursive",Font.PLAIN,14));
        panel.add(lbmeterno);
        
        lbmeterno1=new JLabel(); 
        lbmeterno1.setBounds(155,100,100,20);
        lbmeterno1.setFont(new Font("cursive",Font.BOLD,12));
        panel.add(lbmeterno1);
        
        Random ran=new Random();
        long number=ran.nextLong() %10000000;  
        lbmeterno1.setText(""+Math.abs(number)); 
        
        JLabel lbladdress=new JLabel("Address");
        lbladdress.setBounds(30,135,100,20);
        lbladdress.setFont(new Font("cursive",Font.PLAIN,14));
        panel.add(lbladdress);
        
        tfaddress=new JTextField();
        tfaddress.setBounds(155,135,150,23);
        panel.add(tfaddress);
        
        JLabel lblcity=new JLabel("City");
        lblcity.setBounds(30,170,100,20);
        lblcity.setFont(new Font("cursive",Font.PLAIN,14));
        panel.add(lblcity);
        
        tfcity=new JTextField();
        tfcity.setBounds(155,170,150,23);
        panel.add(tfcity);
        
        JLabel lblstate=new JLabel("State");
        lblstate.setBounds(30,205,100,20);
        lblstate.setFont(new Font("cursive",Font.PLAIN,14));
        panel.add(lblstate);
        
        tfstate=new JTextField();
        tfstate.setBounds(155,205,150,23);
        panel.add(tfstate);
        
        
        JLabel lblpincode=new JLabel("Pincode");
        lblpincode.setBounds(30,240,100,20);
        lblpincode.setFont(new Font("cursive",Font.PLAIN,14));
        panel.add(lblpincode);
        
        tfpincode=new JTextField();
        tfpincode.setBounds(155,240,150,23);
        panel.add(tfpincode);
        
        
        JLabel pinlimit=new JLabel("(6 digit only)");
        pinlimit.setBounds(310,240,100,20);
        pinlimit.setFont(new Font("cursive",Font.BOLD,10));
        panel.add(pinlimit);
        
        
        
        JLabel lblphone=new JLabel("Mobile no.");
        lblphone.setBounds(30,275,100,20);
        lblphone.setFont(new Font("cursive",Font.PLAIN,14));
        panel.add(lblphone);
        
        tfphone=new JTextField();
        tfphone.setBounds(155,275,150,23);
        panel.add(tfphone);
        
        JLabel moblimit=new JLabel("(10 digit only)");
        moblimit.setBounds(310,275,100,20);
        moblimit.setFont(new Font("cursive",Font.BOLD,10));
        panel.add(moblimit);
        
        JLabel lblemail=new JLabel("E-mail");
        lblemail.setBounds(30,310,100,20);
        lblemail.setFont(new Font("cursive",Font.PLAIN,14));
        panel.add(lblemail);
        
        tfemail=new JTextField();
        tfemail.setBounds(155,310,150,23);
        panel.add(tfemail);
        
        next=new JButton("Next");
        next.setBounds(120,355,80,27);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        panel.add(next);
        
        back=new JButton("Back");
        back.setBounds(225,355,80,27);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
        Image i2=i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image,"East");
        
        
        
        
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    
public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==next){
        String name=tfname.getText();
        String meterno=lbmeterno1.getText();
        String address=tfaddress.getText();
        String city=tfcity.getText();
        String state=tfstate.getText();
        String pincode=tfpincode.getText();
        String phone=tfphone.getText();
        String email=tfemail.getText();
        
        if(name.equals("")){
            JOptionPane.showMessageDialog(null, "Error! Required Name");
            return;
        }else if(address.equals("")){
            JOptionPane.showMessageDialog(null, "Error! Required Address");
            return;
        }else if(city.equals("")){
            JOptionPane.showMessageDialog(null, "Error! Required City");
            return;
        }else if(state.equals("")){
            JOptionPane.showMessageDialog(null, "Error! Required State");
            return;
        }else if(pincode.equals("")){
            JOptionPane.showMessageDialog(null, "Error! Required Pincode");
            return;
        }else if(phone.equals("")){
            JOptionPane.showMessageDialog(null, "Error! Required Mobile Number.");
            return;
        }else if(email.equals("")){
            JOptionPane.showMessageDialog(null, "Error! Required E-mail");
            return;
        }
        
        
        try{
            conn c=new conn();
            String str="Insert into addnewcustomer values('"+name+"','"+meterno+"','"+address+"','"+city+"','"+state+"','"+pincode+"','"+phone+"','"+email+"')";
            String str1="Insert into signup values('',"+meterno+",'','"+name+"','')";
            
            c.s.executeUpdate(str);
            c.s.executeUpdate(str1);
            setVisible(false);
            new meterinfo(meterno);
        }catch(Exception e){
            e.printStackTrace();
        }
    }else{
        setVisible(false);
        
    }
}
public static void main(String[] args){
    new newcustomer();
}
}
