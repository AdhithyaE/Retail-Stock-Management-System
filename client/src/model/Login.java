package clientmodel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Login {
public boolean adminLogin(String username,String password,String params) {
	 boolean authentication=false;
	try {
		String url1="http://localhost:8080/Rsms_webservice_demo/rest";
		URL url = new URL(url1+"/"+params);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");

		String input =String.format("{\r\n"
				+ "        \"username\": \"%s\",\r\n"
				+ "        \"password\": \"%s\"\r\n"
				+ "        \r\n"
				+ "    }",username,password );

		OutputStream os = conn.getOutputStream();
		os.write(input.getBytes());
		os.flush();

		BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

		String output;
		while ((output = br.readLine()) != null) {
			if(output.equals("true")) {
				authentication=true;
			}
		}

		conn.disconnect();

	} catch (MalformedURLException e) {

		e.printStackTrace();

	} catch (IOException e) {

		e.printStackTrace();

	}
	return authentication;
}
}
