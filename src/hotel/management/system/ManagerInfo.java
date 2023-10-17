
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;


public class ManagerInfo extends JFrame implements ActionListener{
    JTable t1;
    JButton b1,b2;
    ManagerInfo(){
        
        t1=new JTable();
        t1.setBounds(0,40,1000,500);
        add(t1);
        
        JLabel l1=new JLabel("Name");
        l1.setBounds(25,10,70,20);
        add(l1);
        
        JLabel l2=new JLabel("Age");
        l2.setBounds(140,10,70,20);
        add(l2);
        
        JLabel l3=new JLabel("Gender");
        l3.setBounds(260,10,70,20);
        add(l3);
        
        JLabel l4=new JLabel("Department");
        l4.setBounds(385,10,70,20);
        add(l4);
        
        JLabel l5=new JLabel("Salary");
        
        l5.setBounds(510,10,70,20);
        add(l5);
        
        JLabel l6=new JLabel("Phone");
        l6.setBounds(640,10,70,20);
        add(l6);
        
        JLabel l7=new JLabel("Eamil");
        l7.setBounds(770,10,70,20);
        add(l7);
        
        JLabel l8=new JLabel("Aadhar");
        l8.setBounds(900,10,70,20);
        add(l8);
        
        
        b1=new JButton("Load Data");
        b1.setBounds(300,600,120,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("Back");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(550,600,120,30);
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.white);
        
        
        setBounds(100,10,1050,700);
        setLayout(null);
        setVisible(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1){
            
             try {
            Conn cn = new Conn();
            ResultSet rs = cn.s.executeQuery("select * from employee where job = 'Manager'");
            t1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception ee) {
            ee.printStackTrace();
        }
            
        }else if(e.getSource() ==b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    
    
    public static void main(String[] args) {
        new ManagerInfo();
    }
}
