package custom;

import java.math.BigInteger;

public class Exponent implements Comparable<Exponent> {

	Integer base;
	Integer exp;
	boolean computed = false;

	BigInteger computedVal;

	public Exponent(int base, int exp) {
		this.base = base;
		this.exp = exp;
	}

	// private void computeValue() {
	// computedVal = new BigInteger(base.toString()).pow(exp);
	// computed = true;
	// }

	@Override
	public int compareTo(Exponent o) {
		 if (this.base == o.base && this.exp == o.exp)
		 return 0;
		 if (this.base >= o.base && this.exp >= o.exp)
		 return 1;
		 if (this.base <= o.base && this.exp <= o.exp)
		 return -1;

		return (int) Math.signum(this.exp * Math.log10(this.base) - o.exp * Math.log10(o.base));

		// if (this.computed == false)
		// this.computeValue();
		// if (o.computed == false)
		// o.computeValue();
		//
		// return this.computedVal.compareTo(o.computedVal);
	}

}
