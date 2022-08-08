package model;


public class Sales {
private String productId;
private String date;
private int quantity;
public Sales () {}
public Sales(String productId, String date, int quantity) {
	super();
	this.productId = productId;
	this.date = date;
	this.quantity = quantity;
}
public String getProductId() {
	return productId;
}
public void setProductId(String productId) {
	this.productId = productId;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}

}