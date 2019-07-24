package solutions;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import utils.AbstractPrimeGenerator;
import utils.SievePrimesGenerator;

public class SolutionFor27 implements Solution {

	@Override
	public void solve() {
		// find product of a,b for which the quad n2 + an + b generates more
		// primes

		/*
		 * Observations: b has to be a prime - since n=0 should yield a prime a
		 * needs to be odd, since an odd b would result in a non-even value for
		 * n=1
		 */

		AbstractPrimeGenerator pg = new SievePrimesGenerator(10000000);

		List<Long> primesTill1k = pg.getAllPrimesTill(1000L);

		Long ans = 0L;
		Long maxLength = -1L;
		
		for (Long prime : primesTill1k) {
			
//			System.out.println("Trying " + prime);
			for (Long j = -999L; j < 1000; j += 2) {

				Long i = 0L;
				for (;; i++) {
					if (!pg.isPrime(i * (i + j) + prime))
						break;
				}
				
				if(maxLength < i){
					ans = prime*j;
					maxLength = i;
				}
				
				
			}
		}
		
		System.out.println(ans);
	}

}
