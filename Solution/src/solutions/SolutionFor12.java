package solutions;

import java.util.Map;

import utils.MathFunctions;

public class SolutionFor12 implements Solution {

	@Override
	public void solve() {
		
//		What is the value of the first triangle number to have over five hundred divisors?

		for(int i = 2; ; i++){
			
			Long sum = new Long((i*(i+1))/2);
			if(numberOfFactors(sum) > 500)
			{
				System.out.println(sum);
				break;}
		}
	}

	private int numberOfFactors(Long x) {
		Map<Long, Integer> factors = MathFunctions.getAllFactors(x); 
		return factors.values().stream().map(s -> s+1).reduce(1, (a,b) -> a*b);
	}

}
