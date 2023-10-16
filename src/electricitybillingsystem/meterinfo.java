/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricitybillingsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;


public class meterinfo  extends JFrame implements ActionListener {
    
    JButton submit;
    Choice meterlocation,metertype,phasecode,billtype;
    String meternumber; 
    meterinfo(String meterno){
        super("Meter Information");
        
        this.meternumber=meterno;
        
        
        setSize(600,420);
        setLocation(340,175);
        
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(173,216,230));
        add(panel);
        
        
        JLabel heading=new JLabel("Meter Information");
        heading.setBounds(170,15,200,30);
        heading.setFont(new Font("Cusrive",Font.BOLD,20));
        panel.add(heading);
        
        JLabel lblmeternumber=new JLabel("Meter Number");
        lblmeternumber.setBounds(30,60,100,20);
        lblmeternumber.setFont(new Font("cursive",Font.PLAIN,14));
        panel.add(lblmeternumber);
        
        
        JLabel lbmeterno=new JLabel(meternumber);
        lbmeterno.setBounds(155,60,100,23);
        lbmeterno.setFont(new Font("cursive",Font.BOLD,12));
        panel.add(lbmeterno);
        
        
        JLabel lbladdress=new JLabel("Meter Location");
        lbladdress.setBounds(30,95,100,20);
        lbladdress.setFont(new Font("cursive",Font.PLAIN,14));
        panel.add(lbladdress);
        
        meterlocation=new Choice();
        meterlocation.add("Inside");
        meterlocation.add("Outside");
        meterlocation.setBounds(155,95,150,23);
        panel.add(meterlocation);
                
        
        JLabel lblmetertype=new JLabel("Meter Type");
        lblmetertype.setBounds(30,130,100,20);
        lblmetertype.setFont(new Font("cursive",Font.PLAIN,14));
        panel.add(lblmetertype);
        
        metertype=new Choice();
        metertype.add("Electric Meter");
        metertype.add("Smart Meter");
        metertype.add("Commercial Meter");
        metertype.add("Solar Meter");
        metertype.setBounds(155,130,150,23);
        panel.add(metertype);
        
        JLabel lblPhasecode=new JLabel("Phase Code");
        lblPhasecode.setBounds(30,165,100,20);
        lblPhasecode.setFont(new Font("cursive",Font.PLAIN,14));
        panel.add(lblPhasecode);
        
        phasecode=new Choice();
        phasecode.add("011");
        phasecode.add("022");
        phasecode.add("033");
        phasecode.add("044");
        phasecode.add("055");
        phasecode.add("066");
        phasecode.add("077");
        phasecode.add("088");
        phasecode.add("099");
        phasecode.setBounds(155,165,150,23);
        panel.add(phasecode);
        
        JLabel lblbilltype=new JLabel("Bill Type");
        lblbilltype.setBounds(30,200,100,20);
        lblbilltype.setFont(new Font("cursive",Font.PLAIN,14));
        panel.add(lblbilltype);
        
        billtype=new Choice();
        billtype.add("Normal");
        billtype.add("Industrial");     
        billtype.setBounds(155,200,150,23);
        panel.add(billtype);
        
        
        JLabel lbldays=new JLabel("Days");
        lbldays.setBounds(30,235,100,20);
        lbldays.setFont(new Font("cursive",Font.PLAIN,14));
        panel.add(lbldays);
        
        
        JLabel days1=new JLabel("30 Days");
        days1.setBounds(155,235,100,20);
        days1.setFont(new Font("cursive",Font.PLAIN,14));
        panel.add(days1);
        
        JLabel lblnote=new JLabel("Note");
        lblnote.setBounds(30,270,100,20);
        lblnote.setFont(new Font("cursive",Font.PLAIN,14));
        panel.add(lblnote);
        
        
        JLabel lblnote1=new JLabel("By default Bill is calculated for 30 days only");
        lblnote1.setBounds(155,270,500,20);
        lblnote1.setFont(new Font("cursive",Font.PLAIN,14));
        panel.add(lblnote1);
        
        
        
        submit=new JButton("Submit");
        submit.setBounds(160,325,80,27);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        panel.add(submit);
        
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
        Image i2=i1.getImage().getScaledInstance(150, 280, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image,"West");
        
        
        
        
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String meter=meternumber;
        String location=meterlocation.getSelectedItem();
        String type=metertype.getSelectedItem();
        String code=phasecode.getSelectedItem();
        String billtyp=billtype.getSelectedItem();
        String days="30";
        
         if(location.equals("")){
            JOptionPane.showMessageDialog(null, "Error! Required location");
            return;
        }else if(type.equals("")){
            JOptionPane.showMessageDialog(null, "Error! Required Location Type");
            return;
        }else if(code.equals("")){
            JOptionPane.showMessageDialog(null, "Error! Required Phasecode");
            return;
        }else if(billtyp.equals("")){
            JOptionPane.showMessageDialog(null, "Error! Required Bill Type");
            return;
        }
         
         
        try{
            String query="insert into meterinfo values('"+meter+"','"+location+"','"+type+"','"+code+"','"+billtyp+"','"+days+"')";
            conn c=new conn();
            
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Successfully Added");
            setVisible(false);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new meterinfo("");
    }
}
