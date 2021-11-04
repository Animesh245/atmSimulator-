package aSimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
	JLabel l1,l2,l3;//l16;
	JTextField tf1;
	JPasswordField pf2;
	JButton b1,b2,b3;
	
	Login(){
		
		//Move the text to the center
		
        setTitle("AUTOMATED TELLER MACHINE");
        
        ImageIcon i1 = new ImageIcon("icons/logo.jpg");
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l16 = new JLabel(i3);
        l16.setBounds(70, 10, 100, 100);
        add(l16);
		
		
		
		
		l1 = new JLabel("WELCOME TO ATM");
		l1.setFont(new Font("Osward", Font.BOLD, 38));
		l1.setBounds(200,40,450,40);
		add(l1);
		
		
		l2 = new JLabel("Card No:");
		l2.setFont(new Font("Raleway", Font.BOLD, 28));
		l2.setBounds(125,150,375,30);
		add(l2);
		
		
		l3 = new JLabel("PIN:");
		l3.setFont(new Font("Raleway", Font.BOLD, 28));
		l3.setBounds(125,225,375,30);
		add(l3);
		
		
		tf1 = new JTextField(15);
		tf1.setFont(new Font("Arial", Font.BOLD, 14));
		tf1.setBounds(300,150,230,30);
		add(tf1);
		
		pf2 = new JPasswordField(15);
		pf2.setFont(new Font("Arial", Font.BOLD,14));
		pf2.setBounds(300, 220, 230, 30);
		add(pf2);
		
		
		b1 = new JButton("SIGN IN");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		
		b2 = new JButton("CLEAR");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		
		b3 = new JButton("SIGN UP");
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		
		setLayout(null);
		

		
		b1.setFont(new Font("Arial", Font.BOLD, 14));
		b1.setBounds(300, 300, 100, 30);
		add(b1);
		
		b2.setFont(new Font("Arial", Font.BOLD, 14));
		b2.setBounds(430, 300, 100, 30);
		add(b2);
		
		b3.setFont(new Font("Arial", Font.BOLD, 14));
		b3.setBounds(300, 350, 230, 30);
		add(b3);
		
		
//		Listening to actions which will lead to some result
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		getContentPane().setBackground(Color.WHITE);//Frame background color
		
		setSize(800, 480);//frameSize
		setLocation(550,200);//location on the screen
		setVisible(true);//to see the frame, it should be true
				
	}
	
	public void actionPerformed(ActionEvent ae) {//to see the result of the action this method should be created
		
		try {

			
			if(ae.getSource() == b1) {
				
				Conn c1 = new Conn();
                String cardno  = tf1.getText();
                String pin  = pf2.getText();
                String q  = "SELECT * FROM login WHERE cardno = '"+cardno+"' and pin = '"+pin+"'";
				
				ResultSet rs = c1.s.executeQuery(q);  //executeQuery is used to retrieve data from database. and excuteUpdate to update data. Data retrieved will store in rs.
				
				if(rs.next()) { //Data retrieved from rs, will be checked from the data available on dataBase
					setVisible(false);
					new Transactions(pin).setVisible(true);
					
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");//if the data retrieved does not match then this text will pop up.
				}
			}
			else if(ae.getSource() == b2) {
				tf1.setText("");
				pf2.setText("");
			}
			else if(ae.getSource() == b3) {
				setVisible(false);
				new Signup().setVisible(true);

			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("error: "+e);
		}
	}
	
	public static void main(String[] args) {
		new Login().setVisible(true);
	}
	
	
	
	
}
