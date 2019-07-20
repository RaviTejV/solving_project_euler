package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionFor18 implements Solution {

	@Override
	public void solve() {
		List<List<Integer>> triangle = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(
				new FileReader("/Users/ravitej/git/solving_project_euler/Solution/src/inputs/problem_18.txt"))) {
			
			while (br.ready()) {
				
				List<Integer> entry = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(s -> Integer.parseInt(s))
						.boxed().collect(Collectors.toList());		
				triangle.add(entry);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Collections.reverse(triangle);
		triangle.forEach(System.out::println);
		
		for(int i = 1; i < triangle.size(); i++){
//			System.out.println(triangle.get(i));
			
			List<Integer> currRow = triangle.get(i);
			List<Integer> prevRow = triangle.get(i-1);
			
			for(int j = 0; j < currRow.size(); j++ ){
				currRow.set(j, currRow.get(j) + Math.max(prevRow.get(j), prevRow.get(j+1)));
			}
		}
		
		Collections.reverse(triangle);
		
		triangle.forEach(System.out::println);
		
		System.out.println("Answer is: " + triangle.get(0).get(0));
	}
}
