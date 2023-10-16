/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package electricitybillingsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public  class ElectricityBillingSystem extends JFrame implements Runnable{
Thread t;
    ElectricityBillingSystem(){
    
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/elect.jpg"));  
    Image i2=i1.getImage().getScaledInstance(670, 430, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel i4=new JLabel(i3);
    i4.setBounds(0,0,630,450);
    add(i4);
    setVisible(true);
    
    int x=1;
    for(int i=2;i<450;i++,x++){
        setSize(i+x/2,i);
        setLocation(740-((i+x)/2),345-(i/2));
    
    try{
        Thread.sleep(1);
    }catch(Exception e){
        e.printStackTrace();
    }
    }
    t=new Thread(this); 
    t.start();
    setVisible(true);
    
    
}
   public void run(){
       
       try{
           Thread.sleep(6000); 
           setVisible(false);
           
           new login();
       }catch(Exception e){
           e.printStackTrace();
       }
   }
    public static void main(String[] args) {
        new ElectricityBillingSystem(); 
        
    }
    
}
