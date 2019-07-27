package utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SimplePanDigitGenerator extends PanDigitalNumberGenerator {

	public SimplePanDigitGenerator(Integer n) {

		no_of_digits = n;
		StringBuilder sb = new StringBuilder();
		sb.append(IntStream.range(1, n + 1).boxed().reduce("", (a, b) -> a + b.toString(), (a, b) -> a + b));
		currentDigit = Integer.parseInt(sb.reverse().toString());
	}

	// thinking - what must be next of 12354 -> 12345;
	// 13425->13254->13245->12543; 54321->54312->54(2(31))
	@Override
	protected void calculateNextDigit() {
		if (hasNext()) {

			// from last find index of break
			List<Integer> digits = Arrays.asList(currentDigit.toString().split("")).stream().mapToInt(Integer::parseInt)
					.boxed().collect(Collectors.toList());
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

			currentDigit = Integer.parseInt(digits.stream().reduce("", (a, b) -> a + b.toString(), (a, b) -> a + b));
		} else
			currentDigit = 0;

	}

	@Override
	public boolean hasNext() {
		if (currentDigit == 0 || currentDigit == Integer.parseInt(
				(IntStream.range(1, no_of_digits + 1).boxed().reduce("", (a, b) -> a + b.toString(), (a, b) -> a + b))))
			return false;
		return true;
	}
}