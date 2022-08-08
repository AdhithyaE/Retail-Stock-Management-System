package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SalesDAOImpl implements SalesDAO {
private Connection getConn() throws ClassNotFoundException, SQLException {
	ResourceBundle rb = ResourceBundle.getBundle("db");
	Class.forName(rb.getString("driver"));
   return	DriverManager.getConnection(rb.getString("url"),rb.getString("username"),rb.getString("password"));

}

@Override
public int create(Sales sales) throws ClassNotFoundException, SQLException {
	Connection con =getConn();
	PreparedStatement st = con.prepareStatement("INSERT INTO SALES VALUES(?,?,?)");
	st.setString(1, sales.getProductId());
	st.setString(2, sales.getDate());
	st.setInt(3, sales.getQuantity());
	int no=st.executeUpdate();
	return no;
	
}

//@Override
//public List<Sales> read() throws ClassNotFoundException, SQLException, ParseException {
//Connection con = getConn();
//List<Sales> salesList= new ArrayList<>(); 
//PreparedStatement st = con.prepareStatement("SELECT * FROM SALES");
//ResultSet rs = st.executeQuery();
//Sales sales=null;
//while(rs.next()) {
//	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//	sales= new Sales(rs.getString(1), sdf.parse(rs.getString(2)), rs.getInt(3));
//	salesList.add(sales);
//}
//
//return salesList;
//	
//}
public Sales[] read() throws ClassNotFoundException, SQLException, ParseException {
	Connection con = getConn();
	PreparedStatement st = con.prepareStatement("SELECT * FROM sales");
	ResultSet rs = st.executeQuery();
	List<Sales> salesList=new ArrayList<>();
	Sales sales=null;
	while(rs.next())
	{
		sales= new Sales(rs.getString(1),rs.getString(2), rs.getInt(3));
		salesList.add(sales);
	}
	int len=salesList.size();
	Sales [] sale=new Sales[len];
	int i=0;
	for(Sales s : salesList)
	{
		sale[i++]=s;
	}
	return sale;
}

@Override
public void update() {
	// TODO Auto-generated method stub
	
}

@Override
public void delete() {
	// TODO Auto-generated method stub
	
}

}
