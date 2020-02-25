package custom;

import java.util.ArrayDeque;
import java.util.Deque;

import com.google.common.base.Supplier;

import utils.MathFunctions;

public class IrrationalResidue implements Fractionable<IrrationalResidue>, Supplier<Integer> {

	Integer rational = 0;
	Integer irrationalRoot = 0;
	Integer scale = 1;

	Deque<Integer> sequence = new ArrayDeque<>();
	Fraction<IrrationalResidue> stateFraction;

	public IrrationalResidue(Integer irrationalRoot) {
		this(0, irrationalRoot, 1);
	}

	public IrrationalResidue(Integer rational, Integer irrationalRoot, Integer scale) {
		this.rational = rational;
		this.irrationalRoot = irrationalRoot;
		this.scale = scale;
	}

	@Override
	public IrrationalResidue plus(IrrationalResidue f) {
		this.rational += f.rational;
		this.scale += f.scale;
		return this;
	}

	@Override
	public IrrationalResidue minus(IrrationalResidue f) {
		this.rational -= f.rational;
		this.scale -= f.scale;
		return this;
	}

	// assume you can multiply only those values with the same
	// irrationalRoot
	@Override
	public IrrationalResidue multiply(IrrationalResidue f) {
		if (this.irrationalRoot != f.irrationalRoot) {
			throw new IllegalArgumentException();
		}

		Integer newRational = this.scale * f.scale * irrationalRoot + this.rational * f.rational;
		Integer newScale = this.scale * f.rational + this.rational * f.scale;

		this.scale = newScale;
		this.rational = newRational;

		return this;
	}

	public IrrationalResidue conjugate() {
		return new IrrationalResidue(-1 * rational, irrationalRoot, scale);
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

	@Override
	public Integer get() {
		if (sequence.isEmpty()) {

			Integer initialRational = (int) Math.floor(Math.sqrt(irrationalRoot));

			// generate sequence
			IrrationalResidue seqVal = new IrrationalResidue(-1 * initialRational, irrationalRoot, 1);

			stateFraction = new Fraction<>(seqVal, new IrrationalResidue(1, irrationalRoot, 0));

			Integer result = initialRational;

			sequence.add(result);
			return result;

		}

		else {
			Integer result = sequence.getLast();

			stateFraction.reciprocate();
			// System.out.println(result + ", " + fraction);

			IrrationalResidue den = (IrrationalResidue) stateFraction.den;
			IrrationalResidue conjugate = den.conjugate();

			stateFraction.num = stateFraction.num.multiply(conjugate);
			stateFraction.den = stateFraction.den.multiply(conjugate);

			// System.out.println(fraction);

			stateFraction.simplify();

			result = (int) Math.floor(stateFraction.approxVal());

			stateFraction.num.minusInt(result * den.rational);

			stateFraction.simplify();

			sequence.add(result);
			return result;

		}
	}

}
