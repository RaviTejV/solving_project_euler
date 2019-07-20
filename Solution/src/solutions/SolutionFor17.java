package solutions;

import java.util.HashMap;
import java.util.Map;

public class SolutionFor17 implements Solution {

	
	Map<Integer, Integer> baseMap = new HashMap<>();
	
	@Override
	public void solve() {

		baseMap.put(0, 0);
		baseMap.put(1, "one".length());
		baseMap.put(2, "two".length());
		baseMap.put(3, "three".length());
		baseMap.put(4, "four".length());
		baseMap.put(5, "five".length());
		baseMap.put(6, "six".length());
		baseMap.put(7, "seven".length());
		baseMap.put(8, "eight".length());
		baseMap.put(9, "nine".length());
		baseMap.put(10, "ten".length());
		baseMap.put(11, "eleven".length());
		baseMap.put(12, "twelve".length());
		baseMap.put(13, "thirteen".length());
		baseMap.put(14, "fourteen".length());
		baseMap.put(15, "fifteen".length());
		baseMap.put(16, "sixteen".length());
		baseMap.put(17, "seventeen".length());
		baseMap.put(18, "eighteen".length());
		baseMap.put(19, "nineteen".length());
		baseMap.put(20, "twenty".length());
		baseMap.put(30, "thirty".length());
		baseMap.put(40, "forty".length());
		baseMap.put(50, "fifty".length());
		baseMap.put(60, "sixty".length());
		baseMap.put(70, "seventy".length());
		baseMap.put(80, "eighty".length());
		baseMap.put(90, "ninety".length());
		baseMap.put(100, "hundred".length());
		baseMap.put(1000, "thousand".length());

		
		// one to one thousand
		
		int totalNumOfWords = 0;
		
		for (int i = 1; i <=1000; i++){
			totalNumOfWords += wordify(i);
		}
		
		System.out.println(totalNumOfWords + 6); // plus 6 is to account for the one in 'hundred' and 'thousand' - bit tricky
		
//		342 115
		
//		System.out.println("342: " + wordify(342) + "; 100: " + wordify(100));
		
	}

	private int wordify(int i) {
		if(baseMap.get(i) != null){
			return baseMap.get(i);// + (i>99?3:0);
		}
		
		if(i/100 == 0){
			return wordify(i%10) + wordify(i - i%10);
		}
		
		else if (i/1000 == 0) {
			return wordify(i/100) + wordify(100) + (i%100==0?0:"and".length()) + wordify(i%100) ;
		}
		
		else return wordify(1000) + wordify(i/1000) + wordify(i%1000);
	}

}
