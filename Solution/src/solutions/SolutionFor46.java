package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.AbstractPrimeGenerator;
import utils.SievePrimesGenerator;

public class SolutionFor46 implements Solution {

	@Override
	public void solve() throws Exception {
		// What is the smallest odd composite that cannot be written as the sum
		// of a prime and twice a square?

		AbstractPrimeGenerator pg = new SievePrimesGenerator(1000000L);

		List<Long> squaresTwice = new ArrayList<>();

		for (Long i = 1L; i < 10000; i++) {
			squaresTwice.add(i * i * 2);
		}

		List<Long> primes = pg.getPrimes();

		System.out.println("Done generating primes and squares");
//		System.out.println(squaresTwice);
//		System.out.println(primes);

		for (Long i = 11L; i < 10000000L; i += 2) {

			// System.out.println("processing :" + i);

			if (pg.isPrimeLong(i))
				continue;

			boolean flag = true;
			
			//for all primes, if any prime has a complement in squaresTwice, then break -> false cse
			for (Long prime : primes) {

				if (prime > i)
					break;

				if (Collections.binarySearch(squaresTwice, i - prime) >= 0) {
					flag = false;
					break;
				}
			}

			if (flag == true) {
				System.out.println(i);
				break;
			}
		}
	}

}
