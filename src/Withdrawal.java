package aSimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {
	
	JTextField t1,t2;
	JButton b1,b2,b3;
	JLabel l1,l2,l3,l4;
	String pin;
	
	
	Withdrawal(String pin){
		
		
		this.pin = pin;
		
		ImageIcon i1 = new ImageIcon("icons/atm.jpg");
		Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l6 = new JLabel(i3);
		l6.setBounds(0, 0, 960, 1080);
		add(l6);

		
		l1 = new JLabel("MAXIMUM DAILY WITHDRAWAL");
		l1.setFont(new Font("System", Font.BOLD, 40));
		
		l2 = new JLabel ("IS RS. 10,000");
		l2.setFont(new Font("System", Font.BOLD, 40));
		
		l3 = new JLabel ("PLEASE ENTER YOUR AMOUNT");
		l3.setFont(new Font("System", Font.BOLD, 35));
		
		l4 = new JLabel ("Enter Pin");
		l4.setFont(new Font("System", Font.BOLD, 14));
		
		t1 = new JTextField();
		t1.setFont(new Font("Raleway", Font.BOLD, 22));
		
		t2 = new JTextField();
		t2.setFont(new Font("Raleway", Font.BOLD, 14));
		
		b1 = new JButton("WITHDRAW");
		b1.setFont(new Font("Raleway", Font.BOLD, 18));
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		
		b2 = new JButton("BACK");
		b2.setFont(new Font("Raleway", Font.BOLD, 18));
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		
		b3 = new JButton("EXIT");
		b3.setFont(new Font("Raleway", Font.BOLD, 18));
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		
		
		setLayout(null);
		
		l1.setBounds(90, 100, 800, 60);
		l6.add(l1);
		
		l2.setBounds(270,160,800,60);
		l6.add(l2);
		
		l3.setBounds(120,260,800,60);
		l6.add(l3);
		
		l4.setBounds(620,10,80,30);
		l6.add(l4);
		
		
		
		t1.setBounds(250, 300, 300, 50);
		l6.add(t1);
		
		t2.setBounds(700, 10, 40, 30);
		l6.add(t2);
		
		
		
		
		b1.setBounds(200, 550, 150, 35);
		l6.add(b1);
		
		b2.setBounds(390, 550, 150, 35);
		l6.add(b2);
		
		b3.setBounds(300, 590, 150, 35);
		l6.add(b3);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(800,800);
		setLocation(500,90);
		setVisible(true);
	
	}
	
	public void actionPerformed(ActionEvent ae){
        try{        
            String amount = t1.getText();
            Date date = new Date();
            if(ae.getSource()==b1){
                if(t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                }else{
                    Conn c1 = new Conn();
                    
                    ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+pin+"'");
                    int balance = 0;
                    while(rs.next()){
                       if(rs.getString("mode").equals("Deposit")){
                           balance += Integer.parseInt(rs.getString("amount"));
                       }else{
                           balance -= Integer.parseInt(rs.getString("amount"));
                       }
                    }
                    if(balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }
                    
                    c1.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
            }else if(ae.getSource()==b2){
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
        }
            
    }
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Withdrawal("").setVisible(true);
	}

}

