package solutions;

import java.util.HashMap;
import java.util.Map;

import utils.MathFunctions;

public class SolutionFor15 implements Solution {

	@Override
	public void solve() {
		Long num = 20L;

		// ans = 40 c 20

		Map<Long, Integer> numerator = new HashMap<>();
		Map<Long, Integer> denominator = new HashMap<>();

		for (Long i = num + num; i > num; i--) {
			Map<Long, Integer> factors = MathFunctions.getAllFactors(i);
			factors.keySet().forEach(s -> numerator.put(s, numerator.getOrDefault(s, 0) + factors.get(s)));
		}

		for (Long i = 1L; i <= num; i++) {
			Map<Long, Integer> factors = MathFunctions.getAllFactors(i);
			factors.keySet().forEach(s -> denominator.put(s, denominator.getOrDefault(s, 0) + factors.get(s)));
		}
		
		System.out.println(numerator);
		System.out.println(denominator);

		denominator.keySet().forEach(s -> numerator.put(s, numerator.get(s) - denominator.get(s)));

		System.out.println(numerator.keySet().stream().mapToLong(s -> powerOf(s, numerator.get(s))).reduce(1L, (a,b) -> a*b));
		
		//anotherway - which is very simple
		
		long result =1;
		for(int i=1; i <=20; i++){
			result = (result * (20 + i))/i; 
		}
		
		System.out.println("Simple result: " + result);

	}

	private Long powerOf(Long s, Integer integer) {

		Long result = 1L;

		while (integer > 0) {
			result *= s;
			integer--;
		}

		return result;
	}

}
