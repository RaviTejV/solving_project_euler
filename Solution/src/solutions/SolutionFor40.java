package solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.MathFunctions;

public class SolutionFor40 implements Solution {

	@Override
	public void solve() {
		// First off i need a function to find the nth digit;
		List<Integer> reqNumbers = Arrays.asList(1, 10, 100, 1000, 10000, 100000, 1000000);

		// contains the start pos for an n digit number -> 1=>1 10=>10 100=>190
		// etc..
		Map<Integer, Integer> nthDigitStartsFromPos = new HashMap<>();

		Integer position = 1;
		for (Integer i = 1; i < 8; i++) {
			nthDigitStartsFromPos.put(i, position);
			position += xTimesNine(i) * (i);

		}

		System.out.println(nthDigitStartsFromPos);

		Integer ans = 1;
		for (Integer entry : reqNumbers) {

//			System.out.println(getNthDigit(entry, nthDigitStartsFromPos));
			ans *= getNthDigit(entry, nthDigitStartsFromPos);
		}

		System.out.println("Answer: " + ans);
	}

	private Integer xTimesNine(Integer i) {
		Integer returnVal = 9;

		while (--i > 0) {
			returnVal = returnVal * 10;
		}

		return returnVal;
	}

	private Integer getNthDigit(Integer entry, Map<Integer, Integer> nthDigitStartsFromPos) {
		Integer indexToFind = 1;
		// for (indexToFind = 1; nthDigitStartsFromPos.get(indexToFind) <=
		// entry; indexToFind++)
		// ;

		while (nthDigitStartsFromPos.get(indexToFind) <= entry)
			indexToFind++;

		indexToFind -= 1;

		Integer i = nthDigitStartsFromPos.get(indexToFind);
		Integer x = MathFunctions.simplePower(10, indexToFind - 1);

		do {
			x++;
			i += indexToFind;
		} while (i <= entry);

		x--;
		i -= indexToFind;

		for (int j = 0; j < indexToFind; j++) {
			if (i + j == entry) {
				return x.toString().codePointAt(j) - '0';
			}
		}
		return 0;
	}

}
