package com.ttl.service;

import com.ttl.model.Match;
import com.ttl.model.custom.ParticipantGroup;
import com.ttl.model.exception.BusinessException;

import java.util.List;

/**
 * @author: Moustafa.Bayoumy
 * @since: 1/15/2022 - 11:11 AM
 */
public interface MatchService extends BaseService<Match, Integer> {

    List<Match> createFirstRoundMatches(List<ParticipantGroup> participantGroups, Integer leagueId) throws BusinessException;

    List<Match> getFirstRoundMatches(Integer leagueId) throws BusinessException;

    Match update(Match match) throws BusinessException;

    boolean closeRound(Integer leagueId, Byte roundNumber) throws BusinessException;

    long getFirstRoundCount() throws BusinessException;
}
