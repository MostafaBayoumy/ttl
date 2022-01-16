package com.ttl.repository;

import com.ttl.model.LeagueParticipant;
import com.ttl.model.Participant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Moustafa.Bayoumy
 * @since: 1/15/2022 - 11:18 AM
 */
@Repository
public interface LeagueParticipantRepository extends BaseRepository<LeagueParticipant, Integer> {

    long countByLeague_id(Integer leagueId);

    @Query("select lp.participant from LeagueParticipant lp where lp.league.id =?1")
    List<Participant> getParticipantByLeagueId(Integer leagueId);
}
