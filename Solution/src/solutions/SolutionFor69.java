package solutions;

import utils.MathFunctions;

public class SolutionFor69 implements Solution {

	@Override
	public void solve() throws Exception {

		double max = 0;
		Integer answer = 0;

		for (int i = 1; i < 10; i++) {

			Integer phiN = MathFunctions.totientFunction(i);

			System.out.println(i + " " + phiN);

			double ratio = (double) i / phiN;

			if (ratio > max) {
				max = ratio;
				answer = i;
			}
		}

		System.out.println("Answer: " + answer);

	}

}
