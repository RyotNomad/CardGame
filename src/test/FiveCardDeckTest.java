package test;

import static org.junit.Assert.*;

import org.junit.Test;

import FiveCard.Card;
import FiveCard.CardRank;
import FiveCard.CardSuit;
import FiveCard.FiveCardDeck;
import constants.Constants;

public class FiveCardDeckTest {

	@Test
	public void testGetDeckSize() {
		FiveCardDeck deck = new FiveCardDeck();
		 assertEquals(deck.getDeck().size(), 52);
	}
	
	@Test
	public void testGetDeckFirstCard() {
		FiveCardDeck deck = new FiveCardDeck();
		 Card firstCard = new Card(CardRank.TWO, CardSuit.HEARTS);
		 assertEquals(deck.getDeck().get(0),firstCard); 
	}
	
	@Test
	public void testGetDeckLastCard() {
		FiveCardDeck deck = new FiveCardDeck();
		 Card lastCard = new Card(CardRank.ACE, CardSuit.SPADES);
		 assertEquals(deck.getDeck().get(deck.getDeck().size()-1),lastCard); 
	}

	@Test
	public void testShuffleDeck() {
		FiveCardDeck deck = new FiveCardDeck();
		Card lastCard = new Card(CardRank.KING, CardSuit.HEARTS);
		Card firstCard = new Card(CardRank.TWO, CardSuit.DIAMONDS);
		deck.getDeck();
		try {
			deck.shuffleDeck();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean shuffle = lastCard.equals(deck.getDeck().size()-1) && firstCard.equals(deck.getDeck().get(0));
		assertFalse(shuffle);
	}

	@Test
	public void testGetHand() throws Exception {
		FiveCardDeck deck = new FiveCardDeck();
		deck.getDeck();
		assertEquals(deck.getHand().size(),Constants.FIVE_CARD_HAND_SIZE);
	}
}
