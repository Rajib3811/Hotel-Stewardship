
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Manjur extends JFrame implements ActionListener{
    JTextField t1;
    JButton b1;
    Manjur(){
        
        t1=new JTextField();
        t1.setBounds(100,200,200,30);
        add(t1);
        
        b1=new JButton("Manjur Alam");
        b1.setBounds(200,300,200,30);
        b1.addActionListener(this);
        add(b1);
        
        getContentPane().setBackground(Color.pink);
        setLayout(null);
        setBounds(100,20,1000,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public void actionPerformed(ActionEvent e){
       t1.setText("Manjur Alam");
        
    }
    
    public static void main(String[] args) {
        new Manjur();
    }
}
