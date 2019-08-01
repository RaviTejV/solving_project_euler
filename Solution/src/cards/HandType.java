package cards;

public final class HandType {
	int ordinal;
	String name;

	HandType(int ordinal, String name) {
		this.ordinal = ordinal;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name + " " + ordinal;
	}
}