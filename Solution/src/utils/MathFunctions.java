package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class MathFunctions {
	
	static AbstractPrimeGenerator pg = new SievePrimesGenerator(1000000L);
	
	public static long gcd(long a, long b){
		
		if (b == 0) 
	        return a; 
	    return gcd(b, a % b); 
		
	}

	public static Map<Long, Integer> getAllFactors(Long x) {
		List<Long> primes = pg.getAllPrimesTill(x+1);
		
		Map<Long, Integer> returnMap = new HashMap<>();
		
		for(Long prime: primes){
			while(x % prime == 0){
				x/=prime;
				returnMap.put(prime, returnMap.getOrDefault(prime, 0) + 1);
			}
			
			if(x == 1)
				break;
		}
		
		return returnMap;
	}
	
	public static Set<Long> getPrimeFactors(Long x) {
		List<Long> primes = pg.getAllPrimesTill(x+1);
		
		Set<Long> returnSet = new TreeSet<>();
		
		for(Long prime: primes){
			while(x % prime == 0){
				x/=prime;
				returnSet.add(prime);
			}
			
			if(x == 1)
				break;
		}
		
		return returnSet;
	}
	
	public static List<Integer> getAllDivisors(Integer x) {
		
		List<Integer> retList = new ArrayList<>();
		
		for(int i = 1 ; i < x; i++ ){
			if(x % i == 0) retList.add(new Integer(i));
		}
		
		return retList;
	}

	public static int simpleFactorial(int x) {
		
		if(x < 2) return 1; 
		
		int result = 1;
		
		while (x > 0) {
			result*=x;
			x--;
		}
		
		return result;
	}

	public static Integer simplePower(int i, int j) {
		int returnVal = 1;
		while(j-- > 0){
			returnVal*=i;
		}
		
		return returnVal;
	}

}
