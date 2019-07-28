package utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ZeroToNinePandigitGenerator extends PanDigitalNumberGenerator {

	Long workingDigit;

	String currentString;

	public ZeroToNinePandigitGenerator() {
		this.no_of_digits = 10;
		StringBuilder sb = new StringBuilder();
		sb.append(IntStream.range(0, 10).boxed().reduce("", (a, b) -> a + b.toString(), (a, b) -> a + b));
		currentString = sb.reverse().toString();
		workingDigit = Long.parseLong(currentString);

	}

	public Long getWorkingDigit() {
		return workingDigit;
	}

	public String getCurrentString() {
		return currentString;
	}

	public String getNextWorkingDigit() {
		if (hasNext()) {

			// from last find index of break
			List<Integer> digits = Arrays.asList(currentString.split("")).stream().mapToInt(Integer::parseInt).boxed()
					.collect(Collectors.toList());
			Integer indexOfBreak = -1;
			for (int i = digits.size() - 2; i >= 0; i--) {
				if (digits.get(i) > digits.get(i + 1)) {
					indexOfBreak = i;
					break;
				}
			}

			// find next smallest number from the value of index -> to the right
			// and swap
			Integer nextSmallestIndex = -1;
			Integer breakValue = digits.get(indexOfBreak);
			Integer maxValue = -1;
			for (int i = indexOfBreak + 1; i < digits.size(); i++) {
				if (digits.get(i) > maxValue && digits.get(i) < breakValue) {
					maxValue = digits.get(i);
					nextSmallestIndex = i;
				}
			}

			// System.out.println(indexOfBreak + " " + nextSmallestIndex);

			// swap the vals (break and next smallest index) reverse sort from
			// index
			Integer temp = digits.get(indexOfBreak);
			digits.set(indexOfBreak, digits.get(nextSmallestIndex));
			digits.set(nextSmallestIndex, temp);

			Collections.sort(digits.subList(indexOfBreak + 1, digits.size()));
			Collections.reverse(digits.subList(indexOfBreak + 1, digits.size()));

			currentString = digits.stream().reduce("", (a, b) -> a + b.toString(), (a, b) -> a + b);
			workingDigit = Long.parseLong(currentString);
		} else {
			workingDigit = 0L;
			currentString = "0";
		}

		return getCurrentString();

	}

	@Override
	public boolean hasNext() {
		if (workingDigit == 0 || workingDigit == 123456789L)
			return false;
		return true;
	}

	@Override
	protected void calculateNextDigit() {
	}

}
