package utils;

import java.util.ArrayList;
import java.util.List;

public class FibonacciUtils {

	static List<Integer> fibNumbers = new ArrayList<>();
	static {
		fibNumbers.add(0, 0);
	}

	public static int getNthFibonacciNumber(int n) {
		if (fibNumbers.size() > n+1) {
			return fibNumbers.get(n);
		}
		
		if(n < 2) fibNumbers.add(n, 1);
		else fibNumbers.add(n, getNthFibonacciNumber(n-1) + getNthFibonacciNumber(n-2));
		
		return fibNumbers.get(n);
	}

}