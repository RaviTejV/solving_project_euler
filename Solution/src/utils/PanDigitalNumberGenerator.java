package utils;

public abstract class PanDigitalNumberGenerator {

	Integer no_of_digits;

	Integer currentDigit;

	public Integer getNextDigit() {
		calculateNextDigit();
		return getCurrentDigit();
	}

	public Integer getNo_of_digits() {
		return no_of_digits;
	}

	abstract protected void calculateNextDigit();

	public Integer getCurrentDigit() {
		return currentDigit;
	}

	abstract public boolean hasNext();
}
