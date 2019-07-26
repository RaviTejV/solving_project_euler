package customClasses;

public class PythogoreanTriplet {

	private Integer a, b, c;

	public Integer getA() {
		return a;
	}

	public Integer getB() {
		return b;
	}

	public Integer getC() {
		return c;
	}

	public PythogoreanTriplet(Integer a, Integer b, Integer c) {

		if (a * a + b * b != c * c) {
			throw new IllegalArgumentException("the args are not pythogorean triples - in increasing order");
		}

		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof PythogoreanTriplet)) return false;
		
		PythogoreanTriplet o = (PythogoreanTriplet) obj;
		return o.getA() == a && o.getB() == b && o.getC() == c;
		
	}
	
	@Override
	public int hashCode() {
		return a+b+c;
	}
	
	@Override
	public String toString() {
		return a.toString() + " " + b + " " + c.toString();
	}

}
