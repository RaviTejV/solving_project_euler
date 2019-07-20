package solutions;


import java.util.List;

import utils.MathFunctions;

public class SolutionFor21 implements Solution {

	@Override
	public void solve() {
		//10000
		
		int answer = 0;
		
		for(int i = 2; i < 10001; i ++){
			if(isAmicableNumber(i)){
				answer += i;
			}
		}
		
		System.out.println("Answer: " + answer); //31626
	}

	private boolean isAmicableNumber(Integer i) {
		
		List<Integer> divisors = MathFunctions.getAllDivisors(i);
		
		Integer sumOfDivisors = divisors.stream().reduce(0, Integer::sum);
		
		if(sumOfDivisors.compareTo(i) == 0){
			return false;
		}
		
		if(MathFunctions.getAllDivisors(sumOfDivisors).stream().reduce(0, Integer::sum).compareTo(i) == 0)
			return true;
		
		return false;
	}

}
