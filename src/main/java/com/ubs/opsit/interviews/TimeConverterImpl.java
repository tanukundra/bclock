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
		int upperFixLights = 4;
		String onlight="Y";
		String offLight="O";
		int lowerLights=0;
		if(hours>0) {
			upperOnLights= (hours/5);
			upperOffLights=upperFixLights-upperOnLights;
			
		}
		else {
			 upperOnLights = maxTime/5;
			 if((maxTime%5)>0) {
				 upperOffLights=1;
			 }
			 lowerLights=(maxTime%5);
		}
		
		
		
		for(int i=1; i<upperOnLights;i++) {
			
			
		}
		
		
		
		
		
		
	}
	
	
	
	
	
	public 
	
	public String getOnOffLights(String sign, int count) {
		for(int i=0;i<count;i++) {
			sign=sign+
			
		}
			
		
		
		
	}
	
}
