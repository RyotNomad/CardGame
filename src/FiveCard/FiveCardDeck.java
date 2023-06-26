package FiveCard;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import constants.Constants;
import main.DeckInitializer;


public class FiveCardDeck extends DeckInitializer{
	
	ArrayList<Card> deck = null;
	
	//Used to create the deck. Will initialize a new deck if it's the first time an objects instance is calling it
	@Override
	public ArrayList<Card> getDeck() {
		if (deck == null) {
			deck = new ArrayList<Card>();
			for(CardRank rank:CardRank.values()) {
				for(CardSuit suit:CardSuit.values()) {
					Card card = new Card(rank,suit);
					deck.add(card);
				}
			}
		}
		return deck;
	}

	//Shuffles deck instance. Throws an exception if getDeck() isn't called first as it means a deck wasn't created. 
	//Uses build in Java method Collection.shuffle
	@Override
	public void shuffleDeck() throws Exception {
		if(deck == null) {
			throw new Exception("DECK HAS NOT BEEN INITILIZED");
		}
		System.out.println("Shuffling ... Shuffling ... Shuffling ... ");
		Collections.shuffle(deck);
	}

	@Override
	public ArrayList<Card> getHand() throws Exception {
		if(deck == null) {
			throw new Exception("DECK HAS NOT BEEN INITILIZED");
		}
		return (ArrayList<Card>) deck
	            .stream()
	            .limit(Constants.FIVE_CARD_HAND_SIZE)
	            .collect(Collectors.toList());
	}

	@Override
	public String getDeckType() {
		return Constants.FIVE_CARD;
	}

}
