package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class SolutionFor54 implements Solution {

	@Override
	public void solve() throws Exception {
		try (BufferedReader br = new BufferedReader(
				new FileReader("/Users/ravitej/git/solving_project_euler/Solution/src/inputs/problem_54.txt"))) {

			List<String> cards = Arrays.asList(br.readLine().split(" "));

			List<String> playerA = cards.subList(0, 5);
			List<String> playerB = cards.subList(5, 10);

			System.out.println("Player A: " + playerA);
			System.out.println("Player B: " + playerB);

			System.out.println(compareHands(playerA, playerB));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean compareHands(List<String> playerA, List<String> playerB) {
		// TODO Auto-generated method stub
		return null;
	}

}
