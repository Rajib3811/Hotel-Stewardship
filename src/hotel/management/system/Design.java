
//package hotel.management.system;

import java.awt.*;
import javax.swing.*;


public class Design {
    
    
    public static void main(String[] args) {
        
       ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Icons/s2.jpg"));
       Image i2=icon.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);

        JOptionPane.showMessageDialog(null, "Whatever","this is a message",JOptionPane.PLAIN_MESSAGE,i3);
    }
    
    
}
