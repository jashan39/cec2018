package cec2018;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.json.JSONObject;
import org.json.JSONArray;


import javax.net.ssl.HttpsURLConnection;

public class Starter {
	
	public static void main(String[] args) throws Exception{	
		
		// Start up
		sendGet("startup");

		// Parameters
		String parameters = sendGet("parameters");
		JSONObject json = new JSONObject(parameters).getJSONObject("parameters");		
		
		Integer lifetime = json.getInt("lifetime");
		Integer ms_per_week = json.getInt("ms_per_week");
		
		Integer HubBuildTime = json.getJSONObject("costs").getJSONObject("hub").getInt("weeks"); 
		Integer DeployBuildTime = json.getJSONObject("costs").getJSONObject("deploy").getInt("weeks"); 
		Integer ShipBuildTime = json.getJSONObject("costs").getJSONObject("ship").getInt("weeks"); 
		Integer MoveBuildTime = json.getJSONObject("costs").getJSONObject("move").getInt("weeks"); 
		
		long HubBuildCost = json.getJSONObject("costs").getJSONObject("hub").getLong("rate"); 
		long DeployBuildCost = json.getJSONObject("costs").getJSONObject("deploy").getLong("rate"); 
		long ShipBuildCost = json.getJSONObject("costs").getJSONObject("ship").getLong("rate"); 
		long MoveBuildCost = json.getJSONObject("costs").getJSONObject("move").getLong("rate"); 
		
		System.out.println(json.toString());
		System.out.println(MoveBuildCost);
		
		int i = 1;
		
		while(true){
			
			TimeUnit.sleep(1);

//			sendGet("get_ledger");	
//			sendGet("status_report");
			
			if(i > 0){
				sendGet("build_hubs", "&hubs=[han,hands,handsad]");				
				i--;
			}
		}
			
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
	
	// HTTP GET request
	public static String sendGet(String api_call, String parameters) throws Exception {

		String url = " http://www.cec-2018.ca/mcp/" + api_call + "?token=184d00ac0bfb7c92a8fc37dcac5e26b8" + parameters;
						
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