/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricitybillingsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class paytm extends JFrame implements ActionListener{
String meter;
JButton back;
paytm(String meter){
    this.meter=meter;
    
    JEditorPane j=new JEditorPane();
    j.setEditable(false);
    try{
       j.setPage("https://paytm.com/online-payments"); 
    }catch(Exception e){
        j.setContentType("text/html");
        j.setText("<html>Could not load<html>");
    }
    
    JScrollPane pane=new  JScrollPane(j);
    pane.setBounds(0,70,1300,700);
    add(pane);
    
    
    back=new JButton("Back");
    back.setBounds(1130,25,80,30);
    back.addActionListener(this);
    back.setForeground(Color.BLACK);
    back.setBackground(new Color(165,247,187));
    add(back);
        
    setLayout(null);
    setExtendedState(MAXIMIZED_BOTH);
    setVisible(true);
} 
public void actionPerformed(ActionEvent e){
    setVisible(false);
    new paybill(meter);
}
public static void main(String[] args){
    new paytm("");
}
}
