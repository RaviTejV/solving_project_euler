package utils;

import java.util.Arrays;

public class StringUtils {

	public static boolean isPalindrome(String s) {

		s.length();

		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			if (s.charAt(i) != s.charAt(j))
				return false;
		}
		return true;

	}

	public static boolean isPandigital(Long x) {

		return Arrays.asList(x.toString().split("")).stream().filter(s -> !(s.equals("0") || (s.charAt(0) - '0') > x.toString().length())).distinct().count() == x.toString().length();

	}
}
