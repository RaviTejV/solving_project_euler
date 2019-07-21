package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import utils.MathFunctions;

public class SolutionFor24 implements Solution {

	@Override
	public void solve() {

		// Problem stmt: one millionth permutation of digits 0-9

		List<String> digits = Arrays.asList("0123456789".split("")).stream().collect(Collectors.toList());

		List<Integer> finalOrder = new ArrayList<Integer>();

//		int value = 1000000;

		int value = 999999; //2783915460
		
		int init_size = digits.size();

		for (int i = 0; i < 10; i++) {
			int digits_left = init_size - 1 - i;

			// calculate factorial
			int possibilities = MathFunctions.simpleFactorial(digits_left);

			int x = getHighestMultiplicand(value, possibilities);
			finalOrder.add(x);
			
			value -= x*possibilities;
		}
		
		System.out.println(finalOrder);
		
		for(Integer i: finalOrder) {
			int index = i;
			System.out.print(digits.get(index));
			digits.remove(index);
		}
	}

	private int getHighestMultiplicand(int value, int factor) {
		for (int i = 0;; i++) {
			if (factor * i > value) {
				return i-1;
			}
		}

	}

}
