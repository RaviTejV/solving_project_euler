package solutions;

import java.util.List;

import utils.AbstractPrimeGenerator;
import utils.SievePrimesGenerator;

public class SolutionFor3 implements Solution {

	@Override
	public void solve() {
		/*
		 * The prime factors of 13195 are 5, 7, 13 and 29.
What is the largest prime factor of the number 600851475143 ?
		 */
		
		long num = 600851475143L;
		
		long roof = (long) Math.sqrt(num);
		
		AbstractPrimeGenerator primeGen = new SievePrimesGenerator(roof);
		
		 primeGen.getAllPrimesTill(roof).forEach(System.out::println);
		
	List<Long> primes = primeGen.getPrimes();
	
	for(Long prime : primes){
		while(num%prime == 0 ){
			num/=prime;
		}
		
		if(num == 1){
			System.out.println(prime);
			break;
		}
	}
	
	if(num!=1)System.out.println(num);
		
	}
	
}
