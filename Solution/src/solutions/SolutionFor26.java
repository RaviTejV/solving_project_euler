package solutions;

import java.util.HashMap;
import java.util.Map;

public class SolutionFor26 implements Solution {

	@Override
	public void solve() {
		// most decimal cycle... under 1000

		int ans = 0;
		int maxCycle = -1;

		for (int i = 2; i < 1000; i++) {

			int cycleLength = calcRecurringLength(i);

			System.out.println(i + " " + cycleLength);
			if (cycleLength > maxCycle) {
				maxCycle = cycleLength;
				ans = i;
			}
		}

		System.out.println(ans + " " + maxCycle);

//		System.out.println(calcRecurringLength(983));

	}

	private int calcRecurringLength(int i) {

		int quotient = 10;

		while (i > quotient)
			quotient *= 10;

		Map<Integer, Integer> digitsWithPos = new HashMap<>();
		digitsWithPos.put(0, 0);

		int pos = 1;
		while (quotient != 0 && !digitsWithPos.containsKey(quotient % i)) {

			digitsWithPos.put(quotient % i, pos);

			quotient = (quotient % i) * 10;
			while (i > quotient) {
				quotient *= 10;
				pos++;
			}
			pos++;
		}

		if (quotient == 0)
			return 0;

		return pos - digitsWithPos.get(quotient % i);

	}

}
