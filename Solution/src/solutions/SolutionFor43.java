package solutions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import utils.ZeroToNinePandigitGenerator;

public class SolutionFor43 implements Solution {

	@Override
	public void solve() {

		ZeroToNinePandigitGenerator ng = new ZeroToNinePandigitGenerator();

		List<Integer> primes = Arrays.asList(1, 2, 3, 5, 7, 11, 13, 17);

		Collections.sort(primes);
		
		Long ans = 0L;

		while (ng.hasNext()) {
			String digit = ng.getNextWorkingDigit();

			if (isPropertyTrue(digit, primes)) {
				System.out.println(digit);
				ans += Long.parseLong(digit);
			}
		}
		
		System.out.println("Answer :" + ans);
	}

	private boolean isPropertyTrue(String digit, List<Integer> primes) {

		char[] digits = digit.toCharArray();

		for (int i = 1; i < 8; i++) {
			Integer number = (digits[i] - '0') * 100 + (digits[i + 1] - '0') * 10 + (digits[i + 2] -'0');
			if (number % primes.get(i) != 0)
				return false;
		}

		return true;
	}

}
