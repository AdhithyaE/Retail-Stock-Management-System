package model;

import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {
public Products create(Products product) throws ClassNotFoundException, SQLException;
public Products[] read() throws ClassNotFoundException, SQLException;
public int update(String productId,int quantity) throws ClassNotFoundException, SQLException;
public void delete();
}
