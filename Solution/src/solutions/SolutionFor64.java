package solutions;

import java.util.HashSet;
import java.util.Set;

import customClasses.Fraction;
import customClasses.Fractionable;
import utils.MathFunctions;

public class SolutionFor64 implements Solution {

	public class Residue implements Fractionable<Residue> {
		Integer rational = 0;
		Integer irrationalRoot = 0;
		Integer scale = 1;

		Residue(Integer rational, Integer irrationalRoot, Integer scale) {
			this.rational = rational;
			this.irrationalRoot = irrationalRoot;
			this.scale = scale;
		}

		@Override
		public Residue plus(Residue f) {
			this.rational += f.rational;
			this.scale += f.scale;
			return this;
		}

		@Override
		public Residue minus(Residue f) {
			this.rational -= f.rational;
			this.scale -= f.scale;
			return this;
		}

		// assume you can multiply only those values with the same
		// irrationalRoot
		@Override
		public Residue multiply(Residue f) {
			if (this.irrationalRoot != f.irrationalRoot) {
				throw new IllegalArgumentException();
			}

			Integer newRational = this.scale * f.scale * irrationalRoot + this.rational * f.rational;
			Integer newScale = this.scale * f.rational + this.rational * f.scale;

			this.scale = newScale;
			this.rational = newRational;

			return this;
		}

		public Residue conjugate() {
			return new Residue(-1 * rational, irrationalRoot, scale);
		}

		@Override
		public Integer extractCommon() {
			return (int) MathFunctions.gcd(scale, rational);
		}

		@Override
		public void divideInt(int x) {
			scale /= x;
			rational /= x;
		}

		@Override
		public void mulitplyInt(int x) {
			rational *= x;
			scale *= x;
		}

		@Override
		public int hashCode() {
			return (scale.toString() + rational.toString() + irrationalRoot.toString()).hashCode();
		}

		@Override
		public String toString() {
			if (scale == 0)
				return rational.toString();
			return scale.toString() + "*R(" + irrationalRoot.toString() + ")" + ((rational >= 0) ? "+" : "")
					+ rational.toString();
		}

		@Override
		public void plusInt(int x) {
			this.rational += x;
		}

		@Override
		public void minusInt(int x) {
			this.rational -= x;
		}

		// closest int
		public double floorVal() {
			return Math.floor(Math.sqrt(irrationalRoot) * (double) scale + rational);
		}

		@Override
		public double approxVal() {
			return Math.sqrt(irrationalRoot) * scale + rational;
		}

	}

	@Override
	public void solve() throws Exception {
		Integer count = 0;

		for (int i = 2; i <= 10000; i++) {
			// reciprocal
			Integer x = i;

			Integer initialRational = (int) Math.floor(Math.sqrt(x));
			// generate sequence

			if(initialRational*initialRational == x) continue;
			Residue seqVal = new Residue(-1 * initialRational, x, 1);

			Fraction<Residue> fraction = new Fraction<>(seqVal, new Residue(1, x, 0));

			// fraction.reciprocate();

			// Integer result = (int) Math.floor(fraction.approxVal());

			// fraction.num.minusInt(result);

			Integer result = initialRational;

			Set<String> hashes = new HashSet<>();

			while (hashes.add(fraction.toString())) {
				fraction.reciprocate();
//				System.out.println(result + ",  " + fraction);

				Residue den = (Residue) fraction.den;
				Residue conjugate = den.conjugate();

				fraction.num = fraction.num.multiply(conjugate);
				fraction.den = fraction.den.multiply(conjugate);

				// System.out.println(fraction);

				fraction.simplify();

				result = (int) Math.floor(fraction.approxVal());

				fraction.num.minusInt(result * den.rational);

				fraction.simplify();
			}

//			System.out.println(!(hashes.size() % 2 == 0));
			if(!(hashes.size() % 2 == 0)){
				count++;
			}

		}
		
		System.out.println(count);
	}
}
