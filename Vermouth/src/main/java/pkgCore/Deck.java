package pkgCore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

import pkgEnum.eRank;
import pkgEnum.eSuit;

public class Deck {

	private ArrayList<Card> cardsInDeck;

	public Deck() {
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				cardsInDeck.add(new Card(eSuit, eRank));
			}
		}
		Collections.shuffle(cardsInDeck);
	}

	public Card Draw() {

		return cardsInDeck.remove(0);

	}

	@Override
	public int hashCode() {
		return Objects.hash(eRank.values(), eSuit.values());
	}

	@Override
	public boolean equals(Object o) {
		
		if(o == this) return true;
		if(!(o instanceof Deck)) return false;
		
		Deck d = (Deck) o;
		return Objects.equals(hashCode(), d.hashCode());
		
	}

	

}
