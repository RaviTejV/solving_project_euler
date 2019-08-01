package cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cards.CardStack.Card;

public class PokerGame {
	private CardStack deck = new CardStack();
	private List<Deal> deals = new ArrayList<>();

	public PokerGame(int players, List<String> dealStrings) {
		deck = new CardStack();

		for (int i = 0; i < players; i++) {
			deals.add(new Deal(i, dealStrings.subList(i * 5, i * 5 + 5)));
		}

		System.out.println(deals);

		deals.forEach(s -> System.out.println(ScoreCalculator.getHandForDeal(s)));

		Collections.sort(deals);
		Collections.reverse(deals);

		System.out.println(deals.get(0).player_id);

	}

	public int winner() {
		return deals.get(0).player_id;
	}

	class Deal implements Comparable<Deal> {
		List<Card> cards = new ArrayList<>();

		int player_id;

		public Deal(int id, List<String> cards) {
			this.player_id = id;
			for (int i = 0; i < cards.size(); i++) {
				this.cards.add(deck.drawCard(cards.get(i)));
			}
		}

		public List<Card> getCards() {
			return cards;
		}

		@Override
		public int compareTo(Deal o) {
			int result = ScoreCalculator.getHandForDeal(this).compareTo(ScoreCalculator.getHandForDeal(o));
			if (result != 0)
				return result;
			else
				{
				System.out.println("Tie Tie");
				return ScoreCalculator.simpleCompare(this, o);
				}
		}

		@Override
		public String toString() {
			return cards.toString();
		}

	}
}
