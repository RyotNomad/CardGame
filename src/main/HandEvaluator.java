package main;
import java.util.ArrayList;

import FiveCard.Card;
import FiveCard.FiveCardPokerEvaluator;
import constants.Constants;

public abstract class HandEvaluator {
	
	public abstract String evaluateHand(ArrayList<Card> hand);
	
	public static HandEvaluator getEvaluator(DeckInitializer deckInitializer) {
		HandEvaluator evaluator = null;
		switch(deckInitializer.getDeckType()){
			case Constants.FIVE_CARD:
				evaluator = new FiveCardPokerEvaluator();
		}		
		return evaluator;
	}

}
