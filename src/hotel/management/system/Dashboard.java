package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {

    JMenuBar mb;
    JMenu m1, m2;
    JMenuItem i1, i2, i3, i4;

    Dashboard() {

        mb = new JMenuBar();
        add(mb);
        mb.setBounds(0, 0, 1480, 30);

        m1 = new JMenu("HOTEL MANAGEMENT");
        m1.setForeground(Color.RED);
        mb.add(m1);

        m2 = new JMenu("ADMIN");
        m2.setForeground(Color.BLUE);
        mb.add(m2);

        i1 = new JMenuItem("RECEPTION");
        m1.add(i1);
        i1.addActionListener(this);

        i2 = new JMenuItem("ADD EMPLOYEE");
        m2.add(i2);
        i2.addActionListener(this);

        i3 = new JMenuItem("ADD ROOMS");
        m2.add(i3);
        i3.addActionListener(this);

        i4 = new JMenuItem("ADD DRIVERS");
        m2.add(i4);
        i4.addActionListener(this);

        ImageIcon ii = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Icons/third.jpg"));
        Image ii1 = ii.getImage().getScaledInstance(2000, 750, Image.SCALE_DEFAULT);
        ImageIcon ii2 = new ImageIcon(ii1);

        JLabel l1 = new JLabel(ii2);
        l1.setBounds(0, 0, 2000, 750);
        add(l1);

        JLabel l2 = new JLabel("TAJGROUP WELCOMES YOU");
        l2.setBounds(500, 50, 700, 50);
        l2.setForeground((Color.WHITE));
        l2.setFont(new Font("Tahoma", Font.PLAIN, 30));
        l1.add(l2);

        setLayout(null);
        setBounds(0, 0, 2000, 750);
        setVisible(true);
//       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("RECEPTION")) {

            new Reception().setVisible(true);
        } else if (e.getActionCommand().equals("ADD EMPLOYEE")) {
            new AddEmployee().setVisible(true);

        } else if (e.getActionCommand().equals("ADD ROOMS")) {
            new AddRooms().setVisible(true);
        } else if (e.getActionCommand().equals("ADD DRIVERS")) {
            new AddDriver().setVisible(true);
        }

    }

    public static void main(String[] args) {
        new Dashboard().setVisible(true);
    }

}
