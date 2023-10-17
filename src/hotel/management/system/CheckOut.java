
package hotel.management.system;
import java.awt.*;
import javax.swing.*;
//import java.sql.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;


public class CheckOut extends JFrame implements ActionListener {
    Choice c1;
    JLabel rn,cint,cout;
    JButton b1,b2,b3;
    CheckOut(){
    JLabel l1=new JLabel("Check Out");
    l1.setBounds(50,20,100,30);
    l1.setForeground(Color.BLUE);
    l1.setFont(new Font("Tahoma",Font.PLAIN,20));
    add(l1);
    
    
    JLabel l2=new JLabel("Customer Id");
    l2.setBounds(30,80,100,30);
    add(l2);
    
c1 = new Choice();
try{
    Conn c=new Conn();
    ResultSet rs = c.s.executeQuery("select * from customer");
    while(rs.next()){
        c1.add(rs.getString("number"));
    }
}catch(Exception e){
    
}
    c1.setBounds(200,80,150,30);
    add(c1);
    
    JLabel l3=new JLabel("Room Number");
    l3.setBounds(30,130,100,30);
    add(l3);
    rn=new JLabel();
    rn.setBounds(200,130,150,30);
    add(rn);
    
    JLabel lc=new JLabel("Checkin Time");
    lc.setBounds(30,180,100,30);
    add(lc);
    cint=new JLabel();
    cint.setBounds(200,180,175,30);
    add(cint);
    
    JLabel l5=new JLabel("Checkout Time");
    l5.setBounds(30,230,100,30);
    add(l5);
    
    cout=new JLabel();
    cout.setBounds(200,230,175,30);
    add(cout);
    
    
    
    b1=new JButton("CheckOut");
    b1.setBackground(Color.black);
    b1.setForeground(Color.white);
    b1.setBounds(65,300,120,30);
    b1.addActionListener(this);
    add(b1);
    
    b2=new JButton("Back");
    b2.setBackground(Color.black);
    b2.setForeground(Color.white);
    b2.setBounds(235,300,120,30);
    b2.addActionListener(this);
    add(b2);
    
    getContentPane().setBackground(Color.WHITE);
    
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Icons/tick.png"));
    Image i2=i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    b3=new JButton(i3);
    b3.setBounds(360,80,20,20);
    b3.addActionListener(this);
    add(b3);
    
    ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Icons/sixth.jpg"));
    Image i5=i4.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
    ImageIcon i6=new ImageIcon(i5);
    JLabel l4=new JLabel(i6);
    l4.setBounds(450,05,400,250);
    add(l4);
    
    
    setLayout(null);
    setBounds(300,200,900,400);
    setVisible(true);
    
    
    
    }
    

    
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==b1){
            
            String id=(String) c1.getSelectedItem();
            String room =rn.getText();
            String str="delete from customer where number = '"+id+"'";
            String str2 = "update room set availability = 'Available' where room_number = '"+room+"'";
            Conn c=new Conn();
            try{
                c.s.executeUpdate(str);
                c.s.executeUpdate(str2);
                JOptionPane.showMessageDialog(null,"CheckOut Done");
                new Reception().setVisible(true);
                this.setVisible(false);
            }catch(Exception e){}
            
        }else if(ae.getSource()==b2){
            
            new Reception().setVisible(true);
            this.setVisible(false);
            
        }else if(ae.getSource()==b3){
            Date dt = new Date();
            cout.setText(""+dt);
            Conn c=new Conn();
            String id=c1.getSelectedItem();
            try{
                ResultSet rs=c.s.executeQuery("select * from customer where number = '"+id+"'");
                while(rs.next()){
                    rn.setText(rs.getString("room"));
                    cint.setText(rs.getString("chekintime"));
                }
            }catch(Exception e){}
            
        }
    }
    
    public static void main(String[] args) {
        
        new CheckOut();
    }
}