
package hotel.management.system;

import java.awt.*;
import javax.swing.*;


public class Wlcm extends JFrame {
    Wlcm(){
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Icons/red.jpg"));
        Image i2=i1.getImage().getScaledInstance(2000,750,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon (i2);
        
        JLabel l1=new JLabel(i3);
        l1.setBounds(0,0,2000,750);
        add(l1);
        
        JLabel l2=new JLabel("Rabiul Welcomes everyone");
        l2.setFont(new Font("Tahoma",Font.PLAIN,30));
        l2.setForeground(Color.YELLOW);
        l2.setBounds(500,5,500,200);
        l1.add(l2);
      
        
        
    
    setLayout(null);
    setBounds(0,0,2000,750);
    setVisible(true);
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
   
           try{
               Thread.sleep(2000);
           }catch(Exception e){
       }
           setVisible(false);
          
           
         try{
             new Login().setVisible(true);
         }catch(Exception e){
             
         }
           
    
        }
        
    
    public static void main(String[] args) {
        new Wlcm();
    }
}
