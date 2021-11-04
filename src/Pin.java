package aSimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class Pin extends JFrame implements ActionListener {

	JPasswordField t1,t2,t3;
	JButton b1,b2;
	JLabel l1,l2,l3,l4;
	String pin;
	
	Pin(String pin){
		
		this.pin = pin;
		
        ImageIcon i1 = new ImageIcon("icons/atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l5 = new JLabel(i3);
        l5.setBounds(0, 0, 960, 1080);
        add(l5);
		
		l1 = new JLabel("CHANGE YOUR PIN");
		l1.setFont(new Font("System", Font.BOLD, 35));
		
		l2 = new JLabel ("Current PIN:");
		l2.setFont(new Font("System", Font.BOLD, 22));
		
		l3 = new JLabel ("New PIN:");
		l3.setFont(new Font("System", Font.BOLD, 22));
		
		l4 = new JLabel ("Re-Enter New PIN");
		l4.setFont(new Font("System", Font.BOLD, 22));
		
		
		b1 = new JButton("SAVE");
		b1.setFont(new Font("Raleway", Font.BOLD, 18));
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		
		b2 = new JButton("BACK");
		b2.setFont(new Font("Raleway", Font.BOLD, 18));
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		
		t1 = new JPasswordField();
		t1.setFont(new Font("Raleway", Font.BOLD, 22));
		
		t2 = new JPasswordField();
		t2.setFont(new Font("Raleway", Font.BOLD, 22));
		
		t3 = new JPasswordField();
		t3.setFont(new Font("Raleway", Font.BOLD, 22));
		
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		
		
		setLayout(null);
		
		l1.setBounds(220, 130, 800, 60);
		l5.add(l1);
		
		l2.setBounds(100,240,150,40);
		l5.add(l2);
		
		l3.setBounds(100,300,150,40);
		l5.add(l3);
		
		l4.setBounds(100,360,200,40);
		l5.add(l4);
		
		b1.setBounds(220, 460, 160, 50);
		l5.add(b1);
		
		b2.setBounds(400, 460, 160, 50);
		l5.add(b2);
		
		t1.setBounds(310, 240, 360, 40);
		l5.add(t1);
		
		t2.setBounds(310, 300, 360, 40);
		l5.add(t2);
		
		t3.setBounds(310, 360, 360, 40);
		l5.add(t3);
		
		
		
		
		getContentPane().setBackground(Color.WHITE);
			
        setSize(960,1080);
        setLocation(500,0);
        setUndecorated(true);
        setVisible(true);
			
		}
		
	 public void actionPerformed(ActionEvent ae){
	        try{        
	            String npin = t1.getText();
	            String rpin = t2.getText();
	            
	            if(!npin.equals(rpin)){
	                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
	                return;
	            }
	            
	            if(ae.getSource()==b1){
	                if (t1.getText().equals("")){
	                    JOptionPane.showMessageDialog(null, "Enter New PIN");
	                }
	                if (t2.getText().equals("")){
	                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
	                }
	                
	                Conn c1 = new Conn();
	                String q1 = "update bank set pin = '"+rpin+"' where pin = '"+pin+"' ";
	                String q2 = "update login set pin = '"+rpin+"' where pin = '"+pin+"' ";
	                String q3 = "update signup3 set pin = '"+rpin+"' where pin = '"+pin+"' ";

	                c1.s.executeUpdate(q1);
	                c1.s.executeUpdate(q2);
	                c1.s.executeUpdate(q3);

	                JOptionPane.showMessageDialog(null, "PIN changed successfully");
	                setVisible(false);
	                new Transactions(rpin).setVisible(true);
	            
	            }else if(ae.getSource()==b2){
	                new Transactions(pin).setVisible(true);
	                setVisible(false);
	            }
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	    }
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Pin("").setVisible(true);

	}

}
