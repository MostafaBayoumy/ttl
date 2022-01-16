package com.ttl.repository;

import com.ttl.model.Match;
import com.ttl.model.custom.MatchDateCount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Moustafa.Bayoumy
 * @since: 1/15/2022 - 11:11 AM
 */
@Repository
public interface MatchRepository extends BaseRepository<Match, Integer> {

    @Query("select new com.ttl.model.custom.MatchDateCount(m.matchDate, count(m)) from Match m where m.matchDate = (select max(ma.matchDate) from Match ma)")
    MatchDateCount countByMaxMatchDate();

    List<Match> findByRoundNumberAndLeague_id(Byte roundNumber, Integer leagueId);

    long countByLeague_idAndRoundNumberAndWinnerIsNull(Integer leagueId, Byte roundNumber);

    long countByRoundNumber(Byte roundNumber);
}
