package com.ttl.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: Moustafa.Bayoumy
 * @since: 1/15/2022 - 11:03 AM
 */
@Entity
@Table(name="matches")
@Data
public class Match extends BaseEntity<Integer> {

    @ManyToOne
    @JoinColumn(name = "first_participant_id")
    private Participant firstParticipant;

    @ManyToOne
    @JoinColumn(name = "second_participant_id")
    private Participant secondParticipant;

    @Column(name="round_no")
    private Byte roundNumber;

    @ManyToOne
    @JoinColumn(name = "winner_id")
    private Participant winner;

    @Column(name="result")
    private String result;

    @Temporal(TemporalType.DATE)
    @Column(name="match_date")
    private Date matchDate;

    @ManyToOne
    @JoinColumn(name = "league_id")
    private League league;
}
