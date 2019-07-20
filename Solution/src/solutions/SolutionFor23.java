package solutions;

import java.util.ArrayList;
import java.util.List;

import utils.MathFunctions;

public class SolutionFor23 implements Solution {

	@Override
	public void solve() {
		// 28123
		int ans = 0;

		List<Integer> abundantNumbers = new ArrayList<>();
		for (int i = 1; i < 28124; i++) {
			if (isAbundant(i)) {
				abundantNumbers.add(i);
			}
		}

		for (int i = 1; i < 28124; i++) {
			if (!isSumOfAnyTwoNumbersInArray(i, abundantNumbers)) {
				ans += i;
				System.out.print(i + ", ");
			}
		}

		System.out.println(abundantNumbers);

		System.out.println(ans);// 297604094
	}
// 39 -- 2 37 40
	private boolean isSumOfAnyTwoNumbersInArray(int x, List<Integer> array) {

		for (int i = 0, j = array.size() - 1; i <= j;) {
			if (array.get(i) + array.get(j) == x)
				return true;
			else if (array.get(i) + array.get(j) > x)
				j--;
			else
				i++;
		}

		return false;

	}

	private boolean isAbundant(int i) {

		return MathFunctions.getAllDivisors(i).stream().reduce(0, Integer::sum) > i;
	}

}
