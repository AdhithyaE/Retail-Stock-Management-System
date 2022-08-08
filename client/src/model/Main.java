package clientmodel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import org.codehaus.jackson.map.ObjectMapper;

import model1.Login1;
import model1.Products;
import model1.Sales;
public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner (System.in);
		System.out.println("Welcome "
				+ "Choose your mode of login\n"
				+ "1.Admin Login\n"
				+ "2.SalesManager Login\n"
				+ "3.Admin Registration\n"
				+ "4.SalesManager Registration");
		int loginChoice=sc.nextInt();
		boolean authentication=false;
		View view= new View();
		Login login=new Login();
		Registration registration= new Registration();
		String username="";
		String password="";
		switch(loginChoice) {
		case 1:
			System.out.println("Enter Username");
			username=sc.next();
			System.out.println("Enter Password");
			password=sc.next();
			authentication=login.adminLogin(username, password,"adminlogin");
			if(authentication==true) {
				//code for admin menu
				System.out.println("Welcome Admin\n"
						+ "MENU\n"
						+ "1.View the all the products.\r\n"
						+ "2.Search by Brand Id.\r\n"
						+ "3.Search by Product Type\r\n"
						+ "4.Add new Product Details\r\n"
						+ "5.Update the stock of existing product");
				int adminChoice=sc.nextInt();
				switch(adminChoice) {
				case 1:
					try {
							List<Products> productList=view.productsView();
							System.out.format("%-20s %-25s %-20s %-20s %-20s %-20s\n","PRODUCT_ID","PRODUCT_NAME","TYPE","BRAND_ID","PRICE","STOCK");
							for(Products product:productList)
							{  
								System.out.format("%-20s %-25s %-20s %-20s %-20s %-20s\n",product.getProductId(),product.getProductName(),product.getType(),product.getBrandId(),product.getPrice(),product.getStock());
							}
						}
					 catch (Exception e) {
						System.out.println("Exception in NetClientGet:- " + e);
					}
					break;//break of view products
				case 2:
					try {
							List<Products> p=view.productsView();
							Set<String> brand=new TreeSet<String>();
							for(Products product:p) {
								brand.add(product.getBrandId());
							}

							System.out.println("Enter the brand id");
							for(String b:brand) {
								System.out.println(b);
							}
							String brandId=sc.next();
							System.out.format("%-20s %-25s %-20s %-20s %-20s %-20s\n","PRODUCT_ID","PRODUCT_NAME","TYPE","BRAND_ID","PRICE","STOCK");
							for(Products product:p)
							{  if(product.getBrandId().equals(brandId))
								System.out.format("%-20s %-25s %-20s %-20s %-20s %-20s\n",product.getProductId(),product.getProductName(),product.getType(),product.getBrandId(),product.getPrice(),product.getStock());
							}

					} catch (Exception e) {
						System.out.println("Exception in NetClientGet:- " + e);
					}
					break;//break of search by brand
				case 3:
					try {
							List<Products> p=view.productsView();
							Set<String> type =new TreeSet<String>();
							for(Products product:p) {
								type.add(product.getType());
							}
							System.out.println("Enter the product Type");
							for(String t:type) {
								System.out.println(t);
							}
							String productType=sc.nextLine();
							if(productType.equals("")) {
								productType=sc.nextLine();
							}

							System.out.format("%-20s %-25s %-20s %-20s %-20s %-20s\n","PRODUCT_ID","PRODUCT_NAME","TYPE","BRAND_ID","PRICE","STOCK");
							for(Products product:p)
							{  if(product.getType().equalsIgnoreCase(productType))
								System.out.format("%-20s %-25s %-20s %-20s %-20s %-20s\n",product.getProductId(),product.getProductName(),product.getType(),product.getBrandId(),product.getPrice(),product.getStock());
							}

					} catch (Exception e) {
						System.out.println("Exception in NetClientGet:- " + e);
					}
					break;//BREAK OF search by product type
				case 4:
					try {
						List<Products> p=view.productsView();
						String pId=null;
						System.out.println("Enter the product id");
						String productId=sc.next();
						for(Products product:p) {
							if(product.getProductId().equalsIgnoreCase(productId)) {
								pId=product.getProductId();
							}
						}
						if(pId==null) {
						System.out.println("Enter the product name");
						String productName=sc.nextLine();
						if(productName.equals(""))
						productName=sc.nextLine();
						System.out.println("Enter the product type");
						String type=sc.nextLine();
						System.out.println("Enter the brand id");
						String bid=sc.next();
						System.out.println("Enter the price of the product");
						double price=sc.nextDouble();
						System.out.println("Enter the stock value");
						int stock=sc.nextInt();
						ProductPost productPost=new ProductPost();
						productPost.addProduct(productId, productName, type, bid, price, stock);
						System.out.println("This product is added to the inventory!!!!");
					} 
						else {
							System.out.println("This product already exists!!!!!!");
						}
						}catch (MalformedURLException e) {

						e.printStackTrace();

					} catch (IOException e) {

						e.printStackTrace();

					}
					break;//Add products to the inventory
				case 5:
					try {
							List<Products> productList=view.productsView();
							System.out.println("Enter the product id to update the stock");
							String pId=null;
							int currentStock=0;
							String productId=sc.next();
							for(Products product:productList) {
								if(product.getProductId().equalsIgnoreCase(productId)) {
									pId=product.getProductId();
									currentStock=product.getStock();
								}
							}
                            if(pId!=null) {
							System.out.println("Enter the number of product stock to be added");
							int stockToBeUpdated=sc.nextInt();
							int updatedStock=currentStock+stockToBeUpdated;
							ProductPut netClientPut= new ProductPut();
							netClientPut.updateProduct(productId, updatedStock);
					} 
                            else{
                            	System.out.println("Enter valid product ID");
                            }}catch (Exception e) {
						System.out.println("Exception in NetClientGet:- " + e);
					}
					break; //Updating the stock of products
				}
			}
			break;
		case 2:
			System.out.println("Enter Username");
			username=sc.next();
			System.out.println("Enter Password");
			password=sc.next();
			authentication=login.adminLogin(username, password, "salesManagerlogin");
			if(authentication==true) {

				System.out.println("Welcome SalesManager\n"
						+ "MENU\n"
						+ "1.MAKE A SALE\n\r\n"
						+ "2.VIEW SALES DETAILS\n\r\n"
						+ "3.VIEW PRODUCT DETAILS");
				int salesoption=sc.nextInt();
				switch(salesoption) {
				case 1:
					System.out.println("Choose the product");
					System.out.println("1.TELEVISION \n"
							+ "2.HEADPHONES\n"
							+ "3.CAMERA\n"
							+ "4.MOBILE PHONES\n");
					int choice = sc.nextInt();
					int quantity;
					int balanceStock;
					boolean check=false;
					Products pro=null;
					Date date1=new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					String sDate=sdf.format(date1);
					switch (choice) {
					case 1:
						try {

							SalesPost salesPost = new SalesPost();
							BufferedReader br=salesPost.MakeASale();
							String output;
							while ((output = br.readLine()) != null) {
								ObjectMapper mapper= new ObjectMapper();
								List<Products> productsList=Arrays.asList(mapper.readValue(output, Products[].class));
								for(Products p:productsList) {
									if(p.getProductId().startsWith("TV")) {
										System.out.println(p.getProductName());
									}}
								System.out.println("Enter the product Name");
								String name=sc.nextLine();
								if(name.equals(""))
									name=sc.nextLine();
								for(Products s:productsList) {
									if(s.getProductName().equalsIgnoreCase(name)) {
										System.out.println(s.getType());
									}
								}
								System.out.println("Enter the type");
								String type=sc.nextLine();
								System.out.println("Enter the quantity");
								quantity=sc.nextInt();
								for(Products r:productsList) {
									if(r.getProductName().equalsIgnoreCase(name)&&r.getType().equalsIgnoreCase(type)) {
										balanceStock=r.getStock()-quantity;
										if(balanceStock>=0) {
											pro=r;
											check=true;
											try {
												salesPost.SaleUpdate(pro.getProductId(), sDate, quantity);
												System.out.println("Sale Completed");
												ProductPut netClientPut = new ProductPut();
												netClientPut.updateProduct(pro.getProductId(), balanceStock);
											} catch (MalformedURLException e) {
												e.printStackTrace();
											} catch (IOException e) {
												e.printStackTrace();
											}
										}
										else {
											System.out.println("Not enough stock");
										}
									}
								}

							}

						} catch (Exception e) {
							System.out.println("Exception in NetClientGet:- " + e);
						}
						break;
					case 2:
						try {

							SalesPost salesPost = new SalesPost();
							BufferedReader br=salesPost.MakeASale();
							String output;
							while ((output = br.readLine()) != null) {
								ObjectMapper mapper= new ObjectMapper();
								List<Products> productsList=Arrays.asList(mapper.readValue(output, Products[].class));
								for(Products p:productsList) {
									if(p.getProductId().startsWith("HP")) {
										System.out.println(p.getProductName());
									}}
								System.out.println("Enter the product Name");
								String name=sc.nextLine();
								if(name.equals(""))
									name=sc.nextLine();
								for(Products s:productsList) {
									if(s.getProductName().equalsIgnoreCase(name)) {
										System.out.println(s.getType());
									}
								}
								System.out.println("Enter the type");
								String type=sc.nextLine();
								System.out.println("Enter the quantity");
								quantity=sc.nextInt();
								for(Products r:productsList) {
									if(r.getProductName().equalsIgnoreCase(name)&&r.getType().equalsIgnoreCase(type)) {
										balanceStock=r.getStock()-quantity;
										if(balanceStock>=0) {
											pro=r;
											check=true;
											try {

												salesPost.SaleUpdate(pro.getProductId(), sDate, quantity);
												System.out.println("Sale Completed");
												ProductPut netClientPut = new ProductPut();
												netClientPut.updateProduct(pro.getProductId(), balanceStock);
											} catch (MalformedURLException e) {
												e.printStackTrace();
											} catch (IOException e) {
												e.printStackTrace();
											}
										}
										else {
											System.out.println("Not enough stock");
										}
									}
								}

							}

						} catch (Exception e) {
							System.out.println("Exception in NetClientGet:- " + e);
						}
						break;
					case 3:
						try {

							SalesPost salesPost = new SalesPost();
							BufferedReader br=salesPost.MakeASale();
							String output;
							while ((output = br.readLine()) != null) {
								ObjectMapper mapper= new ObjectMapper();
								List<Products> productsList=Arrays.asList(mapper.readValue(output, Products[].class));
								for(Products p:productsList) {
									if(p.getProductId().startsWith("CAM")) {
										System.out.println(p.getProductName());
									}}
								System.out.println("Enter the product Name");
								String name=sc.nextLine();
								if(name.equals(""))
									name=sc.nextLine();
								for(Products s:productsList) {
									if(s.getProductName().equalsIgnoreCase(name)) {
										System.out.println(s.getType());
									}
								}
								System.out.println("Enter the type");
								String type=sc.nextLine();
								System.out.println("Enter the quantity");
								quantity=sc.nextInt();
								for(Products r:productsList) {
									if(r.getProductName().equalsIgnoreCase(name)&&r.getType().equalsIgnoreCase(type)) {
										balanceStock=r.getStock()-quantity;
										if(balanceStock>=0) {
											pro=r;
											check=true;
											try {
												salesPost.SaleUpdate(pro.getProductId(), sDate, quantity);
												System.out.println("Sale Completed");
												ProductPut netClientPut = new ProductPut();
												netClientPut.updateProduct(pro.getProductId(), balanceStock);
											} catch (MalformedURLException e) {
												e.printStackTrace();
											} catch (IOException e) {
												e.printStackTrace();
											}
										}
										else {
											System.out.println("Not enough stock");
										}
									}
								}

							}

						} catch (Exception e) {
							System.out.println("Exception in NetClientGet:- " + e);
							}
						break;
					case 4:
						try {
							SalesPost salesPost = new SalesPost();
							BufferedReader br=salesPost.MakeASale();
							String output;
							while ((output = br.readLine()) != null) {
								ObjectMapper mapper= new ObjectMapper();
								List<Products> productsList=Arrays.asList(mapper.readValue(output, Products[].class));
								for(Products p:productsList) {
									if(p.getProductId().startsWith("MP")) {
										System.out.println(p.getProductName());
									}}
								System.out.println("Enter the product Name");
								String name=sc.nextLine();
								if(name.equals(""))
									name=sc.nextLine();
								for(Products s:productsList) {
									if(s.getProductName().equalsIgnoreCase(name)) {
										System.out.println(s.getType());
									}
								}
								System.out.println("Enter the type");
								String type=sc.nextLine();
								System.out.println("Enter the quantity");
								quantity=sc.nextInt();
								for(Products r:productsList) {
									if(r.getProductName().equalsIgnoreCase(name)&&r.getType().equalsIgnoreCase(type)) {
										balanceStock=r.getStock()-quantity;
										if(balanceStock>=0) {
											pro=r;
											check=true;

											try {
												salesPost.SaleUpdate(pro.getProductId(), sDate, quantity);
												System.out.println("Sale Completed");
												ProductPut netClientPut = new ProductPut();
												netClientPut.updateProduct(pro.getProductId(), balanceStock);
											} catch (MalformedURLException e) {
												e.printStackTrace();
											} catch (IOException e) {
												e.printStackTrace();

											}
										}
										else {
											System.out.println("Not enough stock");
										}
									}
								}

							}

						} catch (Exception e) {
							System.out.println("Exception in NetClientGet:- " + e);
							}
						break;
					}
					break;//break of make a sale
				case 2:
					try {
							List<Sales> salesList=view.salesView();
							System.out.format("%-20s %-20s %-20s\n","PRODUCT_ID","Date Of Purchase","QUANTITY");
							for(Sales sale:salesList)
							{  
								System.out.format("%-20s %-20s %-20s \n",sale.getProductId(),sale.getDate(),sale.getQuantity());
							}
									} catch (Exception e) {
						System.out.println("Exception in NetClientGet:- " + e);
					}
					break;//break of view sales details
				case 3:
					try {

							List<Products> p=view.productsView();
							System.out.format("%-20s %-25s %-20s %-20s %-20s %-20s\n","PRODUCT_ID","PRODUCT_NAME","TYPE","BRAND_ID","PRICE","STOCK");
							for(Products product:p)
							{  
								System.out.format("%-20s %-25s %-20s %-20s %-20s %-20s\n",product.getProductId(),product.getProductName(),product.getType(),product.getBrandId(),product.getPrice(),product.getStock());
							}

					} catch (Exception e) {
						System.out.println("Exception in NetClientGet:- " + e);
					}
					break;//break of view products
				}
			}
			//break of login
			break;
		case 3:
			try {
				System.out.println("Enter the username");
				String newUsername=sc.next();
				String check=null;
				List<Login1> adminList=registration.usernameCheckAdmin();
				for(Login1 a:adminList) {
					if(a.getUsername().equalsIgnoreCase(newUsername)) {
						check=a.getUsername();
					}
				}
				if(check==null) {
				System.out.println("Enter the password");
				String newPassword=sc.next();
				registration.registerAdmin(newUsername, newPassword);
				System.out.println("Admin Account Created");
				}
				else {
					System.out.println("Username already exists!!!!");
				}
				}catch (MalformedURLException e) {

				e.printStackTrace();

			} catch (IOException e) {

				e.printStackTrace();

			}
			break;//break of admin registration
		case 4:
			try {
				
			System.out.println("Enter the username");
			String newUsername=sc.next();
			String check=null;
			List<Login1> smList=registration.usernameCheckSM();
			for(Login1 a:smList) {
				if(a.getUsername().equalsIgnoreCase(newUsername)) {
					check=a.getUsername();
				}
			}
			if(check==null) {
			System.out.println("Enter the password");
			String newPassword=sc.next();
			registration.registerSM(newUsername,newPassword);
			System.out.println("SalesManager Account Created");
			break;//break of salesManager registration
		}
			else {
				System.out.println("Username already exists!!!!");
			}
			}
			catch (MalformedURLException e) {

				e.printStackTrace();

			} catch (IOException e) {

				e.printStackTrace();

			}}
      sc.close();

	}
}
