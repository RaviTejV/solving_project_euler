package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SolutionFor31 implements Solution {

	@Override
	public void solve() {
		/*
		 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p). It is possible to
		 * make £2 in the following way:
		 * 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p How many different ways can
		 * £2 be made using any number of coins?
		 */
		
		List<Integer> coins = new ArrayList<>(Arrays.asList(1,2,5,10,20,50,100,200));
		Collections.sort(coins);
		Collections.reverse(coins);
		
//		System.out.println(coins);
		
		Integer intended_sum = 200;
		
		System.out.println(findAllPossibilities(intended_sum, coins));
	}

	private Integer findAllPossibilities(Integer intended_sum, List<Integer> coins) {
		
//		System.out.println(coins);
		
		if(intended_sum == 0) return 1;
		
		if(coins.size()==1) {if(intended_sum % coins.get(0) == 0) return 1; else return 0;}
		
		Integer returnValue = 0;
		for(int i = 0; coins.get(0)*i <= intended_sum; i++){
			returnValue += findAllPossibilities(intended_sum - i*coins.get(0), coins.subList(1, coins.size()));
		}
		
		return returnValue;
	}

}
