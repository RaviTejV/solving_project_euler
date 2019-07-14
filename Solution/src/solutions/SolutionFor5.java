package solutions;

import utils.MathFunctions;

public class SolutionFor5 implements Solution {

	@Override
	public void solve() {
		/*
		 * 2520 is the smallest number that can be divided by each of the
		 * numbers from 1 to 10 without any remainder.
		 * 
		 * What is the smallest positive number that is evenly divisible by all
		 * of the numbers from 1 to 20?
		 */
		
		int runningVal = 1;
		for(int i=2; i <= 20; i++ ){
//			System.out.println("Calc GCD of " + i + " " + runningVal);
			runningVal *= i/MathFunctions.gcd(i,runningVal);
		}
		
		System.out.println(runningVal);
	}
}
