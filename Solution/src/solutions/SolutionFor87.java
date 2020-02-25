package solutions;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import utils.SievePrimesGenerator;

public class SolutionFor87 implements Solution {

	@Override
	public void solve() throws Exception {

		// 50_000_000

		Set<Long> set = new TreeSet<>();

		SievePrimesGenerator pg = new SievePrimesGenerator(8000L);

		List<Long> primes = pg.getPrimes();

		long limit = 50_000_000L;

		for (int i = 0;; i++) {

			long a = primes.get(i);

			long sq_a = a * a;

			if (sq_a >= limit)
				break;

			for (int j = 0; j < primes.size(); j++) {

				long b = primes.get(j);

				long cu_b = b * b * b;

				if (sq_a + cu_b >= limit)
					break;

				for (int k = 0; j < primes.size(); k++) {

					long c = primes.get(k);

					long fp_c = c * c * c * c;

					if (sq_a + cu_b + fp_c < limit) {
						set.add(sq_a + cu_b + fp_c);
					} else {
						break;
					}
				}
			}
		}

		System.out.println(set.size());
	}

}
