package solutions;

import java.math.BigInteger;

public class SolutionFor25 implements Solution {

	@Override
	public void solve() {

		BigInteger a = BigInteger.ONE;
		BigInteger b = BigInteger.ONE;
		
		int i;
		for (i = 2; b.toString().split("").length < 1000; i++) {
			BigInteger tmp = a.add(b);
			a = b;
			b = tmp;
		}

		System.out.println(i);
	}

}
