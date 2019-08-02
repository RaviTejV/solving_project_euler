package solutions;

import java.math.BigInteger;

public class SolutionFor57 implements Solution {

	@Override
	public void solve() throws Exception {
		BigInteger num = new BigInteger("3");
		BigInteger den = new BigInteger("2");

		int iterations = 1000;

		int count = 0;

		while (iterations-- > 0) {
			BigInteger tmp = num.add(den.multiply(BigInteger.valueOf(2)));
			den = den.add(num);
			num = tmp;
			if (num.toString().length() > den.toString().length()) {
				count++;
			}

		}
		
		System.out.println(count);

	}

}
