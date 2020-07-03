package com.deck.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deck.api.domain.Card;
import com.deck.api.domain.Deck;
import com.deck.api.domain.DeckCard;
import com.deck.api.repo.DeckCardJdbcRepository;
import com.deck.api.repo.DeckJdbcRepository;

@Service
public class DeckService {

	@Autowired
	DeckJdbcRepository deckJdbcRepository;
	
	@Autowired
	DeckCardJdbcRepository deckCardJdbcRepository;

	public boolean deckExists(String deckId) {
		return deckJdbcRepository.findById(deckId) != null;
	}

	
	public Deck createDeck() {
		Deck deck = new Deck();
		
		//Start transaction
		deckJdbcRepository.insert(deck);
		deckCardJdbcRepository.insert(deck);		
		//End transaction
		
		return deck;
	}
	
	public List<Card> listDeck(String deckId) {
		List<DeckCard> deckCards = deckCardJdbcRepository.findByDeckId(deckId);

		List<Card> cards = null;
		
		if (!deckCards.isEmpty())
			cards = new ArrayList<Card>();
			for (DeckCard deckCard: deckCards) {
				cards.add(new Card(deckCard.getCardCode()));
			}

		return cards;
	}
	
	public List<Card> shuffleDeck(String deckId) {
		List<DeckCard> deckCards = deckCardJdbcRepository.findByDeckId(deckId);
		
		// Get deck, call shuffle, update DB and return list of cards in new order.
		// Stub for now
		return new ArrayList<Card>();
	}
}
