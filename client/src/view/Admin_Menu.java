package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.codehaus.jackson.map.ObjectMapper;

import clientmodel.View;
import model1.Products;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;

public class Admin_Menu extends JFrame {

	private JPanel contentPane;

	public Admin_Menu() {
		setTitle("Admin Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 403);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 181));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 230, 140));
		panel.setBounds(0, 78, 253, 204);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Admin_Menu.class.getResource("/view/Admin_Icon.png")));
		lblNewLabel.setBounds(30, 11, 213, 174);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 253, 77);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 280, 253, 84);
		contentPane.add(panel_2);
		
		Button button = new Button("View All Products");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List <String> bc=new ArrayList<String>();
				try {
					View view= new View();
					List<Products> productList=view.productsView();
					System.out.format("%-20s %-25s %-20s %-20s %-20s %-20s\n","PRODUCT_ID","PRODUCT_NAME","TYPE","BRAND_ID","PRICE","STOCK");
					for(Products product:productList)
					{  
						System.out.format("%-20s %-25s %-20s %-20s %-20s %-20s\n",product.getProductId(),product.getProductName(),product.getType(),product.getBrandId(),product.getPrice(),product.getStock());
						bc.add(product.toString());
					
					}
					View_Frame frame = new View_Frame(bc);
					frame.setVisible(true);
				}
			 catch (Exception e1) {
				System.out.println("Exception in NetClientGet:- " + e1);
			}
				
				
					
				
					
				
			}
		});
		button.setBounds(406, 26, 184, 40);
		contentPane.add(button);
		
		Button button_1 = new Button("Search by Brand Id");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Search_ID_Frame frame = new Search_ID_Frame();
				frame.setVisible(true);
			}
		});
		button_1.setBounds(406, 90, 184, 40);
		contentPane.add(button_1);
		
		Button button_2 = new Button("Search By Product Type");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search_Type_Frame frame = new Search_Type_Frame();
				frame.setVisible(true);
			}
		});
		button_2.setBounds(406, 157, 184, 40);
		contentPane.add(button_2);
		
		Button button_3 = new Button("Add New Product");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Add_Frame frame = new Add_Frame();
			frame.setVisible(true);
			}
		});
		button_3.setBounds(406, 223, 184, 40);
		contentPane.add(button_3);
	}

}

/**
 * Launch the application.
 */
//public static void main(String[] args) {
//	EventQueue.invokeLater(new Runnable() {
//		public void run() {
//			try {
//				Admin_Menu frame = new Admin_Menu();
//				frame.setVisible(true);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	});
//}

/**
 * Create the frame.
 */