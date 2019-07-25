package solutions;

import java.util.HashMap;
import java.util.Map;

public class SolutionFor34 implements Solution {

	@Override
	public void solve() {
		//sum of all nos for which the digits equals the sum factorial of digits
		
		//upper limit - 9! < 900000 -> 9*9! < 9000000
		
		Map<Integer, Integer> map_fact = new HashMap<>();
		
		map_fact.put(0, 1);
		for(int i = 1; i< 10; i ++){
			map_fact.put(i, map_fact.get(i-1)*i);
		}
		
		System.out.println(map_fact);
		
		
		Integer ans = 0;
		for(Integer i = 10; i < 1000000; i ++) {
			if(i.equals(sumOfFactDigits(i, map_fact))) ans+=i;
		}System.out.println(ans);
		
	}

	private Integer sumOfFactDigits(Integer i, Map<Integer, Integer> map_fact) {
		Integer return_val = 0;
		while(i > 0) {
			return_val += map_fact.get(i%10);
			i/=10;
		}
		
		return return_val;
	}

}
