package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import utils.MathFunctions;

public class SolutionFor29 implements Solution {

	@Override
	public void solve() {
		// a^b 2<=a/b<=100

		Integer max_value = 101;
		
		Set<String> unique_values = new HashSet<>();
		
		for (Integer i = 2; i < max_value; i++) {
			Map<Long, Integer> divisors = MathFunctions.getAllFactors(i.longValue());
			for (Integer j = 2; j < max_value; j++) {
				final Integer multiplier = j;
				Map<Long, Integer> copy = new LinkedHashMap<Long, Integer>();
				copy.putAll(divisors);
				copy.replaceAll((a,b) -> b*multiplier);
				unique_values.add(copy.toString());
			}
		}
		
		unique_values.forEach(System.out::println);

		System.out.println(unique_values.size());
	}

}
