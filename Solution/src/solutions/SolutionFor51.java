package solutions;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import utils.SievePrimesGenerator;

public class SolutionFor51 implements Solution {

	int no_of_digits = 6;

	@Override
	public void solve() throws Exception {
		// 0 -> 2 -> 1 -> 0 -> 2 -> 1 -> 0 -> 2 -> 1 -> 0 => implies 2 replace
		// can never result in more than 7 number not divisible by 3

		// trying 3 digits -> this must work the number always has same
		// remainder with 3. -> best case all nine values possible

		// strategy first try 3 wild cards on 4 digits no; followed by 5 digit
		// uptill 6 digits

		// gut feeling; cehck only 6 digit primes

		SievePrimesGenerator pg = new SievePrimesGenerator(1000000L);

		pg.addMorePrimes(Long.parseLong(BigInteger.TEN.pow(no_of_digits - 1).multiply(BigInteger.TEN).toString()));
		List<Long> primes = pg.getPrimes();

		System.out.println("Done getting all primes :" + primes.size());

		int indexOfStart = Collections.binarySearch(primes,
				Long.parseLong(BigInteger.TEN.pow(no_of_digits - 1).toString()));

		List<Long> six_digit_primes = primes.subList(-1 - indexOfStart, primes.size());

		for (Long prime : six_digit_primes) {
			// for (Long prime = 1000001L; prime < 10000000; prime+=2) {
			// System.out.println(prime);
			if (hasOnly3IndeticalDigits(prime)) {
				// System.out.println(prime);
				Integer x = getRepeatedDigit(prime);
				// System.out.println(prime+" "+x);

				int count = 0;
				for (Integer i = 0; i < 10; i++) {
					Long digit = replaceDigit(prime, x, i);
					// if (digit.toString().length() != no_of_digits)
					// break;
					if (pg.isPrime(digit))
						count++;
				}

				if (count == 8) {
					System.out.println(prime);
					for (Integer i = 0; i < 10; i++) {
						Long digit = replaceDigit(prime, x, i);
						System.out.print(digit + " ");
					}
					System.out.println();
				}
			}
		}

	}

	private Long replaceDigit(Long prime, Integer x, Integer i) {
		return Long.parseLong(prime.toString().replace(x.toString().charAt(0), i.toString().charAt(0)));
	}

	private Integer getRepeatedDigit(Long prime) {
		Map<Integer, List<Integer>> temp = prime.toString().chars().boxed().collect(Collectors.groupingBy(s -> s));

		for (Integer i : temp.keySet()) {
			if (temp.get(i).size() == 3)
				return i - '0';
		}
		return -1;
	}

	private boolean hasOnly3IndeticalDigits(Long prime) {
		if (prime.toString().chars().distinct().count() >= no_of_digits - 2)
			return false;

		Map<Integer, List<Integer>> temp = prime.toString().chars().boxed().collect(Collectors.groupingBy(s -> s));

		for (Integer i : temp.keySet()) {
			if (temp.get(i).size() == 3)
				return true;
		}

		return false;
	}

}
