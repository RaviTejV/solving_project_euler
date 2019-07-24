package solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class SolutionFor30 implements Solution {

	@Override
	public void solve() {
		// Find the sum of all the numbers that can be written as the sum of
		// fifth powers of their digits.
		// whats the max value 999999 = 6*(9*9*9*9*9)

		Integer ans = 0;
		Map<Integer, Integer> fifth_power = new HashMap<>();
		IntStream.range(0, 10).forEach(s -> fifth_power.put(s, (s * s) * (s * s) * s));

		for (Integer i = fifth_power.get(2), max_val = fifth_power.get(9) * 9; i < max_val; i++) {
			if (i.equals(sumOfMappedDigits(i, fifth_power)))
				ans += i;
		}

		System.out.println(ans);
	}

	private Integer sumOfMappedDigits(Integer i, Map<Integer, Integer> map) {
		return Arrays.asList(i.toString().split("")).stream().mapToInt(s -> map.get(Integer.parseInt(s))).reduce(0,
				Integer::sum);
	}

}
