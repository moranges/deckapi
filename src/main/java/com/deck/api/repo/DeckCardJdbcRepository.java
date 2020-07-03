package com.deck.api.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.deck.api.domain.Card;
import com.deck.api.domain.Deck;
import com.deck.api.domain.DeckCard;


@Repository
public class DeckCardJdbcRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	class DeckMapper implements RowMapper<DeckCard> {
		public DeckCard mapRow(ResultSet rs, int rowNum) throws SQLException {
			DeckCard deckCard = new DeckCard();
			deckCard.setId(rs.getInt("id"));
			deckCard.setDeckId(rs.getString("deck_id"));
			deckCard.setCardOrder(rs.getInt("card_order"));
			deckCard.setCardCode(rs.getString("card_code"));			
			return deckCard;
		}
	}

	public List<DeckCard> findByDeckId(String deckId) {
		return jdbcTemplate.query("select id, deck_id, card_order, card_code from deck_card where deck_id=? order by card_order ASC", new Object[] { deckId },
				new BeanPropertyRowMapper<DeckCard>(DeckCard.class));
	}

	public void insert(Deck deck) {
		int i = 1;
		for (Card card: deck.getCards()) {
			jdbcTemplate.update("insert into deck_card (deck_id, card_order, card_code) " + "values(?,  ?,  ?)",
				new Object[] { deck.getId(), i++, card.getCode() });
		}
	}
}
