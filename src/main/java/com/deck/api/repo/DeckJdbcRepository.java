package com.deck.api.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.deck.api.domain.Deck;

@Repository
public class DeckJdbcRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	class DeckMapper implements RowMapper<Deck> {
		public Deck mapRow(ResultSet rs, int rowNum) throws SQLException {
			Deck deck = new Deck();
			deck.setId(rs.getString("id"));
			return deck;
		}
	}

	public Deck findById(String id) {
		List<Deck> decks = jdbcTemplate.query("select * from deck where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Deck>(Deck.class));

		if (decks.isEmpty()) {
			return null;
		} else {
			return decks.get(0);
		}
	}

	public int insert(Deck deck) {
		return jdbcTemplate.update("insert into deck (id, cards_used) " + "values(?,  ?)",
				new Object[] { deck.getId(), deck.getCardsUsed() });
	}
}
