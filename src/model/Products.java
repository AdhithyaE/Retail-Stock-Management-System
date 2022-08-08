package model;

import java.util.ArrayList;
import java.util.List;

public class Products {
private String productId;
private String productName;
private String type;
private String brandId;
private Double price;
private int stock;
public Products() {}
public Products(String productId, String productName, String type, String brandId, Double price, int stock) {
	super();
	this.productId = productId;
	this.productName = productName;
	this.type = type;
	this.brandId = brandId;
	this.price = price;
	this.stock = stock;
}
public String getProductId() {
	return productId;
}
public void setProductId(String productId) {
	this.productId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getBrandId() {
	return brandId;
}
public void setBrandId(String brandId) {
	this.brandId = brandId;
}
public Double getPrice() {
	return price;
}
public void setPrice(Double price) {
	this.price = price;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}public List<Products> prefill(){
	List<Products> list = new ArrayList<>();
	list.add(new Products("TV001", "Samsung Televison1", "LCD", "SAM001", 32000.0,25 )); //SAMSUNG
	list.add(new Products("TV002", "LG Televison1", "LCD", "LG001", 45000.0, 15)); //LG
	list.add(new Products("TV003", "Samsung Televison2", "LED", "SAM001", 40000.0,8 ));
	list.add(new Products("TV004", "LG Televison2", "LED", "LG001", 50000.0, 10));
	list.add(new Products("TV005", "VU Televison1", "LCD", "VU001", 30000.0,40 )); //VU
	list.add(new Products("TV006", "VU Televison2", "LED", "VU001", 38000.0, 6));
	list.add(new Products("TV007", "REDMI Televison1", "LCD", "MI001", 28000.0,20 )); //REDMI
	list.add(new Products("TV008", "REDMI Televison2", "LED", "MI001", 50000.0, 10));

	list.add(new Products("HP001", "REDMI HEAD_PHONE_1", "TRUE-WIRELESS", "MI001", 1499.0, 50));
	list.add(new Products("HP002", "Boult HEAD_PHONE_1", "TRUE-WIRELESS", "BO001", 2499.0, 40)); //BOULT
	list.add(new Products("HP003", "One Plus HEAD_PHONE_1", "TRUE-WIRELESS", "OP001", 4990.0, 25)); //ONEPLUS
	list.add(new Products("HP004", "Realme HEAD_PHONE_1", "TRUE-WIRELESS", "RM001", 4999.0, 15)); //REALME
	list.add(new Products("HP005", "Sony HEAD_PHONE_1", "TRUE-WIRELESS", "SO001", 9990.0, 10));
	list.add(new Products("HP006", "Boult HEAD_PHONE_2", "IN-EAR-WIRELESS", "BO001", 1199.0, 50)); //BOULT
	list.add(new Products("HP007", "REDMI HEAD_PHONE_2", "IN-EAR-WIRELESS", "MI001", 1299.0, 80)); //REDMI
	list.add(new Products("HP008", "One Plus HEAD_PHONE_2", "IN-EAR-WIRELESS", "OP001", 1999.0, 50)); //ONEPLUS
	list.add(new Products("HP009", "Boult HEAD_PHONE_3", "ON-EAR-WIRELESS", "BO001", 1199.0, 10)); //BOULT
	list.add(new Products("HP010", "JBL HEAD_PHONE_1", "ON-EAR-WIRELESS", "JBL001", 1599.0, 15)); //JBL
	list.add(new Products("HP011", "REDMI HEAD_PHONE_3", "ON-EAR-WIRELESS", "MI001", 1799.0, 16));
	list.add(new Products("HP012", "Boult HEAD_PHONE_4", "IN-EAR-WIRED", "BO001", 399.0, 80));
	list.add(new Products("HP013", "REDMI HEAD_PHONE_4", "IN-EAR-WIRED", "MI001", 399.0, 60));
	list.add(new Products("HP014", "JBL HEAD_PHONE_2", "IN-EAR-WIRED", "JBL001", 799.0, 50));
	list.add(new Products("HP015", "Sony HEAD_PHONE_2", "IN-EAR-WIRED", "SO001", 775.0, 80)); //SONY

	list.add(new Products("CAM001", "Cannon CAMERA_1", "DSLR", "CA001", 64999.0, 10)); //CANON
	list.add(new Products("CAM002", "Cannon CAMERA_2", "DSLR", "CA001", 119999.0, 5)); 
	list.add(new Products("CAM003", "Cannon CAMERA_3", "DSLR", "CA001", 264999.0, 5)); 
	list.add(new Products("CAM004", "Nikon CAMERA_1", "DSLR", "NI001", 53999.0, 10)); //NIKON
	list.add(new Products("CAM005", "Nikon CAMERA_2", "DSLR", "NI001", 33999.0, 8)); 
	list.add(new Products("CAM006", "Nikon CAMERA_3", "MIRRORLESS", "NI001", 164990.0, 6));
	list.add(new Products("CAM007", "Cannon CAMERA_3", "MIRRORLESS", "CA001", 227990.0, 12));
	list.add(new Products("CAM008", "Cannon CAMERA_3", "DIGITAL", "CA001", 43990.0, 20));
	list.add(new Products("CAM009", "Cannon CAMERA_3", "DIGITAL", "CA001", 16499.0, 20));
	list.add(new Products("CAM010", "Sony CAMERA_1", "DIGITAL", "SO001", 15490.0, 25)); //SONY
	list.add(new Products("CAM011", "GP CAMERA", "ACTION", "GP001", 34999.0, 50));
	list.add(new Products("CAM012", "Sony CAMERA_2", "ACTION", "SO001", 33999.0, 40));





	list.add(new Products("MP001", "REDMI MOBILE_PHONE_1", "SMART_PHONE", "MI001", 14000.0, 30)); //REDMI
	list.add(new Products("MP002", "REDMI MOBILE_PHONE_2", "SMART_PHONE", "MI001", 18000.0, 15));
	list.add(new Products("MP003", "Samsung MOBILE_PHONE_3", "SMART_PHONE", "SAM001", 24000.0, 13)); //SAMSUNG
	list.add(new Products("MP004", "Samsung MOBILE_PHONE_1", "SMART_PHONE", "SAM001", 28000.0, 12));
	list.add(new Products("MP005", "Apple MOBILE_PHONE_1", "SMART_PHONE", "IP001", 58000.0, 5)); //APPLE
	list.add(new Products("MP006", "Aplle MOBILE_PHONE_1", "SMART_PHONE", "IP001", 84000.0, 3));
	list.add(new Products("MP007", "VI MOBILE_PHONE_1", "SMART_PHONE", "VI001", 24990.0, 35));
	list.add(new Products("MP008", "VI MOBILE_PHONE_2", "SMART_PHONE", "VI001", 27000.0, 12));
	list.add(new Products("MP009", "One Plus MOBILE_PHONE_1", "SMART_PHONE", "OP001", 40000.0, 20));
	list.add(new Products("MP010", "One Plus MOBILE_PHONE_2", "SMART_PHONE", "OP001", 34000.0, 21));




	return list;

}

}


