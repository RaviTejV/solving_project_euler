package solutions;

import java.math.BigInteger;

import utils.StringUtils;

public class SolutionFor55 implements Solution {

	@Override
	public void solve() throws Exception {

		Integer ans = 0;
		for (Integer i = 1; i < 10000; i++) {
			BigInteger iter = new BigInteger(i.toString());

			boolean flag = true;
			for (int j = 0; j < 51; j++) {
				BigInteger rev = new BigInteger(new StringBuilder(iter.toString()).reverse().toString());
				
//				System.out.println(iter + " " + rev);
				iter = iter.add(rev);
				
				
				if(StringUtils.isPalindrome(iter.toString())){
					flag = false;
					break;
				}
			}
			
			if(flag == true){
				ans++;
			}
		}
		
		System.out.println(ans);

	}

}
