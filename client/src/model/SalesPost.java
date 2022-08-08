package clientmodel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SalesPost {
public BufferedReader MakeASale() throws IOException {
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
      return br; 
}
public void SaleUpdate(String productId, String sDate,int quantity) throws IOException {
	 URL url = new URL("http://localhost:8080/Rsms_webservice_demo/rest/sales");
     HttpURLConnection conn1 = (HttpURLConnection) url.openConnection();
     conn1.setDoOutput(true);
     conn1.setRequestMethod("POST");
     conn1.setRequestProperty("Content-Type", "application/json");
     String input =String.format("{\"productId\":\"%s\",\"date\":\"%s\",\"quantity\":%s}", productId,sDate,quantity);

     OutputStream os = conn1.getOutputStream();
     os.write(input.getBytes());
     os.flush();
     BufferedReader br2 = new BufferedReader(new InputStreamReader(
             (conn1.getInputStream())));
}
}
