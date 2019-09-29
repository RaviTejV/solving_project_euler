package solutions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.AbstractPrimeGenerator;
import utils.SievePrimesGenerator;

public class SolutionFor77 implements Solution {

	@Override
	public void solve() throws Exception {
		Map<Integer, Integer> map = new HashMap<>();

		map.put(0, 1);
		map.put(1, 0);

		long SAMPLE = 100;

		AbstractPrimeGenerator pg = new SievePrimesGenerator(SAMPLE);

		List<Long> primes = pg.getPrimes();

		for (int i = 0; i < primes.size() - 1; i++) {
			for (int j = primes.get(i).intValue(); j < SAMPLE; j++) {
				map.put(j, map.getOrDefault(j, 0) + map.getOrDefault(j - primes.get(i).intValue(), 0));

				if (map.get(j) >= 5000 && j < primes.get(i + 1)) {
					System.out.println("Answer: " + j + " value: " + map.get(j));
					return;
				}
			}
		}

		// for (int i = 0; i < SAMPLE; i++) {
		// System.out.println(i + " " + map.get(i));
		// }
	}
}
