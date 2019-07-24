package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractPrimeGenerator {

	
	List<Long> primes = new ArrayList<>();
	public List<Long> getPrimes() {
		return primes;
	}

	Long primesTill = new Long(100);
	
	public abstract void generatePrimesTill(Long roof);
	
	public List<Long> getAllPrimesTill(Long x) {		
		return primes.stream().filter(s -> s.compareTo(x) == -1).collect(Collectors.toList());
	}
	
	public boolean isPrime(Long x){		
		return Collections.binarySearch(primes, x) < 0 ? false:true;
	}
}
