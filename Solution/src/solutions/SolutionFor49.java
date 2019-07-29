package solutions;

import java.util.Collections;
import java.util.List;

import utils.AbstractPrimeGenerator;
import utils.SievePrimesGenerator;

public class SolutionFor49 implements Solution {

	@Override
	public void solve() throws Exception {
		/*
		 * The arithmetic sequence, 1487, 4817, 8147, in which each of the terms
		 * increases by 3330, is unusual in two ways: (i) each of the three
		 * terms are prime, and, (ii) each of the 4-digit numbers are
		 * permutations of one another.
		 * 
		 * There are no arithmetic sequences made up of three 1-, 2-, or 3-digit
		 * primes, exhibiting this property, but there is one other 4-digit
		 * increasing sequence.
		 * 
		 * What 12-digit number do you form by concatenating the three terms in
		 * this sequence?
		 * 
		 * 
		 */

		// get all 4 digit primes and examine whether an arithmetic sequence
		// exists

		AbstractPrimeGenerator pg = new SievePrimesGenerator(10000L);

		List<Long> primes = pg.getPrimes();

		// search for a known composite number (1000) to get index of all primes
		// greater than the number
		int indexOfStart = Collections.binarySearch(primes, 1000L);

		List<Long> fourDigitPrimes = primes.subList(-1 - indexOfStart, primes.size());

		// System.out.println(fourDigitPrimes.size());

		// now check for an squenece - for any two vals -> binary search the avg
		// in that range

		for (int i = 0; i < fourDigitPrimes.size(); i++) {
			for (int j = i + 2; j < fourDigitPrimes.size(); j++) {

				Long avg = (fourDigitPrimes.get(i) + fourDigitPrimes.get(j)) / 2;
				String vals = avg.toString() + fourDigitPrimes.get(i).toString() + fourDigitPrimes.get(j).toString();
				if (Collections.binarySearch(fourDigitPrimes, avg) > 0
						&& avg.toString().chars().distinct().count() == vals.chars().distinct().count()
						&& avg.toString().chars().distinct().count() == fourDigitPrimes.get(i).toString().chars()
								.distinct().count()
						&& fourDigitPrimes.get(j).toString().chars().distinct().count() == avg.toString().chars()
								.distinct().count()) {
					System.out.println(fourDigitPrimes.get(i) + "" + avg + "" + fourDigitPrimes.get(j));
				}
			}
		}

	}

}
