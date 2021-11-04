package aSimulatorSystem;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Signup2 extends JFrame implements ActionListener {
	
	
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	JButton b;
	JRadioButton r1,r2,r3,r4;
	JTextField t1,t2,t3;
	JComboBox c1,c2,c3,c4,c5;
	String formno;
	
	
	
	Signup2(String formno){
		
		
		
		
		ImageIcon i1 = new ImageIcon("icons/logo.jpg");
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l14 = new JLabel(i3);
		l14.setBounds(150, 0, 100, 100);
		add(l14);
		
		this.formno = formno;
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

		
		
		
		//OLD CODE
//		setFont(new Font("System", Font.BOLD, 22));
//		Font f = getFont();
//		FontMetrics fm = getFontMetrics(f);
//		
//		int x = fm.stringWidth("NEW ACCOUNT APPLICATION FORM - PAGE 2");
//		int y = fm.stringWidth(" ");
//		int z = getWidth()/2 -(x/2);
//		int w = z/y;
//		String pad = "";
		
		//for(int i = 0; i != w; i++) pad +=" ";
//		pad = String.format("%"+w+"s", pad);
//		setTitle(pad+"NEW ACCOUNT APPLICATION FORM - PAGE 2");
		
		//labels
		l1 = new JLabel("Page 2: Additional Details");
		l1.setFont(new Font("Raleway", Font.BOLD, 22));
		
		l2 = new JLabel("Religion:");
		l2.setFont(new Font("Raleway", Font.BOLD, 18));
		
		l3 = new JLabel("Category:");
		l3.setFont(new Font("Raleway", Font.BOLD, 18));
		
		l4 = new JLabel("Income:");
		l4.setFont(new Font("Raleway", Font.BOLD,18));
		
		l5 = new JLabel("Edcational");
		l5.setFont(new Font("Raleway", Font.BOLD,18));
		
		l6 = new JLabel("Occupation");
		l6.setFont(new Font("Raleway", Font.BOLD, 18));
		
		l7 = new JLabel("PAN Number:");
		l7.setFont(new Font("Raleway", Font.BOLD, 18));
		
		l8	= new JLabel("Aadhar Number:");
		l8.setFont(new Font("Raleway", Font.BOLD, 18));
		
		l9 = new JLabel("Senior Citizen");
		l9.setFont(new Font("Raleway", Font.BOLD, 18));
		
		l10 = new JLabel("Existing Account:");
		l10.setFont(new Font("Raleway", Font.BOLD, 18));
		 
		l11 = new JLabel("Qualification:");
		l11.setFont(new Font("Raleway", Font.BOLD, 18));
		
		l12 = new JLabel("Form No:");
		l12.setFont(new Font("Raleway", Font.BOLD, 13));
		
		//button
		b = new JButton("Next");
		b.setFont(new Font("Raleway", Font.BOLD, 14));
		b.setBackground(Color.BLACK);
		b.setForeground(Color.WHITE);
		
		//textFields
		t1 = new JTextField();
		t1.setFont(new Font("Raleway", Font.BOLD, 14));
		
		t2 = new JTextField();
		t2.setFont(new Font("Raleway", Font.BOLD, 14));
		
		t3 = new JTextField();
		t3.setFont(new Font("Raleway", Font.BOLD, 13));
		
		
		// RadioButtons
		r1 = new JRadioButton("Yes");
		r1.setFont(new Font("Raleway", Font.BOLD, 14));
		r1.setBackground(Color.WHITE);
		
		r2 = new JRadioButton("No");
		r2.setFont(new Font("Raleway", Font.BOLD, 14));
		r2.setBackground(Color.WHITE);
		
		r3 = new JRadioButton("Yes");
		r3.setFont(new Font("Raleway", Font.BOLD, 14));
		r3.setBackground(Color.WHITE);
		
		r4 = new JRadioButton("No");
		r4.setFont(new Font("Raleway", Font.BOLD, 14));
		r4.setBackground(Color.WHITE);
		
		
		//ComboBox
		String religion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
		c1 = new JComboBox<>(religion);
		c1.setBackground(Color.WHITE);
		c1.setFont(new Font("Raleway", Font.BOLD, 14));
		
		String category[] = {"General","OBC","SC","ST","Other"};
		c2 = new JComboBox<>(category);
		c2.setBackground(Color.WHITE);
		c2.setFont(new Font("Raleway", Font.BOLD, 14));
		
		String income[] = {"Null","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000","Above 10,00,000"};
		c3 = new JComboBox<>(income);
		c3.setBackground(Color.WHITE);
		c3.setFont(new Font("Raleway", Font.BOLD, 14));
		
		String education[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
		c4 = new JComboBox<>(education);
		c4.setBackground(Color.WHITE);
		c4.setFont(new Font("Raleway", Font.BOLD, 14));
		
		String occupation[] = {"Salaried","Self-Employed","Business","Student","Retired","Others"};
		c5 = new JComboBox<>(occupation);
		c5.setBackground(Color.WHITE);
		c5.setFont(new Font("Raleway", Font.BOLD, 14));
		
		
		setLayout(null);
		
		
		l1.setBounds(280, 30, 600, 40);
		add(l1);
		
		l2.setBounds(100, 120, 100, 30);
		add(l2);
		
		l3.setBounds(100, 170, 100, 30);
		add(l3);
		
		l4.setBounds(100, 220, 100, 30);
		add(l4);
		
		l5.setBounds(100, 270, 150, 30);
		add(l5);
		
		l6.setBounds(100, 340, 150, 30);
		add(l6);
		
		l7.setBounds(100, 390, 180, 30);
		add(l7);
		
		l8.setBounds(100, 440, 100, 30);
		add(l8);
		
		l9.setBounds(100, 490, 150, 30);
		add(l9);
		
		l10.setBounds(100, 540, 180, 30);
		add(l10);
		
		l11.setBounds(100, 290, 150, 30);
		add(l11);
		
		l12.setBounds(700, 10, 60, 30);
		add(l12);
		
		
		//Button
		b.setBounds(570, 600, 100, 30);
		add(b);
		b.addActionListener(this);
		
		
		
		//TextFields
		t1.setBounds(350, 390, 320, 30);
		add(t1);
		
		t2.setBounds(350, 440, 320, 30);
		add(t2);
		
		t3.setBounds(760, 10, 60, 30);
		add(t3);
		
		
		
		//RadioButtons
		r1.setBounds(350, 490, 100, 30);
		add(r1);
		
		r2.setBounds(460, 490, 100, 30);
		add(r2);
		
		r3.setBounds(350, 540, 100, 30);
		add(r3);
		
		r4.setBounds(460, 540, 100, 30);
		add(r4);
		
		

		
		
		//ComboBox
		c1.setBounds(350, 120, 320, 30);
		add(c1);
		
		c2.setBounds(350, 170, 320, 30);
		add(c2);
		
		c3.setBounds(350, 220, 320, 30);
		add(c3);
		
		c4.setBounds(350, 270, 320, 30);
		add(c4);
		
		c5.setBounds(350, 340, 320, 30);
		add(c5);
		
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(850,850);
		setLocation(500,90);
		setVisible(true);
		
		
	}
	


	public void actionPerformed(ActionEvent ae) {
		
		String religion = (String)c1.getSelectedItem();
		String category = (String)c2.getSelectedItem();
		String income = (String)c3.getSelectedItem();
		String education = (String)c4.getSelectedItem();
		String occupation = (String)c5.getSelectedItem();
	
		String pan = t1.getText();
		String aadhar = t2.getText();
		String formno = t3.getText();
		
		String sCitizen = "";
		
		if(r1.isSelected()) {
			sCitizen = "Yes";
			
		}
		else if(r2.isSelected()) {
			sCitizen = "No";
		}
		
		String eaccount = "";
		if(r3.isSelected()) {
			eaccount = "Yes";
		}
		else if(r4.isSelected()) {
			eaccount = "No";
		}
	
		
	
		
		
		try {
			
			
			if(t2.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Fill all the required fields");
			}else {
				Conn c1 = new Conn();
				String q1 = "INSERT INTO signup2 VALUES('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+aadhar+"','"+sCitizen+"','"+eaccount+"')";
				c1.s.executeUpdate(q1);
				
				new Signup3(formno).setVisible(true);
				setVisible(false);
			}
			
			
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	
	
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Signup2("").setVisible(true);

	}

}
