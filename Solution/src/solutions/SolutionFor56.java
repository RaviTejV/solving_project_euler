package solutions;

import java.math.BigInteger;
import java.util.Arrays;

public class SolutionFor56 implements Solution {

	@Override
	public void solve() throws Exception {

		Integer maxVal = -1;
		
		for(Integer i = 2; i < 100; i++){
			for(Integer j = 2; j < 100; j++){
				BigInteger a = new BigInteger(i.toString());
				
				Integer sumOfDigits = Arrays.asList(a.pow(j).toString().split("")).stream().mapToInt(s -> Integer.parseInt(s))
				.boxed().reduce(0, Integer::sum);
				
				if(sumOfDigits > maxVal){
					maxVal = sumOfDigits;
				}
			}
		}
		
		System.out.println(maxVal);
	}

}
