package com.ubs.opsit.interviews;

import java.util.ArrayList;
import java.util.List;

public class TimeConverterImpl implements TimeConverter {

	@Override
	public String convertTime(String aTime) {
		
		
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<Integer> getTimeDetails(String time){
		
		List<Integer> inputLs= new ArrayList<Integer>();
		
		for(String a : time.split(":") ) {
			inputLs.add(Integer.parseInt(a));
			
			
		}
		return inputLs;
		
		
	}
	
	public String getUpperHours(int hours) {
		int maxTime=24;
		int upperOnLights=0;
		int upperOffLights=0;
		int lowerOnLights=0;
		int lowerFixLights=4;
		int lowerOffLights=0;
		int upperFixLights = 4;
		String onlight="Y";
		String offLight="O";
		int lowerLights=0;
		if(hours>0) {
			upperOnLights= (hours/5);
			upperOffLights=upperFixLights-upperOnLights;
			lowerOnLights=hours- hours/5;
			lowerOffLights=lowerFixLights-lowerOnLights;
					}
		else {
			 upperOffLights = maxTime/5;
			 	lowerOffLights=maxTime- maxTime/5;
			
		}
		String upperHours=getOnOffLights();
	String lowerHours=getOnOffLights();	
	
		
		
		
		
		return null;
		
		
		
		
		
		
	}
	
	
	
	
	 
	
	public String getOnOffLights(int OffLights, int OnLights) {
		String out="";
		String OnSign="Y";
		for(int i=0;i<OnLights;i++) {
			out=out+OnSign;
		}
		
		for(int i=0;i<OffLights;i++) {
			out=out+"R";
		}
		
		return out;
		
	}
	
}
