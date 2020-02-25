package solutions;

import utils.StringUtils;

public class SolutionFor112 implements Solution {

	@Override
	public void solve() throws Exception {

		int i;
		int bounceCount = 0;
		for (i = 100; bounceCount * 100.0 / (i-1) < 99.0; i++) {
			if (!StringUtils.isIncreasing(i) && !StringUtils.isDecreasing(i))
				bounceCount++;
		}

		System.out.println(i-1 + " " + bounceCount + " " + bounceCount * 100.0 / (i-1));
	}

}
