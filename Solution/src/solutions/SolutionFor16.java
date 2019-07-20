package solutions;

import java.math.BigInteger;
import java.util.Arrays;

public class SolutionFor16 implements Solution {

	@Override
	public void solve() {
		// Doing this the most naive way

		// cal 2^1000

		BigInteger result = new BigInteger("1");

		BigInteger constTwo = new BigInteger("2");

		for (int i = 0; i < 1000; i++) {
			result = result.multiply(constTwo);
		}

		System.out.println(Arrays.asList(result.toString().split("")).stream().mapToInt(s -> Integer.parseInt(s)).boxed().reduce(Integer.parseInt("0"), Integer::sum));
		System.out.println(result);

	}

}
