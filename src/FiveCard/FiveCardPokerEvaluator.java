package FiveCard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.HandEvaluator;

public class FiveCardPokerEvaluator extends HandEvaluator {

    // Constants for hand ranks
    private static final int HIGH_CARD = 0;
    private static final int ONE_PAIR = 1;
    private static final int TWO_PAIR = 2;
    private static final int THREE_OF_A_KIND = 3;
    private static final int STRAIGHT = 4;
    private static final int FLUSH = 5;
    private static final int FULL_HOUSE = 6;
    private static final int FOUR_OF_A_KIND = 7;
    private static final int STRAIGHT_FLUSH = 8;
    private static final int ROYAL_FLUSH = 9;

    @Override
    public String evaluateHand(ArrayList<Card> hand) {
        // Sort the hand in descending order of rank
        Collections.sort(hand, Collections.reverseOrder());

        boolean isFlush = isFlush(hand);
        boolean isStraight = isStraight(hand);

       if (isFlush && isStraight) {
            return "Straight Flush";
        } else if (isFlush) {
            return "Flush";
        } else if (isStraight) {
            return "Straight";
        } else if (hasNOfAKind(hand, 4)) {
            return "Four of a Kind";
        } else if (hasFullHouse(hand)) {
            return "Full House";
        } else if (hasNOfAKind(hand, 3)) {
            return "Three of a Kind";
        } else if (hasTwoPair(hand)) {
            return "Two Pair";
        } else if (hasNOfAKind(hand, 2)) {
            return "One Pair";
        } else {
            return "High Card";
        }
    }

    private boolean isFlush(List<Card> hand) {
        CardSuit suit = hand.get(0).getCardSuit();
        return hand.stream().allMatch(card -> card.getCardSuit() == suit);
    }

    private boolean isStraight(List<Card> hand) {
        // Sort the hand by rank in ascending order
        Collections.sort(hand);

        // Check if the hand forms a sequential sequence of ranks
        for (int i = 1; i < hand.size(); i++) {
            if (hand.get(i).getCardRank().ordinal() != hand.get(i - 1).getCardRank().ordinal() + 1) {
                return false;
            }
        }

        // Handle special case for Ace, 2, 3, 4, 5 straight
        if (hand.get(0).getCardRank() == CardRank.TWO && hand.get(hand.size() - 1).getCardRank() == CardRank.ACE) {
            return true;
        }

        return true;
    }


    private boolean hasNOfAKind(List<Card> hand, int n) {
        Map<CardRank, Integer> rankCounts = new HashMap<>();
        for (Card card : hand) {
            rankCounts.put(card.getCardRank(), rankCounts.getOrDefault(card.getCardRank(), 0) + 1);
        }
        return rankCounts.values().contains(n);
    }

    private boolean hasFullHouse(List<Card> hand) {
        Map<CardRank, Integer> rankCounts = new HashMap<>();
        for (Card card : hand) {
            rankCounts.put(card.getCardRank(), rankCounts.getOrDefault(card.getCardRank(), 0) + 1);
        }
        return rankCounts.values().contains(2) && rankCounts.values().contains(3);
    }

    private boolean hasTwoPair(List<Card> hand) {
        Map<CardRank, Integer> rankCounts = new HashMap<>();
        for (Card card : hand) {
            rankCounts.put(card.getCardRank(), rankCounts.getOrDefault(card.getCardRank(), 0) + 1);
        }
        int pairCount = 0;
        for (int count : rankCounts.values()) {
            if (count == 2) {
                pairCount++;
            }
        }
        return pairCount == 2;
    }
}