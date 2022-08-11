import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class Opt1AddPasswordGUI extends JFrame {
	
	private JPanel contentPane;
	private JLabel titlelbl;
	private JLabel usernamelbl;
	private JLabel passwordlbl;
	private JLabel noteslbl;
	private JLabel optionlbl;
	private JButton confirmbtn;
	private JTextField titletxt;
	private JTextField usernametxt;
	private JTextField passwordtxt;
	private JTextField notestxt;
	private JButton cancelbtn;
	private JLabel resultlbl;

	public Opt1AddPasswordGUI(PasswordManager passwordManager) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		titlelbl = new JLabel("New title:");
		titlelbl.setBounds(85, 75, 65, 16);
		contentPane.add(titlelbl);
		
		usernamelbl = new JLabel("New username:");
		usernamelbl.setBounds(85, 105, 101, 16);
		contentPane.add(usernamelbl);
		
		passwordlbl = new JLabel("New password:");
		passwordlbl.setBounds(85, 135, 100, 16);
		contentPane.add(passwordlbl);
		
		noteslbl = new JLabel("Notes:");
		noteslbl.setBounds(85, 165, 75, 16);
		contentPane.add(noteslbl);
		
		optionlbl = new JLabel("Add new password");
		optionlbl.setHorizontalAlignment(SwingConstants.CENTER);
		optionlbl.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		optionlbl.setBounds(100, 28, 200, 27);
		contentPane.add(optionlbl);
		
		confirmbtn = new JButton("Confirm");
		confirmbtn.setForeground(new Color(50, 205, 50));
		confirmbtn.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		confirmbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Password newPassword = new Password(titletxt.getText(), usernametxt.getText(), passwordtxt.getText(), notestxt.getText());
				passwordManager.addNewPassword(newPassword);
				resultlbl.setText("Successfully added!");
				confirmbtn.setVisible(false);
				cancelbtn.setText("Return");
				cancelbtn.setForeground(new Color(50, 205, 50));
			}
		});
		confirmbtn.setBounds(85, 193, 112, 27);
		contentPane.add(confirmbtn);
		
		titletxt = new JTextField();
		titletxt.setBounds(200, 70, 120, 26);
		contentPane.add(titletxt);
		titletxt.setColumns(10);
		
		usernametxt = new JTextField();
		usernametxt.setBounds(200, 100, 120, 26);
		contentPane.add(usernametxt);
		usernametxt.setColumns(10);
		
		passwordtxt = new JTextField();
		passwordtxt.setBounds(200, 130, 120, 26);
		contentPane.add(passwordtxt);
		passwordtxt.setColumns(10);
		
		notestxt = new JTextField();
		notestxt.setBounds(200, 160, 120, 26);
		contentPane.add(notestxt);
		notestxt.setColumns(10);
		
		cancelbtn = new JButton("Cancel");
		cancelbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainGUI mainGui = new MainGUI(passwordManager);
				mainGui.show();
				dispose();
			}
		});
		cancelbtn.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		cancelbtn.setForeground(Color.RED);
		cancelbtn.setBounds(203, 193, 112, 27);
		contentPane.add(cancelbtn);
		
		resultlbl = new JLabel("");
		resultlbl.setForeground(new Color(50, 205, 50));
		resultlbl.setHorizontalAlignment(SwingConstants.CENTER);
		resultlbl.setBounds(100, 225, 200, 27);
		contentPane.add(resultlbl);
	}

}
