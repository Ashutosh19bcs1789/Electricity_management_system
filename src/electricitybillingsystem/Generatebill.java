/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricitybillingsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Generatebill extends JFrame implements ActionListener{
    String meter;
    Choice cmonth;
    JTextArea area;
    JPanel p1;
    Generatebill(String meter){
        super("Generate Bill");
        setLayout(new BorderLayout());
        this.meter=meter;
        
        p1=new JPanel();
        
        
        JLabel heading =new JLabel("Generate Bill   ");
        JLabel meter1=new JLabel(meter);
        
        cmonth=new Choice(  );
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
        cmonth.setBackground(new Color(249,255,205));

        
        area=new JTextArea(50,15);
        area.setText("\n\n\t              ---------Click on the---------\n\t   Generate Bill to get bill of selected month");
        area.setFont(new Font("cursive",Font.PLAIN,15));
        area.setBackground(new Color(242,219,212));
        
        JScrollPane sp=new JScrollPane(area);
        
        JButton bill=new JButton("Generate Bill");
        bill.addActionListener(this);
        bill.setForeground(Color.BLACK);
        bill.setBackground(new Color(165,247,187));
        
        p1.add(heading);
        p1.add(cmonth);
        p1.add(meter1); 
        add(p1,"North");
        add(sp,"Center");
        add(bill,"South");
        
        
        
        
        setSize(500,600);
        setLocation(350,55);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        try{
            conn c=new conn();
            String month=cmonth.getSelectedItem();
           area.setText("\t            TATA INDUSTRIES PVT. LTD.\n          ELECTRICITY BILL GENERATED FOR THE MONTH OF\n\t\t"+month+",2023 \n");
            ResultSet rs=c.s.executeQuery("Select * from addnewcustomer where meterno='"+meter+"'");
            if(rs.next()){
                area.append("\n\n   Customer Name     :   "+rs.getString("name"));
                area.append("\n    Meter Number        :   "+rs.getString("meterno"));
                area.append("\n    Address                  :   "+rs.getString("address"));
                area.append("\n    City                         :   "+rs.getString("city"));
                area.append("\n    State                       :   "+rs.getString("state"));
                area.append("\n    Pincode                  :   "+rs.getString("pincode"));
                area.append("\n    Mobile No.              :   "+rs.getString("phone"));
                area.append("\n    Email                       :   "+rs.getString("email"));  
                area.append("\n--------------------------------");  
                area.append("\n");  

            }
        
            rs=c.s.executeQuery("Select * from meterinfo where meter_no='"+meter+"'");
            if(rs.next()){
                
                area.append("\n    Meter Location       :   "+rs.getString("meter_location"));
                area.append("\n    Meter Type             :   "+rs.getString("meter_Type"));
                area.append("\n    Phase Code           :   "+rs.getString("phase_code"));
                area.append("\n    Bill Type                  :   "+rs.getString("bill_type"));
                area.append("\n    Days                       :   "+rs.getString("days"));
                area.append("\n--------------------------------");  
                area.append("\n");    
            }
            
            rs=c.s.executeQuery("Select * from billcost ");
            if(rs.next()){
                
                area.append("\n    Cost Per Unit                 :   "+rs.getString("cost_per_unit"));
                area.append("\n    Meter Rent                     :   "+rs.getString("meter_rent"));
                area.append("\n    Service Charge             :   "+rs.getString("service_charge"));
                area.append("\n    Swachh Bharat Cess    :   "+rs.getString("swacch_bharat_cess"));
                area.append("\n    Fixed Tax                       :   "+rs.getString("fixed_tax"));
                area.append("\n--------------------------------");  
                area.append("\n"); 
                
                
            }
            rs=c.s.executeQuery("Select * from bill where Meter_number='"+meter+"' and month='"+month+"' ");
            if(rs.next()){
                
                area.append("\n    Current Month                :   "+rs.getString("Month"));
                area.append("\n    Unit Consumed              :   "+rs.getString("Units"));
                area.append("\n    Total Charges                :   "+rs.getString("Total_Bill"));
                area.append("\n    Status                             :   "+rs.getString("Status"));
                area.append("\n--------------------------------");  
                area.append("\n    Total Payable                 :   "+rs.getString("Total_Bill"));
                area.append("\n"); 
                
                
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Generatebill("");
    }
}
