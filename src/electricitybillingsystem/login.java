/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricitybillingsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class login extends JFrame implements ActionListener {
    JButton jbsignup,jbcancel,jblogin;
    JTextField tfname;
    JPasswordField tfpassword;
    JComboBox cbloginas;
    login(){
        super("Login Page");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        
        JLabel jlname=new JLabel("Username");
        jlname.setFont(new Font("cursive",Font.BOLD,13));
        jlname.setBounds(20,20,80,30);
        add(jlname);
        
        tfname=new JTextField();
        tfname.setBounds(120,25,150,23);
        add(tfname);
        
        JLabel jlpassword=new JLabel("Password");
        jlpassword.setFont(new Font("cursive",Font.BOLD,13));
        jlpassword.setBounds(20,60,80,30);
        add(jlpassword);
        
        tfpassword=new JPasswordField();
        tfpassword.setBounds(120,65,150,23);
        add(tfpassword);
        
        JLabel jlloginas=new JLabel("Login As");
        jlloginas.setFont(new Font("cursive",Font.BOLD,13));
        jlloginas.setBounds(20,100,80,30);
        add(jlloginas);
        
        
        String option[]={"Admin","Customer"};
        cbloginas=new JComboBox(option);
        cbloginas.setBounds(120,105,150,23);
        cbloginas.setForeground(Color.BLACK);
        add(cbloginas);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(230, 220, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel i4=new JLabel(i3);
        i4.setBounds(275,0,220,200);
        add(i4);
        
        
        ImageIcon i5=new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i6=i5.getImage().getScaledInstance(12, 12, Image.SCALE_DEFAULT);
        ImageIcon i7=new ImageIcon(i6);
        JLabel i8=new JLabel(i7);
        i8.setBounds(8,112,100,100);
        add(i8);
        
        
        ImageIcon i9=new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        Image i10=i9.getImage().getScaledInstance(12, 12, Image.SCALE_DEFAULT);
        ImageIcon i11=new ImageIcon(i10);
        JLabel i12=new JLabel(i11);
        i12.setBounds(126,112,100,100);
        add(i12);
        
        
        ImageIcon i13=new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image i14=i13.getImage().getScaledInstance(12, 12, Image.SCALE_DEFAULT);
        ImageIcon i15=new ImageIcon(i14);
        JLabel i16=new JLabel(i15);
        i16.setBounds(65,157,100,100);
        add(i16);
        
        
        jblogin=new JButton("Login");
        jblogin.setBounds(40,150,100,25);
        jblogin.setForeground(Color.BLACK);
        jblogin.addActionListener(this);
        add(jblogin);
        
        jbcancel=new JButton("Cancel");
        jbcancel.setBounds(160,150,100,25);
        jbcancel.setForeground(Color.BLACK);
        jbcancel.addActionListener(this);
        add(jbcancel);
        
        jbsignup=new JButton("Sign Up");
        jbsignup.setBounds(100,195,100,25);
        jbsignup.setForeground(Color.BLACK);
        jbsignup.addActionListener(this);
        add(jbsignup);
        
        
        setBounds(400,250,500,280);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==jblogin){
            String username=tfname.getText();
            String password=tfpassword.getText();
            String loginas=(String)cbloginas.getSelectedItem();
            
            try{
                conn c=new conn();
                String query="Select * from signup where username='"+username+"'and password='"+password+"'and accounttype='"+loginas+"'";
                ResultSet rs=c.s.executeQuery(query); 
                if(rs.next()){
                  String meter=rs.getString("meterno");
                  setVisible(false);
                  new project(loginas,meter);
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Login ! Please check your username and password.");
                    tfname.setText("");
                    tfpassword.setText("");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource()==jbcancel){
            setVisible(false);
        }else if(ae.getSource()==jbsignup){
            setVisible(false);
            new signup();
        }
    }
public static void main(String[] args){
    new login();
}
}
