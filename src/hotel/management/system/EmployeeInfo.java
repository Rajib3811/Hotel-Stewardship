package hotel.management.system;

import java.awt.Color;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class EmployeeInfo extends JFrame implements ActionListener {

    JTable t1;
    JButton b1, b2;

    EmployeeInfo() {

        t1 = new JTable();
        t1.setBounds(2, 40, 1400, 500);
        add(t1);

        JLabel l1 = new JLabel("Name");
        l1.setBounds(40, 10, 70, 20);
        add(l1);

        JLabel l2 = new JLabel("Age");
        l2.setBounds(250, 10, 70, 20);
        add(l2);

        JLabel l3 = new JLabel("Gender");
        l3.setBounds(290, 10, 70, 20);
        l3.setBounds(400, 10, 70, 20);
        add(l3);

        JLabel l4 = new JLabel("Department");

        l4.setBounds(590, 10, 70, 20);
        add(l4);

        JLabel l5 = new JLabel("Salary");
        l5.setBounds(775, 10, 70, 20);
        add(l5);

        JLabel l6 = new JLabel("Phone");
        l6.setBounds(910, 10, 70, 20);
        add(l6);

        JLabel l7 = new JLabel("Email");
        l7.setBounds(1100, 10, 70, 20);
        add(l7);

        JLabel l8 = new JLabel("Adhar");
        l8.setBounds(1240, 10, 70, 20);
        add(l8);

        b1 = new JButton("Load Data");
        b1.setBounds(500, 560, 120, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBounds(680, 560, 120, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);

        setBounds(20, 50, 1350, 650);
        setLayout(null);
        setVisible(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {

            try {
                Conn cn = new Conn();
                ResultSet rs = cn.s.executeQuery("select * from employee");
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception ee) {
                ee.printStackTrace();
            }

        } else if (e.getSource() == b2) {
            new Reception().setVisible(true);
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new EmployeeInfo();
    }
}
