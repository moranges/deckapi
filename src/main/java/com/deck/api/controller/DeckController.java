package com.deck.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.deck.api.domain.Card;
import com.deck.api.domain.Deck;
import com.deck.api.service.DeckService;

@RestController
@RequestMapping(path = "deck")
public class DeckController {

	@Autowired
	private DeckService deckService;
	
	public DeckService getDeckService() {
		return deckService;
	}

	public void setDeckService(DeckService deckService) {
		this.deckService = deckService;
	}

	@GetMapping("/new")
	@ResponseBody
	public Deck newDeck() {
		//return new Deck();
		return deckService.createDeck();
	}

	@GetMapping("/{deck_id}/list")
	@ResponseBody
	public List<Card> list(@PathVariable("deck_id") String deckId) {
		return deckService.listDeck(deckId);
	}
	
		
	@GetMapping("/{deck_id}/shuffle")
	@ResponseBody
	public void shuffle(@PathVariable("deck_id") String deckId) {
		Deck deck = new Deck();
		deck.shuffle();
	}
	
	@GetMapping("/{deck_id}/deal")
	@ResponseBody
	public Card deal(@PathVariable("deck_id") String deckId) {
		return new Deck().dealCard();
	}
}
