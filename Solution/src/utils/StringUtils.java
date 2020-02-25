package utils;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

		return Arrays.asList(x.toString().split("")).stream()
				.filter(s -> !(s.equals("0") || (s.charAt(0) - '0') > x.toString().length())).distinct()
				.count() == x.toString().length();

	}

	public static boolean isPermutation(Integer a, Integer b) {

		return digitHash(a) == digitHash(b);

	}

	public static int digitHash(Integer i) {
		return i.toString().chars().sorted().boxed().reduce(0, (a, b) -> a * 10 + b);
	}

	public static int bigDigitHash(BigInteger i) {
		return i.toString().chars().sorted().boxed().map(s -> s.toString()).reduce("", (a, b) -> a + "" + b).hashCode();
	}

	public static boolean isIncreasing(Integer x) {
		List<Integer> a = Arrays.asList(x.toString().split("")).stream().mapToInt(Integer::parseInt).boxed()
				.collect(Collectors.toList());

		for (int i = 0; i < a.size() - 1; i++) {
			if (a.get(i) > a.get(i + 1))
				return false;
		}
		return true;
	}

	public static boolean isDecreasing(Integer x) {
		List<Integer> a = Arrays.asList(x.toString().split("")).stream().mapToInt(Integer::parseInt).boxed()
				.collect(Collectors.toList());

		for (int i = 0; i < a.size() - 1; i++) {
			if (a.get(i) < a.get(i + 1))
				return false;
		}
		return true;
	}
}
