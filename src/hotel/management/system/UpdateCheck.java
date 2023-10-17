package hotel.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class UpdateCheck extends JFrame implements ActionListener {

    JButton b1, b2, b3;
    Choice c1;
    JTextField t1, t2, t3, t4, t5;

    UpdateCheck() {

        JLabel l1 = new JLabel("Check In Details");
        l1.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 20));
        l1.setForeground(Color.blue);
        l1.setBounds(200, 20, 200, 30);
        add(l1);

        JLabel l2 = new JLabel("customer Id");
        l2.setBounds(30, 80, 100, 20);
        add(l2);

        c1 = new Choice();
        c1.setBounds(200, 80, 150, 25);
        add(c1);

        try {
            Conn cn = new Conn();
            ResultSet rs = cn.s.executeQuery("select * from customer");
            while (rs.next()) {
                c1.add(rs.getString("number"));
            }

        } catch (Exception ee) {
            ee.printStackTrace();
        }

        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(30, 120, 100, 20);
        add(l3);

        t1 = new JTextField();
        t1.setBounds(200, 120, 150, 25);
        add(t1);

        JLabel l4 = new JLabel("Name");
        l4.setBounds(30, 160, 100, 20);
        add(l4);

        t2 = new JTextField();
        t2.setBounds(200, 160, 150, 25);
        add(t2);

        JLabel l5 = new JLabel("Check In");
        l5.setBounds(30, 200, 100, 20);
        add(l5);

        t3 = new JTextField();
        t3.setBounds(200, 200, 150, 25);
        add(t3);

        JLabel l6 = new JLabel("Amount Paid");
        l6.setBounds(30, 240, 100, 20);
        add(l6);

        t4 = new JTextField();
        t4.setBounds(200, 240, 150, 25);
        add(t4);

        JLabel l7 = new JLabel("Pending Amount");
        l7.setBounds(30, 280, 150, 25);
        add(l7);

        t5 = new JTextField();
        t5.setBounds(200, 280, 150, 25);
        add(t5);

        b1 = new JButton("Check");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.setBounds(30, 340, 100, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Update");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(150, 340, 100, 30);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Back");
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.setBounds(270, 340, 100, 30);
        b3.addActionListener(this);
        add(b3);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Icons/nine.jpg"));
        JLabel l9 = new JLabel(i1);
        l9.setBounds(400, 50, 500, 300);
        add(l9);

        setLayout(null);
        setBounds(100, 100, 1000, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String id = (String) c1.getSelectedItem();
            String query = "Select * from customer where number = '" + id + "'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery((query));
                while (rs.next()) {
                    t1.setText(rs.getString("room"));
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("chekintime"));
                    t4.setText(rs.getString("deposit"));
                }
                ResultSet rs2 = c.s.executeQuery("select * from room where room_number = '" + t1.getText() + "'");
                while (rs2.next()) {
                    String price = rs2.getString("price");
                    int amountdue = Integer.parseInt(price) - Integer.parseInt(t4.getText());
                    t5.setText("" + amountdue);
                }
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        } else if (e.getSource() == b2) {
            String number = (String) c1.getSelectedItem();
            String room = t1.getText();
            String name = t2.getText();
            String chekintime = t3.getText();
            String deposit = t4.getText();

            if (room.equals("")) {
                JOptionPane.showMessageDialog(null, "Room Number should not be empty");
                return;
            }
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name should not be empty");
                return;
            }
            if (chekintime.equals("")) {
                JOptionPane.showMessageDialog(null, "Chekintime should not be empty");
                return;
            }
            if (deposit.equals("")) {
                JOptionPane.showMessageDialog(null, "Deposit should not be empty");
                return;
            }

            try {   
                Conn c = new Conn();
                String query2 = "update customer set room = '"+room+"', name = '"+ name + "', chekintime = '"+ chekintime + "', deposit = '"+ deposit + "' where number = '" + number + "'";
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Data Updated sucessfully");
                setVisible(false);
                new Reception();

            } catch (Exception e1) {
                e1.printStackTrace();
            }

        } else if (e.getSource() == b3) {
            new Reception().setVisible(true);
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new UpdateCheck();
    }

}
