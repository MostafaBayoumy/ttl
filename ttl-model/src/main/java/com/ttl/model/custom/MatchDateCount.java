package com.ttl.model.custom;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Embeddable;
import java.util.Date;

/**
 * @author: Moustafa.Bayoumy
 * @since: 1/16/2022 - 10:45 AM
 */
@Data
@AllArgsConstructor
public class MatchDateCount {

    private Date matchDate;

    private long count;
}
