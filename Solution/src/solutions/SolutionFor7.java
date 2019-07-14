package solutions;

import utils.AbstractPrimeGenerator;
import utils.SievePrimesGenerator;

public class SolutionFor7 implements Solution {

	@Override
	public void solve() {


		AbstractPrimeGenerator pg = new SievePrimesGenerator(1000000L);
		
		System.out.println(pg.getPrimes().get(10000));
	}

}
