/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricitybillingsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class project extends JFrame implements ActionListener {
String user1,meter1;
project(String loginas,String meternumber){
    super(" Electricity Billing System");
    this.user1=loginas;
    this.meter1=meternumber;
    getContentPane().setBackground(Color.WHITE);
    
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/elect1.jpg"));
    Image i2=i1.getImage().getScaledInstance(1300, 650, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    add(image);
    
    JMenuBar mb=new JMenuBar();
    setJMenuBar(mb);
    
    setLayout(new FlowLayout()); 
    
    JMenu  admin= new JMenu(" Admin ");
    admin.setForeground(new Color(11 ,76,253));
    
    
    
    JMenuItem newcustomer=new JMenuItem("New Customer");
    newcustomer.setFont(new Font("cursive",Font.PLAIN,12));
    newcustomer.setBackground(Color.WHITE);
    ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
    Image i5=i4.getImage().getScaledInstance(15,15,Image.SCALE_DEFAULT);
    newcustomer.setIcon(new ImageIcon(i5));
    newcustomer.setMnemonic('N');
    newcustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
    newcustomer.addActionListener(this);
    admin.add(newcustomer);
   
    
    JMenuItem customerdetail=new JMenuItem("Customer Details");
    customerdetail.setFont(new Font("cursive",Font.PLAIN,12));
    customerdetail.setBackground(Color.WHITE);
    ImageIcon i6=new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
    Image i7=i6.getImage().getScaledInstance(15,15,Image.SCALE_DEFAULT);
    customerdetail.setIcon(new ImageIcon(i7));
    customerdetail.setMnemonic('D');
    customerdetail.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
    customerdetail.addActionListener(this);
    admin.add(customerdetail);
    
    
    JMenuItem depositdetail=new JMenuItem("Deposit Details");
    depositdetail.setFont(new Font("cursive",Font.PLAIN,12));
    depositdetail.setBackground(Color.WHITE);
    ImageIcon i8=new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
    Image i9=i8.getImage().getScaledInstance(15,15,Image.SCALE_DEFAULT);
    depositdetail.setIcon(new ImageIcon(i9));
    depositdetail.setMnemonic('N');
    depositdetail.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
    depositdetail.addActionListener(this);
    admin.add(depositdetail);
    
    JMenuItem calculatebill=new JMenuItem("Calculate Bills");
    calculatebill.setFont(new Font("cursive",Font.PLAIN,12));
    calculatebill.setBackground(Color.WHITE);
    ImageIcon i10=new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
    Image i11=i10.getImage().getScaledInstance(15,15,Image.SCALE_DEFAULT);
    calculatebill.setIcon(new ImageIcon(i11));
    calculatebill.setMnemonic('Q');
    calculatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,ActionEvent.CTRL_MASK));
    calculatebill.addActionListener(this);
    admin.add(calculatebill);
    
    
    JMenu  info= new JMenu(" Information ");
    info.setForeground(new Color(236,66,14));
    
    
    
    JMenuItem updateinfo=new JMenuItem("Update Info.");
    updateinfo.setFont(new Font("cursive",Font.PLAIN,12));
    updateinfo.setBackground(Color.WHITE);
    ImageIcon i12=new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
    Image i13=i12.getImage().getScaledInstance(15,15,Image.SCALE_DEFAULT);
    updateinfo.setIcon(new ImageIcon(i13));
    updateinfo.setMnemonic('U');
    updateinfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));
    updateinfo.addActionListener(this);
    info.add(updateinfo);
    
    
    JMenuItem viewinfo=new JMenuItem("View Info.");
    viewinfo.setFont(new Font("cursive",Font.PLAIN,12));
    viewinfo.setBackground(Color.WHITE);
    ImageIcon i14=new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
    Image i15=i14.getImage().getScaledInstance(15,15,Image.SCALE_DEFAULT);
    viewinfo.setIcon(new ImageIcon(i15));
    viewinfo.setMnemonic('V');
    viewinfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
    viewinfo.addActionListener(this);
    info.add(viewinfo);
    
    
    
    JMenu  user= new JMenu(" User ");
    user.setForeground(new Color(11 ,76,253));
    
    
    
    JMenuItem paybill=new JMenuItem("Pay Bills");
    paybill.setFont(new Font("cursive",Font.PLAIN,12));
    paybill.setBackground(Color.WHITE);
    ImageIcon i16=new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
    Image i17=i16.getImage().getScaledInstance(15,15,Image.SCALE_DEFAULT);
    paybill.setIcon(new ImageIcon(i17));
    paybill.setMnemonic('P');
    paybill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
    paybill.addActionListener(this);
    user.add(paybill);
    
    
    JMenuItem billdetail=new JMenuItem("Bill Detail");
    billdetail.setFont(new Font("cursive",Font.PLAIN,12));
    billdetail.setBackground(Color.WHITE);
    ImageIcon i18=new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
    Image i19=i18.getImage().getScaledInstance(15,15,Image.SCALE_DEFAULT);
    billdetail.setIcon(new ImageIcon(i19));
    billdetail.setMnemonic('L');
    billdetail.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
    billdetail.addActionListener(this);
    user.add(billdetail);
    
    
    
    
    JMenu  report= new JMenu(" Report ");
    report.setForeground(new Color(236,66,14));
    
    
    
    JMenuItem generatebill=new JMenuItem("Generate Bill");
    generatebill.setFont(new Font("cursive",Font.PLAIN,12));
    generatebill.setBackground(Color.WHITE);
    ImageIcon i20=new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
    Image i21=i20.getImage().getScaledInstance(15,15,Image.SCALE_DEFAULT);
    generatebill.addActionListener(this);
    generatebill.setIcon(new ImageIcon(i21));
    generatebill.setMnemonic('G');
    generatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));
    report.add(generatebill);
    
    
    JMenu  utility= new JMenu(" Utiltiy ");
    utility.setForeground(new Color(11 ,76,253));
    
    
    
    
    JMenuItem notepad=new JMenuItem("Notepad");
    notepad.setFont(new Font("cursive",Font.PLAIN,12));
    notepad.setBackground(Color.WHITE);
    ImageIcon i24=new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
    Image i25=i24.getImage().getScaledInstance(15,15,Image.SCALE_DEFAULT);
    notepad.setIcon(new ImageIcon(i25));
    notepad.setMnemonic('N');
    notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
    notepad.addActionListener(this);
    utility.add(notepad);
    
    JMenuItem calculator=new JMenuItem("Calculator");
    calculator.setFont(new Font("cursive",Font.PLAIN,12));
    calculator.setBackground(Color.WHITE);
    ImageIcon i26=new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
    Image i27=i26.getImage().getScaledInstance(15,15,Image.SCALE_DEFAULT);
    calculator.setIcon(new ImageIcon(i27));
    calculator.setMnemonic('C');
    calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
    calculator.addActionListener(this);
    utility.add(calculator);
    
    
    
    JMenu  mexit= new JMenu(" Exit ");
    mexit.setForeground(new Color(236,66,14));
    
    
    
    
    JMenuItem exit=new JMenuItem(" Exitt ");
    exit.setFont(new Font("cursive",Font.PLAIN,12));
    exit.addActionListener(this);
    exit.setBackground(Color.WHITE);
    
    
    
    ImageIcon i28=new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
    Image i29=i28.getImage().getScaledInstance(15,15,Image.SCALE_DEFAULT);
    exit.setIcon(new ImageIcon(i29));
  
    exit.setMnemonic('E');
    exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
    mexit.add(exit);
    
    
    if(user1.equals("Admin")){
        mb.add(admin);
    }else{
         mb.add(info);
         mb.add(user);
         mb.add(report);
        
    }
    
   
    mb.add(utility);
    mb.add(mexit);
    
    setVisible(true);
}   

public void actionPerformed(ActionEvent ae){
 
    String msg=ae.getActionCommand();
    if(msg.equals("New Customer")){
        new newcustomer();
    }else if(msg.equals("Customer Details")){
        new customerdetails();
    }else if(msg.equals("Deposit Details")){
        new depositdetails();
    }else if(msg.equals("Calculate Bills")){
        new calculatebill();
    }
    else if(msg.equals("View Info.")){
        new viewinformation(meter1);
    }
    else if(msg.equals("Update Info.")){
        new updateinformation(meter1);
    }
    else if(msg.equals("Pay Bills")){
        setVisible(false);
        new paybill(meter1);
    }
    else if(msg.equals("Bill Detail")){
        new billdetails(meter1);
    }
    else if(msg.equals("Generate Bill")){
        new Generatebill(meter1);
    }
    else if(msg.equals("Notepad")){
        try{
            Runtime.getRuntime().exec("notepad.exe");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    else if(msg.equals("Calculator")){
        try{
            Runtime.getRuntime().exec("Calc.exe");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    else{
        setVisible(false);
        new login();
    }
    
}
public static void main(String[] args){
    new project("","");
}
}
