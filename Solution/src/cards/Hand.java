package cards;

public class Hand implements Comparable<Hand> {

	private HandType type;
	private int score;

	Hand(HandType type, int score) {
		this.score = score;
		this.type = type;
	}

	@Override
	public int compareTo(Hand o) {
		int diff = this.type.ordinal - o.type.ordinal;
		return diff == 0 ? this.score - o.score : diff;
	}
	
	@Override
	public String toString() {
		return type.toString() + " " + score;
	}
}
