package com.ttl.service;

import com.ttl.model.LeagueParticipant;
import com.ttl.model.Participant;
import com.ttl.model.custom.ParticipantGroup;
import com.ttl.model.exception.BusinessException;

import java.util.List;

/**
 * @author: Moustafa.Bayoumy
 * @since: 1/15/2022 - 11:18 AM
 */
public interface LeagueParticipantService extends BaseService<LeagueParticipant, Integer> {

    LeagueParticipant save(LeagueParticipant leagueParticipant) throws BusinessException;

    List<Participant> getParticipantByLeagueId(Integer leagueId) throws BusinessException;

    List<ParticipantGroup> groupParticipantRandomly(Integer leagueId) throws BusinessException;
}
