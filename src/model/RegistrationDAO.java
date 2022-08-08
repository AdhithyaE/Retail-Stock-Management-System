package model;

import java.sql.SQLException;
import java.util.List;

public interface RegistrationDAO {
	public void createAdmin(Login login) throws ClassNotFoundException, SQLException;
	public void createSalesManager(Login login) throws ClassNotFoundException, SQLException;
	public List<Login> readAdmin() throws ClassNotFoundException, SQLException;
	public List<Login> readsalesManager() throws ClassNotFoundException, SQLException;
}
