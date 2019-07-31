package utils;

public class SievePrimesGenerator extends AbstractPrimeGenerator {

	long roof;
	
	public SievePrimesGenerator(long roof) {
		generatePrimesTill(roof);
	}

	@Override
	public void generatePrimesTill(Long roof) {
		this.roof=roof;
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

	public void addMorePrimes(long l) {
		for(long i = roof - roof%2 +1; i < l; i+=2){
			if(isPrimeLong(i)) {
				primes.add(i);
//				System.out.println("Added " + i);
			}
		}
	}
}
