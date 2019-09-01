package solutions;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SolutionFor65 implements Solution {

	@Override
	public void solve() throws Exception {
		Deque<Integer> stack = new ArrayDeque<Integer>();
		
		stack.push(2);
		
		for(int i = 2; i < 101; i++){
			if(i%3 == 0){
				stack.push(2*(i/3));
			}
			else
				stack.push(1);
		}
		
		BigInteger num = BigInteger.ONE;
		BigInteger den = new BigInteger(stack.pop().toString());
		
		while(!stack.isEmpty()){
			Integer val = stack.pop();
			num = den.multiply(new BigInteger(val.toString())).add(num);
			
			BigInteger tmp = num;
			num = den;
			den = tmp;
			
//			System.out.println(num + " " + den);
		}
		
		System.out.println(den);
		
		System.out.println("Answer: " + Arrays.asList(den.toString().split("")).stream().mapToInt(s -> Integer.parseInt(s)).boxed().reduce(Integer.parseInt("0"), Integer::sum));

	}

}
