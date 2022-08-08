package model;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface SalesDAO {
public int create(Sales sales) throws ClassNotFoundException, SQLException;
public Sales[] read() throws ClassNotFoundException, SQLException, ParseException;
public void update();
public void delete();

}
