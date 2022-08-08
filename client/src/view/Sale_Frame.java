package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.codehaus.jackson.map.ObjectMapper;

import clientmodel.Login;
import clientmodel.ProductPut;
import clientmodel.SalesPost;
import clientmodel.View;
import model1.Products;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.Button;
import java.awt.Color;

public class Sale_Frame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Sale_Frame frame = new Sale_Frame();
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
	public Sale_Frame(String[] names,String[] types) {
		setTitle("Make Sale");
	String[] products= { 	"TELEVISION",
				 "HEADPHONES",
				"CAMERA",
				"MOBILE PHONES"};
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 442);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 315, 403);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Sale_Frame.class.getResource("/view/try.jpg")));
		lblNewLabel.setBounds(-63, 0, 378, 403);
		panel.add(lblNewLabel);
		
		//JLabel lblNewLabel_1 = new JLabel("Choose the Product");
		//lblNewLabel_1.setBounds(330, 32, 129, 29);
		//contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Choose Product Name");
		lblNewLabel_1_1.setBounds(325, 77, 129, 29);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Choose Product Type");
		lblNewLabel_1_2.setBounds(330, 134, 129, 29);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Enter the Quantity");
		lblNewLabel_1_3.setBounds(330, 174, 129, 29);
		contentPane.add(lblNewLabel_1_3);
		
		//JComboBox comboBox = new JComboBox(products);
		//comboBox.setBounds(473, 36, 121, 25);
		//contentPane.add(comboBox);
		//JComboBox comboBox_2 ;
		
		JComboBox comboBox_1 = new JComboBox(names);
		comboBox_1.setBounds(473, 77, 121, 25);
		String producttype="";
		String[] type1;
		JComboBox comboBox_2 = new JComboBox(types);
		comboBox_2.setBounds(473, 138, 121, 25);
		contentPane.add(comboBox_1);
		contentPane.add(comboBox_2);
	

		
		comboBox_1.addActionListener(new ActionListener() {
		
            public void actionPerformed(ActionEvent e) {
            //	contentPane.setVisible(false);
            	String producttype1="";
            	String productname=comboBox_1.getSelectedItem().toString();
            	int index=comboBox_1.getSelectedIndex();
				comboBox_1.setSelectedIndex(index);
				
				//System.out.println(index);
				List<String> plist=new ArrayList<String>();
				List<String> pl=new ArrayList<String>();
				View view= new View();
				List<Products> productList;
				String ptype="";
				int index1=0;
				try {
					productList = view.productsView();
					
					for(Products p:productList) {
						if(p.getProductName().equals(productname)) {
							ptype=p.getType();
							
						}}
					 System.out.println(ptype);
					for (int i=0;i<types.length;i++) {
						System.out.println(types[i].equals(ptype));
					    if (types[i].equals(ptype)) {
					    	{ index1= i;
					       }
					    }
					   // System.out.println(index1);
					   // comboBox_2.setSelectedIndex(index1);
					}
					System.out.println(index1);
					comboBox_2.setSelectedIndex(index1);
					//String[] type1=producttype1.split(":");
					//JComboBox comboBox_2 = new JComboBox(type1);
					//comboBox_2.setBounds(473, 138, 121, 25);
					//contentPane.add(comboBox_2);
					//	contentPane.setVisible(true);
					
						
					}
	
				
	
						
				catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
            }
		 });
		   
				
		
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(473, 178, 92, 25);
		contentPane.add(spinner);
		
		Button button = new Button("Make Sale");
		button.setBackground(new Color(255, 204, 153));
		button.setBounds(414, 231, 92, 47);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	String product=comboBox.getSelectedItem().toString();
				String producttype=comboBox_2.getSelectedItem().toString();
				String productname=comboBox_1.getSelectedItem().toString();
				int quantity=(Integer) spinner.getValue();
				try {

					SalesPost salesPost = new SalesPost();
					BufferedReader br=salesPost.MakeASale();
					String output;
					while ((output = br.readLine()) != null) {
						ObjectMapper mapper= new ObjectMapper();
						List<Products> productsList=Arrays.asList(mapper.readValue(output, Products[].class));
						//for(Products p:productsList) {
						///	if(p.getProductId().startsWith("TV")) {
							//	System.out.println(p.getProductName());
						///	}}
						System.out.println("Enter the product Name");
						
	                 
						System.out.println("Enter the type");
						
						System.out.println("Enter the quantity");
					     boolean check=false;
					     Date date1=new Date();
							SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
							String sDate=sdf.format(date1);
						for(Products r:productsList) {
							if(r.getProductName().equalsIgnoreCase(productname)&&r.getType().equalsIgnoreCase(producttype)) {
								int balanceStock=0;
								Products pro=new Products();
								balanceStock=r.getStock()-quantity;
								if(balanceStock>=0) {
									pro=r;
									check=true;
									try {
										salesPost.SaleUpdate(pro.getProductId(), sDate, quantity);
										System.out.println("Sale Completed");
										ProductPut netClientPut = new ProductPut();
										netClientPut.updateProduct(pro.getProductId(), balanceStock);
										JOptionPane.showMessageDialog(null,"Sale Completed");
									} catch (MalformedURLException e1) {
										e1.printStackTrace();
									} catch (IOException e2) {
										e2.printStackTrace();
									}
								}
								else {
									JOptionPane.showMessageDialog(null,"Not enough stock");
									System.out.println("Not enough stock");
								}
							}
						}

					}

				} catch (Exception e1) {
					System.out.println("Exception in NetClientGet:- " + e1);
				}
				
				
			}
		});
	}
}
