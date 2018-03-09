package cec2018;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONException;

public class Sector {
	
	int getAdjacentOres(JSONArray prospectsReport, int sectorValue, int numRow, int numCol) throws JSONException{
		int totalOres = 0;
		//sector and number of ores adjacent to it

		//corner sectors
		List<Integer> cornerSectors = getCornerSectors(prospectsReport, numRow, numCol);
		List<Integer> topSectors = getTopSectors(prospectsReport, numRow, numCol);
		List<Integer> bottomSectors = getBottomSectors(prospectsReport, numRow, numCol);
		List<Integer> leftSectors = getLeftSectors(prospectsReport, numRow, numCol);
		List<Integer> rightSectors = getRightSectors(prospectsReport, numRow, numCol);
		
//		for (int i = 0; i < prospectsReport.length(); i++) {
			JSONArray currentSector_json = prospectsReport.getJSONArray(sectorValue);
			String currentSector_string = currentSector_json.toString();
			
			ArrayList<Integer> sectorAndAmount = new ArrayList<Integer>();
			
			Pattern p = Pattern.compile("-?\\d+");
			Matcher m = p.matcher(currentSector_string);
			while (m.find()) {
			  //System.out.println(m.group());
			  sectorAndAmount.add(Integer.parseInt(m.group()));
			}
			
			int currentSector = sectorAndAmount.get(0);
			
			//Corner
			if(cornerSectors.contains(currentSector)){
				System.out.println("corner");
				if(cornerSectors.indexOf(currentSector)==0){
					ArrayList<Integer> sectorAndAmount_ind = new ArrayList<Integer>();
					ArrayList<Integer> indices = new ArrayList<Integer>();
					int r_index = currentSector + 1;
					int b_index = currentSector + numRow;
					int rb_index = b_index + 1;
					indices.add(r_index);
					indices.add(b_index);
					indices.add(rb_index);
					
					for(int index:indices){
						String amount_string = prospectsReport.getJSONArray(index).toString();
					
						Matcher m1 = p.matcher(amount_string);
						while (m1.find()) {
						//System.out.println(m.group());
						sectorAndAmount_ind.add(Integer.parseInt(m1.group()));
						}
					
						totalOres = totalOres + sectorAndAmount_ind.get(1);
					
						//System.out.println(r_index);
						//System.out.println(b_index);
						//System.out.println(rb_index);
					}
				}
				if(cornerSectors.indexOf(currentSector)==1){
					ArrayList<Integer> sectorAndAmount_ind = new ArrayList<Integer>();
					ArrayList<Integer> indices = new ArrayList<Integer>();
					int r_index = currentSector - 1;
					int b_index = currentSector + numRow;
					int lb_index = b_index - 1;
					indices.add(r_index);
					indices.add(b_index);
					indices.add(lb_index);
					
					for(int index:indices){
						String amount_string = prospectsReport.getJSONArray(index).toString();
					
						Matcher m1 = p.matcher(amount_string);
						while (m1.find()) {
						//System.out.println(m.group());
						sectorAndAmount_ind.add(Integer.parseInt(m1.group()));
						}
					
						totalOres = totalOres + sectorAndAmount_ind.get(1);
					
						//System.out.println(r_index);
						//System.out.println(b_index);
						//System.out.println(rb_index);
					}
				}
				if(cornerSectors.indexOf(currentSector)==2){
					ArrayList<Integer> sectorAndAmount_ind = new ArrayList<Integer>();
					ArrayList<Integer> indices = new ArrayList<Integer>();
					int r_index = currentSector + 1;
					int t_index = currentSector - numRow;
					int rt_index = t_index + 1;
					indices.add(r_index);
					indices.add(t_index);
					indices.add(rt_index);
					
					for(int index:indices){
						String amount_string = prospectsReport.getJSONArray(index).toString();
					
						Matcher m1 = p.matcher(amount_string);
						while (m1.find()) {
						//System.out.println(m.group());
						sectorAndAmount_ind.add(Integer.parseInt(m1.group()));
						}
					
						totalOres = totalOres + sectorAndAmount_ind.get(1);
					
						//System.out.println(r_index);
						//System.out.println(b_index);
						//System.out.println(rb_index);
					}
				}
				if(cornerSectors.indexOf(currentSector)==3){
					ArrayList<Integer> sectorAndAmount_ind = new ArrayList<Integer>();
					ArrayList<Integer> indices = new ArrayList<Integer>();
					int l_index = currentSector - 1;
					int t_index = currentSector - numRow;
					int lt_index = t_index - 1;
					indices.add(l_index);
					indices.add(t_index);
					indices.add(lt_index);
					
					for(int index:indices){
						String amount_string = prospectsReport.getJSONArray(index).toString();
					
						Matcher m1 = p.matcher(amount_string);
						while (m1.find()) {
						//System.out.println(m.group());
						sectorAndAmount_ind.add(Integer.parseInt(m1.group()));
						}
					
						totalOres = totalOres + sectorAndAmount_ind.get(1);
					
						//System.out.println(r_index);
						//System.out.println(b_index);
						//System.out.println(rb_index);
					}
				}
			}
			
			//Top
			if(topSectors.contains(currentSector)){
				System.out.println("top");
					ArrayList<Integer> sectorAndAmount_ind = new ArrayList<Integer>();
					ArrayList<Integer> indices = new ArrayList<Integer>();
					int r_index = currentSector + 1;
					int l_index = currentSector -1;
					int b_index = currentSector + numRow;
					int rb_index = b_index + 1;
					int lb_index = b_index - 1;
					
					indices.add(r_index);
					indices.add(l_index);
					indices.add(b_index);
					indices.add(rb_index);
					indices.add(lb_index);
					
					for(int index:indices){
						String amount_string = prospectsReport.getJSONArray(index).toString();
					
						Matcher m1 = p.matcher(amount_string);
						while (m1.find()) {
						//System.out.println(m.group());
						sectorAndAmount_ind.add(Integer.parseInt(m1.group()));
						}
					
						totalOres = totalOres + sectorAndAmount_ind.get(1);
					
						//System.out.println(r_index);
						//System.out.println(b_index);
						//System.out.println(rb_index);
					}
				
			}
			
			//Bottom
			if(bottomSectors.contains(currentSector)){
				System.out.println("bottom");
					ArrayList<Integer> sectorAndAmount_ind = new ArrayList<Integer>();
					ArrayList<Integer> indices = new ArrayList<Integer>();
					int r_index = currentSector + 1;
					int l_index = currentSector -1;
					int t_index = currentSector - numRow;
					int rt_index = t_index + 1;
					int lt_index = t_index - 1;
					
					indices.add(r_index);
					indices.add(l_index);
					indices.add(t_index);
					indices.add(rt_index);
					indices.add(lt_index);
					
					for(int index:indices){
						String amount_string = prospectsReport.getJSONArray(index).toString();
					
						Matcher m1 = p.matcher(amount_string);
						while (m1.find()) {
						//System.out.println(m.group());
						sectorAndAmount_ind.add(Integer.parseInt(m1.group()));
						}
					
						totalOres = totalOres + sectorAndAmount_ind.get(1);
					
						//System.out.println(r_index);
						//System.out.println(b_index);
						//System.out.println(rb_index);
					}
				
			}
			//Left
			if(leftSectors.contains(currentSector)){
					System.out.println("left");
					ArrayList<Integer> sectorAndAmount_ind = new ArrayList<Integer>();
					ArrayList<Integer> indices = new ArrayList<Integer>();
					int r_index = currentSector + 1;
					int t_index = currentSector - numRow;
					int b_index = currentSector + numRow;
					int rt_index = t_index + 1;
					int rb_index = b_index + 1;
					
					indices.add(r_index);
					indices.add(b_index);
					indices.add(t_index);
					indices.add(rt_index);
					indices.add(rb_index);
					
					for(int index:indices){
						try{
							String amount_string = prospectsReport.getJSONArray(index).toString();
						}catch(org.json.JSONException e){
							break;
						}
						String amount_string = prospectsReport.getJSONArray(index).toString();
						
						Matcher m1 = p.matcher(amount_string);
						while (m1.find()) {
						//System.out.println(m.group());
						sectorAndAmount_ind.add(Integer.parseInt(m1.group()));
						}
					
						totalOres = totalOres + sectorAndAmount_ind.get(1);
					
						//System.out.println(r_index);
						//System.out.println(b_index);
						//System.out.println(rb_index);
					}
				
			}
			//Right
			if(rightSectors.contains(currentSector)){
					System.out.println("right");
					ArrayList<Integer> sectorAndAmount_ind = new ArrayList<Integer>();
					ArrayList<Integer> indices = new ArrayList<Integer>();
					int l_index = currentSector - 1;
					int t_index = currentSector - numRow;
					int b_index = currentSector + numRow;
					int lt_index = t_index - 1;
					int lb_index = b_index - 1;
					
					indices.add(l_index);
					indices.add(b_index);
					indices.add(t_index);
					indices.add(lt_index);
					indices.add(lb_index);
					
					for(int index:indices){
						try{
							String amount_string = prospectsReport.getJSONArray(index).toString();
						}catch(org.json.JSONException e){
							break;
						}
						String amount_string = prospectsReport.getJSONArray(index).toString();
						
						Matcher m1 = p.matcher(amount_string);
						while (m1.find()) {
						//System.out.println(m.group());
						sectorAndAmount_ind.add(Integer.parseInt(m1.group()));
						}
					
						totalOres = totalOres + sectorAndAmount_ind.get(1);
					
						//System.out.println(r_index);
						//System.out.println(b_index);
						//System.out.println(rb_index);
					}
				
			}
			//Middle
			if(!rightSectors.contains(currentSector) && !leftSectors.contains(currentSector) && !topSectors.contains(currentSector)&& !bottomSectors.contains(currentSector)&& !cornerSectors.contains(currentSector) ){
					
					System.out.println("middle");
					ArrayList<Integer> sectorAndAmount_ind = new ArrayList<Integer>();
					ArrayList<Integer> indices = new ArrayList<Integer>();
					int l_index = currentSector - 1;
					int r_index = currentSector + 1;
					int t_index = currentSector - numRow;
					int b_index = currentSector + numRow;
					int lt_index = t_index - 1;
					int lb_index = b_index - 1;
					int rt_index = t_index + 1;
					int rb_index = b_index + 1;
					
					indices.add(l_index);
					indices.add(r_index);
					indices.add(b_index);
					indices.add(t_index);
					indices.add(lt_index);
					indices.add(lb_index);
					indices.add(rt_index);
					indices.add(rb_index);
					
					for(int index:indices){
						try{
							String amount_string = prospectsReport.getJSONArray(index).toString();
						}catch(org.json.JSONException e){
							break;
						}
						String amount_string = prospectsReport.getJSONArray(index).toString();
						
						Matcher m1 = p.matcher(amount_string);
						while (m1.find()) {
						//System.out.println(m.group());
						sectorAndAmount_ind.add(Integer.parseInt(m1.group()));
						}
					
						totalOres = totalOres + sectorAndAmount_ind.get(1);
					
						//System.out.println(r_index);
						//System.out.println(b_index);
						//System.out.println(rb_index);
					}
				
			}
			
//		}
		
		return totalOres;
	}
	
