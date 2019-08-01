package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import cards.PokerGame;

public class SolutionFor54 implements Solution {

	@Override
	public void solve() throws Exception {
		try (BufferedReader br = new BufferedReader(
//				new FileReader("/Users/ravitej/git/solving_project_euler/Solution/src/inputs/problem_54.txt_sample"))) {

			new FileReader("/Users/ravitej/git/solving_project_euler/Solution/src/inputs/problem_54.txt"))) {

			//sample 4D 6S 9H QH QC 3D 6D 7H QD QS
			int count = 0;
			int junk = 0;
			String input;
			while ((input = br.readLine()) != null) {

				List<String> cards = Arrays.asList(input.split(" "));

				PokerGame game = new PokerGame(2, cards);

				if (game.winner() == 0)
					count++;
				
				if(game.winner() == 1)
					junk++;

			}

			System.out.println("Player 1 wins " + count + " games");
			System.out.println("Player 2 wins " + junk + " games");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
