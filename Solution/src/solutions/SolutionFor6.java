package solutions;

public class SolutionFor6 implements Solution {

	@Override
	public void solve() {
		/*
		 * The sum of the squares of the first ten natural numbers is,
		 * 
		 * 12 + 22 + ... + 102 = 385 The square of the sum of the first ten
		 * natural numbers is,
		 * 
		 * (1 + 2 + ... + 10)2 = 552 = 3025 Hence the difference between the sum
		 * of the squares of the first ten natural numbers and the square of the
		 * sum is 3025 − 385 = 2640.
		 * 
		 * Find the difference between the sum of the squares of the first one
		 * hundred natural numbers and the square of the sum.
		 */
		
		int uptill=100;
		
		// (a + b + c) (a + b + c) = a2 + b2+ c2 + 2ab + 2bc +2ca
		
		int solution = 0;
		
		for(int i = 1 ; i <= uptill; i++ ){
			for(int j = 1; j < i; j++){
				solution+=i*j;
			}
		}
		
		solution*=2;
		
		System.out.println(solution);
	}

}
