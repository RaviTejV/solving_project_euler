package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionFor59 implements Solution {

	@Override
	public void solve() throws Exception {
		try (BufferedReader br = new BufferedReader(
				new FileReader("/Users/ravitej/git/solving_project_euler/Solution/src/inputs/problem_59.txt"))) {

			List<Integer> text = Arrays.asList(br.readLine().split(",")).stream().mapToInt(Integer::parseInt).boxed()
					.collect(Collectors.toList());

			List<Integer> vowels = Arrays.asList((int) 'A', (int) 'E', (int) 'I', (int) 'O', (int) 'U', (int) ' ',
					(int) 'a', (int) 'e', (int) 'i', (int) 'o', (int) 'u');

			// System.out.println(vowels);
			int max_i = 0, max_j = 0, max_k = 0;

			int max = -1;

			for (int i = 'a'; i <= 'z'; i++) {
				// System.out.println(i);
				for (int j = 'a'; j <= 'z'; j++) {
					for (int k = 'a'; k <= 'z'; k++) {
						// System.out.println(k);
						if (score(text, vowels, i, j, k) > max) {
							max_i = i;
							max_j = j;
							max_k = k;

							max = score(text, vowels, i, j, k);

							// System.out.println("Max score found " + max);
						}
					}
				}
			}

			System.out.println(decryptText(text, max_i, max_j, max_k));

			int ans = 0;

			for (int x = 0; x < text.size(); x += 3) {
				ans += (text.get(x) ^ max_i);
				ans += (text.get(x + 1) ^ max_j);
				ans += (text.get(x + 2) ^ max_k);

			}
			
			System.out.println(ans);
		}
	}

	private String decryptText(List<Integer> text, int i, int j, int k) {
		StringBuilder sb = new StringBuilder();
		for (int x = 0; x < text.size(); x += 3) {
			sb.append((char) (text.get(x) ^ i));
			sb.append((char) (text.get(x + 1) ^ j));
			sb.append((char) (text.get(x + 2) ^ k));

		}
		return sb.toString();
	}

	private int score(List<Integer> text, List<Integer> vowels, int i, int j, int k) {
		int score = 0;

		// System.out.println(letters);

		for (int x = 0; x < text.size(); x += 3) {

			// System.out.println((char) (letters[x]^i));
			if (vowels.contains(text.get(x) ^ i))
				score++;
			if (vowels.contains(text.get(x + 1) ^ j))
				score++;
			if (vowels.contains(text.get(x + 2) ^ k))
				score++;

			// if ((letters[x] ^ i) >= 'A' && (letters[x] ^ i) <= 'Z')
			// score++;
			// if ((letters[x + 1] ^ j) >= 'A' && (letters[x+1] ^ j) <= 'Z')
			// score++;
			// if ((letters[x + 2] ^ k) >= 'A' && (letters[x+2] ^ k) <= 'Z')
			// score++;
		}

		return score;
	}

}
