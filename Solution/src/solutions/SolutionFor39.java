package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import customClasses.PythogoreanTriplet;

public class SolutionFor39 implements Solution {

	@Override
	public void solve() {
		// what to do?

		// find all triplets under 1000; and

		List<PythogoreanTriplet> triplets = new ArrayList<>();

		for (Integer a = 1; a < 1000; a++) {
			Integer a_square = a * a;
			for (Integer b = a + 1; b < 1000; b++) {
				Integer expected_c_sqaure = a_square + b * b;
				for (Integer c = b + 1; c < 1000; c++) {
					if (expected_c_sqaure == c * c) {
						triplets.add(new PythogoreanTriplet(a, b, c));
						break;
					}
				}
			}
		}

		Map<Integer, Set<PythogoreanTriplet>> groupedVals = triplets.stream().filter(s -> s.hashCode() < 1001)
				.collect(Collectors.groupingBy(s -> s.hashCode(), Collectors.toSet()));

		Integer max_size = -1;
		Integer max_val = 0;
		for (Entry<Integer, Set<PythogoreanTriplet>> entry : groupedVals.entrySet()) {
			if (entry.getValue().size() > max_size) {
				max_val = entry.getKey();
				max_size = entry.getValue().size();
				System.out.println(entry);
			}
		}

		System.out.println(max_val);

	}

}
