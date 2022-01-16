package com.ttl.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author: Moustafa.Bayoumy
 * @since: 1/15/2022 - 10:56 AM
 */
@Entity
@Table(name="leagues_participants")
@Data
public class LeagueParticipant extends BaseEntity<Integer> {

    @ManyToOne
    @JoinColumn(name = "participant_id")
    private Participant participant;

    @ManyToOne
    @JoinColumn(name = "league_id")
    private League league;

}
