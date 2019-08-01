package cards;

import java.util.HashSet;
import java.util.LinkedHashMap;

public class CardStack {

	public enum Suit {

		SPADE("S"), HEART("H"), CLUB("C"), DIAMOND("D");

		private String notation;

		Suit(String suit) {
			this.notation = suit;
		}

		public String getCardSuit() {
			return this.notation;
		}
	}

	public enum CardValue {
		TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"), EIGHT("8"), NINE("9"), TEN("T"), JACK(
				"J"), QUEEN("Q"), KING("K"), ACE("A");

		private String cardValue;

		private CardValue(String value) {
			this.cardValue = value;
		}

		public String getCardValue() {
			return cardValue;
		}
	}

	public class Card {
		private Suit suit;
		private CardValue cardValue;

		public Card(CardValue cardValue, Suit suit) {
			this.cardValue = cardValue;
			this.suit = suit;
		}

		public Suit getSuit() {
			return suit;
		}

		public void setSuit(Suit suit) {
			this.suit = suit;
		}

		public CardValue getCardValue() {
			return cardValue;
		}

		public int getValue() {

			String temp = getCardValue().getCardValue();

			if ("T".equals(temp))
				temp = "10";
			else if ("J".equals(temp))
				temp = "11";
			else if ("Q".equals(temp))
				temp = "12";
			else if ("K".equals(temp))
				temp = "13";
			else if ("A".equals(temp))
				temp = "14";

			return Integer.parseInt(temp);
		}

		public void setCardValue(CardValue cardValue) {
			this.cardValue = cardValue;
		}

		@Override
		public int hashCode() {
			return suit.hashCode();
		}

		public Card(String cardString) {
			this(cardString.split("")[0], cardString.split("")[1]);
		}

		public Card(String val, String suit) {

		}

		public String getCardString() {
			return cardValue.getCardValue() + suit.getCardSuit();
		}

		@Override
		public String toString() {
			return getCardString();
		}
	}

	private HashSet<String> deck;
	private LinkedHashMap<String, Card> cards = new LinkedHashMap<>();

	public CardStack() {

		this.deck = new HashSet<>();

		for (CardValue value : CardValue.values()) {
			for (Suit suit : Suit.values()) {
				Card card = new Card(value, suit);
				deck.add(card.getCardString());
				cards.put(card.getCardString(), card);
			}
		}
	}

	public Card drawCard(String cardString) {
		deck.remove(cardString);
		return cards.get(cardString);
	}

	public boolean returnCard(String cardString) {
		return deck.add(cardString);
	}

}
