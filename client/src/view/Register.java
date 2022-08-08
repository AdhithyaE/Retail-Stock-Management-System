package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import clientmodel.Registration;
import model1.Login1;

import java.awt.Button;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	JPasswordField passwordField;
    
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Register frame = new Register();
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
	public Register() {
		setTitle("Registration Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 627, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 248, 220));
		panel.setBounds(0, 0, 290, 334);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(238, 232, 170));
		panel_1.setBounds(288, 0, 323, 334);
		panel_1.setVisible(false);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		Button button_2 = new Button("Submit");
		button_2.setBackground(new Color(255, 0, 0));
		button_2.setBounds(48, 266, 101, 37);
		panel_1.add(button_2);
		
		
		Button button = new Button("Admin Registration");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//button.setVisible(false);
				panel_1.setVisible(true);
				button_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Registration registration= new Registration();
						String username=textField.getText().toString();
						String password=passwordField.getText().toString();
						if(username.equals("")||password.equals("")||username.matches("[A-Za-z]{1,}")) {
							JOptionPane.showMessageDialog(null,"Invalid Username or Password!!!!");
						}
						else
						{try {
							
							String check=null;
							List<Login1> adminList=registration.usernameCheckAdmin();
							for(Login1 a:adminList) {
								if(a.getUsername().equalsIgnoreCase(username)) {
									check=a.getUsername();
								}
							}
							if(check==null) {
		
							registration.registerAdmin(username,password);
							JOptionPane.showMessageDialog(null,"Admin Account Created");
						
							}
							else {
								JOptionPane.showMessageDialog(null,"Username already exists!!!!");
							
							}
							}catch (MalformedURLException e1) {

							e1.printStackTrace();

						} catch (IOException e2) {

							e2.printStackTrace();

						}}
					}
				});
			}
		});
		button.setBackground(new Color(255, 215, 0));
		button.setBounds(46, 99, 169, 41);
		panel.add(button);
		
		Button button_1 = new Button("Sales Manager Registration");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//button_1.setVisible(false);
				panel_1.setVisible(true);
				panel_1.setBackground(new Color(152, 227, 54));
				button_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Registration registration= new Registration();
						String username=textField.getText().toString();
						String password=passwordField.getText().toString();
						if(username.equals("")||password.equals("")||username.matches("[A-Za-z]{1,}")) {
							JOptionPane.showMessageDialog(null,"Invalid Username or Password!!!!");
						}
						else
						{try {
							
							
							String check=null;
							List<Login1> smList=registration.usernameCheckSM();
							for(Login1 a:smList) {
								if(a.getUsername().equalsIgnoreCase(username)) {
									check=a.getUsername();
								}
							}
							if(check==null) {
							
							registration.registerSM(username,password);
							JOptionPane.showMessageDialog(null,"SalesManager Account Created");
							System.out.println("SalesManager Account Created");
						
						}
							else {
								JOptionPane.showMessageDialog(null,"Username already exists!!!!");
								System.out.println("Username already exists!!!!");
							}
							}
							catch (MalformedURLException e1) {

								e1.printStackTrace();

							} catch (IOException e2) {

								e2.printStackTrace();

							}}
					}
				});
			}
		});
		button_1.setBackground(new Color(0, 204, 153));
		button_1.setBounds(46, 178, 169, 41);
		panel.add(button_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Register.class.getResource("/view/background.jpg")));
		lblNewLabel.setBounds(0, 0, 290, 334);
		panel.add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(38, 66, 101, 37);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1.setBounds(38, 147, 101, 37);
		panel_1.add(lblNewLabel_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(38, 195, 219, 27);
		panel_1.add(passwordField);
		
		
		textField = new JTextField();
		textField.setBounds(38, 105, 219, 27);
		panel_1.add(textField);
		textField.setColumns(10);
		
	}

}
