package com.ubs.opsit.interviews;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TestBClock {

	@Test
	public void test() {
		TimeConverter converter= new TimeConverterImpl();
		String time="00:00:00";
		String convertedTime=converter.convertTime(time);
			
			Assert.assertNotNull(convertedTime);
		//fail("Not yet implemented");
	}
	
	@Test
	public void test2() {
		TimeConverter converter= new TimeConverterImpl();
		String time="13:17:01";
		String convertedTime=converter.convertTime(time);
			
			Assert.assertNotNull(convertedTime);
		//fail("Not yet implemented");
	}
	
	@Test
	public void test3() {
		TimeConverter converter= new TimeConverterImpl();
		String time="23:59:59";
		String convertedTime=converter.convertTime(time);
			
			Assert.assertNotNull(convertedTime);
		//fail("Not yet implemented");
	}
	
	@Test
	public void test4() {
		TimeConverter converter= new TimeConverterImpl();
		String time="24:00:00";
		String convertedTime=converter.convertTime(time);
			
			Assert.assertNotNull(convertedTime);
		//fail("Not yet implemented");
	}

}
