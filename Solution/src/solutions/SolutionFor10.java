package solutions;

import utils.AbstractPrimeGenerator;
import utils.SievePrimesGenerator;

public class SolutionFor10 implements Solution {

	@Override
	public void solve() {
		/*
		 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
		 * 
		 * Find the sum of all the primes below two million.
		 */

		AbstractPrimeGenerator pg = new SievePrimesGenerator(2000000);
		
//		pg.getPrimes().forEach(System.out::println);
		System.out.println(pg.getPrimes().stream().reduce(0L, Long::sum));
	}

}
