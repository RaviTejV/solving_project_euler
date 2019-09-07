package solutions;

import utils.MathFunctions;
import utils.StringUtils;

public class SolutionFor70 implements Solution {

	@Override
	public void solve() throws Exception {
		double min = 99999999;
		Integer answer = 0;

		Integer LIMIT = 10_000_000;
//		Integer LIMIT = 87109;
		
//		System.out.println(LIMIT + " " + MathFunctions.totientFunctionFast(LIMIT));
		
		for (int i = 2; i < LIMIT; i++) {

			Integer phiN = MathFunctions.totientFunctionFast(i);
			
			if (StringUtils.isPermutation(i, phiN)) {

				double ratio = (double) i / phiN;

				if (ratio < min) {
					System.out.println(i + " " + phiN);
					min = ratio;
					answer = i;
				}
			}
		}

		System.out.println("Answer: " + answer);

	}

}
