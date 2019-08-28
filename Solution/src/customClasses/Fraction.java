package customClasses;

import utils.MathFunctions;

public class Fraction<T> {
	public Fractionable<T> num;
	public Fractionable<T> den;
	
	
	public Fraction(Fractionable<T> num, Fractionable<T> den) {
		this.num = num;
		this.den = den;
	}
	
	//reciprocate
	public Fraction<T> reciprocate(){
		
		Fractionable<T> newNum = this.den;
		this.den = this.num;
		this.num = newNum;
		simplify();
		return this;
	}
	
	
	//simplify/reduce
	public void simplify(){
		Integer numCommonFactor = num.extractCommon();
		Integer denCommonFactor = den.extractCommon();
		
		Integer gcd = (int) MathFunctions.gcd(numCommonFactor, denCommonFactor);
		
		num.divideInt(gcd);
		den.divideInt(gcd);
	}
	
	public double approxVal(){
		return num.approxVal() / den.approxVal();
	}
	
	//hash
	@Override
	public int hashCode() {
		return num.hashCode() + den.hashCode();
	}
	
	@Override
	public String toString() {
		return num.toString() + " / " + den.toString();
	}
	
}
