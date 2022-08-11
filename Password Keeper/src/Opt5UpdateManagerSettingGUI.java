import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Opt5UpdateManagerSettingGUI extends JFrame {

	private JPanel contentPane;
	private JLabel optionlbl;
	private JLabel usernamelbl;
	private JLabel passwordlbl;
	private JTextField usernametxt;
	private JTextField passwordtxt;
	private JButton confirmbtn;
	private JButton cancelbtn;
	private Password searchResult;
	private String searchDisplay;
	private JLabel resultlbl;
	private JButton retainUsernamebtn;
	private JButton retainPasswordbtn;

	/**
	 * Create the frame.
	 */
	public Opt5UpdateManagerSettingGUI(PasswordManager passwordManager) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		optionlbl = new JLabel("Update Manager Information");
		optionlbl.setHorizontalAlignment(SwingConstants.CENTER);
		optionlbl.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		optionlbl.setBounds(87, 27, 226, 19);
		contentPane.add(optionlbl);
		
		usernamelbl = new JLabel("New Username:");
		usernamelbl.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		usernamelbl.setBounds(55, 84, 106, 17);
		contentPane.add(usernamelbl);
		
		usernametxt = new JTextField();
		usernametxt.setBounds(180, 80, 120, 26);
		contentPane.add(usernametxt);
		usernametxt.setColumns(10);
		
		confirmbtn = new JButton("Confirm");
		confirmbtn.setForeground(new Color(50, 205, 50));
		confirmbtn.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		confirmbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordManager.updatePasswordKeeper(usernametxt.getText(),passwordtxt.getText());
				resultlbl.setText("Updated Successfully!");
				confirmbtn.setVisible(false);
				cancelbtn.setText("Return");
				cancelbtn.setForeground(new Color(50, 205, 50));
			}
		});
		confirmbtn.setBounds(85, 150, 112, 27);
		contentPane.add(confirmbtn);
		
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
		cancelbtn.setBounds(203, 150, 112, 27);
		contentPane.add(cancelbtn);
		
		resultlbl = new JLabel("");
		resultlbl.setHorizontalAlignment(SwingConstants.CENTER);
		resultlbl.setBounds(100, 200, 200, 30);
		contentPane.add(resultlbl);
		
		retainUsernamebtn = new JButton("Retain");
		retainUsernamebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usernametxt.setText(passwordManager.getPasswordManagerUsername());
			}
		});
		retainUsernamebtn.setForeground(new Color(50, 205, 50));
		retainUsernamebtn.setBounds(305, 79, 83, 29);
		contentPane.add(retainUsernamebtn);
		
		passwordlbl = new JLabel("New Password:");
		passwordlbl.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		passwordlbl.setBounds(59, 114, 102, 17);
		contentPane.add(passwordlbl);
		
		passwordtxt = new JTextField();
		passwordtxt.setBounds(180, 110, 120, 26);
		contentPane.add(passwordtxt);
		passwordtxt.setColumns(10);
		
		retainPasswordbtn = new JButton("Retain");
		retainPasswordbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordtxt.setText(passwordManager.getPasswordManagerPassword());
			}
		});
		retainPasswordbtn.setForeground(new Color(50, 205, 50));
		retainPasswordbtn.setBounds(305, 109, 83, 29);
		contentPane.add(retainPasswordbtn);
	}
}
