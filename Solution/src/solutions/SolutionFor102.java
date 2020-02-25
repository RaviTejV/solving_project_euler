package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import custom.Point;

public class SolutionFor102 implements Solution {

	@Override
	public void solve() throws Exception {

		int result = 0;

		try (BufferedReader br = new BufferedReader(
				new FileReader("/Users/ravitej/git/solving_project_euler/Solution/src/inputs/problem_102.txt"))) {

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

				if (check(a, b, c) && check(b, c, a) && check(c, a, b))
					result++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Result: " + result);

		// y - y1 * x2 -x1 - x-x1 * y2 - y1
	}

	private boolean check(Point p1, Point p2, Point x) {

		int checkSum1 = (x.y - p1.y) * (p2.x - p1.x) - (x.x - p1.x) * (p2.y - p1.y);
		int checkSum0 = (-1 * p1.y) * (p2.x - p1.x) - (-1 * p1.x) * (p2.y - p1.y);

		return (checkSum1 > 0) == (checkSum0 > 0);
	}

}
