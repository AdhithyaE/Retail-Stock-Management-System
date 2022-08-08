package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class View_Sales extends JFrame {

	private JPanel contentPane;
	JList list;
	DefaultListModel<String> l1 = new DefaultListModel<>();
	public View_Sales(List<String> plist) throws HeadlessException {
		setTitle("Sales Details");
		String top=String.format("%-20s %-20s %-20s\n","PRODUCT_ID","Date Of Purchase","QUANTITY");
		setTitle("Sales Details");
		contentPane=new JPanel(null);
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		JPanel panel = new JPanel();
		panel.setBounds(10, 10,500,400);
		panel.setBackground(new Color(255, 255, 153));
		contentPane.add(panel);
		l1.addElement(top);
		for(String s:plist)
			l1.addElement(s);
		
		list=new JList<>(l1);
		this.add(list);
		list.setBackground(Color.WHITE);
		list.setSelectionBackground(Color.red);
		panel.add(list);
		contentPane.add(panel);
		setContentPane(contentPane);
		this.setSize(500,500);
		this.setVisible(true);
	}



}
