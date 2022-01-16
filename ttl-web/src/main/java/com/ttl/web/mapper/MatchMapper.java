package com.ttl.web.mapper;

import com.ttl.model.Match;
import com.ttl.web.dto.MatchDto;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author: Moustafa.Bayoumy
 * @since: 1/15/2022 - 11:50 AM
 */
@Mapper(componentModel = "spring")
public interface MatchMapper {

    MatchDto map(Match match);

    Match unMap(MatchDto matchDto);

    List<MatchDto> mapList(List<Match> matches);

    List<Match> unMapList(List<MatchDto> matchDtos);
}