	List<Integer> orderSectorOreAmounts(JSONArray prospectsReport, int numRow, int numCol) throws JSONException{
		List<Integer> sectorOreAmounts = new ArrayList<Integer>();
		for(int i=0; i<prospectsReport.length(); i++){
			if(i==390){
				break;
			}
			sectorOreAmounts.add(getAdjacentOres(prospectsReport, i, numRow, numCol));
		}
		
		return sectorOreAmounts;
	}
	
	//List corner sectors
	List<Integer> getCornerSectors(JSONArray prospectsReport, int numRow, int numCol){
		List<Integer> cornerSectors = new ArrayList<Integer>(numRow);
		cornerSectors.add(0);
		cornerSectors.add(0+numRow-1);
		cornerSectors.add(prospectsReport.length()-numRow);
		cornerSectors.add(prospectsReport.length()-1);
		return cornerSectors;
	}
	
	//List top sectors
	List<Integer> getTopSectors(JSONArray prospectsReport, int numRow, int numCol){
		List<Integer> topSectors = new ArrayList<Integer>(numRow);
		for(int i=1; i<numRow-1 ; i++){
			topSectors.add(i);
		}
		return topSectors;
	}
	
	//List bottom sectors
	List<Integer> getBottomSectors(JSONArray prospectsReport, int numRow, int numCol){
		List<Integer> bottomSectors = new ArrayList<Integer>(numRow);
		for(int i=prospectsReport.length()-2; i>prospectsReport.length() - numRow ; i--){
			bottomSectors.add(i);
		}
		return bottomSectors;
	}
	
	//List left sectors
	List<Integer> getLeftSectors(JSONArray prospectsReport, int numRow, int numCol){
		List<Integer> leftSectors = new ArrayList<Integer>(numRow);
		int lastLeftSector = prospectsReport.length() - 2*numRow;
		for(int i=numRow; i<= lastLeftSector ; i=i+numRow){
			leftSectors.add(i);
		}
		return leftSectors;
	}
	
	//List right sectors
	List<Integer> getRightSectors(JSONArray prospectsReport, int numRow, int numCol){
		List<Integer> rightSectors = new ArrayList<Integer>(numRow);
		int lastRightSector = prospectsReport.length() - 1 - numRow;
		for(int i=2*numRow-1; i<= lastRightSector ; i=i+numRow){
			rightSectors.add(i);
		}
		return rightSectors;
	}

	
	
}
