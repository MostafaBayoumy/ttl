package com.ttl.web.mapper;

import com.ttl.model.League;
import com.ttl.web.dto.LeagueDto;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author: Moustafa.Bayoumy
 * @since: 1/15/2022 - 11:50 AM
 */
@Mapper(componentModel = "spring")
public interface LeagueMapper {

    LeagueDto map(League league);

    League unMap(LeagueDto leagueDto);

    List<LeagueDto> mapList(List<League> leagues);

    List<League> unMapList(List<LeagueDto> leagueDtos);
}
