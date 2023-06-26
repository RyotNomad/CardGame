package FiveCard;

public class Card implements Comparable<Card> {	
	CardRank cardRank;
	CardSuit cardSuit;
	
	public Card(CardRank cardRank,CardSuit cardSuit) {
		this.cardRank=cardRank;
		this.cardSuit = cardSuit;
	}	

	public CardRank getCardRank() {
		return cardRank;
	}
	public void setCardRank(CardRank cardRank) {
		this.cardRank = cardRank;
	}
	public CardSuit getCardSuit() {
		return cardSuit;
	}
	public void setCardSuit(CardSuit cardSuit) {
		this.cardSuit = cardSuit;
	}
	
	@Override 
	public String toString(){ 
		StringBuilder cardValue = new StringBuilder();
		cardValue.append(cardRank);
		switch(cardSuit) {
			case DIAMONDS:
				cardValue.append((char)'\u2666');	
				break;
			case SPADES:
				cardValue.append((char)'\u2660');
				break;
			case HEARTS:
				cardValue.append((char)'\u2764');
				break;
			case CLUBS:
				cardValue.append((char)'\u2663');
				break;
		}
		cardValue.append(" ");
		return cardValue.toString();
	} 
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {  
	         return true;  
	      }  
	      if (!(o instanceof Card)) {  
	         return false;  
	      }  
	      Card card = (Card) o;  
	      return card.getCardRank().equals(this.getCardRank()) && card.getCardSuit().equals(this.getCardSuit());
	   }  
	
	@Override
	public int compareTo(Card other) {
	    return this.cardRank.ordinal() - other.cardRank.ordinal();
	}
}

