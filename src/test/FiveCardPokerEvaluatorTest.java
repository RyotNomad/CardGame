package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import FiveCard.Card;
import FiveCard.CardRank;
import FiveCard.CardSuit;
import FiveCard.FiveCardPokerEvaluator;

public class FiveCardPokerEvaluatorTest {

	@Test
	public void testHighCard() {
		FiveCardPokerEvaluator eval = new FiveCardPokerEvaluator();
		ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(CardRank.TWO, CardSuit.SPADES));
        hand.add(new Card(CardRank.FIVE, CardSuit.CLUBS));
        hand.add(new Card(CardRank.SEVEN, CardSuit.HEARTS));
        hand.add(new Card(CardRank.JACK, CardSuit.DIAMONDS));
        hand.add(new Card(CardRank.KING, CardSuit.SPADES));

        assertEquals(eval.evaluateHand(hand),"High Card");
        }

	@Test
    public void testEvaluateHandOnePair() {
		FiveCardPokerEvaluator eval = new FiveCardPokerEvaluator();
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(CardRank.TWO, CardSuit.SPADES));
        hand.add(new Card(CardRank.TWO, CardSuit.CLUBS));
        hand.add(new Card(CardRank.SEVEN, CardSuit.HEARTS));
        hand.add(new Card(CardRank.JACK, CardSuit.DIAMONDS));
        hand.add(new Card(CardRank.KING, CardSuit.SPADES));

        String actualRank = eval.evaluateHand(hand);

        assertEquals(actualRank, "One Pair");
    }

    @Test
    public void testEvaluateHandTwoPair() {
		FiveCardPokerEvaluator eval = new FiveCardPokerEvaluator();
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(CardRank.TWO, CardSuit.SPADES));
        hand.add(new Card(CardRank.TWO, CardSuit.CLUBS));
        hand.add(new Card(CardRank.SEVEN, CardSuit.HEARTS));
        hand.add(new Card(CardRank.SEVEN, CardSuit.DIAMONDS));
        hand.add(new Card(CardRank.KING, CardSuit.SPADES));

        String actualRank = eval.evaluateHand(hand);
        String expectedRank = "Two Pair";

        assertEquals(expectedRank, actualRank);
    }

    @Test
    public void testEvaluateHandThreeOfAKind() {
		FiveCardPokerEvaluator eval = new FiveCardPokerEvaluator();
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(CardRank.TWO, CardSuit.SPADES));
        hand.add(new Card(CardRank.TWO, CardSuit.CLUBS));
        hand.add(new Card(CardRank.TWO, CardSuit.HEARTS));
        hand.add(new Card(CardRank.JACK, CardSuit.DIAMONDS));
        hand.add(new Card(CardRank.KING, CardSuit.SPADES));

        String actualRank = eval.evaluateHand(hand);
        String expectedRank = "Three of a Kind";

        assertEquals(expectedRank, actualRank);
    }

    @Test
    public void testEvaluateHandStraight() {
		FiveCardPokerEvaluator eval = new FiveCardPokerEvaluator();
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(CardRank.FIVE, CardSuit.SPADES));
        hand.add(new Card(CardRank.SIX, CardSuit.CLUBS));
        hand.add(new Card(CardRank.SEVEN, CardSuit.HEARTS));
        hand.add(new Card(CardRank.EIGHT, CardSuit.DIAMONDS));
        hand.add(new Card(CardRank.NINE, CardSuit.SPADES));

        String actualRank = eval.evaluateHand(hand);
        String expectedRank = "Straight";

        assertEquals(expectedRank, actualRank);
    }

    @Test
    public void testEvaluateHandFlush() {
		FiveCardPokerEvaluator eval = new FiveCardPokerEvaluator();
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(CardRank.TWO, CardSuit.HEARTS));
        hand.add(new Card(CardRank.FOUR, CardSuit.HEARTS));
        hand.add(new Card(CardRank.SIX, CardSuit.HEARTS));
        hand.add(new Card(CardRank.EIGHT, CardSuit.HEARTS));
        hand.add(new Card(CardRank.JACK, CardSuit.HEARTS));

        String actualRank = eval.evaluateHand(hand);
        String expectedRank = "Flush";

        assertEquals(expectedRank, actualRank);
    }

    @Test
    public void testEvaluateHandFullHouse() {
		FiveCardPokerEvaluator eval = new FiveCardPokerEvaluator();
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(CardRank.TWO, CardSuit.SPADES));
        hand.add(new Card(CardRank.TWO, CardSuit.CLUBS));
        hand.add(new Card(CardRank.TWO, CardSuit.HEARTS));
        hand.add(new Card(CardRank.KING, CardSuit.DIAMONDS));
        hand.add(new Card(CardRank.KING, CardSuit.SPADES));

        String actualRank = eval.evaluateHand(hand);
        String expectedRank = "Full House";

        assertEquals(expectedRank, actualRank);
    }

    @Test
    public void testEvaluateHandFourOfAKind() {
		FiveCardPokerEvaluator eval = new FiveCardPokerEvaluator();
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(CardRank.TWO, CardSuit.SPADES));
        hand.add(new Card(CardRank.TWO, CardSuit.CLUBS));
        hand.add(new Card(CardRank.TWO, CardSuit.HEARTS));
        hand.add(new Card(CardRank.TWO, CardSuit.DIAMONDS));
        hand.add(new Card(CardRank.KING, CardSuit.SPADES));

        String actualRank = eval.evaluateHand(hand);
        String expectedRank = "Four of a Kind";

        assertEquals(expectedRank, actualRank);
    }

    @Test
    public void testEvaluateHandStraightFlush() {
		FiveCardPokerEvaluator eval = new FiveCardPokerEvaluator();
		ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(CardRank.TEN, CardSuit.HEARTS));
        hand.add(new Card(CardRank.JACK, CardSuit.HEARTS));
        hand.add(new Card(CardRank.QUEEN, CardSuit.HEARTS));
        hand.add(new Card(CardRank.KING, CardSuit.HEARTS));
        hand.add(new Card(CardRank.ACE, CardSuit.HEARTS));

        String actualRank = eval.evaluateHand(hand);
        String expectedRank = "Straight Flush";

        assertEquals(expectedRank, actualRank);
    }


	
}
