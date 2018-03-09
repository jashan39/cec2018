package cec2018;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;
import org.json.JSONArray;


import javax.net.ssl.HttpsURLConnection;

public class Starter{
	
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
		
// Jenny New Code		
		String prospects = sendGet("prospect_report");
		JSONObject json_prospects = new JSONObject(prospects).getJSONObject("prospect_report");	
		JSONArray prospectsReport = json_prospects.getJSONArray("report");
		System.out.println(prospectsReport.toString());
		Sector newSectors = new Sector();
		
		Integer numRow = json.getInt("rows");
		Integer numCol = json.getInt("cols");
		
		System.out.println(numRow);
		System.out.println(numCol);
		//JSONArray currentSector_json = prospectsReport.getJSONArray(0);
		//System.out.println(currentSector_json.toString());
		//ArrayList<Integer> sectorAndAmount = new ArrayList<Integer>();
		
		//Pattern p = Pattern.compile("-?\\d+");
		//Matcher m = p.matcher(currentSector_json.toString());
		//while (m.find()) {
		  ////System.out.println(m.group());
		  //sectorAndAmount.add(Integer.parseInt(m.group()));
		//}
		//System.out.println(sectorAndAmount);
		//int currentSector = sectorAndAmount.get(0);
		//System.out.println(currentSector);
		
		//String currentSector_string = currentSector_json.getJSONObject(0).toString();
		int totalOres = newSectors.getAdjacentOres(prospectsReport, 0, numRow, numCol);
		System.out.println(totalOres);
		
		//List<Integer> totalOresList = new ArrayList<Integer>();
		//for(int i=0; i<prospectsReport.length() &&; i++){
		//	totalOresList.add(newSectors.getAdjacentOres(prospectsReport, i, numRow, numCol));
		//}
		//System.out.println(totalOresList);
		
		List<Integer> totalOresList = newSectors.orderSectorOreAmounts(prospectsReport, numRow, numCol);
		System.out.println(totalOresList);
//end Jenny New Code
		
		int i = 1;
		
		while(true){
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