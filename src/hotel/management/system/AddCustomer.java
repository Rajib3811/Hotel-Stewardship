package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class AddCustomer extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
    JTextField f1, f2, f3, f4, f5;
    JComboBox c1;
    Choice c2;
    JRadioButton r1, r2;
    JButton b1, b2;

    AddCustomer() {

        l1 = new JLabel("New Customer Form");
        l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        l1.setForeground(Color.BLUE);
        l1.setBounds(100, 20, 300, 30);
        add(l1);

        l2 = new JLabel("ID");
        l2.setFont(new Font("Tahoma", Font.BOLD, 16));
        l2.setBounds(35, 80, 100, 20);
        add(l2);

        c1 = new JComboBox(new String[]{"Passport", "Voter-Id card", "Driving License", "aadhar Card"});
        c1.setBounds(200, 80, 170, 25);
        c1.setBackground(Color.WHITE);
        c1.setForeground(Color.BLACK);
        add(c1);

        l3 = new JLabel("Number");
        l3.setFont(new Font("Tahoma", Font.BOLD, 16));
        l3.setBounds(35, 140, 100, 20);
        add(l3);

        f1 = new JTextField();
        f1.setBounds(200, 140, 170, 30);
        add(f1);

        l4 = new JLabel("Name");
        l4.setFont(new Font("Tahoma", Font.BOLD, 16));
        l4.setBounds(35, 200, 100, 20);
        add(l4);

        f2 = new JTextField();
        f2.setBounds(200, 200, 170, 30);
        add(f2);

        l5 = new JLabel("Gender");
        l5.setFont(new Font("Tahoma", Font.BOLD, 16));
        l5.setBounds(35, 260, 100, 20);
        add(l5);
        r1 = new JRadioButton("Male");
        r1.setBackground(Color.WHITE);
        r1.setBounds(200, 260, 60, 20);
        add(r1);

        r2 = new JRadioButton("FeMale");
        r2.setBackground(Color.WHITE);
        r2.setBounds(290, 260, 80, 20);
        add(r2);

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        l6 = new JLabel("Country");
        l6.setFont(new Font("Tahoma", Font.BOLD, 16));
        l6.setBounds(35, 320, 100, 20);
        add(l6);

        f3 = new JTextField();
        f3.setBounds(200, 320, 170, 30);
        add(f3);

        l7 = new JLabel("Room Number");
        l7.setFont(new Font("Tahoma", Font.BOLD, 16));
        l7.setBounds(35, 380, 150, 20);
        add(l7);

        c2 = new Choice();
        
        try{
            Conn cn = new Conn();
            String query = "select * from room where availability = 'Available'";
            ResultSet rs  = cn.s.executeQuery(query);
            while(rs.next()){
                c2.add(rs.getString("room_number"));
            }
            
        }catch(Exception e1){
            e1.printStackTrace();
        }
        
        c2.setBackground(Color.WHITE);
        c2.setBounds(200, 380, 170, 30);
        add(c2);
        
        
        l8 = new JLabel("Checked In");
        l8.setFont(new Font("Tahoma", Font.BOLD, 16));
        l8.setBounds(35, 440, 100, 20);
        add(l8);
        
        Date date = new Date();
        f4 = new JTextField(""+date);
        f4.setBounds(200, 440, 170, 30);
        add(f4);

        l9 = new JLabel("Deposit");
        l9.setFont(new Font("Tahoma", Font.BOLD, 16));
        l9.setBounds(35, 500, 100, 20);
        add(l9);

        f5 = new JTextField();
        f5.setBounds(200, 500, 170, 30);
        add(f5);

        getContentPane().setBackground(Color.WHITE);

        b1 = new JButton("Add Customer");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(100, 570, 120, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(300, 570, 120, 30);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_FAST);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel ll = new JLabel(i3);
        ll.setBounds(400, 50, 400, 500);
        add(ll);

        setBounds(285, 105, 800, 650);
        setLayout(null);
        setVisible(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {

            String document = (String) c1.getSelectedItem();
            String number = f1.getText();
            String name = f2.getText();
            String gender = "";
            if (r1.isSelected()) {
                gender = "Male";
            } else {
                gender = "Female";
            }
            String country = f3.getText();
            String room = (String) c2.getSelectedItem();
            String chekintime = f4.getText();
            String deposit = f5.getText();

            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Number should not be empty");
                return;
            }
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name should not be empty");
                return;
            }
            if (gender.equals("")) {
                JOptionPane.showMessageDialog(null, "Gender should not be empty");
                return;
            }
            if (country.equals("")) {
                JOptionPane.showMessageDialog(null, "Country should not be empty");
                return;
            }
            if (chekintime.equals("")) {
                JOptionPane.showMessageDialog(null, "Cheked in should not be empty");
                return;
            }
            if (deposit.equals("")) {
                JOptionPane.showMessageDialog(null, "Deposit should not be empty");
                return;
            }

            try {
                Conn c = new Conn();
                String query = "insert into customer values('" + document + "', '" + number + "', '" + name + "', '" + gender + "', '" + country + "', '" + room + "', '" + chekintime + "', '" + deposit + "')";
                String query2 = "update room set availability = 'Occupied' where room_number = '"+ room + "'";
                c.s.executeUpdate(query);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Customer added sucessfully");
                setVisible(false);

            } catch (Exception e1) {
                e1.printStackTrace();
            }

        } else if (e.getSource() == b2) {
            new Reception().setVisible(true);
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new AddCustomer();
    }

}
