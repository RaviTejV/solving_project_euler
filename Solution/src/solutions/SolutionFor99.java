package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import custom.Exponent;

public class SolutionFor99 implements Solution {

	@Override
	public void solve() throws Exception {
		try (BufferedReader br = new BufferedReader(
				new FileReader("/Users/ravitej/git/solving_project_euler/Solution/src/inputs/problem_99.txt"))) {

			Integer lineNum = 0;

			Exponent max = new Exponent(0, 0);
			Integer maxLine = 0;

			while (br.ready()) {

				lineNum++;
				// System.out.println("Processing LineNumber: " + lineNum);
				String[] vals = br.readLine().split(",");
				// BigInteger base = new BigInteger(vals[0]);
				// Integer exp = Integer.parseInt(vals[1]);

				Exponent exponent = new Exponent(Integer.parseInt(vals[0]), Integer.parseInt(vals[1]));

				// BigInteger result = base.pow(exp);

				if (exponent.compareTo(max) > 0) {
					max = exponent;
					maxLine = lineNum;
					System.out.println("Hit a max at line - " + lineNum);
				}

			}

			System.out.println("LineNumber: " + maxLine);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
