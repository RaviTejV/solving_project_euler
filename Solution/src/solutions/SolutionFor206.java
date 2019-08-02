package solutions;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SolutionFor206 implements Solution {

	@Override
	public void solve() throws Exception {

		Pattern p = Pattern.compile("1.2.3.4.5.6.7.8.9.0");

		for (BigInteger i = new BigInteger("100000000");; i = i.add(BigInteger.TEN)) {
			System.out.println(i);
			BigInteger square = i.multiply(i);
			Matcher m = p.matcher(square.toString());
			if (m.matches()) {
				System.out.println(i + " " + square);
				break;
			}
		}
	}

}
