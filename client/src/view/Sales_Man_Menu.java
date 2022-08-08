package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clientmodel.View;
import model1.Products;
import model1.Sales;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Sales_Man_Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Sales_Man_Menu frame = new Sales_Man_Menu();
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
	public Sales_Man_Menu() {
		setTitle("Sales Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 805, 470);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 378, 431);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Sales_Man_Menu.class.getResource("/view/SM.jpg")));
		lblNewLabel.setBounds(-135, 0, 513, 589);
		panel.add(lblNewLabel);
		
		Button button = new Button("View Sales Details");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View view= new View();
				try {
					List<Sales> salesList=view.salesView();
					List<String> sales=new ArrayList<String>();
					for(Sales s:salesList)
						sales.add(s.toString());
					View_Sales frame=new View_Sales(sales);
					frame.setVisible(true);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//View_Frame frame = new View_Frame();
				//frame.setVisible(true);
			}
		});
		button.setForeground(new Color(0, 0, 0));
		button.setBackground(new Color(255, 153, 102));
		button.setBounds(406, 26, 184, 40);
		contentPane.add(button);
		Button button_2 = new Button("VIEW PRODUCT DETAILS");
		button_2.addActionListener(new ActionListener() {
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
		button_2.setForeground(new Color(0, 0, 0));
		button_2.setBackground(new Color(155, 53, 102));
		button_2.setBounds(406, 90, 184, 40);
		contentPane.add(button_2);
		Button button_1 = new Button("Make a Sale");
        button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String productnames="";
				String producttype="";
				List<String> plist=new ArrayList<String>();
				View view= new View();
				List<Products> productList;
				
				try {
					productList = view.productsView();
					
					for(Products p:productList) {
						int f=0;
						productnames+=p.getProductName()+":";
						for(String pt:plist)	
						{
							if(pt.equals(p.getType()))
							{  f=1;  
							
							}
						}
						if(f==0)
						{ producttype+=p.getType()+":";
						plist.add(p.getType());
						}
						
						
					}
					String[] names=productnames.split(":");
					String[] types=producttype.split(":");
					Sale_Frame frame = new Sale_Frame(names,types);
					frame.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				//Sale_Frame frame = new Sale_Frame();
				
				//frame.setVisible(true);
			}
		});
		button_1.setForeground(new Color(255, 255, 255));
		button_1.setBackground(new Color(51, 153, 51));
		button_1.setBounds(406, 157, 184, 40);
		contentPane.add(button_1);
	}

}
