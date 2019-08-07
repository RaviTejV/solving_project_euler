package solutions;

import java.util.List;

import utils.SievePrimesGenerator;

public class SolutionFor60 implements Solution {

	SievePrimesGenerator pg = new SievePrimesGenerator(1000000L);

	@Override
	public void solve() throws Exception {

		pg.addMorePrimes(10000000L);

		List<Long> primes = pg.getAllPrimesTill(27000L);

		System.out.println("Primes Generated, values: " + primes.size());

		Integer num_primes = primes.size();

		Long min = 27000L;
		for (int i = 0; i < num_primes; i++) {
			for (int j = i + 1; j < num_primes; j++) {

				if (primes.get(i) + 4 * primes.get(j) > min) {
					break;
				}

				if (check(primes.get(i), primes.get(j)) == false)
					continue;

				for (int k = j + 1; k < num_primes; k++) {

					if (primes.get(i) + primes.get(j) + 3 * primes.get(k) > min) {
						break;
					}

					if (check(primes.get(j), primes.get(k)) == false || check(primes.get(k), primes.get(i)) == false)
						continue;

					for (int l = k + 1; l < num_primes; l++) {

						if (primes.get(i) + primes.get(j) + primes.get(k) + 2 * primes.get(l) > min) {
							break;
						}

						if (check(primes.get(l), primes.get(k)) == false || check(primes.get(l), primes.get(i)) == false
								|| check(primes.get(l), primes.get(j)) == false)
							continue;
						for (int m = l + 1; m < num_primes; m++) {
							Long sum = primes.get(i) + primes.get(j) + primes.get(k) + primes.get(l) + primes.get(m);

							if (sum > min)
								break;

							if (check(primes.get(m), primes.get(k)) == false
									|| check(primes.get(m), primes.get(i)) == false
									|| check(primes.get(m), primes.get(j)) == false
									|| check(primes.get(m), primes.get(l)) == false)
								continue;

							System.out.println(primes.get(i) + " " + primes.get(j) + " " + primes.get(k) + " "
									+ primes.get(l) + " " + primes.get(m));
							System.out.println(sum);

							if (sum < min) {
								// System.out.println("New min found: " + sum);
								min = sum;
							}

						}

					}
				}

			}
		}
		System.out.println("Answer: " + min);

	}

	private boolean check(Long i, Long j) {
		if (!pg.isPrimeLong(Long.parseLong(j.toString() + i.toString())))
			return false;

		if (!pg.isPrimeLong(Long.parseLong(i.toString() + j.toString())))
			return false;

		return true;

	}

}
