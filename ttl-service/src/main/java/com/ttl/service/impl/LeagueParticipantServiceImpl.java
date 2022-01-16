package com.ttl.service.impl;

import com.ttl.model.LeagueParticipant;
import com.ttl.model.Participant;
import com.ttl.model.custom.ParticipantGroup;
import com.ttl.model.constant.ErrorMessages;
import com.ttl.model.exception.BusinessException;
import com.ttl.repository.LeagueParticipantRepository;
import com.ttl.repository.ParticipantRepository;
import com.ttl.service.LeagueParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author: Moustafa.Bayoumy
 * @since: 1/15/2022 - 11:26 AM
 */
@Service
public class LeagueParticipantServiceImpl extends BaseServiceImpl<LeagueParticipant, Integer>
        implements LeagueParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private LeagueParticipantRepository leagueParticipantRepository;

    @Override
    @Transactional
    public LeagueParticipant save(LeagueParticipant leagueParticipant) throws BusinessException {
        long count = leagueParticipantRepository.countByLeague_id(leagueParticipant.getLeague().getId());
        if(count >= 12) {
            throw new BusinessException(ErrorMessages.PARATICIPANT_MAX_NUMBER.getErrorMessage());
        }
        Participant participant = participantRepository.save(leagueParticipant.getParticipant());
        leagueParticipant.setParticipant(participant);
        return super.save(leagueParticipant);
    }

    @Override
    public List<Participant> getParticipantByLeagueId(Integer leagueId) throws BusinessException {
        return leagueParticipantRepository.getParticipantByLeagueId(leagueId);
    }

    @Override
    public List<ParticipantGroup> groupParticipantRandomly(Integer leagueId) throws BusinessException {
        List<Participant> participants = this.getParticipantByLeagueId(leagueId);
        List<ParticipantGroup> result = new ArrayList();
        if(participants == null || participants.size() ==0) {
            return result;
        }
        Random random = new Random();
        while(participants.size() > 0) {
            result.add(createParticipantGroup(participants, random));
        }
        return result;
    }

    private ParticipantGroup createParticipantGroup(List<Participant> participants, Random random) {
        ParticipantGroup participantGroupDto = new ParticipantGroup();
        participantGroupDto.setFirstParty(participants.get(0));
        participants.remove(0);
        if(participants.size() == 0) {
            participantGroupDto.setSecondParty(null);
        } else if(participants.size() ==1) {
            participantGroupDto.setSecondParty(participants.get(0));
            participants.remove(0);
        } else {
            int index = random.nextInt(participants.size());
            participantGroupDto.setSecondParty(participants.get(index));
            participants.remove(index);
        }
        return participantGroupDto;
    }
}
