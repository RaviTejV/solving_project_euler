package solutions;

import utils.MathFunctions;

public class SolutionFor53 implements Solution {

	@Override
	public void solve() throws Exception {
		
		Integer count = 0;
		
		for(Integer n = 3; n < 101; n ++){
			for(Integer r = 1; r < n; r++){
				if(MathFunctions.nCr(n, r).toString().length() >= 7)
					count++;
			}
		}
		
		System.out.println(count);
	}

}
