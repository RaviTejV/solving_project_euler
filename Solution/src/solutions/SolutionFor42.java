package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SolutionFor42 implements Solution {

	@Override
	public void solve() {// find score of all names in input file.

		List<String> names = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(
				new FileReader("/Users/ravitej/git/solving_project_euler/Solution/src/inputs/problem_42.txt"))) {

			names = Arrays.asList(br.readLine().split(","));

			names = names.stream().map(s -> s.replace('"', ' ').trim()).collect(Collectors.toList());

			List<String> good_cases = new ArrayList<>();

			Set<Integer> triangleNos = new TreeSet<>();
			
			Integer runningSum = 0;
			for(int i = 1; i < 100 ; i ++){
				runningSum += i;
				triangleNos.add(runningSum);
			}

			for (int i = 0; i < names.size(); i++) {
				if (triangleNos.contains(score(names.get(i))))
					good_cases.add(names.get(i));
			}

			System.out.println("Answer: " + good_cases.size());

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private int score(String string) {
		char[] letters = string.toCharArray();

		int score = 0;

		for (char letter : letters) {
			score += letter - 'A' + 1;
		}

		return score;
	}

}
