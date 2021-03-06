package aSimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.util.Date;


public class FastCash extends JFrame implements ActionListener{

	JLabel l1,l2;
	JButton b1,b2,b3,b4,b5,b6,b7;
	JTextField t1;
	String pin;
	
	FastCash(String pin){
		
		this.pin = pin;
        ImageIcon i1 = new ImageIcon("icons/atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1080);
        add(l3);
		
		
		
		l1 = new JLabel("SELECT WITHDRAWAL AMOUNT");
		l1.setFont(new Font("System", Font.BOLD, 38));
		
		l2 = new JLabel ("Enter PIN:");
		l2.setFont(new Font("System", Font.BOLD, 13));
		
		t1 = new JTextField();
		t1.setFont(new Font("System", Font.BOLD, 13));
		
		b1 = new JButton("Rs 100");
		b1.setFont(new Font("System", Font.BOLD, 18));
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		
		b2 = new JButton("Rs 500");
		b2.setFont(new Font("System", Font.BOLD, 18));
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		
		
		b3 = new JButton("Rs 1000");
		b3.setFont(new Font("System", Font.BOLD, 18));
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		
		b4 = new JButton("Rs 2000");
		b4.setFont(new Font("System", Font.BOLD, 18));
		b4.setBackground(Color.BLACK);
		b4.setForeground(Color.WHITE);
		
		b5 = new JButton("Rs 5000");
		b5.setFont(new Font("System", Font.BOLD, 18));
		b5.setBackground(Color.BLACK);
		b5.setForeground(Color.WHITE);
		
		b6 = new JButton("Rs 10000");
		b6.setFont(new Font("System", Font.BOLD, 18));
		b6.setBackground(Color.BLACK);
		b6.setForeground(Color.WHITE);
		
		b7 = new JButton("EXIT");
		b7.setFont(new Font("System", Font.BOLD, 18));
		b7.setBackground(Color.BLACK);
		b7.setForeground(Color.WHITE);
		

		

		setLayout(null);
		
			l1.setBounds(100, 100, 700, 40);
			add(l1);
			
			l2.setBounds(640,10,60,40);
			add(l2);
		
			
			
			t1.setBounds(710, 10, 60, 40);
			add(t1);
			
			
			
			b1.setBounds(40, 250, 300, 60);
			add(b1);
			
			b2.setBounds(440, 250, 300, 60);
			add(b2);
			
			b3.setBounds(40, 360, 300, 60);
			add(b3);
			
			b4.setBounds(440, 360, 300, 60);
			add(b4);
			
			b5.setBounds(40, 470, 300, 60);
			add(b5);
			
			b6.setBounds(440, 470, 300, 60);
			add(b6);
			
			b7.setBounds(240, 600, 300, 60);
			add(b7);
			
			
			b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
			b4.addActionListener(this);
			b5.addActionListener(this);
			b6.addActionListener(this);
			b7.addActionListener(this);
		
	
			
			
		getContentPane().setBackground(Color.WHITE);
			
        setSize(960, 1080);
        setLocation(500, 0);
        setUndecorated(true);
        setVisible(true);

			
		}
	
    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = ((JButton)ae.getSource()).getText().substring(3); //k
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin = '"+pin+"'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("mode").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            } String num = "17";
            if (ae.getSource() != b7 && balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insuffient Balance");
                return;
            }

            if (ae.getSource() == b7) {
                this.setVisible(false);
                new Transactions(pin).setVisible(true);
            }else{
                Date date = new Date();
                c.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new FastCash("").setVisible(true);
	}

}
