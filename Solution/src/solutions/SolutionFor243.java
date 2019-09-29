package solutions;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

import utils.AbstractPrimeGenerator;
import utils.SievePrimesGenerator;

public class SolutionFor243 implements Solution {

	@Override
	public void solve() throws Exception {

		double target = (double) 15499 / 94744;
		// double target = 0.4;
		// 15499/94744

		AbstractPrimeGenerator pg = new SievePrimesGenerator(30L);

		List<Long> primes = pg.getPrimes();

		BigInteger runningVal = BigInteger.ONE;
		BigInteger runningProduct = BigInteger.ONE;

		// primes.remove(2);

		for (int i = 0; i < primes.size(); i++) {

			runningVal = runningVal.multiply(new BigInteger(new Integer(primes.get(i).intValue() - 1).toString()));

			runningProduct = runningProduct.multiply(new BigInteger(primes.get(i).toString()));

			BigDecimal maxVal = new BigDecimal(runningVal)
					.divide(new BigDecimal(runningProduct).subtract(BigDecimal.ONE), 100, RoundingMode.HALF_UP);
			BigDecimal minVal = new BigDecimal(runningVal).divide(new BigDecimal(runningProduct), 100,
					RoundingMode.HALF_UP);

			System.out.println("checking " + primes.get(i) + "... Range " + minVal + " - " + maxVal);

			// double val = (double) MathFunctions.totientFunctionFast((int) i)
			// / (i - 1);

			if (maxVal.doubleValue() > target && minVal.doubleValue() < target) {
				// System.out.println("Answer: " + primes.get(i));

				for (int j = 0; j <= i; j++) {

					BigInteger checkInt = runningProduct
							.multiply(new BigInteger(new Integer(primes.get(j).intValue()).toString()))
							.multiply(new BigInteger(new Integer(primes.get(j).intValue()).toString()));

					BigDecimal checkDec = new BigDecimal(checkInt).multiply(new BigDecimal(minVal.doubleValue()))
							.divide(new BigDecimal(checkInt).subtract(BigDecimal.ONE), 100, RoundingMode.HALF_UP);

					System.out
							.println("checking for " + target + " :" + primes.get(j) + " " + checkInt + " " + checkDec);

					if (checkDec.doubleValue() < target) {
						System.out.println("Answer: " + primes.get(j) + " " + checkInt);
						break;
					}
				}

				break;
			}
		}

	}

}
