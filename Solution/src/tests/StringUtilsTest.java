package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;
import utils.StringUtils;

public class StringUtilsTest {

	@Test
	public void testPalindrom() {
		assertTrue(StringUtils.isPalindrome("abcba"));
	}

}
