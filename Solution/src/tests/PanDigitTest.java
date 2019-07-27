package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import utils.PanDigitalNumberGenerator;
import utils.SimplePanDigitGenerator;

public class PanDigitTest {

	@Test
	public void constructSimplePanDigitGen() {
		
		PanDigitalNumberGenerator ng = new SimplePanDigitGenerator(5);
		
		assertEquals(ng.getCurrentDigit().toString(),"54321");
		assertEquals(ng.getNextDigit().toString(),"54312");
		assertEquals(ng.getNextDigit().toString(),"54231");
		assertEquals(ng.getNextDigit().toString(),"54213");
		
//		while(ng.hasNext()) {
//			System.out.println(ng.getNextDigit());
//		}
	}

}
