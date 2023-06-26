package main;
import java.util.ArrayList;

import FiveCard.Card;
import FiveCard.FiveCardDeck;
import constants.Constants;

public abstract class DeckInitializer {
	
	public abstract ArrayList<Card> getDeck();
	
	//Throws an exception if called before a deck has been initialized
	public abstract void shuffleDeck() throws Exception;
	public abstract ArrayList<Card> getHand() throws Exception;
	
	public static DeckInitializer getInitializer(String type) {
		DeckInitializer deck = null;
		switch(type) {
			case Constants.FIVE_CARD:
				deck = new FiveCardDeck();
				
			//Add in case for other decktypes and return their implementation of this class
		}
		deck.getDeck();
		return deck;
	}
	public abstract String getDeckType();
	
}
