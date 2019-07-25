package solutions;

import java.util.Arrays;

public class SolutionFor38 implements Solution {

	@Override
	public void solve() {

		// given the clue, it only possible that a 4 digits no starting with
		// nine along with its mulitple would be greater that the pandigital
		// create by 9(1,5)

		for (Integer i = 10000; i > 9122; i--) {
			Integer mul = i * 2;
			if (Arrays.asList((i.toString() + mul.toString()).split("")).stream().filter(s -> !s.equals("0")).distinct()
					.count() == 9) {
				System.out.println(i + "" + mul);
				break;
			}
		}
	}

}
