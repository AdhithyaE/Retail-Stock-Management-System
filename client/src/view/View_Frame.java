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

public class View_Frame extends JFrame {

	private JPanel contentPane;
	JList list;
	DefaultListModel<String> l1 = new DefaultListModel<>();
	public View_Frame(List<String> plist) throws HeadlessException {
		String top=String.format("%-15s %-15s %-15s %-15s %-15s %-15s\n","PRODUCT_ID","PRODUCT_NAME","TYPE","BRAND_ID","PRICE","STOCK");
		setTitle("Products Details");
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

/*	public View_Frame(List<String> plist) {
		for(String s:plist)
			l1.addElement(s);
		setTitle("Products Details");
		contentPane = new JPanel(null);
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		list=new JList<>(l1);
		this.add(list);
		list.setBackground(Color.WHITE);
		list.setSelectionBackground(Color.red);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 495);
		
	}
	*/


}


/**
 * Launch the application.
 */
//public static void main(String[] args) {
//	EventQueue.invokeLater(new Runnable() {
//		public void run() {
//			try {
//				View_Frame frame = new View_Frame();
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