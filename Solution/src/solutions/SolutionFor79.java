package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SolutionFor79 implements Solution {

	@Override
	public void solve() throws Exception {
		try (BufferedReader br = new BufferedReader(
				new FileReader("/Users/ravitej/git/solving_project_euler/Solution/src/inputs/problem_79.txt"))) {

			Deque<Integer> entries = new ArrayDeque<>();

			String entry;
			while ((entry = br.readLine()) != null) {
				entries.add(Integer.parseInt(entry));
			}

			List<Integer> finalString = Arrays.asList(entries.removeFirst().toString().split("")).stream()
					.mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

			boolean edit = false;
			while (!entries.isEmpty()) {
				edit = false;

				List<Integer> intsToRemove = new ArrayList<>();
				for (Integer curr : entries) {
					if (followsOrder(finalString, curr)) {
						intsToRemove.add(curr);
					}
				}

				for (Integer curr : intsToRemove) {
					entries.removeIf(s -> s.equals(curr));
					edit = true;
				}

				// List<Integer> newFinalString = new LinkedList<>(finalString);

				// System.out.println(finalString + " " + entries);

				for (int i = 0; i < finalString.size() - 1; i++) {
					Integer candidate = findCandidate(entries, finalString.get(i), finalString.get(i + 1));
					if (candidate != -1) {
						entries.removeIf(s -> s.equals(candidate));
						finalString.add(i + 1, (candidate / 10) % 10);
						edit = true;
						System.out.println(finalString + " " + candidate + " " + entries);
						break;
					}
				}

				Integer firstCandidate = findCornerCandidate(entries, finalString.get(0));
				if (firstCandidate != -1) {
					entries.removeIf(s -> s.equals(firstCandidate));
					finalString.add(0, firstCandidate / 100);
					System.out.println(finalString + " " + firstCandidate + " " + entries);
					edit = true;
				}

				Integer lastCandidate = findCornerCandidate(entries, finalString.get(finalString.size() - 1));
				if (lastCandidate != -1) {
					entries.removeIf(s -> s.equals(lastCandidate));
					finalString.add(finalString.size(), lastCandidate % 10);
					System.out.println(finalString + " " + lastCandidate + " " + entries);
					edit = true;
				}

				if (edit == false)
					break;
			}

			System.out.println(finalString.stream().reduce(0, (a, b) -> a * 10 + b));
		}
	}

	private boolean followsOrder(List<Integer> finalString, Integer curr) {

		int firstIndex = finalString.indexOf(curr / 100);
		if (firstIndex == -1)
			return false;
		int secondIndex = finalString.subList(firstIndex, finalString.size()).indexOf((curr / 10) % 10);
		if (secondIndex == -1)
			return false;
		int thirdIndex = finalString.subList(secondIndex, finalString.size()).indexOf(curr % 10);
		if (thirdIndex == -1)
			return false;

		return true;
	}

	private Integer findCornerCandidate(Deque<Integer> entries, Integer i) {
		Optional<Integer> val = entries.stream().filter(s -> i == (s / 10) % 10).findFirst();

		if (val.isPresent())
			return val.get();

		return -1;
	}

	private Integer findCandidate(Deque<Integer> entries, Integer i, Integer j) {
		// find string that start with i and ends with j

		Optional<Integer> val = entries.stream().filter(s -> (j == s % 10) && i == (s / 100)).findFirst();

		if (val.isPresent())
			return val.get();

		return -1;
	}

}
