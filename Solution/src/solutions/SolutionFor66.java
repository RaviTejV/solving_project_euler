package solutions;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.google.common.base.Supplier;

import custom.IrrationalResidue;

public class SolutionFor66 implements Solution {

	@Override
	public void solve() throws Exception {

		Integer answer = 0;
		BigInteger maxVal = BigInteger.ZERO;

		for (Integer n = 2; n < 1000; n++) {
			if (((int) Math.sqrt(n) * Math.sqrt(n)) == n)
				continue;

			BigInteger bigIntN = new BigInteger(n.toString());
			Supplier<Integer> irrationalSeqSupplier = new IrrationalResidue(n);

			List<Integer> seq = new ArrayList<>();
			seq.add(irrationalSeqSupplier.get());

			while (true) {

				seq.add(irrationalSeqSupplier.get());

				Deque<Integer> stack = new ArrayDeque<Integer>();
				for (Integer x : seq)
					stack.push(x);

				BigInteger den = BigInteger.ONE;
				BigInteger num = new BigInteger(stack.pop().toString());

				while (!stack.isEmpty()) {
					BigInteger tmp = num;
					num = den;
					den = tmp;
					Integer val = stack.pop();
					num = den.multiply(new BigInteger(val.toString())).add(num);


				}

				// check whether eqn staisfies
				if (BigInteger.ONE.compareTo(num.multiply(num).subtract(den.multiply(den).multiply(bigIntN))) == 0) {
//					System.out.println(n + " " + num + " " + den);
					if(maxVal.compareTo(num) < 0){
						maxVal=num;
						answer = n;
					}
					break;
				}

			}

		}

		System.out.println("Answer: " + maxVal + " " + answer);
	}

}
