package cec2018;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import org.json.JSONArray;


import javax.net.ssl.HttpsURLConnection;

public class Starter {
	
	public static void main(String[] args) throws Exception{	
		
		String parameters = sendGet("parameters");
		JSONObject json = new JSONObject(parameters);
		JSONObject json1 = json.getJSONObject("parameters");
		JSONObject json2 = json.getJSONObject("parameters");
		Integer json3 = json2.getInt("lifetime");

		System.out.println(json.toString());
		System.out.println(json1.toString());
		System.out.println(json3);
		
		sendGet("startup");
	}
	
	// HTTP GET request
	public static String sendGet(String api_call) throws Exception {

		String url = " http://www.cec-2018.ca/mcp/" + api_call + "?token=184d00ac0bfb7c92a8fc37dcac5e26b8";
				
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());
		return response.toString();
	}
}