package solutions;

import java.util.ArrayList;
import java.util.List;

import utils.AbstractPrimeGenerator;
import utils.SievePrimesGenerator;

public class SolutionFor37 implements Solution {

	@Override
	public void solve() {
		// only 11 primes are truncatable both left to right and vice versa find
		// them
		AbstractPrimeGenerator pg = new SievePrimesGenerator(1000000);

		List<Long> primesList = pg.getAllPrimesTill(1000000L);

		System.out.println("Computed Primes");
		List<Long> resultList = new ArrayList<>();
		for (Long prime : primesList) {
			Long number = prime;
			while(number > 0){
				if(!pg.isPrime(number)) break;
				number=number/10;
			}
			
			if(number == 0) {
				Long anotherNumber=prime;
				while(anotherNumber > 0){
					if(!pg.isPrime(anotherNumber)) break;
					anotherNumber = anotherNumber/10==0?0:Long.parseLong(anotherNumber.toString().replaceFirst(".", ""));
				}
				
				if(anotherNumber==0) resultList.add(prime);
			}
		}
				
		resultList.removeIf(s -> s< 10);
		
		System.out.println(resultList.stream().reduce(0L, (a,b) -> a+b));
	}

}
