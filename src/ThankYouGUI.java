import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThankYouGUI extends JFrame {

	private JPanel contentPane;
	private JButton exitbtn;
	private JLabel thankyoulbl;
	private JLabel errorlbl;

	/**
	 * Create the frame.
	 */
	public ThankYouGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		exitbtn = new JButton("See you :)");
		exitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitbtn.setForeground(new Color(50, 205, 50));
		exitbtn.setFont(new Font("Lucida Grande", Font.BOLD, 17));
		exitbtn.setBounds(140, 170, 120, 33);
		contentPane.add(exitbtn);
		
		thankyoulbl = new JLabel("Thanks for using PasswordManager!");
		thankyoulbl.setHorizontalAlignment(SwingConstants.CENTER);
		thankyoulbl.setFont(new Font("Lucida Grande", Font.BOLD, 17));
		thankyoulbl.setBounds(25, 85, 350, 41);
		contentPane.add(thankyoulbl);

	}
	
	public ThankYouGUI(boolean status) {
		if(status == false) {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 400, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			exitbtn = new JButton("See you :)");
			exitbtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			exitbtn.setForeground(new Color(50, 205, 50));
			exitbtn.setFont(new Font("Lucida Grande", Font.BOLD, 17));
			exitbtn.setBounds(140, 160, 120, 33);
			contentPane.add(exitbtn);
			
			thankyoulbl = new JLabel("We are sorry, some problem happened :(");
			thankyoulbl.setHorizontalAlignment(SwingConstants.CENTER);
			thankyoulbl.setFont(new Font("Lucida Grande", Font.BOLD, 17));
			thankyoulbl.setBounds(25, 85, 350, 41);
			contentPane.add(thankyoulbl);
			
			errorlbl = new JLabel("The changes were not saved, please start again.");
			errorlbl.setBounds(171, 120, 61, 16);
			contentPane.add(errorlbl);
		}
	}


}
