package solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class SolutionFor14 implements Solution {

	Function<Long, Long> odd = s -> 3*s + 1;
	Function<Long, Long> even = s -> s/2;
	
	Map<Long, Long> memoizedChainLength = new HashMap<>();
	
	@Override
	public void solve() {
		
//		System.out.println(calcChainLength(13L));
		
		memoizedChainLength.put(1L, 1L);
		
		Long maxChain = -1L;
		Long maxChainStarter = 0L;
		
		for(Long i = 2L; i < 1000001L; i++){
			Long chainLength = calcChainLength(i);
//			System.out.println(i + " " + chainLength);
			if (chainLength > maxChain) {
				maxChain = chainLength;
				maxChainStarter = i;
			}
		}
		
		System.out.println("Max length: " + maxChain + " for " + maxChainStarter);
	}

	private Long calcChainLength(Long x) {
		
		if(memoizedChainLength.get(x) != null) {
			return memoizedChainLength.get(x);
		}
		
		if(x % 2 == 0) {
			memoizedChainLength.put(x, calcChainLength(even.apply(x)) + 1);
		}
		else
			memoizedChainLength.put(x, calcChainLength(odd.apply(x)) + 1);
		
		return memoizedChainLength.get(x);
	}

}
