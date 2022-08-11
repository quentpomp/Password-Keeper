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

public class Opt4DeleteAPasswordGUI extends JFrame {

	private JPanel contentPane;
	private JLabel optionlbl;
	private JLabel titlelbl;
	private JTextField titletxt;
	private JButton confirmbtn;
	private JButton cancelbtn;
	private JTextArea resultarea;
	private Password searchResult;
	private String searchDisplay;
	private boolean confirmStatus;


	/**
	 * Create the frame.
	 */
	public Opt4DeleteAPasswordGUI(PasswordManager passwordManager) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		optionlbl = new JLabel("Delete A Passowrd");
		optionlbl.setHorizontalAlignment(SwingConstants.CENTER);
		optionlbl.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		optionlbl.setBounds(100, 28, 200, 27);
		contentPane.add(optionlbl);
		
		titlelbl = new JLabel("Search title:");
		titlelbl.setBounds(85, 75, 74, 16);
		contentPane.add(titlelbl);
		
		titletxt = new JTextField();
		titletxt.setBounds(200, 70, 120, 26);
		contentPane.add(titletxt);
		titletxt.setColumns(10);
		
		confirmbtn = new JButton("Confirm");
		confirmbtn.setForeground(new Color(50, 205, 50));
		confirmbtn.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		confirmbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!confirmStatus) {
					searchResult = passwordManager.getPasswordData(titletxt.getText());
					if(searchResult == null) {
						resultarea.setText("No matching result. Please try again.");
						cancelbtn.setText("Cancel");
						cancelbtn.setForeground(Color.RED);
					}
					else {
						confirmStatus = true;
						titletxt.disable();
						searchDisplay = searchResult.showInfo();
						resultarea.setText(searchDisplay);
						confirmbtn.setText("Delete");
					}
				}
				else {
					passwordManager.deletePassword(titletxt.getText());
					resultarea.setText("Deleted Successfully!");
					cancelbtn.setText("Return");
					cancelbtn.setForeground(new Color(50, 205, 50));
				}
			}
		});
		confirmbtn.setBounds(85, 110, 112, 27);
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
		cancelbtn.setBounds(203, 110, 112, 27);
		contentPane.add(cancelbtn);
		
		resultarea = new JTextArea();
		resultarea.setBounds(80, 149, 240, 104);
		contentPane.add(resultarea);
	}

}
