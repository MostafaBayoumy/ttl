package com.ttl.web.mapper;

import com.ttl.model.custom.ParticipantGroup;
import com.ttl.web.dto.ParticipantGroupDto;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author: Moustafa.Bayoumy
 * @since: 1/15/2022 - 11:50 AM
 */
@Mapper(componentModel = "spring", uses = ParticipantMapper.class)
public interface ParticipantGroupMapper {

    ParticipantGroupDto map(ParticipantGroup participantGroup);

    ParticipantGroup unMap(ParticipantGroupDto participantGroupDto);

    List<ParticipantGroupDto> mapList(List<ParticipantGroup> participantGroups);

    List<ParticipantGroup> unMapList(List<ParticipantGroupDto> participantGroupDtos);
}
