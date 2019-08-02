package solutions;

import java.math.BigInteger;

public class SolutionFor97 implements Solution {

	@Override
	public void solve() throws Exception {
		// 28433×2^7830457+1

		BigInteger answer = new BigInteger("28433");
		answer = answer.multiply(new BigInteger("2").pow(7830457));
		answer = answer.add(BigInteger.ONE);

		System.out.println(answer.toString().substring(answer.toString().length() - 10));

	}

}
