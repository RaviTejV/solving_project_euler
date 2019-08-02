package solutions;

import java.math.BigInteger;

public class SolutionFor63 implements Solution {

	@Override
	public void solve() throws Exception {

		int count = 0;

		for (Integer i = 1;; i++) {

			System.out.println(i + " count: " + count);
			if (i > (new BigInteger("9").pow(i).toString().length()))
				break;

			for (Integer j = 1;; j++) {
				if (new BigInteger(j.toString()).pow(i).toString().length() == i)
					count++;

				if (new BigInteger(j.toString()).pow(i).toString().length() > i)
					break;
			}

		}

		System.out.println("Answer " + count);
	}

}
