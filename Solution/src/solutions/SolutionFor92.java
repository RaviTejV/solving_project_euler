package solutions;

import java.util.Set;
import java.util.TreeSet;

public class SolutionFor92 implements Solution {

	Set<Long> setOf1 = new TreeSet<>();
	Set<Long> setOf89 = new TreeSet<>();

	@Override
	public void solve() throws Exception {

		Long answer = 0L;
		setOf1.add(1L);
		setOf89.add(89L);

		for (Long i = 1L; i < 10000000; i++) {
			if (checkChainEnding(i) == 89L) {
				answer++;
			}
		}

		System.out.println(answer);

	}

	private Long checkChainEnding(Long i) {
		if (setOf1.contains(i))
			return 1L;

		if (setOf89.contains(i))
			return 89L;

		Long sumOfDigitSquares = 0L;

		while (i > 0) {
			sumOfDigitSquares += (i % 10) * (i % 10);
			i /= 10;
		}

		Long endResult = checkChainEnding(sumOfDigitSquares);
		if (endResult == 1L) {
			setOf1.add(i);
			setOf1.add(sumOfDigitSquares);
		}
		if (endResult == 89L) {
			setOf89.add(i);
			setOf89.add(sumOfDigitSquares);
		}

		return endResult;

	}

}
