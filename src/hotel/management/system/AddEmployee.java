package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField t1, t2, t5, t6, t7, t8;
    JRadioButton r1, r2;
    JComboBox c1;
    JButton b1;

    AddEmployee() {

        JLabel name = new JLabel("NAME");
        name.setFont(new Font("Tahoma", Font.PLAIN, 17));
        name.setBounds(60, 30, 120, 30);
        add(name);

        t1 = new JTextField();
        t1.setBounds(200, 30, 150, 30);
        add(t1);

        JLabel age = new JLabel("AGE");
        age.setFont(new Font("Tahoma", Font.PLAIN, 17));
        age.setBounds(60, 80, 120, 30);
        add(age);

        t2 = new JTextField();
        t2.setBounds(200, 80, 150, 30);
        add(t2);
//        
        JLabel gender = new JLabel("GENDER");
        gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        gender.setBounds(60, 130, 120, 30);
        add(gender);
        r1 = new JRadioButton("Male");
        r1.setBackground(Color.WHITE);
        r1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        r1.setBounds(200, 130, 70, 30);
        add(r1);

        r2 = new JRadioButton("Famale");
        r2.setBackground(Color.WHITE);
        r2.setBounds(280, 130, 70, 30);
        r2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(r2);

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        JLabel job = new JLabel("JOB");
        job.setFont(new Font("Tahoma", Font.PLAIN, 17));
        job.setBounds(60, 180, 120, 30);
        add(job);

        String str[] = {"Front desk clerks", "Porters", "Manager", "HouseKeeping", "KItchen Staff", "Room Service", "Waiter/Waitress", "Accountant", "Chef",};
        c1 = new JComboBox(str);
        c1.setBackground(Color.WHITE);
        c1.setBounds(200, 180, 150, 30);
        add(c1);
//        
        JLabel salary = new JLabel("SALARY");
        salary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        salary.setBounds(60, 230, 120, 30);
        add(salary);
//        
        t5 = new JTextField();
        t5.setBounds(200, 230, 150, 30);
        add(t5);

        JLabel phone = new JLabel("PHONE");
        phone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        phone.setBounds(60, 280, 120, 30);
        add(phone);

        t6 = new JTextField();
        t6.setBounds(200, 280, 150, 30);
        add(t6);
//        
        JLabel aadhar = new JLabel("AADHAR");
        aadhar.setFont(new Font("Tahoma", Font.PLAIN, 17));
        aadhar.setBounds(60, 330, 120, 30);
        add(aadhar);

        t7 = new JTextField();
        t7.setBounds(200, 330, 150, 30);
        add(t7);
        //  
        JLabel email = new JLabel("EMAIL");
        email.setFont(new Font("Tahoma", Font.PLAIN, 17));
        email.setBounds(60, 380, 120, 30);
        add(email);

        t8 = new JTextField();
        t8.setBounds(200, 380, 150, 30);
        add(t8);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel jl = new JLabel(i3);
        jl.setBounds(400, 60, 500, 380);
        add(jl);

        JLabel jl1 = new JLabel("ADD EMPLOYEE DATABASE");
        jl1.setForeground(Color.BLUE);
        jl1.setFont(new Font("Tahoma", Font.PLAIN, 30));
        jl1.setBounds(450, 30, 400, 30);
        add(jl1);

        b1 = new JButton("SUBMIT");
        b1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        b1.setBounds(200, 430, 150, 40);
        b1.setBackground(Color.black);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setVisible(true);
        setBounds(250, 150, 900, 550);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent ae) {

        String name = t1.getText();
        String age = t2.getText();
        String salary = t5.getText();
        String phone = t6.getText();
        String aadhar = t7.getText();
        String email = t8.getText();

        if (name.equals("")) {
            JOptionPane.showMessageDialog(null, "Name should not be empty");
            return;
        }
        if (age.equals("")) {
            JOptionPane.showMessageDialog(null, "Age should not be empty");
            return;
        } else if (!r1.isSelected() && !r2.isSelected()) {
            JOptionPane.showMessageDialog(null, "Please select your gender");
            return;
        } else if (salary.equals("")) {
            JOptionPane.showMessageDialog(null, "Salary should not be empty");
            return;
        } else if (phone.equals("")) {
            JOptionPane.showMessageDialog(null, "Phone should not be empty");
            return;
        } else if (aadhar.equals("")) {
            JOptionPane.showMessageDialog(null, "Aadhar should not be empty");
            return;
        } else if (email.equals("")) {
            JOptionPane.showMessageDialog(null, "Email should not be empty");
            return;
        }

        String gender = null;
        if (r1.isSelected()) {
            gender = "male";
        }
        if (r2.isSelected()) {
            gender = "Female";
        }

        String job = (String) c1.getSelectedItem();
        try {
            Conn c = new Conn();                                           //name, age, gender, job, salary, phone, email, aadhar

            String query = "insert into employee values('" + name + "', '" + age + "', '" + gender + "', '" + job + "', '" + salary + "', '" + phone + "', '" + email + "', '" + aadhar + "')";
            c.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Employee added sucessfully");
            setVisible(false);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new AddEmployee().setVisible(true);
    }
}
