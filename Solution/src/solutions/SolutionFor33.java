package solutions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SolutionFor33 implements Solution {

	@Override
	public void solve() {
		for (Integer i = 11; i < 100; i++) {
			for (Integer j = i + 1; j < 100; j++) {
				if (i % 10 == 0 && j % 10 == 0)
					continue;
				if (isRedSameAsDumbRed(i, j))
					System.out.println(i + "," + j);
				;
			}
		}
		
		System.out.println("WRONG ANSWER");
	}

	private boolean isRedSameAsDumbRed(Integer i, Integer j) {
		List<Integer> i_digits = new ArrayList<>(Arrays.asList(i / 10, i % 10));
		List<Integer> j_digits = new ArrayList<>(Arrays.asList(j / 10, j % 10));

		Set<Integer> intersection = new TreeSet<>();
		i_digits.forEach(s -> {
			if (j_digits.contains(s))
				intersection.add(s);
		});

		if (intersection.size() != 1)
			return false;

		i_digits.removeIf(a -> intersection.contains(a));
		j_digits.removeIf(a -> intersection.contains(a));

		if (i_digits.size() == 0 || j_digits.size() == 0)
			return false;

		Integer x = i_digits.get(0);
		Integer y = j_digits.get(0);

		if (x == 0 || y == 0)
			return false;

		if (j % y == 0 && i % x == 0 && j / y == i / x)
			return true;// x/y i/j = 4*5*5

		return false;
	}

}
