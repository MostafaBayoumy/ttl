package com.ttl.model;

/**
 * @author: Moustafa.Bayoumy
 * @since: 1/15/2022 - 10:53 AM
 */

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="leagues")
@Data
public class League extends BaseEntity<Integer> {

    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "champion_id")
    private Participant champion;
}
