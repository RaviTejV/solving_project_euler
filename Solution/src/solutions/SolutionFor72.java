package solutions;

import utils.MathFunctions;

public class SolutionFor72 implements Solution {

	@Override
	public void solve() throws Exception {
		// simplies to adding sum of totient fn values for all ints in range

		Long answer = 0L;

		for (int i = 2; i <= 1_000_000; i++) {
			answer += MathFunctions.totientFunctionFast(i);
		}

		System.out.println(answer);
	}

}
