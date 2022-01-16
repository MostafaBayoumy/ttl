package com.ttl.web.dto;

/**
 * @author: Moustafa.Bayoumy
 * @since: 1/15/2022 - 10:53 AM
 */

import lombok.Data;

@Data
public class LeagueDto extends BaseDto<Integer> {

    private String name;

    private ParticipantDto champion;
}
