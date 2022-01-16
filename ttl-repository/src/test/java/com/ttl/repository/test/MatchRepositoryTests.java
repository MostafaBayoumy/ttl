package com.ttl.repository.test;


import com.ttl.model.*;
import com.ttl.model.custom.MatchDateCount;
import com.ttl.repository.MatchRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


/**
 * @author: Moustafa.Bayoumy
 * @since: 1/15/2022 - 10:56 AM
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Transactional
//@Rollback(false)
@DisplayName("<= MatchRepositoryTests =>")
class MatchRepositoryTests {

	@Autowired
	private MatchRepository matchRepository;

	private Match match;

	@BeforeEach
	void init() {
		Assertions.assertNotNull(matchRepository);
		match = new Match();
	}

    @Test
	@DisplayName("count by max match date")
	 void testCountByMaxMatchDate() {
	    MatchDateCount matchDateCount = matchRepository.countByMaxMatchDate();
        System.err.println("count >> " + matchDateCount.getCount());
        System.err.println("Date >> " + matchDateCount.getMatchDate());
		Assertions.assertNotNull(matchDateCount);
	}

	@Test
	@DisplayName("count by league id and round number and winner is null")
	void testCountByLeagueIdAndRoundNumberAndWinnerIsNull() {
		long count = matchRepository.countByLeague_idAndRoundNumberAndWinnerIsNull(1, (byte)1);
		System.err.println("count >> " + count);
		Assertions.assertEquals(count, 4);
	}


}
