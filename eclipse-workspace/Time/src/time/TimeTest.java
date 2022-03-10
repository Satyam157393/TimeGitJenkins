package time;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {
	

	@Test
	public void testGetMilliSecondsGood() {
		int milliSeconds = Time.getMilliSeconds("05:05:05:005");
		assertTrue("The milli seconds were not calculated properly", milliSeconds==5);
	}
	@Test
	public void testGetMilliSecondsBad() {
		
		assertThrows(StringIndexOutOfBoundsException.class, 
				()-> {Time.getMilliSeconds("10:00:0");});
	}
	@ParameterizedTest
	@ValueSource(strings = {"04:00:00:001","04:59:59:999"})
	void testGetMilliSecondsBoundary(String candidate) {
		int milliSeconds = Time.getMilliSeconds(candidate);
		assertTrue("The milli seconds were not calculated properly", milliSeconds==1||milliSeconds==999);
	}

	@Test
	public void testGetTotalSecondsGood() {
		int seconds = Time.getTotalSeconds("05:05:05");
				assertTrue("The seconds were not calculated  properly", seconds==18305);
				}


	@Test
	public void testGetTotalSecondsBad() 
	{
	assertThrows(StringIndexOutOfBoundsException.class, 
			()-> {Time.getTotalSeconds("10:00");});
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"04:00:00","04:59:59"})
	void testGetTotalSecondsBoundary(String candidate) {
		int seconds = Time.getTotalSeconds(candidate);
		assertTrue("The seconds were not calculated properly", seconds==14400||seconds==17999);
	}
	
	


	@ParameterizedTest
	@ValueSource(strings = {"05:26:00", "05:36:34", "05:25:59"})
	void testGetSecondsGoodAndBoundary(String candidate) {
	int seconds2 = Time.getSeconds(candidate);
	assertTrue("The seconds were not calculated properly", seconds2 >= 0 && seconds2 <= 59);
	
}
	@Test
	void testGetSecondsBad() {
		assertThrows(NumberFormatException.class, 
				()-> {Time.getTotalSeconds("wrg");});
	}
	

	

	@ParameterizedTest
	@ValueSource(strings = { "05:03:00", "05:03:10", "05:03:59" })
	void testGetTotalMinutesGoodAndBoundary(String candidate) {
	int minutes = Time.getTotalMinutes(candidate);
	assertTrue("The minutes were not calculated properly", minutes==3);

}
	@Test
	void testGetTotalMinutesBad() {
		assertThrows(NumberFormatException.class, 
				()-> {Time.getTotalSeconds("jsc");});
	
	}
	
	
	@ParameterizedTest
	@ValueSource(strings = { "05:00:00", "05:10:29", "05:59:59" })
	void testGetTotalHoursGoodAndBoundary(String candidate) {
	int hours = Time.getTotalHours(candidate);
	assertTrue("The hours were not calculated properly", hours==5);

}
	@Test
	void testGetTotalHoursBad() {
		assertThrows(NumberFormatException.class, 
				()-> {Time.getTotalSeconds("abc");});
	}
	}
