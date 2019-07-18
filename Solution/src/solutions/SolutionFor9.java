package solutions;

public class SolutionFor9 implements Solution {

	@Override
	public void solve() {
		/*
		 * A Pythagorean triplet is a set of three natural numbers, a < b < c,
		 * for which,
		 * 
		 * a2 + b2 = c2 For example, 32 + 42 = 9 + 16 = 25 = 52.
		 * 
		 * There exists exactly one Pythagorean triplet for which a + b + c =
		 * 1000. Find the product abc.
		 */
		
		for(int i=1; i<=334; i++){
			for(int j=i+1; j<=666; j++){
				int k = 1000 - i - j;
//				System.out.println(i + " " + j + " " + k);

				if(i*i + j*j == k*k){
					System.out.println(i + " " + j + " " + k + " product: " + i*j*k);
					break;
				}
			}
		}

	}

}
