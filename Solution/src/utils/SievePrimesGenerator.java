package utils;

public class SievePrimesGenerator extends AbstractPrimeGenerator {

	public SievePrimesGenerator(long roof) {
		generatePrimesTill(roof);
	}

	@Override
	public void generatePrimesTill(Long roof) {
		boolean[] numbers = new boolean[roof.intValue()];

		for (int i = 2; i < roof; i++)
			numbers[i] = true;

		for (int i = 2; i * i <= roof; i++) {

			if (numbers[i] == true) {

				for (int j = 2; i * j < roof; j++)
					numbers[j * i] = false;
			}
		}

		for (int i = 2; i < roof; i++) {
			if (numbers[i] == true)
				primes.add((long) i);
		}
	}
}
