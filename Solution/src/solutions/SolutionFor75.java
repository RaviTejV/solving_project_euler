package solutions;

import java.util.HashMap;

import utils.MathFunctions;

public class SolutionFor75 implements Solution {

	@Override
	public void solve() throws Exception {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (Long i = 1L; i * i <= 1500000L; i++) {

			for (Long j = i + 1; i * i + j * j <= 1500000L; j++) {

				if (MathFunctions.gcd(i, j) != 1L)
					continue;

				if (i % 2 == 1L && j % 2 == 1L)
					continue;

				Long a = j * j + i * i;
				Long b = 2 * i * j;
				Long c = j * j - i * i;

				if (a + b + c > 1500000L)
					break;

				System.out.println(a + " " + b + " " + c);

				for (int x = 1; x * (a + b + c) < 1500000L; x++) {
					map.put((int) (a + b + c) * x, map.getOrDefault((int) (a + b + c) * x, 0) + 1);
				}
			}
		}

		System.out.println(map.size());
		System.out.println(map.get(120));
		System.out.println("Answer: " + map.entrySet().stream().filter(s -> s.getValue() == 1).count());
	}

}
