package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionFor81 implements Solution {

	@Override
	public void solve() throws Exception {

		List<List<Integer>> matrix = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(
				new FileReader("/Users/ravitej/git/solving_project_euler/Solution/src/inputs/problem_81.txt"))) {

			while (br.ready()) {

				List<Integer> entry = Arrays.asList(br.readLine().split(",")).stream()
						.mapToInt(s -> Integer.parseInt(s)).boxed().collect(Collectors.toList());
				matrix.add(entry);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 1; i < matrix.size(); i++) {
			matrix.get(0).set(i, matrix.get(0).get(i) + matrix.get(0).get(i - 1));
			matrix.get(i).set(0, matrix.get(i).get(0) + matrix.get(i - 1).get(0));
		}

		for (int i = 1; i < matrix.size(); i++) {
			for (int j = 1; j < matrix.size(); j++) {
				matrix.get(i).set(j,
						matrix.get(i).get(j) + Math.min(matrix.get(i - 1).get(j), matrix.get(i).get(j - 1)));
			}
		}

//		System.out.println(matrix.size());
		System.out.println("Answer: " + matrix.get(matrix.size() - 1).get(matrix.size() - 1));
	}

}
