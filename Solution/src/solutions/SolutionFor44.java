package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolutionFor44 implements Solution {

	List<Long> pentagonalNumbers = new ArrayList<>();

	@Override
	public void solve() {
		// pentagonal numbers - randomly vary limit (manually) until i get a solution... have to do this programatically

		for (Long i = 1L; i <= 100000; i++) {
			pentagonalNumbers.add((i * (3 * i - 1)) / 2);
		}
		
		for(Long i = 0L; i < 10000; i++){
			for(Long j = i+1; j < 10000; j++){
				Long a = pentagonalNumbers.get(j.intValue());
				Long b = pentagonalNumbers.get(i.intValue());
				if(isPentagonal(a - b)&&isPentagonal(a+b)){
					System.out.println(a - b);					
				}
			}
		}
		

//		System.out.println(Collections.binarySearch(pentagonalNumbers, 210) >= 0);

//		System.out.println(pentagonalNumbers);
	}

	private boolean isPentagonal(Long i) {
		return Collections.binarySearch(pentagonalNumbers, i) >= 0;
	}
	
	
}
