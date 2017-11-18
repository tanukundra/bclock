package com.ubs.opsit.interviews;

import java.util.ArrayList;
import java.util.List;

import com.ubs.opsit.interviews.exceptions.ApplicationException;

public class TimeConverterImpl implements TimeConverter {
	
	
	@Override
	public String convertTime(String aTime) throws Exception {
		String[] times=getTimeDetails(aTime);
		// TODO Auto-generated method stub
		int hours = Integer.parseInt(times[0]);
       int  minutes = Integer.parseInt(times[1]);
        int seconds = Integer.parseInt(times[2]);
        if(aTime==null||aTime.isEmpty()) {
        	throw new ApplicationException("nput time cannot be empty.please provide valid Input");
        }
        if(hours< 0 ||hours>24) {
        	throw new ApplicationException("hours are not provided in acceptable range.");
        }
        if(minutes<0 || minutes>59) {
        	throw new ApplicationException("minutes are not provided in acceptable range.");
        }
        if(seconds<0||seconds>59) {
        	throw new ApplicationException("seconds are not provided in acceptable range.");
        }
        
		return processTime(hours,minutes,seconds);
	}

	
	/**
	 * This method splits given time into hours,minutes, seconds
	 * @param time
	 * @return
	 */
	private String[] getTimeDetails(String time) {
		List<String> inputLs = new ArrayList<String>();
		for (String a : time.split(":")) {
			inputLs.add(a);
		}
		String[] timeArray = new String[inputLs.size()];
		inputLs.toArray(timeArray);
		return timeArray;

	}
	
	/**
	 * This method collects the berlin representation of hours, minutes and seconds
	 * @param hours
	 * @param minutes
	 * @param seconds
	 * @return
	 */
	private String processTime(int hours, int minutes, int seconds)
	{
		String secondsRow = "";
		if (seconds % 2 == 0) {
			secondsRow = "Y";
		} else {
			secondsRow = "O";
		}

		String result =secondsRow +"\r\n"+ getHoursRow(hours)+"\r\n"+getMinutesRow(minutes);;
		return result;

	}
	
	/**
	 * To get Berlin representation of given hours and returns first two rows conversion
	 * @param hours
	 * @return
	 */
	private String getHoursRow(int hours) {
		int upperOnLights = 0;
		int upperOffLights = 4;
		int lowerOnLights = 0;
		int lowerFixLights = 4;
		int lowerOffLights = 4;
		int upperFixLights = 4;
		if (hours > 0) {
			upperOnLights = (hours / 5);
			upperOffLights = upperFixLights - upperOnLights;
			lowerOnLights = hours % 5;
			lowerOffLights = lowerFixLights - lowerOnLights;
		} 
		String upperHours = getOnOffLights(upperOnLights, upperOffLights,"R");
		String lowerHours = getOnOffLights(lowerOnLights, lowerOffLights,"R");

		String hoursLine = "";
		hoursLine = upperHours + "\r\n" + lowerHours;
		return hoursLine;

	}
	
	
	
	/**
	 * This method returns the representation of two minutes rows in berlin clock 
	 * @param minutes
	 * @return
	 */
	private String getMinutesRow(int minutes) {
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
		
		return minutesLine;
		
		
	}
		
	/**
	 * Utility method to create berlin representation of input
	 * @param OnLights
	 * @param OffLights
	 * @param onSign
	 * @return
	 */
	private String getOnOffLights(int OnLights, int OffLights,String onSign) {
		String out = "";
		String offSign="O";
		
		for (int i = 0; i < OnLights; i++) {
			out = out + onSign;
		}

		for (int i = 0; i < OffLights; i++) {
			out = out + offSign;
		}
		return out;
	}
	
}
