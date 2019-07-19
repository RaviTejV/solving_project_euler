package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class SolutionFor13 implements Solution {

	@Override
	public void solve() {

		List<List<Integer>> inputs = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(
				new FileReader("/Users/ravitej/git/solving_project_euler/Solution/src/inputs/problem_13.txt"))) {

			while (br.ready()) {
				
				List<Integer> entry = Arrays.asList(br.readLine().split("")).stream().mapToInt(s -> Integer.parseInt(s)).boxed()
						.collect(Collectors.toList());
				
				Collections.reverse(entry);
				
				inputs.add(entry);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Deque<Integer> sumStack = new ArrayDeque<>();
		
		Integer carry = 0;
		for(int i = 0; i < inputs.get(0).size(); i++){
			final Integer index = i;
			Integer digitSum = inputs.stream().mapToInt(s -> s.get(index)).reduce(carry, (a,b)->a+b);
			
			sumStack.addLast(digitSum%10);
			carry = digitSum / 10;
		}
		
		while(carry>0){
			sumStack.addLast(carry % 10);
			carry = carry / 10;
		}
		
		for(int i =0 ; i < 10; i++){
			System.out.print(sumStack.removeLast());
		}
		
//		inputs.forEach(System.out::println);
		
//		System.out.println(inputs.size());

	}

}
