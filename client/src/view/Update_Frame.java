package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clientmodel.ProductPut;
import clientmodel.View;
import model1.Products;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionEvent;

public class Update_Frame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Update_Frame frame = new Update_Frame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Update_Frame() throws IOException {
		setTitle("Update");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 404, 319);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter the Product Id:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(89, 39, 157, 44);
		contentPane.add(lblNewLabel);
		View view=new View();
		String pids="";
        List<Products> productList = view.productsView();
    		 for(Products p:productList) {
			int f=0;
			pids+=p.getProductId()+":";	
							}
		
		 String[] pid=pids.split(":");
		
		
		JComboBox comboBox = new JComboBox(pid);
//		Add the data to the combobox
		comboBox.setBounds(256, 53, 120, 20);
		contentPane.add(comboBox);
		
		JLabel lblEnterTheStock = new JLabel("Enter the Stock:");
		lblEnterTheStock.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEnterTheStock.setBounds(89, 124, 157, 44);
		contentPane.add(lblEnterTheStock);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(256, 138, 70, 20);
		contentPane.add(spinner);
		
		Button button = new Button("Update");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					System.out.println("Enter the product id to update the stock");
		
					int currentStock=0;
					String pId=comboBox.getSelectedItem().toString();

					for(Products product:productList) {
						if(product.getProductId().equalsIgnoreCase(pId)) {
							//pId=product.getProductId();
							currentStock=product.getStock();
						}
					}
                    if(pId!=null) {
					System.out.println("Enter the number of product stock to be added");
					int stockToBeUpdated=(Integer) spinner.getValue();
					int updatedStock=currentStock+stockToBeUpdated;
					ProductPut netClientPut= new ProductPut();
					netClientPut.updateProduct(pId, updatedStock);
					JOptionPane.showMessageDialog(null,"Updated Successfully!");
			         } 
                    else{
                    	System.out.println("Enter valid product ID");
                    	JOptionPane.showMessageDialog(null,"!!!!");
                    }}
				catch (Exception e2) {
				System.out.println("Exception in NetClientGet:- " + e2);
				
			}
			//Updating the stock of products
		//}
	//}
//				display an alert if the details meet the required crietiria
			}
		});
		button.setFont(new Font("Dialog", Font.PLAIN, 14));
		button.setBackground(new Color(102, 102, 204));
		button.setBounds(173, 182, 89, 37);
		contentPane.add(button);
	}
	public static void main(String args[]) throws IOException {
		new Update_Frame().setVisible(true);;
		
	}
}
