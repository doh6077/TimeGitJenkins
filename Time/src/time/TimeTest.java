package time;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest extends Time {
	
	@Test
	void testGetTotalSecondsGood() {
		int seconds = Time.getTotalSeconds("10:10:10:10");
		assertTrue( seconds==36610, "The seconds were not calculated properly");
	}
	@Test
	void testGetTotalSecondsBad() {
		assertThrows(
				StringIndexOutOfBoundsException.class,
				()-> {Time.getTotalSeconds("10");}); 
	    
	}
	@Test
	void testGetTotalSecondsBoundary() {
	    int seconds = Time.getTotalSeconds("00:00:00:00");
	    assertTrue( seconds == 0 ,"The total seconds for 00:00:00 should be 0.");
	}
	@Test
	void testGetSecondsGood() {
		int seconds = Time.getSeconds("05:05:05:05");
		assertTrue( seconds==5, "The seconds were not calculated properly");		
	}
	@Test
	void testGetSecondsBad() {	    
		assertThrows(
				StringIndexOutOfBoundsException.class,
				()-> {Time.getSeconds("10:00");}); 
	}
	@Test
	void testGetSecondsBoundary() {
	    int seconds = Time.getSeconds("00:00:00:00");
	    assertTrue(seconds == 0, "The seconds for 00:00:00:00 should be 0.");
	}
	@Test
	void testGetTotalMinutesGood() {
		int minutes = Time.getTotalMinutes("05:05:05:05");
		assertTrue( minutes==5, "The minutes were calculated properly");
	}
	@Test
	void testGetTotalMinutesBad() {
        assertThrows(
                StringIndexOutOfBoundsException.class,
                () -> {Time.getTotalMinutes("10");}
        );
	}
	@Test
	void testGetTotalMinutesBoundary() {
	    int minutes = Time.getTotalMinutes("00:00:00:00");
	    assertTrue(minutes == 0, "The minutes for 00:00:00 should be 0.");
	}
	@Test
	void testGetTotalHoursGood() {
		int hours = Time.getTotalHours("05:00:00:00");
		assertTrue(hours == 5, "The hours were not calculated properly");
	}
		
		
	
	@Test
	void testGetTotalHoursBad() {
        assertThrows(
                StringIndexOutOfBoundsException.class,
                () -> {Time.getTotalHours("");}
        );
	}
	@Test
	void testGetTotalHoursBoundary() {
	    int hours = Time.getTotalHours("00:00:00:00");
	    assertTrue(hours == 0, "The minutes for 00:00:00:00 should be 0.");
	}
	

	@Test
	void testGetMillisecondsBad() {
	    Exception exception = assertThrows(StringIndexOutOfBoundsException.class, () -> 
	    {
	        Time.getMilliseconds("00");});
	}

	@Test
	void testGetMillisecondsGood() {
	    int milliseconds = Time.getMilliseconds("12:05:05:12");
	    assertEquals(12, milliseconds, "The milliseconds should be 12.");
	}

	@Test
	void testGetMillisecondsBoundary() {
	    int milliseconds = Time.getMilliseconds("12:05:05:000");
	    assertEquals(0, milliseconds, "The milliseconds should be 0.");
	}

}
