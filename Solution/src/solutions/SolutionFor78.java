package solutions;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class SolutionFor78 implements Solution {

	long[] memoized = new long[100000];

	@Override
	public void solve() throws Exception {

		// // 55374
		// System.out.println(function(55374));

		MathContext mc = new MathContext(1, RoundingMode.HALF_DOWN);

		System.out.println(new BigDecimal((double) (2) / 3).setScale(0, RoundingMode.HALF_EVEN));

		for (int i = 1; i < 13; i++) {
			long res = function(i);

			System.out.println(i + " " + res);

			if (res % 1000000L == 0) {
				break;
			}
		}

	}

	private long function(int x) {

		if (x < 0)
			return 0;
		if (x == 0 || x == 1)
			return 1;

		if (memoized[x] != 0)
			return memoized[x];

		long res = 1L;

		int prevDigit = -1;

		for (int i = 1; i < x; i++) {

			int nextDigit = new BigDecimal((double) (x - i) / i).setScale(0, RoundingMode.HALF_DOWN).intValueExact();
			if (nextDigit > 0 && prevDigit != nextDigit) {
				// System.out.println("Calling " + nextDigit);
				res += function(nextDigit) % 1000000L;
			}

			prevDigit = nextDigit;
		}

		memoized[x] = res;

		return res;
	}

}
