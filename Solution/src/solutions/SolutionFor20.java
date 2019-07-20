package solutions;

import java.math.BigInteger;
import java.util.Arrays;

public class SolutionFor20 implements Solution {

	@Override
	public void solve() {
		
		// 100 factorial sum
		
		int input = 100;
		
		//compute factorial
		
		BigInteger factorial = BigInteger.ONE;
		BigInteger runningVal = BigInteger.ONE;
		for(int i = 0 ; i < input; i++){
			factorial = factorial.multiply(runningVal);
			runningVal = runningVal.add(BigInteger.ONE);
		}
		
		System.out.println("Running sum: " + Arrays.asList(factorial.toString().split("")).stream().mapToInt(s -> Integer.parseInt(s)).boxed().reduce(Integer.parseInt("0"), Integer::sum));
		
	}

}
