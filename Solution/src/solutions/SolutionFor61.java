package solutions;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

public class SolutionFor61 implements Solution {

	Multimap<Integer, Integer> all_values = HashMultimap.create();

	// .add(s -> s+1);

	// functions.add(s -> (s * (s + 1)) / 2);

	@Override
	public void solve() throws Exception {
		/*
		 * Triangle P3,n=n(n+1)/2 1, 3, 6, 10, 15, ... Square P4,n=n2 1, 4, 9,
		 * 16, 25, ... Pentagonal P5,n=n(3n−1)/2 1, 5, 12, 22, 35, ... Hexagonal
		 * P6,n=n(2n−1) 1, 6, 15, 28, 45, ... Heptagonal P7,n=n(5n−3)/2 1, 7,
		 * 18, 34, 55, ... Octagonal P8,n=n(3n−2) 1, 8, 21, 40, 65, ...
		 */

		List<Function<Integer, Integer>> formulas = Arrays.asList(s -> (s * (s + 1)) / 2, s -> s * s,
				s -> (s * (3 * s - 1)) / 2, s -> s * (2 * s - 1), s -> (s * (5 * s - 3)) / 2, s -> (s * (3 * s - 2)));

		for (Integer i = 0; i < formulas.size(); i++) {
			Integer index = 1;
			while (formulas.get(i).apply(++index) < 1000)
				;

			while (formulas.get(i).apply(index) < 10000) {
				all_values.put(formulas.get(i).apply(index), i);
				index++;
			}
		}

		System.out.println(all_values);

		for (Integer a = 10; a < 100; a++) {
			for (Integer b = 10; b < 100; b++) {
				if (isValidPair(a, b)) {
				} else
					continue;

				for (Integer c = 10; c < 100; c++) {
					if (isValidPair(b, c)) {
					} else
						continue;

					for (Integer d = 10; d < 100; d++) {
						if (isValidPair(c, d)) {
						} else
							continue;

						for (Integer e = 10; e < 100; e++) {
							if (isValidPair(d, e)) {
							} else
								continue;

							for (Integer f = 10; f < 100; f++) {
								if (isValidPair(e, f)) {
								} else
									continue;

								if (isValidPair(f, a)) {
								} else
									continue;

								if (!isValidPair(a, b, c, d, e, f)) {
									continue;
								} else
									return;

							}
						}
					}
				}
			}
		}
	}

	private boolean isValidPair(Integer a, Integer b, Integer c, Integer d, Integer e, Integer f) {

		HashSet<Collection<Integer>> set = new HashSet<>();

		set.add(presentIn(a, b));
		set.add(presentIn(b, c));
		set.add(presentIn(c, d));
		set.add(presentIn(d, e));
		set.add(presentIn(e, f));
		set.add(presentIn(f, a));

		Set<Integer> listNum = new HashSet<>();
		listNum.add(a * 100 + b);
		listNum.add(b * 100 + c);
		listNum.add(c * 100 + d);
		listNum.add(d * 100 + e);
		listNum.add(e * 100 + f);
		listNum.add(f * 100 + a);

		if (listNum.size() != 6 || set.size() != 6)
			return false;

		System.out.println(a + "" + b + presentIn(a, b) + " " + b + "" + c + presentIn(b, c) + " " + c + "" + d
				+ presentIn(c, d) + " " + d + "" + e + presentIn(d, e) + " " + e + "" + f + presentIn(e, f) + " " + f
				+ "" + a + presentIn(f, a));
		System.out.println(a * 100 + b + b * 100 + c + c * 100 + d + d * 100 + e + e * 100 + f + f * 100 + a);

		return true;

	}

	private Collection<Integer> presentIn(Integer a, Integer b) {
		return all_values.get(Integer.parseInt(a.toString() + b.toString()));
	}

	private boolean isValidPair(Integer a, Integer b) {
		return all_values.containsKey(Integer.parseInt(a.toString() + b.toString()));
	}

}
