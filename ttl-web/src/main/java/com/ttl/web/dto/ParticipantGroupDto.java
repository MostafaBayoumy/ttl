package com.ttl.web.dto;

import com.ttl.model.Participant;
import lombok.Data;

/**
 * @author: Moustafa.Bayoumy
 * @since: 1/15/2022 - 7:18 PM
 */
@Data
public class ParticipantGroupDto {

    private ParticipantDto firstParty;
    private ParticipantDto secondParty;
}
