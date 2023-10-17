
package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class AddDriver extends JFrame implements ActionListener {
    
    JTextField t1,t2,t3,t4,t5;
    JComboBox c1,c2;
    JButton b1,b2;
    
    AddDriver(){
    
        JLabel title=new JLabel("Add Driver");
        title.setFont(new Font("Tahoma",Font.BOLD,18));
        title.setBounds(150,10,150,30);
        add(title);
        
        JLabel name=new JLabel("Name");
        name.setFont(new Font("Tahoma",Font.PLAIN,14));
        name.setBounds(60,70,100,30);
        add(name);
        
        t1=new JTextField();
        t1.setBounds(200,70,150,30);
        add(t1);
        
        JLabel age=new JLabel("Age");
        age.setFont(new Font("Tahoma",Font.PLAIN,14));
        age.setBounds(60,110,100,30);
        add(age);
        
        t2=new JTextField("");
        t2.setBounds(200,110,150,30);
        add(t2);
        
        JLabel gender=new JLabel("Gender");
        gender.setFont(new Font("Tahoma",Font.PLAIN,14));
        gender.setBounds(60,150,100,30);
        add(gender);
        
        c1=new JComboBox(new String [] {"Male","female"});
        c1.setBackground(Color.WHITE);
        c1.setBounds(200,150,150,30);
        add(c1);
        
        JLabel company=new JLabel("Car Company");
        company.setFont(new Font("Tahoma",Font.PLAIN,14));
        company.setBounds(60,190,100,30);
        add(company);
        
        t3=new JTextField("");
        t3.setBounds(200,190,150,30);
        add(t3);
        
        JLabel model=new JLabel("Car Brand");
        model.setFont(new Font("Tahoma",Font.PLAIN,14));
        model.setBounds(60,230,100,30);
        add(model);
        
        t4=new JTextField();
        t4.setBounds(200,230,150,30);
        add(t4);
        
        JLabel available=new JLabel("Available");
        available.setFont(new Font("Tahoma",Font.PLAIN,14));
        available.setBounds(60,270,100,30);
        add(available);
        
        c2=new JComboBox(new String[] {"Yes","No"});
        c2.setBackground(Color.WHITE);
        c2.setBounds(200,270,150,30);
        add(c2);
        
        JLabel location=new JLabel("Location");
        location.setFont(new Font("Tahoma",Font.PLAIN,14));
        location.setBounds(60,310,100,30);
        add(location);
        
         t5=new JTextField();
        t5.setBounds(200,310,150,30);
        add(t5);
        
        b1=new JButton("Add Driver");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(60,370,130,30);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(210,370,130,30);
        b2.addActionListener(this);
        add(b2);
               
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Icons/eleven.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel ll=new JLabel(i3);
        ll.setBounds(400,50,500,300);
        add(ll);
        
        getContentPane().setBackground(Color.WHITE);
        
        setBounds(200,140,1000,470);
        setLayout(null);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
    }
    public void actionPerformed (ActionEvent e){
        if(e.getSource()==b1){
            
            String name = t1.getText();
            String age = t2.getText();
            String car_company = t3.getText();
            String car_model = t4.getText();
            String location = t5.getText();
            String gender = (String)c1.getSelectedItem();
            String available = (String)c2.getSelectedItem();
            
             if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name should not be empty");
                return;
            }
            if (age.equals("")) {
                JOptionPane.showMessageDialog(null, "Age should not be empty");
                return;
            }
            if (car_company.equals("")) {
                JOptionPane.showMessageDialog(null, "Car company should not be empty");
                return;
            }
            if (car_model.equals("")) {
                JOptionPane.showMessageDialog(null, "Car model should not be empty");
                return;
            }
            if (location.equals("")) {
                JOptionPane.showMessageDialog(null, "Location should not be empty");
                return;
            }
            try {   //name, age, gender, company, branch, available, location
                Conn c = new Conn();
                String query = "insert into driver values('" + name + "', '" + age + "', '" + gender + "', '" + car_company + "', '"+ car_model + "', '"+ available + "', '" + location + "')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Driver added sucessfully");
                setVisible(false);

            } catch (Exception e1) {
                e1.printStackTrace();
            }
            
            
        }else if(e.getSource()==b2){
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new AddDriver().setVisible(true);
    }
}
