package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Button;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JPasswordField;

public class Login_Frame_1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Frame_1 frame = new Login_Frame_1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login_Frame_1() {
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
						String username=textField.getText().toString();
						String password=passwordField.getText().toString();
						boolean authentication=false;
						try {
							String url1="http://localhost:8080/Rsms_webservice_demo/rest";
							URL url = new URL(url1+"/"+"adminlogn");
							HttpURLConnection conn = (HttpURLConnection) url.openConnection();
							conn.setDoOutput(true);
							conn.setRequestMethod("POST");
							conn.setRequestProperty("Content-Type", "application/json");

							String input =String.format("{\r\n"
									+ "        \"username\": \"%s\",\r\n"
									+ "        \"password\": \"%s\"\r\n"
									+ "        \r\n"
									+ "    }",username,password );

							OutputStream os = conn.getOutputStream();
							os.write(input.getBytes());
							os.flush();

							BufferedReader br = new BufferedReader(new InputStreamReader(
									(conn.getInputStream())));

							String output;
							while ((output = br.readLine()) != null) {
								if(output.equals("true")) {
									authentication=true;
								}
							}

							conn.disconnect();

						} catch (MalformedURLException e1) {

							e1.printStackTrace();

						} catch (IOException e2) {

							e2.printStackTrace();

						}
						if(authentication==true) {
						Admin_Menu frame = new Admin_Menu();
						frame.setVisible(true);}
						else  {
							JOptionPane.showMessageDialog(null,"Invalid credentials!!!!\nLogin Unsuccessfull");
						}	
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
						String username=textField.getText().toString();
						String password=passwordField.getText().toString();
						boolean authentication=false;
						try {
							String url1="http://localhost:8080/Rsms_webservice_demo/rest";
							URL url = new URL(url1+"/"+"salesManagerlogin");
							HttpURLConnection conn = (HttpURLConnection) url.openConnection();
							conn.setDoOutput(true);
							conn.setRequestMethod("POST");
							conn.setRequestProperty("Content-Type", "application/json");

							String input =String.format("{\r\n"
									+ "        \"username\": \"%s\",\r\n"
									+ "        \"password\": \"%s\"\r\n"
									+ "        \r\n"
									+ "    }",username,password );

							OutputStream os = conn.getOutputStream();
							os.write(input.getBytes());
							os.flush();

							BufferedReader br = new BufferedReader(new InputStreamReader(
									(conn.getInputStream())));

							String output;
							while ((output = br.readLine()) != null) {
								if(output.equals("true")) {
									authentication=true;
								}
							}

							conn.disconnect();

						} catch (MalformedURLException e1) {

							e1.printStackTrace();

						} catch (IOException e2) {

							e2.printStackTrace();

						}
						if(authentication==true) {
						//Sales_Menu_Frame frame = new Sales_Menu_Frame();
						//frame.setVisible(true);
							}
						else  {
							JOptionPane.showMessageDialog(null,"Invalid credentials!!!!\nLogin Unsuccessfull");
						}
					}
				});
			}
		});
		button_1.setForeground(Color.BLACK);
		button_1.setBackground(new Color(9,89,54));
		button_1.setBounds(374, 229, 212, 46);
		contentPane.add(button_1);
		
		
		
	}
}
