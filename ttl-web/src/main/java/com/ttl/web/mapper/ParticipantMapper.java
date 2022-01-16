package com.ttl.web.mapper;

import com.ttl.model.Participant;
import com.ttl.web.dto.ParticipantDto;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author: Moustafa.Bayoumy
 * @since: 1/15/2022 - 11:50 AM
 */
@Mapper(componentModel = "spring")
public interface ParticipantMapper {

    ParticipantDto map(Participant participant);

    Participant unMap(ParticipantDto participantDto);

    List<ParticipantDto> mapList(List<Participant> participants);

    List<Participant> unMapList(List<ParticipantDto> participantDtos);
}
