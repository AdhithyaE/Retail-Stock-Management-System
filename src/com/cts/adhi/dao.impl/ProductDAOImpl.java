package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ProductDAOImpl implements ProductDAO{
	private Connection getConn() throws ClassNotFoundException, SQLException {
		ResourceBundle rb = ResourceBundle.getBundle("db");
		Class.forName(rb.getString("driver"));
	   return	DriverManager.getConnection(rb.getString("url"),rb.getString("username"),rb.getString("password"));

	}
	public Products create(Products products) throws ClassNotFoundException, SQLException {
		Connection con =getConn();
		PreparedStatement st = con.prepareStatement("INSERT INTO PRODUCT VALUES(?,?,?,?,?,?)");
		st.setString(1, products.getProductId());
		st.setString(2, products.getProductName());
		st.setString(3, products.getType());
		st.setString(4, products.getBrandId());
		st.setDouble(5, products.getPrice());
		st.setInt(6, products.getStock());
		int no=st.executeUpdate();
			return products;
		
	}
//	public List<Products> read() throws ClassNotFoundException, SQLException {
//			Connection con = getConn();
//			List<Products> productList= new ArrayList<>(); 
//			PreparedStatement st = con.prepareStatement("SELECT * FROM PRODUCT");
//			ResultSet rs = st.executeQuery();
//			Products products=null;
//			while(rs.next()) {
//				products=new Products(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getInt(6));
//				productList.add(products);
//			}
//			return productList;
//	
	public Products[] read() throws ClassNotFoundException, SQLException {
		Connection con = getConn();
		PreparedStatement st = con.prepareStatement("SELECT * FROM product");
		ResultSet rs = st.executeQuery();
		List<Products> productList=new ArrayList<>();
		Products products=null;
		while(rs.next())
		{
			products=new Products(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getInt(6));
			productList.add(products);
		}
		int len=productList.size();
		Products []product=new Products[len];
		int i=0;
		for(Products p : productList)
		{
			product[i++]=p;
		}
		return product;
	}

	public int update(String productId,int quantity) throws ClassNotFoundException, SQLException {
		Connection con = getConn();
		PreparedStatement st = con.prepareStatement("UPDATE PRODUCT SET STOCK=? WHERE PRODUCTID=?");
		st.setInt(1, quantity);
		st.setString(2, productId);
		int no = st.executeUpdate();
		return no;
		
	}
	public void delete() {}
	
	
}
