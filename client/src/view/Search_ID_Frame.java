package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clientmodel.View;
import model1.Products;

import java.awt.Color;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.awt.event.ActionEvent;

public class Search_ID_Frame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Search_ID_Frame frame = new Search_ID_Frame();
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
	public Search_ID_Frame() {
		setTitle("Search by BrandId");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 755, 456);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 744, 258);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 760, 255);
		lblNewLabel.setIcon(new ImageIcon(Search_ID_Frame.class.getResource("/view/search.png")));
		panel.add(lblNewLabel);
		
		Label label = new Label("Enter the Brand Id");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		label.setBounds(208, 282, 131, 39);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(345, 292, 137, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		Button button = new Button("Search");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List <String> bc=new ArrayList<String>();
				try {
					View view= new View();
					List<Products> p=view.productsView();
					Set<String> brand=new TreeSet<String>();
					for(Products product:p) {
						brand.add(product.getBrandId());
					}
                
					
					for(String b:brand) {
						System.out.println(b);
					}
					String brandId=textField.getText().toString();
					System.out.format("%-20s %-25s %-20s %-20s %-20s %-20s\n","PRODUCT_ID","PRODUCT_NAME","TYPE","BRAND_ID","PRICE","STOCK");
					for(Products product:p)
					{  if(product.getBrandId().equals(brandId))
						{System.out.format("%-20s %-25s %-20s %-20s %-20s %-20s\n",product.getProductId(),product.getProductName(),product.getType(),product.getBrandId(),product.getPrice(),product.getStock());
					bc.add(product.toString());
						}
					
					}
					if(!bc.isEmpty())
					{View_Frame frame = new View_Frame(bc);
					frame.setVisible(true);}
					else {
						JOptionPane.showMessageDialog(null,"BrandId doesn't exists!!!!");
					}

			} catch (Exception e1) {
				System.out.println("Exception in NetClientGet:- " + e1);
			}
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(Color.DARK_GRAY);
		button.setBounds(308, 337, 70, 22);
		contentPane.add(button);
	}
}
