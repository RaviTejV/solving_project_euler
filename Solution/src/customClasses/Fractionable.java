package customClasses;

public interface Fractionable<T> {

	public T plus(T f);
	
	public T minus(T f);
	
	public T multiply(T f);
	
	public double approxVal();
	
	public void divideInt(int x);
	
	public void mulitplyInt(int x);
	
	public void plusInt(int x);
	
	public void minusInt(int x);

	public Integer extractCommon();
	
//	public T divide(T f);
	
}
