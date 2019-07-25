package solutions;

import utils.StringUtils;

public class SolutionFor36 implements Solution {

	@Override
	public void solve() {
		// sum of all nos under 1 mill which are palindromes in base 2 and base
		// 10
		
		Integer ans = 0;
		
		for(Integer i = 1; i < 1000000; i ++){
			if(StringUtils.isPalindrome(i.toString())){
				if(StringUtils.isPalindrome(Integer.toBinaryString(i))) 
					ans+=i;
//					System.out.println(i);;
			}
		}
		
		System.out.println(ans);
	}

}
