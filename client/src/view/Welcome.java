package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Label;
import java.awt.Font;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Welcome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome frame = new Welcome();
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
	public Welcome() {
		setTitle("RSMS- Retail Stock Managemet System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 458);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 387, 419);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Welcome.class.getResource("/view/helo.jpg")));
		lblNewLabel.setBounds(-102, 0, 489, 419);
		panel.add(lblNewLabel);
		
		Label label = new Label("RSMS- Retail Stock Managemet System");
		label.setForeground(new Color(51, 102, 204));
		label.setFont(new Font("Times New Roman", Font.BOLD, 18));
		label.setBounds(434, 10, 360, 62);
		contentPane.add(label);
		
		Button button = new Button("Login");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login_Frame_11 frame = new Login_Frame_11();
				frame.setVisible(true);
			}
		});
		button.setFont(new Font("Times New Roman", Font.BOLD, 16));
		button.setBackground(new Color(244, 164, 96));
		button.setBounds(528, 109, 142, 40);
		contentPane.add(button);
		
		Button button_1 = new Button("Register");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register frame = new Register();
				frame.setVisible(true);
			}
		});
		button_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		button_1.setBackground(new Color(244, 164, 96));
		button_1.setBounds(528, 225, 142, 40);
		contentPane.add(button_1);
	}
}
