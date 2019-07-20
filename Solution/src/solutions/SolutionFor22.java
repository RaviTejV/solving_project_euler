package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionFor22 implements Solution {

	@Override
	public void solve() {
		// find score of all names in input file.

		List<String> names = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(
				new FileReader("/Users/ravitej/git/solving_project_euler/Solution/src/inputs/problem_22.txt"))) {

			names = Arrays.asList(br.readLine().split(","));

			names = names.stream().map(s -> s.replace('"', ' ').trim()).collect(Collectors.toList());

			Collections.sort(names);

			long ans = 0;
			for (int i = 0; i < names.size(); i++) {
				ans += score(names.get(i)) * (i+1);
			}

			System.out.println("Answer: " + ans);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private int score(String string) {
		char[] letters = string.toCharArray();
		
		int score = 0;
		
		for(char letter: letters){
			score += letter - 'A' + 1;
		}
		
		return score;
	}

}
