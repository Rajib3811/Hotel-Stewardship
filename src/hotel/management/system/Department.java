package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;


public class Department extends JFrame implements ActionListener {

    JButton b1, b2;
    JTable t1;

    Department() {

        JLabel l1 = new JLabel("Department");
        l1.setBackground(Color.WHITE);
        l1.setForeground(Color.BLUE);
        l1.setBounds(170, 10, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Budget");
        l2.setBackground(Color.WHITE);
        l2.setForeground(Color.BLUE);
        l2.setBounds(480, 10, 100, 20);
        add(l2);


        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(250, 400, 120, 30);
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(Color.WHITE);

        t1 = new JTable();
        t1.setBounds(0, 50, 700, 350);
        add(t1);

        try {
            Conn cn = new Conn();
            ResultSet rs = cn.s.executeQuery("select * from department");
            t1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception ee) {
            ee.printStackTrace();
        }

        setBounds(300, 150, 700, 480);
        setLayout(null);
        setVisible(true);
//    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b2) {
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Department().setVisible(true);
    }

}
