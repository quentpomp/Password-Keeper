import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import java.io.*;


public class LoginGUI extends JFrame {

	private JPanel contentPane;
	private JLabel loginlbl;
	private JLabel usernamelbl;
	private JTextField usernametxt;
	private JLabel passwordlbl;
	private JTextField passwordtxt;
	private JButton loginbtn;
	private JLabel resultlbl;
	private PasswordManager passwordManager;
	private int falseTime = 0;
	private JButton exitbtn;
	private JButton resetbtn;

	/**
	 * Create the frame.
	 */
	public LoginGUI() {
		try {
			FileInputStream f = new FileInputStream("data.bin");
			ObjectInputStream inStream = new ObjectInputStream(f);
			passwordManager = (PasswordManager)inStream.readObject();
			inStream.close();
			System.out.println("Successfully read from data.bin");
		}
		catch(Exception ex) {
			passwordManager = new PasswordManager();
			System.out.println("Created new manager");
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		loginlbl = new JLabel("Welcome to PasswordManager !", SwingConstants.CENTER);
		loginlbl.setBounds(49, 6, 300, 40);
		loginlbl.setFont(new Font("Calibri", Font.BOLD, 14));
		contentPane.add(loginlbl);
		
		usernamelbl = new JLabel("Username:");
		usernamelbl.setBounds(90, 52, 73, 16);
		contentPane.add(usernamelbl);
		
		usernametxt = new JTextField();
		usernametxt.setBounds(175, 47, 140, 26);
		contentPane.add(usernametxt);
		usernametxt.setColumns(10);
		
		passwordlbl = new JLabel("Password:");
		passwordlbl.setBounds(90, 80, 73, 16);
		contentPane.add(passwordlbl);
		
		passwordtxt = new JTextField();
		passwordtxt.setBounds(175, 75, 140, 26);
		contentPane.add(passwordtxt);
		passwordtxt.setColumns(10);
		
		loginbtn = new JButton("Login");
		loginbtn.setForeground(new Color(50, 205, 50));
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 boolean success = passwordManager.signIn(usernametxt.getText(), passwordtxt.getText());
		         if (success) {
		        	 MainGUI mainGui = new MainGUI(passwordManager);
		        	 mainGui.show();
		        	 dispose();
		         }
		         else {
		        	 if(falseTime == 4) {
		        		 resultlbl.setText("5 times failed login! Please start again.");
		        		 loginbtn.setVisible(false);
		        	 }
		        	 else {
		        		 falseTime ++;
		        		 resultlbl.setText("Incorrect username or password (" + falseTime + ") ! Try again.");
		        	 }
		         }
			}
		});
		loginbtn.setBounds(90, 111, 100, 32);
		contentPane.add(loginbtn);
		
		resultlbl = new JLabel("");
		resultlbl.setHorizontalAlignment(SwingConstants.CENTER);
		resultlbl.setBounds(49, 140, 300, 26);
		contentPane.add(resultlbl);
		
		exitbtn = new JButton("EXIT");
		exitbtn.setBackground(Color.WHITE);
		exitbtn.setForeground(Color.RED);
		exitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThankYouGUI thankyouGui = new ThankYouGUI();
				thankyouGui.show();
				dispose();
			}
		});
		exitbtn.setBounds(198, 113, 117, 29);
		contentPane.add(exitbtn);
		
		resetbtn = new JButton("RESET ALL");
		resetbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File f = new File("data.bin"); 
			    f.delete();
				System.out.println("Reset All");
				LoginGUI loginGui = new LoginGUI();
		        loginGui.show();
		        dispose();
			}
		});
		resetbtn.setForeground(Color.RED);
		resetbtn.setBackground(Color.WHITE);
		resetbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		resetbtn.setBounds(315, 126, 79, 40);
		contentPane.add(resetbtn);
	}
	
	
	
	
	public LoginGUI(PasswordManager passwordManager) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		loginlbl = new JLabel("Welcome to PasswordManager !", SwingConstants.CENTER);
		loginlbl.setBounds(49, 6, 300, 40);
		loginlbl.setFont(new Font("Calibri", Font.BOLD, 14));
		contentPane.add(loginlbl);
		
		usernamelbl = new JLabel("Username:");
		usernamelbl.setBounds(90, 52, 73, 16);
		contentPane.add(usernamelbl);
		
		usernametxt = new JTextField();
		usernametxt.setBounds(175, 47, 140, 26);
		contentPane.add(usernametxt);
		usernametxt.setColumns(10);
		
		passwordlbl = new JLabel("Password:");
		passwordlbl.setBounds(90, 80, 73, 16);
		contentPane.add(passwordlbl);
		
		passwordtxt = new JTextField();
		passwordtxt.setBounds(175, 75, 140, 26);
		contentPane.add(passwordtxt);
		passwordtxt.setColumns(10);
		
		loginbtn = new JButton("Login");
		loginbtn.setForeground(new Color(50, 205, 50));
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 boolean success = passwordManager.signIn(usernametxt.getText(), passwordtxt.getText());
		         if (success) {
		        	 MainGUI mainGui = new MainGUI(passwordManager);
		        	 mainGui.show();
		        	 dispose();
		         }
		         else {
		        	 if(falseTime == 4) {
		        		 resultlbl.setText("5 times failed login! Please start again.");
		        		 loginbtn.setVisible(false);
		        	 }
		        	 else {
		        		 falseTime ++;
		        		 resultlbl.setText("Incorrect username or password (" + falseTime + ") ! Try again.");
		        	 }
		         }
			}
		});
		loginbtn.setBounds(90, 111, 100, 32);
		contentPane.add(loginbtn);
		
		resultlbl = new JLabel("");
		resultlbl.setHorizontalAlignment(SwingConstants.CENTER);
		resultlbl.setBounds(49, 140, 300, 26);
		contentPane.add(resultlbl);
		
		exitbtn = new JButton("EXIT");
		exitbtn.setBackground(Color.WHITE);
		exitbtn.setForeground(Color.RED);
		exitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileOutputStream f = new FileOutputStream("data.bin");
					ObjectOutputStream outStream = new ObjectOutputStream(f);
					outStream.writeObject(passwordManager);
					outStream.close();
					System.out.println("Correctly written to data.bin");
					ThankYouGUI thankyouGui = new ThankYouGUI();
					thankyouGui.show();
					dispose();
				}
				catch(Exception ex) {
//					Print the exception:
//					System.out.println("toString(): " + ex.toString());
//			        System.out.println("getMessage(): " + ex.getMessage());
//			        System.out.println("StackTrace: ");
//			        ex.printStackTrace();
					ThankYouGUI thankyouGui = new ThankYouGUI(false);
					thankyouGui.show();
					dispose();
				}
			}
		});
		exitbtn.setBounds(198, 113, 117, 29);
		contentPane.add(exitbtn);
		
		resetbtn = new JButton("RESET ALL");
		resetbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File f = new File("data.bin"); 
			    f.delete();
				System.out.println("Reset All");
				LoginGUI loginGui = new LoginGUI();
		        loginGui.show();
		        dispose();
			}
		});
		resetbtn.setForeground(Color.RED);
		resetbtn.setBackground(Color.WHITE);
		resetbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		resetbtn.setBounds(315, 126, 79, 40);
		contentPane.add(resetbtn);
	}
}
