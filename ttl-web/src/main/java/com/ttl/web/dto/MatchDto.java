package com.ttl.web.dto;

import com.ttl.model.Match;
import lombok.*;

import java.util.Date;

/**
 * @author: Moustafa.Bayoumy
 * @since: 1/15/2022 - 11:03 AM
 */
@Data
public class MatchDto extends BaseDto<Integer> {

    private ParticipantDto firstParticipant;

    private ParticipantDto secondParticipant;

    private Byte roundNumber;

    private ParticipantDto winner;

    private String result;

    private Date matchDate;

    private LeagueDto league;
}
