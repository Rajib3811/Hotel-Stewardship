
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class Room extends JFrame implements ActionListener {
    
    JTable t1;
    JButton b1,b2;
    JLabel l1,l2,l4,l3,l5,l6;
    
    Room(){
        
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Icons/eight.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        l1=new JLabel(i3);
        l1.setBounds(490,8,640,600);
        add(l1);
        
        t1=new JTable();
        t1.setBounds(0,40,500,400);
        add(t1);
        
        
        
        
        l2 =new JLabel("Room Number");
        l2.setBounds(10,10,100,20);
        add(l2);
        
        l3 =new JLabel("Availability");
        l3.setBounds(108,10,80,20);
        add(l3);
        
        l4=new JLabel("Status");
        l4.setBounds(210,10,80,20);
        add(l4);
        
        l5 =new JLabel("Price");
        l5.setBounds(310,10,60,20);
        add(l5);
        
        l5 =new JLabel("Bad Type");
        l5.setBounds(405,10,100,20);
        add(l5);
        
        
        
        
        
        b1=new JButton("Load Data");
        b1.setBounds(100,460,120,30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.black);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("Back");
        b2.setBounds(250,460,120,30);
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.WHITE);
        
        setBounds(185,140,1130,600);
        setLayout(null);
        setVisible(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1){
            try{
            Conn cn = new Conn();
            ResultSet rs = cn.s.executeQuery("select * from room");
            t1.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception ee){
            ee.printStackTrace();
        }
        }else if(e.getSource()==b2){
            new Reception().setVisible(true);
            setVisible(false);
        }
        
    }
    
    
    public static void main(String[] args) {
        new Room();
    }
}
