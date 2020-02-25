package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import custom.Point;

public class SolutionFor102 implements Solution {

	@Override
	public void solve() throws Exception {

		int result = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(
				"/Users/ravitej/git/solving_project_euler/Solution/src/inputs/problem_102.txt_sample"))) {

			while (br.ready()) {

				List<Integer> entry = Arrays.asList(br.readLine().split(",")).stream().mapToInt(Integer::parseInt)
						.boxed().collect(Collectors.toList());

				if (entry.get(0) == 0 && entry.get(1) == 0 || entry.get(2) == 0 && entry.get(3) == 0
						|| entry.get(4) == 0 && entry.get(5) == 0) {
					continue;
				}

				Point a = new Point(entry.get(0), entry.get(1));
				Point b = new Point(entry.get(2), entry.get(3));
				Point c = new Point(entry.get(4), entry.get(5));

				List<Double> slopes = new ArrayList<>();
				slopes.add(a.getSlope());
				slopes.add(b.getSlope());
				slopes.add(c.getSlope());

				Collections.sort(slopes);

				List<Double> slopeDiffs = new ArrayList<>();

				slopeDiffs.add(diff(slopes.get(0), slopes.get(1)));
				slopeDiffs.add(diff(slopes.get(1), slopes.get(2)));
				slopeDiffs.add(diff(slopes.get(2), slopes.get(0)));

				System.out.println(slopes + " " + Math.abs(slopes.get(2) - slopes.get(0)));

				if (Math.abs(slopes.get(2) - slopes.get(0)) > Math.PI)
					result++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Result: " + result);
	}

	private Double diff(Double double1, Double double2) {
		return 0.0;
	}

}
