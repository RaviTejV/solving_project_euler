package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import utils.StringUtils;

public class StringUtilsTest {

	@Test
	public void testPalindrom() {
		assertTrue(StringUtils.isPalindrome("abcba"));

		assertTrue(StringUtils.isPalindrome("123321"));
	}

	@Test
	public void testPanDigital() {
		assertTrue(StringUtils.isPandigital(87654321L));

		assertTrue(StringUtils.isPandigital(1765432L));

		assertFalse(StringUtils.isPandigital(8765321L));
		assertFalse(StringUtils.isPandigital(120L));
	}

}
