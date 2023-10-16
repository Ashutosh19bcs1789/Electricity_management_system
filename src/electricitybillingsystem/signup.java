/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricitybillingsystem;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

//package will import with .* but sub package will not import.

public class signup extends JFrame implements ActionListener {
JButton jbback,jbcreate;
Choice accounttype;
JTextField tfmeter,tfname,tfuser;
JPasswordField tfpass;
    signup(){
    super("Sign Up" );
    setLayout(null);
    getContentPane().setBackground(Color.WHITE);
    
    
    JPanel panel=new JPanel();
    panel.setBounds(12,12,530,290);
    panel.setBorder(new TitledBorder(new LineBorder(new Color(173,216,230),2),"Create-Account",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(172,216,230)));
    panel.setBackground(Color.WHITE);
    panel.setLayout(null);
    panel.setForeground(new Color(34,139,34));
    add(panel);

    JLabel heading=new JLabel("Create Account As");
    heading.setBounds(15,35,130,20);
    heading.setForeground(Color.GRAY);
    heading.setFont(new Font("cursive",Font.BOLD,14));
    panel.add(heading);
    
    
    accounttype=new Choice();
    accounttype.add("Admin");
    accounttype.add("Customer");
    accounttype.setBounds(160,35,150,30);
    accounttype.setForeground(Color.BLACK);
    accounttype.setBackground(new Color(162,200,243));
    accounttype.setFont(new Font("Tahoma",Font.PLAIN,12));
    panel.add(accounttype);
    
    JLabel lbmeter=new JLabel("Meter Number");
    lbmeter.setBounds(15,70,140,20);
    lbmeter.setForeground(Color.GRAY);
    lbmeter.setFont(new Font("cursive",Font.BOLD,14));
    lbmeter.setVisible(false);
    panel.add(lbmeter);
    
    tfmeter=new JTextField();
    tfmeter.setBounds(160,75,150,20);
    tfmeter.setVisible(false);
    panel.add(tfmeter);
   
    JLabel lbuser=new JLabel("Username");
    lbuser.setBounds(15,105,140,20);
    lbuser.setForeground(Color.GRAY);
    lbuser.setFont(new Font("cursive",Font.BOLD,14));
    panel.add(lbuser);
    
    tfuser=new JTextField();
    tfuser.setBounds(160,110,150,20);
    panel.add(tfuser);
    
    JLabel lbname=new JLabel("Name");
    lbname.setBounds(15,140,140,20);
    lbname.setForeground(Color.GRAY);
    lbname.setFont(new Font("cursive",Font.BOLD,14));
    panel.add(lbname);
    
    tfname=new JTextField();
    tfname.setBounds(160,145,150,20);
    panel.add(tfname);
    
    
     tfmeter.addFocusListener(new FocusListener(){
        @Override
        public void focusGained(FocusEvent fe){
            
        }
        public void focusLost(FocusEvent fe){
            try{
                conn c=new conn();
                ResultSet rs=c.s.executeQuery("Select * from signup where meterno='"+tfmeter.getText()+"'");
                while(rs.next()){
                    tfname.setText(rs.getString("name"));
                }
               
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    });
     
     
    JLabel lbpassword=new JLabel("Password");
    lbpassword.setBounds(15,175,140,20);
    lbpassword.setForeground(Color.GRAY);
    lbpassword.setFont(new Font("cursive",Font.BOLD,14));
    panel.add(lbpassword);
    
    tfpass=new JPasswordField();
    tfpass.setBounds(160,180,150,20);
    panel.add(tfpass);
    
    
    accounttype.addItemListener(new ItemListener(){
    public void itemStateChanged(ItemEvent ae){
        String user=accounttype.getSelectedItem();
        if(user.equals("Customer")){
            lbmeter.setVisible(true);
            tfmeter.setVisible(true);
            tfname.setEditable(false);
        }else{
            lbmeter.setVisible(false);
            tfmeter.setVisible(false);
            tfname.setEditable(true);
        }
    }
    });
    
    jbcreate=new JButton("Create");
    jbcreate.setBounds(50,230,95,25);
    jbcreate.setForeground(Color.WHITE);
    jbcreate.setBackground(Color.BLACK);
    jbcreate.addActionListener(this);
    panel.add(jbcreate);
    
    jbback=new JButton("Back");
    jbback.setBounds(185,230,95,25);
    jbback.setForeground(Color.WHITE);
    jbback.setBackground(Color.BLACK);
    jbback.addActionListener(this);
    panel.add(jbback);
    
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
    Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(325,20,200,200);
    panel.add(image);
    
    
    
    setBounds(380,200,570,350);
    setVisible(true);
}   
public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==jbcreate){
        String atype=accounttype.getSelectedItem();
        String smeter=tfmeter.getText();
        String susername=tfuser.getText();
        String sname=tfname.getText();
        String spassword=tfpass.getText();
        
         if(susername.equals("")){
            JOptionPane.showMessageDialog(null, "Error! Required a valid username.");
            return; 
        }else if(sname.equals("")){
            JOptionPane.showMessageDialog(null, "Error! Required a valid name.");
            return;
        }else if(spassword.equals("")){
            JOptionPane.showMessageDialog(null, "Error! Please enter password.");
            return;
        }
        try{
            conn c=new conn();
            String str=null;
            if(atype.equals("Admin")){
                str="insert into signup values('"+atype+"','"+smeter+"', '"+susername+"', '"+sname+"', '"+spassword+"')";
            }else{
                str="Update signup set username='"+susername+"',password='"+spassword+"',accounttype='"+atype+"' where meterno='"+smeter+"'";
            }
            c.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null, "Account created Successfully");
            setVisible(false);
        }catch(Exception e){
            e.printStackTrace();
        }
    }else if(ae.getSource()==jbback){
        setVisible(false);
        new login();
}
}
public static void main(String[] args){
    new signup();
}
}
