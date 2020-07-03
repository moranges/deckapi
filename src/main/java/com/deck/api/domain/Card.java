package com.deck.api.domain;

public class Card {

    public final static char SPADES = 'S',       // Codes for the 4 suits.
                            HEARTS = 'H',
                            DIAMONDS = 'D',
                            CLUBS = 'C';
                            
    public final static int ACE = 1,          // Codes for the non-numeric cards.
                            JACK = 11,        //   Cards 2 through 10 have their 
                            QUEEN = 12,       //   numerical values for their codes.
                            KING = 13;
                            
    private final char suit;   // The suit of this card, one of the constants
                              //    SPADES, HEARTS, DIAMONDS, CLUBS.
                              
    private final int value;  // The value of this card, from 1 to 11.
                             
    public Card(int theValue, char theSuit) {
            // Construct a card with the specified value and suit.
            // Value must be between 1 and 13.  Suit must be between
            // 0 and 3.  If the parameters are outside these ranges,
            // the constructed card object will be invalid.
        value = theValue;
        suit = theSuit;
    }
        
    public Card(String cardCode) {
		suit = cardCode.charAt(0);
		value = Integer.parseInt(cardCode.substring(1));
	}

	public char getSuit() {
            // Return the int that codes for this card's suit.
        return suit;
    }
    
    public int getValue() {
            // Return the int that codes for this card's value.
        return value;
    }
    
    public String getCode() {
    	return Character.toString(suit) + value;
    }

} // end class Card