package com.ttl.service.impl;

import com.ttl.model.League;
import com.ttl.model.Match;
import com.ttl.model.custom.MatchDateCount;
import com.ttl.model.custom.ParticipantGroup;
import com.ttl.model.constant.ErrorMessages;
import com.ttl.model.exception.BusinessException;
import com.ttl.repository.MatchRepository;
import com.ttl.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author: Moustafa.Bayoumy
 * @since: 1/15/2022 - 11:26 AM
 */
@Service
public class MatchServiceImpl extends BaseServiceImpl<Match, Integer>
        implements MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Override
    @Transactional
    public List<Match> createFirstRoundMatches(List<ParticipantGroup> participantGroups, Integer leagueId) throws BusinessException {
        List<Match> matches = new ArrayList<>();
        MatchDateCount matchDateCount = matchRepository.countByMaxMatchDate();
        byte roundNumber =(byte)1;
        League league = new League();
        league.setId(1);
        for(ParticipantGroup participantGroup : participantGroups) {
            Match match = new Match();
            match.setLeague(league);
            match.setFirstParticipant(participantGroup.getFirstParty());
            match.setSecondParticipant(participantGroup.getSecondParty());
            if(participantGroup.getSecondParty() == null) {
                match.setRoundNumber(++roundNumber);
            } else {
                match.setRoundNumber(roundNumber);
            }

            match.setMatchDate(createMatchDate(matchDateCount));
            match = matchRepository.save(match);
            matches.add(match);
        }
        return matches;
    }

    @Override
    public List<Match> getFirstRoundMatches(Integer leagueId) throws BusinessException {
        return matchRepository.findByRoundNumberAndLeague_id((byte)1, leagueId);
    }

    @Override
    public Match update(Match match) throws BusinessException {
        Match existMatch = matchRepository.findById(match.getId()).orElseThrow(() ->
                new BusinessException(ErrorMessages.MATCH_DOES_NOT_EXIST.getErrorMessage()));
        existMatch.setResult(match.getResult());
        existMatch.setWinner(match.getWinner());
        return matchRepository.save(existMatch);
    }

    @Override
    public boolean closeRound(Integer leagueId, Byte roundNumber) {
        long count = matchRepository.countByLeague_idAndRoundNumberAndWinnerIsNull(leagueId, roundNumber);
        if(count > 0) {
            throw new BusinessException(ErrorMessages.CAN_NOT_CLOSE_ROUND.getErrorMessage());
        }
        return true;
    }

    private Date createMatchDate(MatchDateCount matchDateCount){
        Calendar calendar = Calendar.getInstance();
        if(matchDateCount.getCount() == 0 && matchDateCount.getMatchDate() ==null){
            Date date = calendar.getTime();
            matchDateCount.setMatchDate(date);
            matchDateCount.setCount(matchDateCount.getCount()+1);
            return date;
        } else if(matchDateCount.getCount() >= 3) {
            matchDateCount.setCount(1);
            calendar.setTime(matchDateCount.getMatchDate());
            calendar.add(Calendar.DATE, 1);
            matchDateCount.setMatchDate(calendar.getTime());
            return matchDateCount.getMatchDate();
        } else {
            matchDateCount.setCount(matchDateCount.getCount()+1);
            return matchDateCount.getMatchDate();
        }
    };
}
