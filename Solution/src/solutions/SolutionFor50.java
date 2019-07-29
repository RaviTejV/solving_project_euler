package solutions;

import java.util.Collections;
import java.util.List;

import utils.AbstractPrimeGenerator;
import utils.SievePrimesGenerator;

public class SolutionFor50 implements Solution {

	@Override
	public void solve() throws Exception {
		AbstractPrimeGenerator pg = new SievePrimesGenerator(1000000L);

		List<Long> primes = pg.getPrimes();

		int maxLength = -1;
		Long answer = 0L;
		for (int i = 0; i < primes.size(); i++) {
			// System.out.println(i);
			Long runningVal = primes.get(i);
			for (int j = i + 1; j < primes.size(); j++) {
				runningVal += primes.get(j);

				if (Collections.binarySearch(primes, runningVal) > 0) {
					if (j - i > maxLength) {
						maxLength = j - i;
						answer = runningVal;
						// System.out.println(i + " " + j + " " + runningVal + "
						// " + (j - i + 1));
					}
				} else if (Collections.binarySearch(primes, runningVal) == (-1 - 1 * primes.size()))
					break;
			}
		}
		
		System.out.println("maxLength :" + maxLength + "; number :" + answer);
	}

}
