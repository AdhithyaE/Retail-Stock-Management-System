package clientmodel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import model1.Products;
import model1.Sales;

public class View {

public List<Products> productsView() throws IOException {
			List<Products> productList=null;
			URL url = new URL("http://localhost:8080/Rsms_webservice_demo/rest");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP Error code : "
						+ conn.getResponseCode());
			}
			InputStreamReader in = new InputStreamReader(conn.getInputStream());
			BufferedReader br = new BufferedReader(in);
			String output;
			while ((output = br.readLine()) != null) {
				ObjectMapper mapper= new ObjectMapper();
			productList=Arrays.asList(mapper.readValue(output, Products[].class));
			}
			conn.disconnect();
			return productList;
}
public List<Sales> salesView() throws IOException {
	List<Sales> salesList=null;
	URL url = new URL("http://localhost:8080/Rsms_webservice_demo/rest/salesdata");
	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	conn.setRequestMethod("GET");
	conn.setRequestProperty("Accept", "application/json");
	if (conn.getResponseCode() != 200) {
		throw new RuntimeException("Failed : HTTP Error code : "
				+ conn.getResponseCode());
	}
	InputStreamReader in = new InputStreamReader(conn.getInputStream());
	BufferedReader br = new BufferedReader(in);
	String output;
	while ((output = br.readLine()) != null) {
		ObjectMapper mapper= new ObjectMapper();
	salesList=Arrays.asList(mapper.readValue(output, Sales[].class));
}
	return salesList;
}
}
