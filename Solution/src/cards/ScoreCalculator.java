package cards;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import cards.CardStack.Card;
import cards.PokerGame.Deal;

public class ScoreCalculator {

	final static int fullSet = 5;

	final static HandType ROYAL_FLUSH = new HandType(10, "ROYAL_FLUSH");
	final static HandType STRAIGHT_FLUSH = new HandType(9, "STRAIGHT_FLUSH");
	final static HandType FOUR_OF_A_KIND = new HandType(8, "FOUR_OF_A_KIND");
	final static HandType FULL_HOUSE = new HandType(7, "FULL_HOUSE");
	final static HandType FLUSH = new HandType(6, "FLUSH");
	final static HandType STRAIGHT = new HandType(5, "STRAIGHT");
	final static HandType THREE_OF_A_KIND = new HandType(4, "THREE_OF_A_KIND");
	final static HandType TWO_PAIRS = new HandType(3, "TWO_PAIRS");
	final static HandType ONE_PAIR = new HandType(2, "ONE_PAIR");
	final static HandType HIGH_CARD = new HandType(1, "HIGH_CARD");

	public static Hand getHandForDeal(Deal x) {

		List<Card> cards = x.getCards();

		// royal_flush
		if (isFullSet(cards) && isSameSuit(cards) && isConsecutive(cards) && highestCard(cards) == 14)
			return new Hand(ROYAL_FLUSH, 0);

		// straight flush
		if (isFullSet(cards) && isSameSuit(cards) && isConsecutive(cards))
			return new Hand(STRAIGHT_FLUSH, highestCard(cards));

		// four of a kind
		if (isFullSet(cards) && cardsWithSameValue(cards) == 4)
			return new Hand(FOUR_OF_A_KIND, valueOfMostRepeatedCard(cards));

		// full house
		if (isFullSet(cards) && cardsWithSameValue(cards) == 3 && hasPerfectPair(cards))
			return new Hand(FULL_HOUSE, valueOfMostRepeatedCard(cards));

		// flush
		if (isFullSet(cards) && isSameSuit(cards))
			return new Hand(FLUSH, highestCard(cards));

		// straight
		if (isFullSet(cards) && isConsecutive(cards))
			return new Hand(STRAIGHT, highestCard(cards));

		// three of a kind
		if (isFullSet(cards) && hasPerfectTriple(cards))
			return new Hand(THREE_OF_A_KIND, valueOfMostRepeatedCard(cards));

		// two pair
		if (isFullSet(cards) && hasTwoPairs(cards))
			return new Hand(TWO_PAIRS, valueOfMostRepeatedCard(cards));

		// one pair
		if (isFullSet(cards) && hasPerfectPair(cards))
			return new Hand(ONE_PAIR, valueOfMostRepeatedCard(cards));

		return new Hand(HIGH_CARD, highestCard(cards));
	}

	private static boolean hasTwoPairs(List<Card> cards) {
		Map<Integer, List<Card>> map = cards.stream()
				.collect(Collectors.groupingBy(s -> s.getValue(), Collectors.toList()));
		for (Entry<Integer, List<Card>> entry : map.entrySet()) {
			if (entry.getValue().size() == 2 && map.entrySet().size() == 3) {
				return true;
			}
		}
		return false;
	}

	private static boolean hasPerfectTriple(List<Card> cards) {
		Map<Integer, List<Card>> map = cards.stream()
				.collect(Collectors.groupingBy(s -> s.getValue(), Collectors.toList()));
		for (Entry<Integer, List<Card>> entry : map.entrySet()) {
			if (entry.getValue().size() == 3) {
				return true;
			}
		}
		return false;
	}

	private static boolean isFullSet(List<Card> cards) {
		return cards.size() == fullSet;
	}

	private static boolean hasPerfectPair(List<Card> cards) {
		Map<Integer, List<Card>> map = cards.stream()
				.collect(Collectors.groupingBy(s -> s.getValue(), Collectors.toList()));
		for (Entry<Integer, List<Card>> entry : map.entrySet()) {
			if (entry.getValue().size() == 2) {
				return true;
			}
		}
		return false;
	}

	private static int valueOfMostRepeatedCard(List<Card> cards) {
		Map<Integer, List<Card>> map = cards.stream()
				.collect(Collectors.groupingBy(s -> s.getValue(), Collectors.toList()));
		int maxCards = -1;
		int returnVal = 0;
		for (Entry<Integer, List<Card>> entry : map.entrySet()) {
			if (entry.getValue().size() > maxCards) {
				maxCards = entry.getValue().size();
				returnVal = entry.getKey();
			} else if (entry.getValue().size() == maxCards && returnVal < entry.getKey()) {
				returnVal = entry.getKey();
			}
		}
		return returnVal;
	}

	private static int cardsWithSameValue(List<Card> cards) {
		Map<Integer, List<Card>> map = cards.stream()
				.collect(Collectors.groupingBy(s -> s.getValue(), Collectors.toList()));
		int maxCards = -1;
		for (Entry<Integer, List<Card>> entry : map.entrySet()) {
			if (entry.getValue().size() > maxCards) {
				maxCards = entry.getValue().size();
			}
		}
		return maxCards;
	}

	private static boolean isConsecutive(List<Card> cards) {
		return (cards.stream().map(s -> s.getCardValue()).distinct().count() == 5) && (cards.stream().mapToInt(s -> s.getValue()).boxed().max(Integer::compare).get()
				- cards.stream().mapToInt(s -> s.getValue()).boxed().min(Integer::compare).get()) == 4;
	}

	private static int highestCard(List<Card> cards) {
		return cards.stream().map(s -> s.getValue()).max(Integer::compareTo).get();
	}

	private static boolean isSameSuit(List<Card> cards) {
		return cards.stream().map(s -> s.getSuit().getCardSuit()).distinct().count() == 1;
	}

	public static int simpleCompare(Deal a, Deal b) {
		List<Integer> cards_a = a.getCards().stream().mapToInt(s -> s.getValue()).boxed().collect(Collectors.toList());
		List<Integer> cards_b = b.getCards().stream().mapToInt(s -> s.getValue()).boxed().collect(Collectors.toList());

		Collections.sort(cards_a);
		Collections.sort(cards_b);

		for (int i = cards_a.size() - 1; i >= 0; i--) {
			if (cards_a.get(i) != cards_b.get(i)) {
				return cards_a.get(i) - cards_b.get(i);
			}
		}

		return 0;
	}
}
