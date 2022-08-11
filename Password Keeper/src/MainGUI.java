import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MainGUI extends JFrame {

	private JPanel contentPane;
	private JLabel welcomelbl;
	private JLabel asklbl;
	private JButton choice01btn;
	private JButton choice02btn;
	private JButton choice03btn;
	private JButton choice04btn;
	private JButton choice05btn;
	private JButton choice06btn;

	/**
	 * Create the frame.
	 */
	public MainGUI(PasswordManager passwordManager) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		welcomelbl = new JLabel("Welcome, " + passwordManager.getPasswordManagerUsername(), SwingConstants.CENTER);
		welcomelbl.setBounds(75, 6, 249, 30);
		welcomelbl.setFont(new Font("Dialog", Font.BOLD, 16));
		contentPane.add(welcomelbl);
		
		asklbl = new JLabel("Please choose one of the options below:");
		asklbl.setBounds(15, 48, 256, 13);
		contentPane.add(asklbl);
		
		choice01btn = new JButton("(1) Add a new password");
		choice01btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Opt1AddPasswordGUI opt1Gui = new Opt1AddPasswordGUI(passwordManager);
				opt1Gui.show();
				dispose();
			}
		});
		choice01btn.setHorizontalAlignment(SwingConstants.LEFT);
		choice01btn.setBounds(50, 70, 300, 33);
		contentPane.add(choice01btn);
		
		choice02btn = new JButton("(2) Search for a password");
		choice02btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Opt2SearchPasswordGUI opt2Gui = new Opt2SearchPasswordGUI(passwordManager);
				opt2Gui.show();
				dispose();
			}
		});
		choice02btn.setHorizontalAlignment(SwingConstants.LEFT);
		choice02btn.setBounds(50, 100, 300, 33);
		contentPane.add(choice02btn);
		
		choice03btn = new JButton("(3) Update a password");
		choice03btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Opt3UpdateAPasswordGUI opt3Gui = new Opt3UpdateAPasswordGUI(passwordManager);
				opt3Gui.show();
				dispose();
			}
		});
		choice03btn.setHorizontalAlignment(SwingConstants.LEFT);
		choice03btn.setBounds(50, 130, 300, 33);
		contentPane.add(choice03btn);
		
		choice04btn = new JButton("(4) Delete a password");
		choice04btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Opt4DeleteAPasswordGUI opt4Gui = new Opt4DeleteAPasswordGUI(passwordManager);
				opt4Gui.show();
				dispose();
			}
		});
		choice04btn.setHorizontalAlignment(SwingConstants.LEFT);
		choice04btn.setBounds(50, 160, 300, 33);
		contentPane.add(choice04btn);
		
		choice05btn = new JButton("(5) Update PasswordManager setting");
		choice05btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Opt5UpdateManagerSettingGUI opt5Gui = new Opt5UpdateManagerSettingGUI(passwordManager);
				opt5Gui.show();
				dispose();
			}
		});
		choice05btn.setHorizontalAlignment(SwingConstants.LEFT);
		choice05btn.setBounds(50, 190, 300, 33);
		contentPane.add(choice05btn);
		
		choice06btn = new JButton("(6) Sign out");
		choice06btn.setForeground(Color.RED);
		choice06btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI loginGui = new LoginGUI(passwordManager);
				loginGui.show();
				dispose();
			}
		});
		choice06btn.setHorizontalAlignment(SwingConstants.LEFT);
		choice06btn.setBounds(50, 220, 300, 33);
		contentPane.add(choice06btn);
	}

}
