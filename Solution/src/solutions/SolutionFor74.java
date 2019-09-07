package solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SolutionFor74 implements Solution {

	Map<Long, Long> loop_length;
	Map<Long, Long> factorialVals;

	@Override
	public void solve() throws Exception {
		loop_length = new HashMap<>();
		factorialVals = new HashMap<>();

		/*
		 * 145 169 → 363601 → 1454 → 169 871 → 45361 → 871 872 → 45362 → 872
		 */

		loop_length.put(0L, 1L);
		loop_length.put(1L, 1L);
		loop_length.put(2L, 1L);
		loop_length.put(145L, 1L);
		loop_length.put(169L, 3L);
		loop_length.put(363601L, 3L);
		loop_length.put(1454L, 3L);
		loop_length.put(871L, 2L);
		loop_length.put(872L, 2L);
		loop_length.put(45361L, 2L);
		loop_length.put(45362L, 2L);

		computeFactorials();

		System.out.println(factorialVals);

		Integer answer = 0;

		for (long i = 2L; i < 1_000_000; i++) {
			Long loopLength = calculateLoopLength(i);

			System.out.println(i + " " + loopLength);

			if (loopLength == 60L)
				answer++;
		}

		System.out.println("Answer: " + answer);

	}

	private void computeFactorials() {
		factorialVals.put(0L, 1L);
		for (long i = 1; i < 10; i++) {
			factorialVals.put(i, factorialVals.get(i - 1) * i);
		}
	}

	private Long calculateLoopLength(Long i) {

		System.out.println(i);
		if (loop_length.containsKey(i)) {
			return loop_length.get(i);
		}

		Long sumOfDigitFact = Arrays.asList(i.toString().split("")).stream().mapToLong(s -> Long.parseLong(s))
				.map(factorialVals::get).reduce(0L, (a, b) -> a + b);

		if (sumOfDigitFact.equals(i)) {
			loop_length.put(i, 1L);
			return 1L;
		}

		Long retrunVal = calculateLoopLength(sumOfDigitFact);

		loop_length.put(i, 1 + retrunVal);

		return 1 + retrunVal;
	}

}
