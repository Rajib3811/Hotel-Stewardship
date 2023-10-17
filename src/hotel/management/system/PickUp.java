
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;
//import net.proteanit.sql.DbUtils;
//import java.sql.*;


public class PickUp extends JFrame implements ActionListener {

  Choice c1;
    JButton b1,b2;
    JTable t1;
    
PickUp()
{
    
    JLabel l1=new JLabel("PickUp Service");
    l1.setFont(new Font("Tahoma",Font.PLAIN,20));
    l1.setForeground(Color.BLUE);
    l1.setBounds(400,30,200,30);
    add(l1);
    
    
    JLabel l2=new JLabel("Type Of Car");
    l2.setBounds(50,100,100,20);
    add(l2);
    
  c1 = new Choice();
  try{
      Conn c=new Conn();
      ResultSet rs = c.s.executeQuery("select * from driver");
      while(rs.next()){
          c1.add(rs.getString("brand"));
      }
      c1.add("All");
  }catch(Exception e){
      
  }
    c1.setBounds(150,100,0200,25);
    add(c1);
    
   
    
    
    b1=new JButton("Submit");
    b1.setBackground(Color.BLACK);
    b1.setForeground(Color.WHITE);
    b1.setBounds(300,520,120,30);
    b1.addActionListener(this);
    add(b1);
    
    b2=new JButton("Back");
    b2.setBackground(Color.BLACK);
    b2.setForeground(Color.WHITE);
    b2.setBounds(500,520,120,30);
    b2.addActionListener(this);
    add(b2);
    
    getContentPane().setBackground(Color.WHITE);
    
     JLabel l3=new JLabel("Name");
    l3.setBounds(30,160,100,20);
    add(l3);
    
     JLabel l4=new JLabel("Age");
    l4.setBounds(160,160,100,20);
    add(l4);
    
     JLabel l5=new JLabel("Gender");
    l5.setBounds(305,160,100,20);
    add(l5);
    
     JLabel l6=new JLabel("Company");
    l6.setBounds(460,160,100,20);
    add(l6);
    
     JLabel l7=new JLabel("Brand");
    l7.setBounds(610,160,100,20);
    add(l7);
    
    JLabel l8=new JLabel("Availability ");
    l8.setBounds(740,160,100,20);
    add(l8);
    
    JLabel l9=new JLabel("Location");
    l9.setBounds(890,160,100,20);
    add(l9);
    
    t1=new JTable();
    t1.setBounds(0,200,1000,300);
    add(t1);
    
    setBounds(200,50,1000,650);
    setLayout(null);
    setVisible(true);
//    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
  
    
}

public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==b1){
        
        
        try{ 
            String br = (String) c1.getSelectedItem();
            String str="select * from driver where brand = '"+c1.getSelectedItem()+"'";
            Conn c=new Conn();
            ResultSet rs =c.s.executeQuery(str);
            if(br.equals("All")){
                rs = c.s.executeQuery("select * from driver");
               t1.setModel(DbUtils.resultSetToTableModel(rs));
            }else{
               t1.setModel(DbUtils.resultSetToTableModel(rs));  
            }
        }catch(Exception e){
        System.out.println(e);
        }
    }else if(ae.getSource()==b2){
        new Reception().setVisible(true);
        this.setVisible(false);
    }
}

    public static void main(String[] args) {
        new PickUp().setVisible(true);
    }
    
}
