package solutions;

import java.math.BigInteger;

public class SolutionFor48 implements Solution {

	@Override
	public void solve() throws Exception {
		
		BigInteger ans = BigInteger.ZERO;
		for(Integer i = 1; i < 1001; i ++){
			BigInteger iVal = new BigInteger(i.toString());
			BigInteger power = iVal.pow(i);
			ans = ans.add(power);
		}
		
		System.out.println(ans.toString().substring(ans.toString().length() - 10));
	}

}
