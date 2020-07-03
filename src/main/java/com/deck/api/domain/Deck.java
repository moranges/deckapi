package com.deck.api.domain;

import org.apache.commons.lang3.RandomStringUtils;

public class Deck {

	private String id;

	private Card[] cards;   // An array of 52 Cards, representing the deck.
    
    public Card[] getCards() {
		return cards;
	}

	public void setCards(Card[] cards) {
		this.cards = cards;
	}

	public int getCardsUsed() {
		return cardsUsed;
	}

	public void setCardsUsed(int cardsUsed) {
		this.cardsUsed = cardsUsed;
	}

	private int cardsUsed; // How many cards have been dealt from the deck.
    
    public Deck() {
           // Create an unshuffled deck of cards.
    	
       id = RandomStringUtils.randomAlphanumeric(8);	
       cards = new Card[52];
       int cardCt = 0; // How many cards have been created so far.
       for ( char suit: "SHDC".toCharArray()) {
          for ( int value = 1; value <= 13; value++ ) {
             cards[cardCt] = new Card(value,suit);
             cardCt++;
          }
       }
       cardsUsed = 0;
    }
    
    public void shuffle() {
          // Put all the used cards back into the deck, and shuffle it into
          // a random order.
        for ( int i = 51; i > 0; i-- ) {
            int rand = (int)(Math.random()*(i+1));
            Card temp = cards[i];
            cards[i] = cards[rand];
            cards[rand] = temp;
        }
        cardsUsed = 0;
    }
    
    public int cardsLeft() {
          // As cards are dealt from the deck, the number of cards left
          // decreases.  This function returns the number of cards that
          // are still left in the deck.
        return 52 - cardsUsed;
    }
    
    public Card dealCard() {
          // Deals one card from the deck and returns it.
        if (cardsUsed == 52)
           shuffle();
        cardsUsed++;
        return cards[cardsUsed - 1];
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
} // end class Deck
