package solutions;

import utils.MathFunctions;

public class SolutionFor47 implements Solution {

	@Override
	public void solve() throws Exception {

		Integer PRIMES = 4;

		for (Long i = 5L; i < 1000000; i++) {

			// System.out.println("Processing :" + i);
			if (MathFunctions.getPrimeFactors(i).size() == PRIMES
					&& MathFunctions.getPrimeFactors(i + 1).size() == PRIMES
					&& MathFunctions.getPrimeFactors(i + 2).size() == PRIMES
					&& MathFunctions.getPrimeFactors(i + 3).size() == PRIMES)

			{
				System.out.println(i);
				break;
			}
		}

	}

}
