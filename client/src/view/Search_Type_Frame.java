package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.codehaus.jackson.map.ObjectMapper;

import clientmodel.View;
import model1.Products;

public class Search_Type_Frame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Search_Type_Frame frame = new Search_Type_Frame();
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
	public Search_Type_Frame() {
		setTitle("Search by product type");
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
		
		Label label = new Label("Enter the Type");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		label.setBounds(208, 282, 131, 39);
		contentPane.add(label);
		
		JTextField textField = new JTextField();
		textField.setBounds(345, 292, 137, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		Button button = new Button("Search");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String productType=textField.getText().toString();
				List <String> bc=new ArrayList<String>();
				try {
					View view= new View();
					List<Products> p=view.productsView();
					Set<String> type =new TreeSet<String>();
					for(Products product:p) {
						type.add(product.getType());
					}
					System.out.println("Enter the product Type");
					for(String t:type) {
						System.out.println(t);
					}
				
					

					System.out.format("%-20s %-25s %-20s %-20s %-20s %-20s\n","PRODUCT_ID","PRODUCT_NAME","TYPE","BRAND_ID","PRICE","STOCK");
					for(Products product:p)
					{  if(product.getType().equalsIgnoreCase(productType))
						{System.out.format("%-20s %-25s %-20s %-20s %-20s %-20s\n",product.getProductId(),product.getProductName(),product.getType(),product.getBrandId(),product.getPrice(),product.getStock());
					bc.add(product.toString());
					
					}}
					if(!bc.isEmpty())
					{View_Frame frame = new View_Frame(bc);
					frame.setVisible(true);}
					else {
						JOptionPane.showMessageDialog(null,"Product Type doesn't exists!!!!");
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
