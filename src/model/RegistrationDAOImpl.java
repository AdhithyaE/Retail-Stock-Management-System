package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class RegistrationDAOImpl implements RegistrationDAO {
	private Connection getConn() throws ClassNotFoundException, SQLException {
		ResourceBundle rb = ResourceBundle.getBundle("db");
		Class.forName(rb.getString("driver"));
	   return	DriverManager.getConnection(rb.getString("url"),rb.getString("username"),rb.getString("password"));

	}
public void createAdmin(Login login) throws ClassNotFoundException, SQLException {
		Connection con =getConn();
		PreparedStatement st = con.prepareStatement("INSERT INTO ADMINDB VALUES(?,?)");
		st.setString(1,login.getUsername() );
		st.setString(2, login.getPassword());
		int no=st.executeUpdate();
	}

public void createSalesManager(Login login) throws ClassNotFoundException, SQLException {
	Connection con =getConn();
	PreparedStatement st = con.prepareStatement("INSERT INTO SALESMANAGERDB VALUES(?,?)");
	st.setString(1,login.getUsername() );
	st.setString(2, login.getPassword());
	int no=st.executeUpdate();
}
public List<Login> readAdmin() throws ClassNotFoundException, SQLException {
	Connection con = getConn();
	PreparedStatement st = con.prepareStatement("SELECT * FROM ADMINDB");
	ResultSet rs = st.executeQuery();
	List<Login> adminList=new ArrayList<>();
	Login login=null;
	
	while(rs.next())
	{
		login=new Login (rs.getString(1),rs.getString(2));
		adminList.add(login);
	}
	return adminList;
}
public List<Login> readsalesManager() throws ClassNotFoundException, SQLException {
	Connection con = getConn();
	PreparedStatement st = con.prepareStatement("SELECT * FROM SALESMANAGERDB");
	ResultSet rs = st.executeQuery();
	List<Login> salesManagerList=new ArrayList<>();
	Login login=null;
	
	while(rs.next())
	{
		login=new Login (rs.getString(1),rs.getString(2));
		salesManagerList.add(login);
	}
	return salesManagerList;
}
}