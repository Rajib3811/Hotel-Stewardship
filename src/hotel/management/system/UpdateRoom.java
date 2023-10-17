package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class UpdateRoom extends JFrame implements ActionListener {

    Choice c1, c2;
    JTextField t1, t2, t3;
    JButton b1, b2, b3, rnb, cidb;

    JLabel tl, l2, l3;
    int count = 0;

    UpdateRoom() {


        cidb = new JButton("By Cust ID");
        cidb.setBounds(30, 16, 100, 30);
        cidb.setVisible(false);
        cidb.setBackground(Color.black);
        cidb.setForeground(Color.white);
        cidb.addActionListener(this);
        add(cidb);

        tl = new JLabel("Through Custmer ID");
        tl.setFont(new Font("Tahoma", Font.BOLD, 18));
        tl.setBounds(185, 25, 215, 30);
        tl.setForeground(Color.RED);
        add(tl);

        rnb = new JButton("By Room NO.");
        rnb.setBounds(415, 16, 110, 30);
        rnb.setBackground(Color.black);
        rnb.setForeground(Color.white);
        rnb.addActionListener(this);
        add(rnb);

        l2 = new JLabel("Guest ID");
        l2.setForeground(Color.blue);
        l2.setBounds(30, 80, 120, 20);
        add(l2);

        c1 = new Choice();
        c1.setBounds(200, 80, 150, 25);
        add(c1);

        c2 = new Choice();
        c2.setBounds(200, 80, 150, 25);
        c2.setVisible(false);
        add(c2);

        try {
            Conn cn = new Conn();
            ResultSet rs = cn.s.executeQuery("select * from customer");
            while (rs.next()) {
                c1.add(rs.getString("number"));
            }

            rs = cn.s.executeQuery("select * from room");
            while (rs.next()) {
                c2.add(rs.getString("room_number"));
            }

        } catch (Exception ee) {
            ee.printStackTrace();
        }

        l3 = new JLabel("Room Number");
        l3.setForeground(Color.blue);
        l3.setBounds(30, 120, 120, 20);
        add(l3);
        t1 = new JTextField();
        t1.setBounds(200, 120, 150, 25);
        add(t1);

        JLabel l4 = new JLabel("Availability");
        l4.setBounds(30, 160, 120, 20);
        l4.setForeground(Color.blue);
        add(l4);

        t2 = new JTextField();
        t2.setBounds(200, 160, 150, 25);
        add(t2);

        JLabel l5 = new JLabel("Clean Status");
        l5.setForeground(Color.blue);
        l5.setBounds(30, 200, 120, 20);
        add(l5);

        t3 = new JTextField();
        t3.setBounds(200, 200, 150, 25);
        add(t3);

        b1 = new JButton("Check");
        b1.setBounds(60, 350, 120, 30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Update");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);;
        b2.setBounds(150, 280, 120, 30);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Back");
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.setBounds(220, 350, 120, 30);
        b3.addActionListener(this);
        add(b3);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(550, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel ll = new JLabel(i3);
        ll.setBounds(0, 0, 550, 500);
        add(ll);

        getContentPane().setBackground(Color.white);

        setLayout(null);
        setBounds(100, 100, 565, 500);
        setVisible(true);
        setTitle("Update Room Status : ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == rnb) {
            count = 1;
            tl.setText("Through Room Number");
            cidb.setVisible(true);
            rnb.setVisible(false);
            c2.setVisible(true);
            c1.setVisible(false);
            l2.setText("Room No.");
            l3.setVisible(false);
            t1.setVisible(false);
            t2.setText("");
            t3.setText("");

        } else if (e.getSource() == cidb) {
            count = 0;
            tl.setText("Through Custmer ID");
            cidb.setVisible(false);
            rnb.setVisible(true);
            c2.setVisible(true);
            c1.setVisible(true);
            l2.setText("Guest ID");
            l3.setVisible(true);
            t1.setVisible(true);
            t2.setText("");
            t3.setText("");
        } else if (e.getSource() == b1) {
            if (count == 0) {

                String id = (String) c1.getSelectedItem();
                String query = "Select * from customer where number = '" + id + "'";
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery((query));
                    while (rs.next()) {
                        t1.setText(rs.getString("room"));

                    }
                    ResultSet rs2 = c.s.executeQuery("select * from room where room_number = '" + t1.getText() + "'");
                    while (rs2.next()) {
                        t2.setText(rs2.getString("availability"));
                        t3.setText(rs2.getString("cleaning_status"));

                    }

                } catch (Exception ee) {
                    ee.printStackTrace();
                }

            } else {
                String no = (String) c2.getSelectedItem();
                String query = "Select * from room where room_number = '" + no + "'";
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery((query));
                    while (rs.next()) {
                        t2.setText(rs.getString("availability"));
                        t3.setText(rs.getString("cleaning_status"));

                    }

                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }

        } else if (e.getSource() == b2) {
            String room_number;
            if (count == 0) {
                room_number = t1.getText();
            } else {
                room_number = (String) c2.getSelectedItem();

            }
            String availability = t2.getText();
            String cleaning_status = t3.getText();

            if (availability.equals("")) {
                JOptionPane.showMessageDialog(null, "Availability should not be empty");
                return;
            }
            if (cleaning_status.equals("")) {
                JOptionPane.showMessageDialog(null, "Clean Status should not be empty");
                return;
            }

            try {
                Conn c = new Conn();
                String query2 = "update room set availability = '" + availability + "', cleaning_status = '" + cleaning_status + "' where room_number = '" + room_number + "'";
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Data Updated sucessfully");
                t1.setText("");
                t2.setText("");
                t3.setText("");

            } catch (Exception e1) {
                e1.printStackTrace();
            }

        } else if (e.getSource() == b3) {
            new Reception().setVisible(true);
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new UpdateRoom();
    }
}
