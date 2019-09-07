package customClasses;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class RomanNumeralsInterpreter {

	/*
	 * I = 1 V = 5 X = 10 L = 50 C = 100 D = 500 M = 1000
	 */

	static Map<Character, Integer> romanToDecimalMap;
	static Map<Integer, String> decimalToRomanMap;

	static {
		romanToDecimalMap = new HashMap<Character, Integer>();
		romanToDecimalMap.put('I', 1);
		romanToDecimalMap.put('V', 5);
		romanToDecimalMap.put('X', 10);
		romanToDecimalMap.put('L', 50);
		romanToDecimalMap.put('C', 100);
		romanToDecimalMap.put('D', 500);
		romanToDecimalMap.put('M', 1000);

		decimalToRomanMap = new LinkedHashMap<>();
		decimalToRomanMap.put(1000, "M");
		decimalToRomanMap.put(900, "CM");
		decimalToRomanMap.put(500, "D");
		decimalToRomanMap.put(400, "CD");
		decimalToRomanMap.put(100, "C");
		decimalToRomanMap.put(90, "XC");
		decimalToRomanMap.put(50, "L");
		decimalToRomanMap.put(40, "XL");
		decimalToRomanMap.put(10, "X");
		decimalToRomanMap.put(9, "IX");
		decimalToRomanMap.put(5, "V");
		decimalToRomanMap.put(4, "IV");
		decimalToRomanMap.put(1, "I");
	}

	public static String generateRomanNumeral(Integer decimalInt) {

		StringBuilder returnString = new StringBuilder();

		Set<Entry<Integer, String>> orderedSet = decimalToRomanMap.entrySet();

		while (decimalInt > 0) {
			for (Entry<Integer, String> entry : orderedSet) {
				if (entry.getKey().compareTo(decimalInt) <= 0) {
					returnString.append(entry.getValue());
					decimalInt -= entry.getKey();
					break;
				}
			}
		}
		return returnString.toString();

	}

	public static Integer parseRomanInteger(String romanInt) throws IllegalArgumentException {

		if (!validateAgainstRules(romanInt)) {
			throw new IllegalArgumentException();
		}

		// Assume the string is valid

		// variables to hold any state (for subtraction)
		char prevChar = '\0';
		Integer finalValue = 0;

		// Only one I, X, and C can be used as the leading numeral in part of a
		// subtractive pair.
		// I can only be placed before V and X.
		// X can only be placed before L and C.
		// C can only be placed before D and M.

		// Character[] chars = romanInt.chars().mapToObj(c -> (char)
		// c).toArray(Character[]::new);

		for (int i = 0; i < romanInt.length(); i++) {

			char currentChar = romanInt.charAt(i);

			finalValue += romanToDecimalMap.get(currentChar);

			if ((prevChar == 'I' && (currentChar == 'V' || currentChar == 'X'))
					|| (prevChar == 'X' && (currentChar == 'L' || currentChar == 'C'))
					|| (prevChar == 'C' && (currentChar == 'D' || currentChar == 'M'))) {
				finalValue -= 2 * romanToDecimalMap.get(prevChar);
			}

			prevChar = currentChar;

		}

		return finalValue;
	}

	private static boolean validateAgainstRules(String romanInt) {
		// TODO: write rules for validation
		return true;
	}
}
