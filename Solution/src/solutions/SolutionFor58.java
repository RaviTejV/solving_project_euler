package solutions;

import utils.AbstractPrimeGenerator;
import utils.SievePrimesGenerator;

public class SolutionFor58 implements Solution {

	@Override
	public void solve() throws Exception {

		int prime_count = 0;
		int values = 1;

		AbstractPrimeGenerator pg = new SievePrimesGenerator(1000000L);

		for (long i = 2; ; i+=2) {
			values += 4;
			if (pg.isPrimeLong(i * i + 1)) {
				prime_count++;
			}

			if (pg.isPrimeLong(i * i + 1 - i)) {
				prime_count++;
			}

			if (pg.isPrimeLong(i * i + 1 + i)) {
				prime_count++;
			}

			double fraction = 100 * prime_count / (double) values;

			System.out.println((i + 1) + " " + fraction);

			if (fraction < 10)
				break;

		}
	}

}
