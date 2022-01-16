package com.ttl.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author: Moustafa.Bayoumy
 * @since: 1/15/2022 - 10:50 AM
 */
@Entity
@Table(name="participants")
@Data
public class Participant extends BaseEntity<Integer> {

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;
}
