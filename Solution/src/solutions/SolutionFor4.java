package solutions;

import utils.StringUtils;

public class SolutionFor4 implements Solution {

	@Override
	public void solve() {
		/*
		 * A palindromic number reads the same both ways. The largest palindrome
		 * made from the product of two 2-digit numbers is 9009 = 91 × 99.
		 * 
		 * Find the largest palindrome made from the product of two 3-digit
		 * numbers.
		 */
		
		int maxValue = -1;
		
		for(int i=101; i< 1000; i++){
			for(int j=101; j<1000; j++){
				int product = i*j;
				
				if(StringUtils.isPalindrome(Integer.toString(product)) && product > maxValue){
					maxValue = product;
				}
			}
		}
		
		System.out.println(maxValue);
	}

}
