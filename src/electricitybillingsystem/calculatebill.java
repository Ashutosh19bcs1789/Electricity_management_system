/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricitybillingsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class calculatebill extends JFrame implements ActionListener {

    JButton submit,back;
    JTextField tfunitc;
    JLabel lbladress,lblname;
    Choice cmonth,meternumber;

    calculatebill() {
        super("Calculate Bill");
        setSize(600, 400);
        setLocation(340, 175);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(173, 216, 230));
        add(panel);

        JLabel heading = new JLabel("Calculate Electricity Bill");
        heading.setBounds(100, 15, 250, 30);
        heading.setFont(new Font("Cusrive", Font.BOLD, 20));
        panel.add(heading);

        JLabel lblmeternumber = new JLabel("Meter Number");
        lblmeternumber.setBounds(30, 65, 100, 20);
        lblmeternumber.setFont(new Font("cursive", Font.PLAIN, 14));
        panel.add(lblmeternumber);

        meternumber = new Choice();

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("Select * from addnewcustomer");
            while (rs.next()) {
                meternumber.add(rs.getString("meterno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        meternumber.setBounds(155, 65, 150, 23);
        meternumber.setFont(new Font("cursive", Font.BOLD, 12));
        panel.add(meternumber);

        JLabel lbname = new JLabel("Name");
        lbname.setBounds(30, 100, 100, 20);
        lbname.setFont(new Font("cursive", Font.PLAIN, 14));
        panel.add(lbname);

        lblname=new JLabel();
        lblname.setBounds(155,100,150,23);
        panel.add(lblname);

        JLabel lbaddress = new JLabel("Address");
        lbaddress.setBounds(30, 135, 100, 20);
        lbaddress.setFont(new Font("cursive", Font.PLAIN, 14));
        panel.add(lbaddress);

        lbladress=new JLabel();
        lbladress.setBounds(155,135,190,23);
        panel.add(lbladress);
        
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("Select * from addnewcustomer where meterno='"+meternumber.getSelectedItem()+"'");
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                lbladress.setText(rs.getString("address"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        meternumber.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent ie){
        try{
   
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("Select * from addnewcustomer where meterno='"+meternumber.getSelectedItem()+"'");
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                lbladress.setText(rs.getString("address"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        }
    });
        
        
        JLabel lblunitconsumed=new JLabel("Unit Consumed");
        lblunitconsumed.setBounds(30,170,100,20);
        lblunitconsumed.setFont(new Font("cursive",Font.PLAIN,14));
        panel.add(lblunitconsumed);
        
        tfunitc=new JTextField();
        tfunitc.setBounds(155,170,150,23);
        panel.add(tfunitc);
        
        
        JLabel lblmonth=new JLabel("Month");
        lblmonth.setBounds(30,205,100,20);
        lblmonth.setFont(new Font("cursive",Font.PLAIN,14));
        panel.add(lblmonth);
        
        cmonth=new Choice();
        cmonth.setBounds(155,205,150,23);
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
        panel.add(cmonth);

        
        submit = new JButton("Submit");
        submit.setBounds(80, 265, 80, 27);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        panel.add(submit);

        back = new JButton("Back");
        back.setBounds(190, 265, 80, 27);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150, 260, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image, "East");

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==submit){
            String meter=meternumber.getSelectedItem();
        String units=tfunitc.getText();
        String months=cmonth.getSelectedItem();
        
        int totalbill=0;
        int unit_consumed=Integer.parseInt(units);
        String str="Select * from billcost ";
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery(str);
            while(rs.next()){
                totalbill+=unit_consumed* Integer.parseInt(rs.getString("cost_per_unit"));
                totalbill+=Integer.parseInt(rs.getString("meter_rent"));
                totalbill+=Integer.parseInt(rs.getString("service_charge"));
                totalbill+=Integer.parseInt(rs.getString("Service_tax"));
                totalbill+=Integer.parseInt(rs.getString("swacch_bharat_cess"));
                totalbill+=Integer.parseInt(rs.getString("fixed_tax"));
            }        
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        //second query for showing table in daata
        
        String query="insert into bill values('"+meter+"','"+months+"','"+units+"','"+totalbill+"','Not Paid')";
        try{
           conn c=new conn();
           c.s.executeUpdate(query);
           JOptionPane.showMessageDialog(null, "Customer Bill Updated Successfully");
           setVisible(false);
        }catch(Exception e){
            e.printStackTrace();
        }
    }else{
            setVisible(false);
        }

        }
    public static void main(String[] args) {
        new calculatebill();
    }
}
