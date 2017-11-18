package com.ubs.opsit.interviews;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TimeConverterTest {
	
	public TimeConverterImpl converter;
	
	@Before
	public void beforeTest() {
		converter=new TimeConverterImpl();
		
	}

	@Test
	public void testConvertTime()  throws Exception{
		String inputTime="00:00:00";
		String expectedResult="Y\r\n" + 
				"OOOO\r\n" + 
				"OOOO\r\n" + 
				"OOOOOOOOOOO\r\n" + 
				"OOOO";
		String outputString= converter.convertTime(inputTime);
		Assert.assertTrue(outputString.equals(expectedResult));
	}
	
	
	@Test
	public void testConvertTimeEvenhours()  throws Exception{
		String inputTime="24:00:00";
		String expectedResult="Y\r\n" + 
				"RRRR\r\n" + 
				"RRRR\r\n" + 
				"OOOOOOOOOOO\r\n" + 
				"OOOO";
		String outputString= converter.convertTime(inputTime);
		Assert.assertTrue(outputString.equals(expectedResult));
	}
	
	@Test
	public void testConvertTimeOddSeconds() throws Exception{
		
		String inputTime="00:00:01";
		String expectedResult="O\r\n" + 
				"OOOO\r\n" + 
				"OOOO\r\n" + 
				"OOOOOOOOOOO\r\n" + 
				"OOOO";
		String outputString= converter.convertTime(inputTime);
		Assert.assertTrue(outputString.equals(expectedResult));
		
	}
	
	@Test
	public void testConvertTimeOddHours() throws Exception{
		
		String inputTime="13:17:01";
		String expectedResult="O\r\n"+
				"RROO\r\n"+
				"RRRO\r\n"+
				"YYROOOOOOOO\r\n"+
				"YYOO";
;
		String outputString= converter.convertTime(inputTime);
		Assert.assertTrue(outputString.equals(expectedResult));
		
	}
	
	@Test 
	public void testValidateInputHours() {
		String inputTime="25:00:00";
		String message="hours are not provided in acceptable range.";
		String errormsg="";
		boolean exceptionThrown=false;
		try {
			converter.convertTime(inputTime);
		}catch(Exception e) {
			exceptionThrown=true;
			errormsg=e.getMessage();
		}
		Assert.assertEquals(message, errormsg);
		Assert.assertTrue(exceptionThrown);
		
	}
	
	@Test 
	public void testValidateInputMinutes() {
		String inputTime="00:70:00";
		String message="minutes are not provided in acceptable range.";
		String errormsg="";
		boolean exceptionThrown=false;
		try {
			converter.convertTime(inputTime);
		}catch(Exception e) {
			exceptionThrown=true;
			errormsg=e.getMessage();
		}
		Assert.assertEquals(message, errormsg);
		Assert.assertTrue(exceptionThrown);
		
	}
	
	@Test 
	public void testValidateInputSeconds() {
		String inputTime="00:00:60";
		String message="seconds are not provided in acceptable range.";
		String errormsg="";
		boolean exceptionThrown=false;
		try {
			converter.convertTime(inputTime);
		}catch(Exception e) {
			exceptionThrown=true;
			errormsg=e.getMessage();
		}
		Assert.assertEquals(message, errormsg);
		Assert.assertTrue(exceptionThrown);
	}
	
	@Test 
	public void testValidateInputTime() {
		String inputTime="";
		String message="Input time cannot be empty.please provide valid Input.";
		String errormsg="";
		boolean exceptionThrown=false;
		try {
			converter.convertTime(inputTime);
		}catch(Exception e) {
			exceptionThrown=true;
			errormsg=e.getMessage();
		}
		Assert.assertEquals(message, errormsg);
		Assert.assertTrue(exceptionThrown);
	}
	
	
	
	
	/*@Test
	public void testGetTimeDetails() {
		String inputTime="00:00:00";
		String[] expectedArr= {"00","00","00"};
		String[] outputArr=converter.getTimeDetails(inputTime);
		Assert.assertTrue(outputArr[0].equals(expectedArr[0]));
		
	}
	
	@Test
	public void test*/
	
	

}
