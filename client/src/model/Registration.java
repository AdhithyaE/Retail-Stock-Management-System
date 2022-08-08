package clientmodel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import model1.Login1;
public class Registration {
	public void registerAdmin(String username,String password) throws IOException {
		URL url = new URL("http://localhost:8080/Rsms_webservice_demo/rest/adminregistration");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
		String input =String.format("{\"username\":\"%s\",\"password\":\"%s\"}", username,password);

		OutputStream os = conn.getOutputStream();
		os.write(input.getBytes());
		os.flush();
		BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));
		conn.disconnect();
	}
	public void registerSM(String username,String password) throws IOException {
		URL url = new URL("http://localhost:8080/Rsms_webservice_demo/rest/smregistration");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
		String input =String.format("{\"username\":\"%s\",\"password\":\"%s\"}", username,password);

		OutputStream os = conn.getOutputStream();
		os.write(input.getBytes());
		os.flush();
		BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));
		conn.disconnect();
	}
	public List<Login1> usernameCheckAdmin() throws IOException {
		List<Login1> adminList=null;
		URL url = new URL("http://localhost:8080/Rsms_webservice_demo/rest/adminregistration");
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
		adminList=Arrays.asList(mapper.readValue(output, Login1[].class));
	}
		return adminList;
}
	public List<Login1> usernameCheckSM() throws IOException {
		List<Login1> salesManagerList=null;
		URL url = new URL("http://localhost:8080/Rsms_webservice_demo/rest/smregistration");
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
		salesManagerList=Arrays.asList(mapper.readValue(output, Login1[].class));
	}
		return salesManagerList;
}
	}
