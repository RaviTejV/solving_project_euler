package solutions;

public class SolutionFor71 implements Solution {

	@Override
	public void solve() throws Exception {
		

		double largestFraction = 0;
		Integer correspondingNumerator = 0;
		
		double threeBySeven = (double) 3 / 7;
		
		for(Integer i = 2; i < 1_000_001; i ++)
		{
			if(i % 7 == 0) continue;
			// find largest fraction less than 3/7
			Integer floor = (int) Math.floor(threeBySeven*i);
			double fraction = (double) floor / i;
//			System.out.println(floor);
			
			if(fraction > largestFraction) {
				largestFraction = fraction;
				correspondingNumerator = floor;
				System.out.println(floor +"/" + i);
			}
		}
		
		System.out.println("Answer:" + correspondingNumerator);
	}

}
