package com.ttl.web.mapper;

import com.ttl.model.LeagueParticipant;
import com.ttl.web.dto.LeagueParticipantDto;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author: Moustafa.Bayoumy
 * @since: 1/15/2022 - 11:50 AM
 */
@Mapper(componentModel = "spring")
public interface LeagueParticipantMapper {

    LeagueParticipantDto map(LeagueParticipant leagueParticipant);

    LeagueParticipant unMap(LeagueParticipantDto leagueParticipantDto);

    List<LeagueParticipantDto> mapList(List<LeagueParticipant> leagueParticipants);

    List<LeagueParticipant> unMapList(List<LeagueParticipantDto> leagueParticipantDtos);
}
