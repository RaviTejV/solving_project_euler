package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import custom.RomanNumeralsInterpreter;

public class SolutionFor89 implements Solution {

	@Override
	public void solve() throws Exception {

		// Create roman numerals calss

		try (BufferedReader br = new BufferedReader(
				new FileReader("/Users/ravitej/git/solving_project_euler/Solution/src/inputs/problem_89.txt"))) {

			int answer = 0;

			while (br.ready()) {

				String romanNumeral = br.readLine();
				Integer decimal = RomanNumeralsInterpreter.parseRomanInteger(romanNumeral);
				String bestDecimalNumeral = RomanNumeralsInterpreter.generateRomanNumeral(decimal);

				answer += romanNumeral.length() - bestDecimalNumeral.length();

				System.out.println(romanNumeral + " -> " + decimal + " -> " + bestDecimalNumeral + " Diff: "
						+ (romanNumeral.length() - bestDecimalNumeral.length()));
			}

			System.out.println("Answer: " + answer);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
