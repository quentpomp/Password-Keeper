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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Opt3UpdateAPasswordGUI extends JFrame {

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
	private JLabel searchResultlbl;
	private boolean confirmStatus;
	private Password searchResult;
	private JButton retainUsernamebtn;
	private JButton retainPasswordbtn;
	private JButton retainNotesbtn;


	/**
	 * Create the frame.
	 */
	public Opt3UpdateAPasswordGUI(PasswordManager passwordManager) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		titlelbl = new JLabel("Search title:");
		titlelbl.setBounds(86, 75, 74, 16);
		contentPane.add(titlelbl);
		
		usernamelbl = new JLabel("New username:");
		usernamelbl.setBounds(64, 105, 96, 16);
		contentPane.add(usernamelbl);
		usernamelbl.setVisible(false);
		
		passwordlbl = new JLabel("New password:");
		passwordlbl.setBounds(65, 135, 95, 16);
		contentPane.add(passwordlbl);
		passwordlbl.setVisible(false);
		
		noteslbl = new JLabel("New Notes:");
		noteslbl.setBounds(88, 165, 72, 16);
		contentPane.add(noteslbl);
		noteslbl.setVisible(false);
		
		optionlbl = new JLabel("Update A Password");
		optionlbl.setHorizontalAlignment(SwingConstants.CENTER);
		optionlbl.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		optionlbl.setBounds(100, 28, 200, 27);
		contentPane.add(optionlbl);
		
		confirmStatus = false;
		confirmbtn = new JButton("Confirm");
		confirmbtn.setForeground(new Color(50, 205, 50));
		confirmbtn.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		confirmbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!confirmStatus) {
					searchResult = passwordManager.getPasswordData(titletxt.getText());
					if(searchResult == null) {
						searchResultlbl.setText("No matchinging result. Please try again.");
					}
					else {
						titletxt.disable();
						confirmStatus = true;
						searchResultlbl.setVisible(false);
						confirmbtn.move(85,193);
						cancelbtn.move(203, 193);
						usernamelbl.setVisible(true);
						passwordlbl.setVisible(true);
						noteslbl.setVisible(true);
						usernametxt.setVisible(true);
						passwordtxt.setVisible(true);
						notestxt.setVisible(true);
						retainUsernamebtn.setVisible(true);
						retainPasswordbtn.setVisible(true);
						retainNotesbtn.setVisible(true);
						searchResultlbl.setVisible(false);
					}
				}
				else {
					searchResult.updateUsername(usernametxt.getText());
					searchResult.updatePassword(passwordtxt.getText());
					searchResult.updateNotes(notestxt.getText());
					resultlbl.setText("Successfully added!");
					confirmbtn.setVisible(false);
					cancelbtn.setText("Return");
					cancelbtn.setForeground(new Color(50, 205, 50));
				}
			}
		});
		confirmbtn.setBounds(85, 105, 112, 27);
		contentPane.add(confirmbtn);
		
		titletxt = new JTextField();
		titletxt.setBounds(185, 71, 120, 26);
		contentPane.add(titletxt);
		titletxt.setColumns(10);
		
		usernametxt = new JTextField();
		usernametxt.setBounds(185, 102, 120, 26);
		contentPane.add(usernametxt);
		usernametxt.setColumns(10);
		usernametxt.setVisible(false);
		
		passwordtxt = new JTextField();
		passwordtxt.setBounds(185, 132, 120, 26);
		contentPane.add(passwordtxt);
		passwordtxt.setColumns(10);
		passwordtxt.setVisible(false);
		
		notestxt = new JTextField();
		notestxt.setBounds(185, 162, 120, 26);
		contentPane.add(notestxt);
		notestxt.setColumns(10);
		notestxt.setVisible(false);
		
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
		cancelbtn.setBounds(203, 105, 112, 27);
		contentPane.add(cancelbtn);
		
		resultlbl = new JLabel("");
		resultlbl.setForeground(new Color(50, 205, 50));
		resultlbl.setHorizontalAlignment(SwingConstants.CENTER);
		resultlbl.setBounds(100, 225, 200, 27);
		contentPane.add(resultlbl);
		
		searchResultlbl = new JLabel("");
		searchResultlbl.setHorizontalAlignment(SwingConstants.CENTER);
		searchResultlbl.setBounds(70, 144, 265, 27);
		contentPane.add(searchResultlbl);
		
		retainUsernamebtn = new JButton("retain");
		retainUsernamebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usernametxt.setText(searchResult.getUserName());
			}
		});
		retainUsernamebtn.setForeground(new Color(50, 205, 50));
		retainUsernamebtn.setBounds(314, 102, 80, 29);
		contentPane.add(retainUsernamebtn);
		retainUsernamebtn.setVisible(false);
		
		retainPasswordbtn = new JButton("retain");
		retainPasswordbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordtxt.setText(searchResult.getPassword());
			}
		});
		retainPasswordbtn.setForeground(new Color(50, 205, 50));
		retainPasswordbtn.setBounds(314, 132, 80, 29);
		contentPane.add(retainPasswordbtn);
		retainPasswordbtn.setVisible(false);
		
		retainNotesbtn = new JButton("retain");
		retainNotesbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				notestxt.setText(searchResult.getNotes());
			}
		});
		retainNotesbtn.setForeground(new Color(50, 205, 50));
		retainNotesbtn.setBounds(314, 161, 80, 29);
		contentPane.add(retainNotesbtn);
		retainNotesbtn.setVisible(false);
	}

}
