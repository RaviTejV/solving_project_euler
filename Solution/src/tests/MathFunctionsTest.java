package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import utils.MathFunctions;

public class MathFunctionsTest {

	@Test
	public void gcdTest() {

		assertEquals(14L, MathFunctions.gcd(14, 360360));
		assertEquals(5L, MathFunctions.gcd(15, 25));
		assertEquals(5L, MathFunctions.gcd(35, 25));
		assertEquals(1L, MathFunctions.gcd(1, 1));
	}

}
