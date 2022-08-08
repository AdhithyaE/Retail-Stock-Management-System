package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clientmodel.ProductPost;
import clientmodel.View;
import model1.Products;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Button;
import javax.swing.ImageIcon;

public class Add_Frame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Add_Frame frame = new Add_Frame();
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
	public Add_Frame() {
		setTitle("Add new product");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 817, 485);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter the product id");
		lblNewLabel.setBounds(432, 31, 108, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter the product name");
		lblNewLabel_1.setBounds(432, 65, 145, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter the product type");
		lblNewLabel_2.setBounds(432, 106, 119, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Enter the brand id");
		lblNewLabel_3.setBounds(432, 147, 119, 36);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Enter the price of the product");
		lblNewLabel_4.setBounds(432, 190, 187, 31);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Enter the stock value");
		lblNewLabel_5.setBounds(432, 233, 156, 30);
		contentPane.add(lblNewLabel_5);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 356, 446);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(595, 31, 196, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(595, 69, 196, 22);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(595, 110, 196, 22);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(595, 154, 196, 22);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(595, 194, 196, 22);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(595, 238, 196, 22);
		contentPane.add(textField_5);
		
		Button button = new Button("Add");
		button.setBounds(534, 305, 102, 30);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View view= new View();
				try {
					
					List<Products> p=view.productsView();
					String pId=null;
					System.out.println("Enter the product id");
					String productId=textField.getText().toString();
					for(Products product:p) {
						if(product.getProductId().equalsIgnoreCase(productId)) {
							pId=product.getProductId();
						}
					}
					if(pId==null) {
					System.out.println("Enter the product name");
					System.out.println("Enter the product type");
					System.out.println("Enter the brand id");
					System.out.println("Enter the price of the product");
					System.out.println("Enter the stock value");
					String productName=textField_1.getText().toString();
					String type=textField_2.getText().toString();
					String bid=textField_3.getText().toString();
					double price=Double.parseDouble(textField_4.getText().toString());
					int stock=Integer.parseInt(textField_5.getText().toString());
					ProductPost productPost=new ProductPost();
					productPost.addProduct(productId, productName, type, bid, price, stock);
					JOptionPane.showMessageDialog(null,"This product is added to the inventory!!!!");
					System.out.println("This product is added to the inventory!!!!");
				} 
					else {
						JOptionPane.showMessageDialog(null,"This product already exists!!!!!!");
						System.out.println("This product already exists!!!!!!");
					}
					}catch (MalformedURLException e1) {

					e1.printStackTrace();

				} catch (IOException e2) {

					e2.printStackTrace();

				}
	            
			}
		});
	}
}





