package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractPrimeGenerator {

	List<Long> primes = new ArrayList<>();

	public List<Long> getPrimes() {
		return primes;
	}

	Long primesTill = new Long(100);

	public abstract void generatePrimesTill(Long roof);

	public List<Long> getAllPrimesTill(Long x) {
		// return primes.stream().filter(s -> s.compareTo(x) ==
		// -1).collect(Collectors.toList());
		Integer searchIndex = Collections.binarySearch(primes, x);
		if (searchIndex >= 0)
			return primes.subList(0, searchIndex);
		else
			return primes.subList(0, -1 - searchIndex);

	}

	public boolean isPrime(Long x) {
		return Collections.binarySearch(primes, x) < 0 ? false : true;
	}

	public boolean isPrimeLong(Long x) {
		for (Long prime : primes) {
			
			if(prime >= x) return true;
			if (x % prime == 0)
				return false;
		}

		return true;
	}
}
