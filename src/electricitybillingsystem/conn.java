/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricitybillingsystem;
import java.sql.*;
/**
 *
 * @author ashut
 */
public class conn {
    Connection c;
    Statement s;

    conn(){
       
    try{
        c=DriverManager.getConnection("jdbc:mysql:///ElectricityBillingSystem","root","140600");
        s=c.createStatement();
    }catch(Exception e){
        e.printStackTrace();
    }     
    }
    public static void main(String[] args){
        new conn();
    }
}
