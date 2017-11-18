package com.ubs.opsit.interviews;

import java.util.ArrayList;
import java.util.List;

public class TimeConverterImpl implements TimeConverter {

	@Override
	public String convertTime(String aTime) {
		String[] times=getTimeDetails(aTime);
		// TODO Auto-generated method stub
		int hours = Integer.parseInt(times[0]);
       int  minutes = Integer.parseInt(times[1]);
        int seconds = Integer.parseInt(times[2]);
		return processTime(hours,minutes,seconds);
	}

	
	public String[] getTimeDetails(String time) {
		List<String> inputLs = new ArrayList<String>();
		for (String a : time.split(":")) {
			inputLs.add(a);
		}
		String[] timeArray = new String[inputLs.size()];
		inputLs.toArray(timeArray);
		return timeArray;

	}
	
	
	public String processTime(int hours, int minutes, int seconds)
	{
		String firstLine = "";
		// String firstLine= (seconds %2 ==0) ? "Y" :"0";
		if (seconds % 2 == 0) {
			firstLine = "Y";
		} else {
			firstLine = "O";
		}

		String nextLine = "";
		nextLine = getHours(hours);
		String result = firstLine + "\r\n" + nextLine+"\r\n"+getMinutes(minutes);
		//System.out.println("result is:"+result);
		return result;

	}
	
	public String getHours(int hours) {
		int upperOnLights = 0;
		int upperOffLights = 0;
		int lowerOnLights = 0;
		int lowerFixLights = 4;
		int lowerOffLights = 0;
		int upperFixLights = 4;
		if (hours > 0) {
			upperOnLights = (hours / 5);
			upperOffLights = upperFixLights - upperOnLights;
			lowerOnLights = hours % 5;
			lowerOffLights = lowerFixLights - lowerOnLights;
		} else {
			upperOffLights = 4;
			lowerOffLights = 4;

		}
		String upperHours = getOnOffLights(upperOnLights, upperOffLights,"R");
		String lowerHours = getOnOffLights(lowerOnLights, lowerOffLights,"R");

		String hoursLine = "";
		hoursLine = upperHours + "\r\n" + lowerHours;
		//System.out.println("hours line:"+hoursLine);
		return hoursLine;

	}
	
	
	public String getMinutes(int minutes) {
		 int onLights= 0;
		 int offlights=0;
		 int lastOnLights=0;
		 int lastOffLights=0;
		if(minutes>0) {
			onLights=minutes/5;
			lastOnLights=minutes%5;
			offlights=11-onLights;
			lastOffLights=4-minutes%5;
		}else {
			offlights=11;
			lastOffLights=4;
		}
				
		String thirdLine=getOnOffLights(onLights,offlights,"Y");
		thirdLine=thirdLine.replaceAll("YYY", "YYR");
				
		String fourthLine=
				getOnOffLights(lastOnLights,lastOffLights,"Y");
		
		String minutesLine=thirdLine+"\r\n"+fourthLine;
		//System.out.println("minutes line:" +minutesLine);
		
		return minutesLine;
		
		
	}
		
	public String getOnOffLights(int OnLights, int OffLights,String onSign) {
		String out = "";
		
		for (int i = 0; i < OnLights; i++) {
			out = out + onSign;
		}

		for (int i = 0; i < OffLights; i++) {
			out = out + "O";
		}
		return out;
	}
	
}
