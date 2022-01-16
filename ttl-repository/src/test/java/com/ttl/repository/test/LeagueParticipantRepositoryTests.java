package com.ttl.repository.test;


import com.ttl.model.League;
import com.ttl.model.LeagueParticipant;
import com.ttl.model.Participant;
import com.ttl.repository.LeagueParticipantRepository;
import com.ttl.repository.ParticipantRepository;
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
@DisplayName("<= LeagueParticipantRepositoryTests =>")
class LeagueParticipantRepositoryTests {

	@Autowired
	private LeagueParticipantRepository leagueParticipantRepository;

    @Autowired
    private ParticipantRepository participantRepository;

	private LeagueParticipant leagueParticipant;

	@BeforeEach
	void init() {
		Assertions.assertNotNull(leagueParticipantRepository);
		leagueParticipant = new LeagueParticipant();
	}

    @Test
	@DisplayName("saves a new entity leagueParticipant")
	 void testSave() {
        Participant participant = new Participant();
        participant.setName("gsg Shehan");
        participant.setEmail("asgas@gmail.com");
        participant = participantRepository.save(participant);

        League league = new League();
        league.setId(1);

        leagueParticipant.setParticipant(participant);
        leagueParticipant.setLeague(league);

        leagueParticipant = leagueParticipantRepository.save(leagueParticipant);
		Assertions.assertNotNull(leagueParticipant.getId());
	}

    @Test
    @DisplayName("saves already exist leagueParticipant")
    void testSaveAlreadyExist() {
        Participant participant = new Participant();
        participant.setId(15);

        League league = new League();
        league.setId(1);

        leagueParticipant.setParticipant(participant);
        leagueParticipant.setLeague(league);

        leagueParticipant = leagueParticipantRepository.save(leagueParticipant);
        Assertions.assertNotNull(leagueParticipant.getId());
    }
}
