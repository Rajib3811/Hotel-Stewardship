
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class HotelManagementSystem extends JFrame implements ActionListener {
    HotelManagementSystem()
    {
        setBounds(15,5,1366,565);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Icons/first.jpg"));
        JLabel l1=new JLabel(i1);
        l1.setBounds(0,0,1366,565);
        add(l1);
        
        JLabel l2=new JLabel("Hotel Management System");
        l2.setBounds(50,440,300,100);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("serif",Font.PLAIN,20));
        l1.add(l2);
        
        JButton b1=new JButton("Next");
        b1.setBounds(1150,450,150,50);
        b1.setBackground(Color.CYAN);
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        l1.add(b1);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        
       while(true){
           l2.setVisible(false);
           try{
               Thread.sleep(500);
           }catch(Exception e){
       }
           l2.setVisible(true);
           try{
               Thread.sleep(500);
    }catch(Exception e){
        
    }
       }
    }
    
    public void actionPerformed(ActionEvent ae){
        new Login().setVisible(true);
        this.setVisible(false);
    }
    public static void main(String[] args) {
        new HotelManagementSystem();
    }
}

    
