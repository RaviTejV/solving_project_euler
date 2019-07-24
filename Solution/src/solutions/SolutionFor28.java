package solutions;

public class SolutionFor28 implements Solution {

	@Override
	public void solve() {
		// sum of squares of odd integers + 3 times sum of evensquares+1
		// uptill 1001*1001
		
		//n(2n+1)(2n-1)/3 odd
		//2n(n+1)(2n+1)/3 even
		
		Long range = 1001L;
		
		Long ans = 0L;
		
		for(Long i = 1L; i <= range; i+=2){
			ans+=i*i;
		}
		
		for(Long i = 2L; i < range; i+=2){
			ans+=3*(i*i+1);
		}
		
		System.out.println(ans);
	}

}
