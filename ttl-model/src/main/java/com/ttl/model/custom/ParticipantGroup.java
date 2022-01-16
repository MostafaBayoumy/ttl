package com.ttl.model.custom;

import com.ttl.model.Participant;
import lombok.Data;

import javax.servlet.http.Part;

/**
 * @author: Moustafa.Bayoumy
 * @since: 1/15/2022 - 9:57 PM
 */
@Data
public class ParticipantGroup {

    private Participant firstParty;
    private Participant secondParty;
}
