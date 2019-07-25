package solutions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import utils.AbstractPrimeGenerator;
import utils.SievePrimesGenerator;

public class SolutionFor35 implements Solution {

	@Override
	public void solve() {
		// get all primes under 1_mill -> for each prime get all rotations -> if
		// each is prime then add all these rotation to set
		Set<Integer> circularPrimes = new TreeSet<>();

		AbstractPrimeGenerator pg = new SievePrimesGenerator(1000000);

		List<Long> primesList = pg.getPrimes();

		for (Long prime : primesList) {
			Set<Long> rotations = getAllRotations(prime);
			
			if(rotations.stream().anyMatch(s -> !primesList.contains(s))) continue;
			
			circularPrimes.add(prime.intValue());
		}
		
		System.out.println(circularPrimes.size());

	}

	private Set<Long> getAllRotations(Long prime) {
		Set<Long> returnSet = new TreeSet<>();
		
		List<String> digits = Arrays.asList(prime.toString().split(""));
		
		while (returnSet.add(digits.stream().mapToLong(s -> Long.parseLong(s)).reduce(0, (a,b) -> a*10+b))){
			Collections.rotate(digits, 1);
		}
		
		return returnSet;
	}

}
