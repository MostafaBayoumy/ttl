package com.ttl.web.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author: Moustafa.Bayoumy
 * @since: 1/15/2022 - 10:56 AM
 */
@Data
public class LeagueParticipantDto extends BaseDto<Integer> {

    @NotNull(message = "{leagueParticipantDto.participant.notnull}")
    private ParticipantDto participant;

    @NotNull(message = "{leagueParticipantDto.league.notnull}")
    private LeagueDto league;

}
