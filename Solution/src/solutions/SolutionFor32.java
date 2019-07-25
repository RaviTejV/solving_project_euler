package solutions;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class SolutionFor32 implements Solution {

	@Override
	public void solve() {
		// sum of all products with identity 1through9 pandigital

		Set<Integer> pandigitalProducts = new TreeSet<>();

		// Use computer for brute force

		// I have to know when to stop - first of all
		// Start with i < j for all pairs - till when?

		for (Integer i = 1; i < 1000; i++) {
//			System.out.println(i);
			for (Integer j = i + 1, limit = 1000000 / i; j < limit; j++) {
				Integer product = i * j;
				if (isPandigitalIdentity(i, j, product)) {
					pandigitalProducts.add(product);
				}
			}
		}
		System.out.println(pandigitalProducts.stream().reduce(Integer::sum));

	}

	private boolean isPandigitalIdentity(Integer i, Integer j, Integer product) {

		String identityString = i.toString().concat(j.toString()).concat(product.toString());

		if (identityString.length() != 9)
			return false;

		return Arrays.asList(identityString.split("")).stream().filter(s -> !s.equals("0")).distinct().count() == 9;

	}

}
