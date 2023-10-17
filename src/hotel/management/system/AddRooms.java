package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6;
    JComboBox c1, c2, c3;
    JTextField t1, t2;
    JButton b1, b2;

    AddRooms() {

        l1 = new JLabel("Add Rooms");
        l1.setBounds(140, 20, 100, 20);
        l1.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(l1);

        l2 = new JLabel("Room Numbers");
        l2.setBounds(60, 80, 110, 30);
        l2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(l2);

        t1 = new JTextField();
        t1.setBounds(200, 80, 150, 30);
        add(t1);

        l3 = new JLabel("Available");
        l3.setBounds(60, 130, 110, 30);
        l3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(l3);

        c1 = new JComboBox(new String[]{"Available", "Occupaied"});
        c1.setBackground(Color.WHITE);
        c1.setBounds(200, 130, 150, 30);;
        add(c1);

        l4 = new JLabel("Cleaning Status");
        l4.setBounds(60, 180, 110, 30);
        l4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(l4);

        c2 = new JComboBox(new String[]{"Cleaned", "Dirty"});
        c2.setBackground(Color.WHITE);
        c2.setBounds(200, 180, 150, 30);;
        add(c2);

        l5 = new JLabel("Price");
        l5.setBounds(60, 230, 180, 30);
        l5.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(l5);

        t2 = new JTextField();
        t2.setBounds(200, 230, 150, 30);
        add(t2);

        l6 = new JLabel("Bed Type");
        l6.setBounds(60, 280, 180, 30);
        l6.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(l6);

        c3 = new JComboBox(new String[]{"Single Bed", "Double Bed"});
        c3.setBackground(Color.WHITE);
        c3.setBounds(200, 280, 150, 30);
        add(c3);

        b1 = new JButton("Add Room");
        b1.setBounds(60, 350, 130, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);

        add(b1);

        b2 = new JButton("Cemcel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(250, 350, 130, 30);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Icons/twelve.jpg"));
        JLabel l7 = new JLabel(i1);
        l7.setBounds(400, 30, 500, 350);
        add(l7);

        getContentPane().setBackground(Color.WHITE);

        setBounds(200, 150, 950, 470);
        setLayout(null);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {

            String roomNumbers = t1.getText();
            String price = t2.getText();

            if (roomNumbers.equals("")) {
                JOptionPane.showMessageDialog(null, "Room number should not be empty");
                return;
            }
            if (price.equals("")) {
                JOptionPane.showMessageDialog(null, "price should not be empty");
                return;
            }

            String available = (String) c1.getSelectedItem();
            String cliningStatus = (String) c2.getSelectedItem();
            String bedType = (String) c3.getSelectedItem();

            try {
                Conn c = new Conn();
                String query = "insert into room values('" + roomNumbers + "', '" + available + "', '" + cliningStatus + "', '" + price + "', '" + bedType + "')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Romm added sucessfully");
                setVisible(false);

            } catch (Exception e1) {
                e1.printStackTrace();
            }

        } else if (e.getSource() == b2) {
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new AddRooms().setVisible(true);
    }
}
