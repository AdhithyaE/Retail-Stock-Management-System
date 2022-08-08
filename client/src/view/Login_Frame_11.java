package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clientmodel.Login;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Button;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JPasswordField;

public class Login_Frame_11 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Login_Frame_1 frame = new Login_Frame_1();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Login_Frame_11() {
		setTitle("Login Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 445);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setBackground(new Color(25, 25, 112));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 303, 406);
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel);
		panel.setLayout(null);
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(46, 139, 87));
		panel_1.setBounds(302, 0, 350, 406);
		panel_1.setVisible(false);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(38, 39, 101, 37);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(37, 76, 219, 27);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1.setBounds(38, 175, 101, 37);
		panel_1.add(lblNewLabel_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(38, 223, 219, 27);
		panel_1.add(passwordField);
		
		Button button_2 = new Button("Submit");
		button_2.setBackground(new Color(255, 0, 0));
		button_2.setBounds(38, 319, 101, 37);
		panel_1.add(button_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(-105, 0, 424, 412);
		panel.add(lblNewLabel);
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setIcon(new ImageIcon(Login_Frame_1.class.getResource("/view/Icon.png")));
		
		Button button = new Button("Login As Admin");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				panel_1.setVisible(true);
				button_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Login login=new Login();
						String username=textField.getText().toString();
						String password=passwordField.getText().toString();
						if(username.equals("")||password.equals("")) {
							JOptionPane.showMessageDialog(null,"Invalid credentials!!!!\nLogin Unsuccessful");
						}
						else
						{boolean authentication=login.adminLogin(username, password,"adminlogin");
						if(authentication==true) {
							
						Admin_Menu frame = new Admin_Menu();
						frame.setVisible(true);}
						else {
							JOptionPane.showMessageDialog(null,"Invalid credentials!!!!\nLogin Unsuccessful");
						}}
					}
				});
			}
		});
		button.setForeground(SystemColor.inactiveCaptionText);
		button.setBackground(new Color(241,57,83));
		button.setBounds(374, 128, 212, 46);
		contentPane.add(button);
		
		Button button_1 = new Button("Login As Sales Manager");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e2) {
				panel_1.setVisible(true);
				panel_1.setBackground(new Color(66, 151, 194));
				button_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Login login=new Login();
						String username=textField.getText().toString();
						String password=passwordField.getText().toString();
						if(username.equals("")||password.equals("")) {
							JOptionPane.showMessageDialog(null,"Invalid credentials!!!!\nLogin Unsuccessful");
						}
						else
							{boolean authentication=false;
						authentication=login.adminLogin(username, password, "salesManagerlogin");
						if(authentication==true) {
						Sales_Man_Menu frame = new Sales_Man_Menu();
						frame.setVisible(true);}
						else  {
							JOptionPane.showMessageDialog(null,"Invalid credentials!!!!\nLogin Unsuccessful");
						}
					}}
					
				});
			}
		});
		button_1.setForeground(Color.BLACK);
		button_1.setBackground(new Color(9,89,54));
		button_1.setBounds(374, 229, 212, 46);
		contentPane.add(button_1);
		
		
		
	}
}
