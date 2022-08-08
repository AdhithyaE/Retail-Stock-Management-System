package clientmodel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ProductPost {
public void addProduct(String productId,String productName,String type,String bid,double price,int stock) throws IOException {
	URL url = new URL("http://localhost:8080/Rsms_webservice_demo/rest/inventory");
	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	conn.setDoOutput(true);
	conn.setRequestMethod("POST");
	conn.setRequestProperty("Content-Type", "application/json");

	String input =String.format(" {\r\n"
			+ "        \"productId\": \"%s\",\r\n"
			+ "        \"productName\": \"%s\",\r\n"
			+ "        \"type\": \"%s\",\r\n"
			+ "        \"brandId\": \"%s\",\r\n"
			+ "        \"price\": %s,\r\n"
			+ "        \"stock\": %s\r\n"
			+ "    }", productId,productName,type,bid,price,stock);

	OutputStream os = conn.getOutputStream();
	os.write(input.getBytes());
	os.flush();
	BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));
	conn.disconnect();
}
}
