package model;

public class Update {
private String productId;
private int quantity;
public String getProductId() {
	return productId;
}
public void setProductId(String productId) {
	this.productId = productId;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public Update () {}
public Update(String productId, int quantity) {
	super();
	this.productId = productId;
	this.quantity = quantity;
}

}
