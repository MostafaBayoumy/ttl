package com.ttl.web.request;

import com.ttl.model.Participant;
import com.ttl.web.dto.LeagueDto;
import com.ttl.web.dto.ParticipantDto;
import lombok.Data;

/**
 * @author: Moustafa.Bayoumy
 * @since: 1/16/2022 - 2:23 PM
 */
@Data
public class SubmitChampionRequest {

    private ParticipantDto champion;

    private LeagueDto league;
}
