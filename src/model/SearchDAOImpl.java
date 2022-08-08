package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

//import model.Brand;
//import model.Product;

public class SearchDAOImpl {
	public Connection getCon() throws SQLException, ClassNotFoundException {
		ResourceBundle rb= ResourceBundle.getBundle("db");
		//Load driver
		Class.forName(rb.getString("driver"));
		String url=rb.getString("url");
		String userName=rb.getString("username");
		String pass=rb.getString("password");

		//Connection
		Connection con=DriverManager.getConnection(url, userName, pass);
		return con;
	}
//	Method for adding new products
	
	public void createProducts(Products product) throws ClassNotFoundException, SQLException {
		int a=0;
		Connection con=getCon();
		PreparedStatement st= con.prepareStatement("insert into Product values(?,?,?,?,?,?)");
		st.setString(1, product.getProductId());
		st.setString(2, product.getProductName());
		st.setString(3, product.getType());
		st.setString(4, product.getBrandId());
		st.setDouble(5, product.getPrice());
		st.setInt(6, product.getStock());
		a+=st.executeUpdate();
		System.out.println(a+" rows effected");
	}
//	Method for adding Brand details
	
	public void createBrand(Brand brand) throws ClassNotFoundException, SQLException {
		int a=0;
		Connection con=getCon();
		PreparedStatement st= con.prepareStatement("insert into Brand values(?,?)");
		st.setString(1, brand.getBrandId());
		st.setString(2, brand.getBrandName());
		a+=st.executeUpdate();
		System.out.println(a+" rows effected");
	}
//	Method for deleting Brand Details
	
	public void deleteBrand( ) throws ClassNotFoundException, SQLException {
		Connection con=getCon();
		PreparedStatement st=con.prepareStatement("delete from Brand");
		st.executeUpdate();
	}
	
	public void deleteProduct() throws ClassNotFoundException, SQLException {
		Connection con=getCon();
		PreparedStatement st=con.prepareStatement("delete from Product");
		st.executeUpdate();
	}
	public List<Products> findProductByType(String type) throws ClassNotFoundException, SQLException {
		List<Products> result =new ArrayList<Products>();
		Connection con=getCon();
		PreparedStatement st1=con.prepareStatement("select * from Product where type=?");
		st1.setString(1, type);
		ResultSet rs=st1.executeQuery();
		while(rs.next()) {
			Products product =new Products(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6));
			result.add(product);
		}
		return result;
	}
	

	
	public List<Products> findProductByBrandId(String brandId) throws SQLException, ClassNotFoundException{
		List<Products> result =new ArrayList<Products>();
		Connection con=getCon();
		PreparedStatement st1=con.prepareStatement("select * from Product where brandId=?");
		st1.setString(1, brandId);
		ResultSet rs=st1.executeQuery();
		while(rs.next()) {
			Products product =new Products(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6));
			result.add(product);
		}
		return result;
	}
}