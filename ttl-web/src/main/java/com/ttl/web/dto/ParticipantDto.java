package com.ttl.web.dto;

import lombok.Data;

/**
 * @author: Moustafa.Bayoumy
 * @since: 1/15/2022 - 10:50 AM
 */
@Data
public class ParticipantDto extends BaseDto<Integer> {

    private String name;

    private String email;
}
