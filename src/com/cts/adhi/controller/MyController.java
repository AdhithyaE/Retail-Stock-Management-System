package com.cts.adarsh;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Login;
import model.ProductDAOImpl;
import model.Products;
import model.RegistrationDAOImpl;
import model.Sales;
import model.SalesDAOImpl;
import model.Update;

@Path("/")
public class MyController {
@GET
@Produces(MediaType.APPLICATION_JSON)
public Products[] getProduct() throws ClassNotFoundException, SQLException {
	ProductDAOImpl productDAOImpl = new ProductDAOImpl();
	return productDAOImpl.read();
}
@POST
@Path("adminlogin")
@Produces(MediaType.APPLICATION_JSON)
public String adminLogin(Login login) throws ClassNotFoundException, SQLException {
	String check="";
	RegistrationDAOImpl registrationImpl= new RegistrationDAOImpl();
	List<Login> adminList=registrationImpl.readAdmin();
	Login adminCheck=null;
	for(Login admin:adminList) {
		if(admin.getUsername().equals(login.getUsername()))
			adminCheck=admin;
	}
	if(login.getUsername().equals(adminCheck.getUsername()) && (login.getPassword().equals(adminCheck.getPassword()))){
		 check="true";
	}
	return check;
}
@POST
@Path("salesManagerlogin")
@Produces(MediaType.APPLICATION_JSON)
public String salesManagerLogin(Login login) throws ClassNotFoundException, SQLException {
	String check="";
	RegistrationDAOImpl registrationImpl= new RegistrationDAOImpl();
	List<Login> smList=registrationImpl.readsalesManager();
	Login adminCheck=null;
	for(Login sm:smList) {
		if(sm.getUsername().equals(login.getUsername()))
			adminCheck=sm;
	}
	if(login.getUsername().equals(adminCheck.getUsername()) && (login.getPassword().equals(adminCheck.getPassword()))){
		 check="true";
	}
	return check;
}

@POST
@Path("sales")
@Consumes(MediaType.APPLICATION_JSON)
public void saleProduct(Sales sales) throws ClassNotFoundException, SQLException {
	SalesDAOImpl salesDAOImpl = new SalesDAOImpl();
	salesDAOImpl.create(sales);
}
@PUT
@Path("updateproduct")
@Consumes(MediaType.APPLICATION_JSON)
public void updateProduct(Update update) throws ClassNotFoundException, SQLException {
	ProductDAOImpl productDAOImpl= new ProductDAOImpl();
	productDAOImpl.update(update.getProductId(),update.getQuantity());
}
@GET
@Path("salesdata")
@Produces(MediaType.APPLICATION_JSON)
public Sales[] getSales() throws ClassNotFoundException, SQLException, ParseException {
	SalesDAOImpl salesDAOImpl= new SalesDAOImpl();
	return salesDAOImpl.read();
}
@POST
@Path("inventory")
@Consumes(MediaType.APPLICATION_JSON)
public void addProduct(Products product) throws ClassNotFoundException, SQLException {
	ProductDAOImpl productDAOImpl= new ProductDAOImpl();
	productDAOImpl.create(product);
}
@POST
@Path("adminregistration")
@Consumes(MediaType.APPLICATION_JSON)
public void addadmin(Login login) throws ClassNotFoundException, SQLException {
	RegistrationDAOImpl registrationImpl= new RegistrationDAOImpl();
	registrationImpl.createAdmin(login);
}
@POST
@Path("smregistration")
@Consumes(MediaType.APPLICATION_JSON)
public void addSalesManager(Login login) throws ClassNotFoundException, SQLException {
	RegistrationDAOImpl registrationImpl= new RegistrationDAOImpl();
	registrationImpl.createSalesManager(login);
}
@GET
@Path("adminregistration")
@Produces(MediaType.APPLICATION_JSON)
public Login[] getAdmin() throws ClassNotFoundException, SQLException {
	RegistrationDAOImpl registrationImpl= new RegistrationDAOImpl();
	List<Login> loginList=registrationImpl.readAdmin();
	Login ad[]=new Login[loginList.size()];
	int i=0;
	for(Login l:loginList) {
		ad[i++]=l;
	}
	return ad;
}
@GET
@Path("smregistration")
@Produces(MediaType.APPLICATION_JSON)
public Login[] getSalesManager() throws ClassNotFoundException, SQLException {
	RegistrationDAOImpl registrationImpl= new RegistrationDAOImpl();
	List<Login>loginList =registrationImpl.readsalesManager();
	Login sm[]=new Login[loginList.size()];
	int i=0;
	for(Login l:loginList) {
		sm[i++]=l;
	}
	return sm;
}

}
