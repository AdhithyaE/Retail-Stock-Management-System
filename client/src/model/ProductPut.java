package clientmodel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
public class ProductPut {
    public void updateProduct(String productId,int quantity) {
    	   try {

    	        URL url = new URL("http://localhost:8080/Rsms_webservice_demo/rest/updateproduct");
    	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    	        conn.setDoOutput(true);
    	        conn.setRequestMethod("PUT");
    	        conn.setRequestProperty("Content-Type", "application/json");

    	        String input =String.format("{\r\n"
    	        		+ "        \"productId\": \"%s\",\r\n"
    	        		+ "    	 \"quantity\": %s\r\n"
    	        		+ "    }\r\n"
    	        		+ "   ",productId,quantity );

    	        OutputStream os = conn.getOutputStream();
    	        os.write(input.getBytes());
    	        os.flush();
    	        BufferedReader br = new BufferedReader(new InputStreamReader(
    	                (conn.getInputStream())));
    	        System.out.println("Products table updated");
    	        conn.disconnect();

    	      } catch (MalformedURLException e) {

    	        e.printStackTrace();

    	      } catch (IOException e) {

    	        e.printStackTrace();

    	     }
    }
   }
