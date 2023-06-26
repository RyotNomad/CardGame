package main;
import java.util.ArrayList;

import FiveCard.Card;
import constants.Constants;

public class Controller {
	
	public static void main(String[] args) {
		
		//We can change the parameter to get different types of decks
		DeckInitializer deckInitializer  = DeckInitializer.getInitializer(Constants.FIVE_CARD);
		ArrayList<Card> hand = null;
		
		//Check to ensure deck has been created and hand has been successfully dealt
		boolean evaluateHand =true;
		try {
			deckInitializer.shuffleDeck();
			hand = new ArrayList<Card>(deckInitializer.getHand());
			System.out.println(deckInitializer.getHand());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			evaluateHand = false;
			e.printStackTrace();
		}
		
		if(evaluateHand) {
			//ArrayList as it's caters for different hand sizes in a simple way. Arrays would be a performance improvement
			HandEvaluator eval = HandEvaluator.getEvaluator(deckInitializer);
			System.out.println(eval.evaluateHand(hand));
		}
	}
}
