package solutions;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.StringUtils;

public class SolutionFor62 implements Solution {

	@Override
	public void solve() throws Exception {

		// CAVEAT - just checking that the hash has atleast five cubes -> there
		// could be more

		Map<Integer, List<BigInteger>> countOfHashes = new HashMap<>();

		for (int i = 1;; i++) {
			BigInteger cube = BigInteger.valueOf(i).pow(3);

			int hash = StringUtils.bigDigitHash(cube);

			countOfHashes.put(hash, countOfHashes.getOrDefault(hash, new ArrayList<>()));
			countOfHashes.get(hash).add(cube);

			if (countOfHashes.get(hash).size() == 5) {
				System.out.println(countOfHashes.get(hash));
				System.out.println("Answer: " + countOfHashes.get(hash).get(0));
				break;
			}

		}
	}

}
