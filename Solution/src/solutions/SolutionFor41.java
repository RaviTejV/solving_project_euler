package solutions;

import java.util.Collections;
import java.util.List;

import utils.AbstractPrimeGenerator;
import utils.PanDigitalNumberGenerator;
import utils.SievePrimesGenerator;
import utils.SimplePanDigitGenerator;

public class SolutionFor41 implements Solution {

	@Override
	public void solve() {
		AbstractPrimeGenerator pg = new SievePrimesGenerator(40000L);

		List<Long> primes = pg.getPrimes();
		Collections.reverse(primes);

		// for (Long i = 87654321L;; i-=2) {
		// System.out.println(i + " " + StringUtils.isPandigital(i));
		// if (StringUtils.isPandigital(i) && pg.isPrimeLong(i)) {
		// System.out.println(i);
		// break;
		// }
		// }
		// 7652413

		// different way
		PanDigitalNumberGenerator ng = new SimplePanDigitGenerator(8);
		do {
			while (ng.hasNext()) {
				Integer i = ng.getCurrentDigit();
				// System.out.println(i);
				if (pg.isPrimeLong(i.longValue())) {
					System.out.println(i.longValue());
					return;
				}
				ng.getNextDigit();
			}
			ng = new SimplePanDigitGenerator(ng.getNo_of_digits() - 1);
		} while (true);

	}

}
